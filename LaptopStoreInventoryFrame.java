import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LaptopStoreInventoryFrame extends JFrame {
    private JTable inventoryTable;
    private JButton backButton;

    public LaptopStoreInventoryFrame() {
        setTitle("Inventory Frame");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create table with laptop details
        String[] columnNames = {"Brand", "Model", "Type", "Price", "CPU", "GPU", "RAM", "SSD", "OS", "Display", "Touchscreen", "Weight"};
        Object[][] data = new Object[LaptopStoreApplication.laptopArray.length][columnNames.length];

        for (int i = 0; i < LaptopStoreApplication.laptopArray.length; i++) {
            Laptop laptop = LaptopStoreApplication.laptopArray[i];
            data[i][0] = laptop.getBrand();
            data[i][1] = laptop.getModel();
            data[i][2] = laptop.getType();
            data[i][3] = laptop.getLaptopCost();
            data[i][4] = laptop.getCpuModel();
            data[i][5] = laptop.getGpuModel();
            data[i][6] = laptop.getRam();
            data[i][7] = laptop.getSsd();
            data[i][8] = laptop.getOs();
            data[i][9] = laptop.getDisplaySize() + " (" + laptop.getDisplayResolution() + ")";
            data[i][10] = laptop.isTouchscreen() ? "Yes" : "No";
            data[i][11] = laptop.getWeight();
        }

        inventoryTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(inventoryTable);
        add(scrollPane, BorderLayout.CENTER);

        // Create back button
        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LaptopStoreTitleFrame();
            }
        });
        add(backButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
