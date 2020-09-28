package com.gb.java.level_2.lesson_7.Clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientApplicationTwo {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("-auth l2 p3");
            new Thread(() -> {
                while (true) {
                    try {
                        String message = in.readUTF();
                        System.out.println(message);
                        if (message.contains("Incorrect credentials")) {
                            out.writeUTF("-auth l2 p2");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();

                        try {
                            in.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                        return;
                    }
                }
            }).start();

            out.writeUTF("-exit");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
