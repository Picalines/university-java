package practice12.exercise3;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class AnimationViewer {
    public static void main(String[] imagePaths) {
        if (imagePaths.length == 0) {
            System.out.println("invalid number of arguments. Paths to image files expected");
            return;
        }

        BufferedImage[] images = new BufferedImage[imagePaths.length];

        for (int i = 0; i < images.length; i++) {
            File imageFile = new File(imagePaths[i]);

            try {
                images[i] = ImageIO.read(imageFile);
            } catch (IOException ioException) {
                System.out.println("failed to load image '" + imagePaths[i] + "'");
                return;
            }
        }

        var frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Animation viewer");
        frame.setResizable(false);
        frame.setSize(images[0].getWidth(), images[0].getHeight());

        JComponent renderer;
        frame.setContentPane(renderer = new JComponent() {
            private int animFrame = -1;
            @Override
            public void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                animFrame += 1;
                if (animFrame >= images.length) animFrame = 0;
                frame.setSize(images[animFrame].getWidth(), images[animFrame].getHeight());
                graphics.drawImage(images[animFrame], 0, 0, this);
            }
        });

        var timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                renderer.repaint();
            }
        }, 0, 1000);

        frame.setVisible(true);
    }
}
