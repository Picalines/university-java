package practice12.exercise2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePreviewer {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("invalid number of arguments. Path to image file expected");
            return;
        }

        var imagePath = args[0];

        File imageFile = new File(imagePath);
        BufferedImage image;

        try {
            image = ImageIO.read(imageFile);
        }
        catch (IOException ioException) {
            System.out.println("failed to load image '" + imagePath + "'");
            return;
        }

        var frame = new JFrame();
        frame.setSize(image.getWidth(), image.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(imageFile.getName());
        frame.setResizable(false);

        frame.setContentPane(new JComponent() {
            @Override
            public void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                graphics.drawImage(image, 0, 0, this);
            }
        });

        frame.setVisible(true);
    }
}
