import javax.swing.*;
import java.awt.*;

public class FoodTruckSimulationUI extends JFrame {
    public FoodTruckSimulationUI() {
        ImageIcon iconIcon = new ImageIcon(getClass().getResource("/images/icon.jpg"));
        // setIconImage(iconIcon.getImage());

        setTitle("FoodTruck Simulation");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Fix 2: Use 'this' or just 'add(panel)' since you ARE the JFrame
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);  // make it visible
        add(panel);  // <- was 'frame.add(panel)'


        setVisible(true);


    }

    public static void main(String[] args) {
        new FoodTruckSimulationUI();
    }
}
