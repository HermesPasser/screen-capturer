package com.hermespasser.capturer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class Capturer {
    private Capturer() {}

    public static BufferedImage capture = null;

    public static void capture(Rectangle area) throws AWTException {
        Robot robot = new Robot();
        capture = robot.createScreenCapture(area);
    }

    public static void save(File output) throws IOException {
        ImageIO.write(capture, "png", output);
    }
}
