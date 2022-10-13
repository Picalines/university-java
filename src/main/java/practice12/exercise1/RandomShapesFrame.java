package practice12.exercise1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class RandomShapesFrame extends JFrame {
    private final Random random = new Random();

    private interface RandomShapeCreator {
        Shape createRandomShape();
    }

    private RandomShapesFrame() {
        super("random shapes");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);

        var shapeCreators = new RandomShapeCreator[]{
            () -> new Rectangle(getRandomPoint(), random.nextInt(100), random.nextInt(100), getRandomColor()),
            () -> new Circle(getRandomPoint(), random.nextInt(100), getRandomColor()),
        };

        var canvasPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);

                var graphics2D = (Graphics2D) graphics;

                for (int i = 0; i < 20; i++) {
                    var shapeCreator = shapeCreators[random.nextInt(shapeCreators.length)];
                    var shape = shapeCreator.createRandomShape();
                    shape.paint(graphics2D);
                }
            }
        };

        canvasPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                canvasPanel.paintComponent(canvasPanel.getGraphics());
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });

        add(canvasPanel);
    }

    private Point getRandomPoint() {
        var size = getSize();
        return new Point(random.nextInt(size.width), random.nextInt(size.height));
    }

    private Color getRandomColor() {
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public static void main(String[] args) {
        new RandomShapesFrame().setVisible(true);
    }
}
