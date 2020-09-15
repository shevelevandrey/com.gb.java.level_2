package com.geekbrains.java.level_2.lesson_6;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private DataInputStream in;
    private DataOutputStream out;
    private JTextArea charArea;

    public Client() {}

    public Client(JTextArea charArea) {
        this.charArea = charArea;

        try {
            Socket socket = new Socket("127.0.0.1", 18443);
            System.out.println("Client info: " + socket);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String message = in.readUTF();
                            charArea.append(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

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

    public DataInputStream getIn() {
        return in;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public static void main(String[] args) {
        new Client();
    }
}
