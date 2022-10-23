package practice15.exercise2;

import javax.swing.*;
import java.awt.*;

enum Country {
    Australia(25_766_605),
    China(1_411_778_724),
    England(56_489_800),
    Russia(147_182_123);

    private final int populationSize;

    Country(int populationSize) {
        this.populationSize = populationSize;
    }

    public int getPopulationSize() {
        return populationSize;
    }
}

public class CountryInfoViewer extends JFrame {
    private CountryInfoViewer() {
        super("Country info viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 200);
        setLayout(new GridBagLayout());

        var comboBox = new JComboBox<>(Country.values());
        add(comboBox);

        comboBox.addActionListener(l -> {
            var selectedCountry = (Country) comboBox.getSelectedItem();
            JOptionPane.showMessageDialog(
                this,
                "Численность населения " + selectedCountry + ": " + selectedCountry.getPopulationSize());
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CountryInfoViewer();
    }
}
