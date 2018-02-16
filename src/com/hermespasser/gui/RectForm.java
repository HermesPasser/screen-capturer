package com.hermespasser.gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.*;

public class RectForm extends javax.swing.JFrame{

    public static JFrame frame;
    public static boolean isAlpha;
    private static Point location;
    private static Dimension size;
    private JPanel panel1;

    public RectForm(boolean isAlpha) {
        this.setContentPane(this.panel1);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLocation(location);
        this.setAlwaysOnTop(true);

        if (isAlpha) {
            this.setUndecorated(true);
            this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        } else
            panel1.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        this.setPreferredSize(size);
        this.pack();
        this.setVisible(true);

        panel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
             super.mouseClicked(e);
             changeForm();
            }
        });
    }

    public static void changeForm(){
        if (frame != null) frame.dispose();

        location = frame.getLocation();
        isAlpha = !isAlpha;
        size = frame.getSize();
        frame = new RectForm(isAlpha);
    }

    public static void main(String[] args) {
        isAlpha = true;
        location = new Point(10, 10);
        size = new Dimension(400, 400);
        frame = new RectForm(isAlpha);
    }
}
