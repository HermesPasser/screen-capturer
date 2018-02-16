package com.hermespasser.gui;

import com.hermespasser.capturer.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URISyntaxException;
import java.net.URI;

public class MainForm extends javax.swing.JFrame {
    private JButton btnCapture;
    private JButton btnChange;
    private JButton btnSave;
    private JPanel panel1;
    private JLabel labelCredit;
    private JLabel labelSource;
    private JLabel labelImage;

    public MainForm(){
        this.setContentPane(this.panel1);
        this.setTitle("Screen Capturer");

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
               if (RectForm.frame != null)
                   RectForm.frame.dispose();
            }
        });

        labelCredit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                openURL("https://hermespasser.github.io");
            }
        });

        labelSource.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                openURL("https://github.com/HermesPasser/screen-capturer");
            }
        });

        btnChange.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                RectForm.changeForm();
            }
        });

        btnCapture.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            Rectangle rect = new Rectangle(RectForm.frame.getLocation(), RectForm.frame.getSize());
            RectForm.frame.setVisible(false);

            try {
                Capturer.capture(rect);
                ImageIcon icon = new ImageIcon(Capturer.capture.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                labelImage.setIcon(icon);
            } catch (AWTException ex) {
                ex.printStackTrace();
            } finally {
                RectForm.frame.setVisible(true);
            }
            }
        });

        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            JFileChooser saveFile = new JFileChooser();

            if (Capturer.capture == null || saveFile.showSaveDialog(null) != JFileChooser.APPROVE_OPTION)
                return;

            File file = new File(saveFile.getSelectedFile() + ".png");

            try {
                Capturer.save(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            }
        });
    }

    private void openURL(String url){
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
