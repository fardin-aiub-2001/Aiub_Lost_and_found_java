package Log;

import javax.swing.*;
import java.awt.*;
import AllClass.admin;

public class showadmins extends JFrame {
    // Initialize
    JLabel nameLabel, idLabel, passwordLabel;

    // Constructor
    public showadmins(admin admin) {
        setTitle("Admin Details");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(3, 2));

        // Initialize labels
        nameLabel = new JLabel("Name:");
        idLabel = new JLabel("ID:");
        passwordLabel = new JLabel("Password:");

        // Set font for labels
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        nameLabel.setFont(labelFont);
        idLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);

        // Add labels to the frame
        add(nameLabel);
        add(new JLabel(admin.getName()));
        add(idLabel);
        add(new JLabel(admin.getId()));
        add(passwordLabel);
        add(new JLabel(admin.getAdPass()));

        setVisible(true);
    }

    // Method to display admin details
    public static void displayshowadmins(login login, int index) {
        admin admin = login.getshowadmins(index);
        if (admin != null) {
            new showadmins(admin);
        } else {
            JOptionPane.showMessageDialog(null, "Admin not found!");
        }
    }

    
    
}
