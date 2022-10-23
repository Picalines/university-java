package practice15.exercise3;

import javax.swing.*;
import java.awt.*;

public class MenuTest extends JFrame {
    private MenuTest() {
        super("Hello Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 200);

        var menuBar = new JMenuBar();

        var fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        fileMenu.add(new JMenuItem("Save"));
        fileMenu.add(new JMenuItem("Quit"));

        var editMenu = new JMenu("Edit");
        menuBar.add(editMenu);
        editMenu.add(new JMenuItem("Copy"));
        editMenu.add(new JMenuItem("Cut"));
        editMenu.add(new JMenuItem("Paste"));

        menuBar.add(new JMenu("Help"));

        setLayout(new GridBagLayout());
        var c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        add(new JButton("Button 1"), c);
        c.gridx = 1;
        add(new JButton("Button 2"), c);

        setJMenuBar(menuBar);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuTest();
    }
}
