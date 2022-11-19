package practice16.exercise2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WhereAmI extends JFrame {
    private WhereAmI() {
        super("where am I?");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 500);

        var borderLayout = new BorderLayout();
        borderLayout.setHgap(20);
        borderLayout.setVgap(20);
        setLayout(borderLayout);

        addNotifiedPanelAt("Добро пожаловать в ЦАО", BorderLayout.CENTER);
        addNotifiedPanelAt("Добро пожаловать в ЗАО", BorderLayout.WEST);
        addNotifiedPanelAt("Добро пожаловать в ЮАО", BorderLayout.SOUTH);
        addNotifiedPanelAt("Добро пожаловать в САО", BorderLayout.NORTH);
        addNotifiedPanelAt("Добро пожаловать в ВАО", BorderLayout.EAST);

        setVisible(true);
    }

    private void addNotifiedPanelAt(String messageOnMouseEnter, String borderLayoutDirection) {
        var panel = new JPanel();

        panel.setLayout(new GridBagLayout());
        panel.add(new JLabel(borderLayoutDirection));

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(panel, borderLayoutDirection);
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                JOptionPane.showMessageDialog(null, messageOnMouseEnter);
            }

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });
    }

    public static void main(String[] args) {
        new WhereAmI();
    }
}
