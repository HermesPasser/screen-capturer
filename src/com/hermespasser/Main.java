package com.hermespasser;

import com.hermespasser.gui.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        MainForm mf = new MainForm();
        mf.setSize(500, 200);
        mf.setVisible(true);

        RectForm.main(null);
    }
}
