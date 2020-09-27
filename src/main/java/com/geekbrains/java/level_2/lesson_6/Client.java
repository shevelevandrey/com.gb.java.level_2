package com.geekbrains.java.level_2.lesson_6;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client(String endpointHost, int endpointPort, JTextArea charArea) {
        try {
            clientSocket = new Socket(endpointHost, endpointPort);
            System.out.println("Client info: " + clientSocket);

            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

            new Thread(() -> {
                try {
                    while (!clientSocket.isInputShutdown()) {
                        String message = in.readUTF();
                        charArea.append("[My] " + message + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DataInputStream getIn() {
        return in;
    }

    public DataOutputStream getOut() {
        return out;
    }
}
