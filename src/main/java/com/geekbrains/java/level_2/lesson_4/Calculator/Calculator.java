package com.geekbrains.java.level_2.lesson_4.Calculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public Calculator() {
        JFrame frame = new JFrame();
        frame.setTitle("Calculator v2.0");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(new Rectangle(0, 0, 300, 250));

        JPanel basicPanel = new JPanel();
        basicPanel.setLayout(new BoxLayout(basicPanel, BoxLayout.Y_AXIS));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        JTextField inputField = new JTextField();
        inputField.setEditable(false);
        topPanel.add(inputField);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(4, 5));

        List<JButton> buttons = createBasicButtons();
        for (JButton btn : buttons) {
            bottomPanel.add(btn);
        }

        JPanel customPanel = new JPanel();

        JComboBox<ButtonMode> modes = new JComboBox<>();
        modes.addItem(ButtonMode.BASIC);
        modes.addItem(ButtonMode.ENGINEER);
        modes.addItem(ButtonMode.PROGRAMMING);
        modes.addActionListener(new ModeListener(bottomPanel));
        customPanel.add(modes);

        frame.add(basicPanel);
        basicPanel.add(topPanel);
        basicPanel.add(customPanel);
        basicPanel.add(bottomPanel);

        frame.setVisible(true);
    }

    private List<JButton> createBasicButtons() {
        List<JButton> basicButtons = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            basicButtons.add(new JButton(String.valueOf(i)));
        }
        basicButtons.add(new JButton("C"));
        basicButtons.add(new JButton("+"));
        basicButtons.add(new JButton("-"));
        basicButtons.add(new JButton("*"));
        basicButtons.add(new JButton("/"));

        return basicButtons;
    }
}
