package com.bit.lake.lwjgl.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Patrick Wilmes
 */
public class HostInputDialog extends JFrame implements ActionListener {

    private String hostIp;
    private JTextField textField = new JTextField();

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
        textField.setLocation(10, 10);
        textField.setSize(new Dimension(100, 20));
        add(textField);

        JButton button = new JButton("OK");
        button.setSize(100, 20);
        button.setLocation(120, 20);
        button.addActionListener(this);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("OK")) {
            hostIp = textField.getText();
        }
    }

    public String getHostIp() {
        return hostIp;
    }
}
