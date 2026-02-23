import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class FoodTruckSimulationUI extends JFrame {
    public FoodTruckSimulationUI() {
        ImageIcon iconIcon = new ImageIcon(getClass().getResource("/images/icon.jpg"));
        setLayout(new BorderLayout());

        setTitle("FoodTruck Simulation");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(iconIcon.getImage());

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);  // bg = Color.BLUE
        panel.setPreferredSize(new Dimension(400, 600));  // Give left panel width

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.RED);  // bg = Color.BLUE
        panel2.setPreferredSize(new Dimension(400, 600));  // Give left panel width

        add(panel, BorderLayout.WEST);   // Left panel
        add(panel2, BorderLayout.EAST);  // Right panel
        setVisible(true);  // Last for safety
    }


    public static void main(String[] args) {
        new FoodTruckSimulationUI();
    }
}
