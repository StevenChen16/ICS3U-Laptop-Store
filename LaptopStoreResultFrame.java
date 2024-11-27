import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class LaptopStoreResultFrame extends JFrame {
    private JTable resultTable;
    private JButton backButton;

    public LaptopStoreResultFrame(List<Laptop> filteredLaptops) {
        setTitle("Result Frame");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create table with filtered laptop details
        String[] columnNames = {"Brand", "Model", "Type", "Price", "CPU", "GPU", "RAM", "SSD", "OS", "Display", "Touchscreen", "Weight"};
        Object[][] data = new Object[filteredLaptops.size()][columnNames.length];

        for (int i = 0; i < filteredLaptops.size(); i++) {
            Laptop laptop = filteredLaptops.get(i);
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

        resultTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(resultTable);
        add(scrollPane, BorderLayout.CENTER);

        // Create back button
        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LaptopStoreSurveyFrame();
            }
        });
        add(backButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
