package com.gb.java.level_2.lesson_6;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public Server(int port, JTextArea charArea) {
        try {
            System.out.println("Server is starting up...");
            server = new ServerSocket(port);

            new Thread(() -> {
                try {
                    System.out.println("Server waiting for connection...");
                    clientSocket = server.accept();
                    System.out.println("Client connected: " + clientSocket);

                    in = new DataInputStream(clientSocket.getInputStream());
                    out = new DataOutputStream(clientSocket.getOutputStream());

                    while (!clientSocket.isInputShutdown()) {
                        try {
                            String message = in.readUTF();
                            out.writeUTF(message);
                            charArea.append("[Server] " + message + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}