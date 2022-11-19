package practice16.exercise4;

import javax.swing.*;
import java.awt.*;

public class PasswordChecker extends JFrame {
    private PasswordChecker() {
        super("Password application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 200);

        setLayout(new GridLayout(2, 1));

        var formPanel = new JPanel();
        add(formPanel);

        formPanel.setLayout(new GridBagLayout());

        var c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0, 0, 5, 10);

        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.1;

        addRow(formPanel, c, new JLabel("Service: ", JLabel.RIGHT),
            new JLabel("User name: ", JLabel.RIGHT),
            new JLabel("Password: ", JLabel.RIGHT));

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;

        addRow(formPanel, c, new JTextField(), new JTextField(), new JTextField());

        add(new JPanel()); // empty space

        setVisible(true);
    }

    private static void addRow(JComponent parent, GridBagConstraints c, JComponent... components) {
        for (JComponent component : components) {
            parent.add(component, c);
            c.gridy++;
        }
    }

    public static void main(String[] args) {
        new PasswordChecker();
    }
}
