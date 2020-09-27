package com.geekbrains.java.level_2.lesson_7.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Objects;

/**
 * Represents client session
 */
public class ClientHandler {
    private String name;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Server server;

    public ClientHandler(Socket socket, Server server) {
        this.socket = socket;
        try {
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.socket.setSoTimeout(12000);
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.server = server;
    }

    public String getName() {
        return name;
    }

    public void start(){
        new Thread(() -> {
            try {
                authenticate();
                readMessage();
            } catch (SocketTimeoutException e) {
                System.out.printf("Time expired for unauthorized client: %s.%n", socket);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }).start();
    }

    public void authenticate() throws IOException {
        System.out.println("Client auth is on going...");
        while (true) {
            String loginInfo = in.readUTF();
            if (loginInfo.startsWith("-auth")) {
                // -auth l1 p1
                String[] splittedLoginInfo = loginInfo.split("\\s");
                AuthenticationService.Client maybeClient = server.getAuthenticationService()
                        .findByLoginAndPassword(
                                splittedLoginInfo[1],
                                splittedLoginInfo[2]
                        );
                if (maybeClient != null) {
                    if (!server.checkLogin(maybeClient.getName())) {
                        socket.setSoTimeout(0);
                        sendMessage("Status: authok");

                        name = maybeClient.getName();
                        server.broadcast(this, "", String.format("%s came in", name));
                        System.out.println("Client auth completed");
                        server.subscribe(this);
                        return;
                    } else {
                        sendMessage(String.format("%s already logged in", maybeClient.getName()));
                    }
                } else {
                    sendMessage("Incorrect credentials");
                }
            }
        }
    }

    public void closeConnection() {
        server.unsubscribe(this);
        server.broadcast(this, "", String.format("%s left chat", (name != null) ? name : "You"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessage() throws IOException {
        while (true) {
            String message = in.readUTF();
            String formatterMessage = String.format("Message from %s: %s", name, message);
            System.out.println(formatterMessage);

            if (message.equalsIgnoreCase("-exit")) {
                return;
            }

            String targetUser = "";
            if (message.contains("-user")) {
                String[] splittedMessage = message.split("\\s");
                targetUser = splittedMessage[1];
                formatterMessage = String.format("Message from %s: %s", name,
                        message.replace(splittedMessage[0] + " " + splittedMessage[1] + " ", ""));
            }

            server.broadcast(this, targetUser, formatterMessage);
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientHandler that = (ClientHandler) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(socket, that.socket) &&
                Objects.equals(in, that.in) &&
                Objects.equals(out, that.out) &&
                Objects.equals(server, that.server);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, socket, in, out, server);
    }

    @Override
    public String toString() {
        return "ClientHandler{" +
                "name='" + name + '\'' +
                ", socket=" + socket +
                ", in=" + in +
                ", out=" + out +
                ", server=" + server +
                '}';
    }
}
