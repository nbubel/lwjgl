package com.bit.lake.lwjgl.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Patrick Wilmes
 */
public class HostInputDialog extends JFrame implements ActionListener {

    public HostInputDialog() {
        setTitle("LWJGL Game Host Input Dialog");
        setLocationRelativeTo(null);
        setSize(new Dimension(300, 300));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        initializeDialog();
        setVisible(true);
    }

    private void initializeDialog() {
        JTextField textField = new JTextField();
        textField.setLocation(10, 10);
        textField.setSize(new Dimension(100, 20));
        add(textField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
