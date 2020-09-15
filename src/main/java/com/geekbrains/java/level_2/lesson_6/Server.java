package com.geekbrains.java.level_2.lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private DataInputStream in;
    private DataOutputStream out;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        try {
            System.out.println("Server is starting up...");
            ServerSocket serverSocket = new ServerSocket(18443);

            System.out.println("Server waiting for connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String message = in.readUTF();
                out.writeUTF("Echo: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}