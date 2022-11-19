package practice16.exercise3;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class FontTest extends JFrame {
    private record LabeledComboBoxItem<T>(T value, String label) {
        @Override
        public String toString() {
            return label;
        }

        public static <T> Function<T, LabeledComboBoxItem<T>> createFactory(Function<T, String> getLabel) {
            return value -> new LabeledComboBoxItem<>(value, getLabel.apply(value));
        }

        public static <T> void addListenerTo(JComboBox<LabeledComboBoxItem<T>> comboBox, Consumer<T> listener) {
            comboBox.addItemListener(item -> listener.accept(((LabeledComboBoxItem<T>)item.getItem()).value()));
        }
    }

    private FontTest() {
        super("Font tester");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 400);

        var textArea = new JTextArea();
        var fontSelect = new JComboBox<LabeledComboBoxItem<Font>>();
        var colorSelect = new JComboBox<LabeledComboBoxItem<Color>>();

        var fontItemFactory = LabeledComboBoxItem.createFactory(Font::getName);

        var timesNewRomanFont = new Font("Times New Roman", Font.PLAIN, 14);

        fontSelect.addItem(fontItemFactory.apply(timesNewRomanFont));
        fontSelect.addItem(fontItemFactory.apply(new Font("MS Sans Serif", Font.PLAIN, 14)));
        fontSelect.addItem(fontItemFactory.apply(new Font("Courier New", Font.PLAIN, 14)));

        LabeledComboBoxItem.addListenerTo(fontSelect, textArea::setFont);

        colorSelect.addItem(new LabeledComboBoxItem<>(Color.BLUE, "Blue"));
        colorSelect.addItem(new LabeledComboBoxItem<>(Color.RED, "Red"));
        colorSelect.addItem(new LabeledComboBoxItem<>(Color.BLACK, "Black"));

        LabeledComboBoxItem.addListenerTo(colorSelect, textArea::setForeground);

        textArea.setFont(timesNewRomanFont);
        textArea.setForeground(Color.BLACK);
        textArea.setText("Hello, world!");

        setLayout(new GridLayout(3, 1));

        add(textArea);
        add(fontSelect);
        add(colorSelect);

        setVisible(true);
    }

    public static void main(String[] args) {
        new FontTest();
    }
}
