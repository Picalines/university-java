package practice30;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.function.Supplier;

public class OrderUI extends JFrame {
    private static final String currentOrderTextHeader = "Current order: ";
    private final Customer customer = new Customer(
        "Petr", "Kostenko", 19,
        new Address("Moscow", 119454, "Prospect Vernadskogo", 78, 1)
    );

    private final TableOrdersManager tableOrderManager = new TableOrdersManager(32);
    private final InternetOrdersManager internetTableManager = new InternetOrdersManager();

    private Order currentOrder = new InternetOrder();

    private int selectedTable = -1;

    private final JComboBox<Integer> tableComboBox;
    private final JTextArea currentOrderText;

    private OrderUI() {
        super("OrderUI");
        setSize(new Dimension(500, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        currentOrderText = new JTextArea(currentOrderTextHeader);
        currentOrderText.setEditable(false);

        final var allOrdersText = new JTextArea("Orders: ");
        allOrdersText.setEditable(false);

        final var dishesOrderComboBox = createMenuItemComboBox(
            new Dish("Meatballs", "Tasty meatballs", 500),
            new Dish("Pasta", "Tasty pasta", 400),
            new Dish("Seafood", "Tasty seafood", 300)
        );

        final var drinksOrderComboBox = createMenuItemComboBox(
            new Drink("Water", "Not alcohol drink", 400, DrinkType.WATER, 0),
            new Drink("Tea", "Tasty tea", 300, DrinkType.TEA, 0),
            new Drink("Vodka", "Alcohol drink", 500, DrinkType.VODKA, 40)
        );

        final var addOrderButton = new JButton("Add order");

        final var internetOrderRadioButton = new JRadioButton("Internet order");
        final var tableOrderRadioButton = new JRadioButton("Table order");
        final var chooseType = new ButtonGroup();
        chooseType.add(tableOrderRadioButton);
        chooseType.add(internetOrderRadioButton);

        internetOrderRadioButton.setSelected(true);
        tableOrderRadioButton.setSelected(false);

        tableOrderRadioButton.addActionListener(orderTypeRadioButtonActionListener(TableOrder::new));
        internetOrderRadioButton.addActionListener(orderTypeRadioButtonActionListener(InternetOrder::new));

        tableComboBox = new JComboBox<>();
        tableComboBox.setBackground(Color.white);
        tableComboBox.setVisible(false);
        tableComboBox.addActionListener(e -> selectedTable = (Integer) tableComboBox.getSelectedItem());
        updateTableComboBoxItems();

        addOrderButton.addActionListener(e -> {
            if (currentOrder.getItems().size() == 0) {
                return;
            }

            currentOrderText.setText(currentOrderTextHeader);

            var orderReportStr = new StringBuilder("\nOrder: ");
            for (var item : currentOrder.getItems()) {
                orderReportStr.append(item).append('\n');
            }

            if (tableOrderRadioButton.isSelected()) {
                if (selectedTable == -1) return;
                tableOrderManager.add(currentOrder, selectedTable);
                currentOrder = new TableOrder();
                orderReportStr
                    .append("at table #")
                    .append(selectedTable)
                    .append('\n');
                updateTableComboBoxItems();
                selectedTable = -1;
            } else {
                internetTableManager.add(currentOrder, customer);
                currentOrder = new InternetOrder();
            }

            allOrdersText.append(orderReportStr.toString());
        });

        var gridLayout = new GridLayout(1, 2);
        gridLayout.setHgap(10);
        setLayout(gridLayout);
        var orderSettingsPanel = new JPanel();
        orderSettingsPanel.setLayout(new GridBagLayout());

        add(orderSettingsPanel);

        var c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;

        var orderTypePanel = new JPanel();
        orderSettingsPanel.add(orderTypePanel, c);
        orderTypePanel.setLayout(new FlowLayout());
        orderTypePanel.add(internetOrderRadioButton);
        orderTypePanel.add(tableOrderRadioButton);

        orderSettingsPanel.add(tableComboBox, c);
        orderSettingsPanel.add(dishesOrderComboBox, c);
        orderSettingsPanel.add(drinksOrderComboBox, c);
        orderSettingsPanel.add(addOrderButton, c);

        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        orderSettingsPanel.add(currentOrderText, c);

        var resultOrdersPanel = new JPanel();
        add(resultOrdersPanel);
        resultOrdersPanel.setLayout(new BorderLayout());

        resultOrdersPanel.add(allOrdersText, BorderLayout.CENTER);
    }

    private JComboBox<MenuItem> createMenuItemComboBox(MenuItem... menuItems) {
        var comboBox = new JComboBox<>(menuItems);
        comboBox.setBackground(Color.white);

        comboBox.addActionListener(e -> {
            var selectedMenuItem = (MenuItem) comboBox.getSelectedItem();
            currentOrder.add(selectedMenuItem);
            currentOrderText.append("\n" + selectedMenuItem + "\n");
        });

        return comboBox;
    }

    private void updateTableComboBoxItems() {
        var freeTableNumbersArray = tableOrderManager.freeTableNumbers().toArray(new Integer[0]);
        var model = new DefaultComboBoxModel<>(freeTableNumbersArray);
        tableComboBox.setModel(model);
    }

    private ActionListener orderTypeRadioButtonActionListener(Supplier<Order> createNewOrder) {
        return e -> {
            currentOrder = createNewOrder.get();
            tableComboBox.setVisible(currentOrder instanceof TableOrder);
            currentOrderText.setText(currentOrderTextHeader);
        };
    }

    public static void main(String[] args) {
        new OrderUI().setVisible(true);
    }
}
