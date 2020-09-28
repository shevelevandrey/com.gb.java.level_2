package com.gb.java.level_2.lesson_4.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame {

    JTextArea messagesArea;
    JTextField messageField;
    JButton sendButton;


    public Chat() {
        initChat();
    }

    private void initChat() {
        setTitle("myChat");
        setBounds(new Rectangle(300, 300));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();

        JPanel basicPanel = new JPanel();
        basicPanel.setLayout(new GridLayout(1, 1));

        messagesArea = new JTextArea();
        messagesArea.setEditable(false);
        basicPanel.add(messagesArea);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2));

        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(messageField.getText());
            }
        });

        sendButton = new JButton("Send message");
        sendButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(messageField.getText());
            }
        });

        bottomPanel.add(messageField);
        bottomPanel.add(sendButton);

        container.add(basicPanel, BorderLayout.CENTER);
        container.add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void sendMessage(String message) {
        messagesArea.append(message + "\n");
        messageField.setText("");
    }

}
