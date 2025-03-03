package Log;
import AllClass.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import static javax.swing.JOptionPane.showMessageDialog;

public class login implements ActionListener {
    // Initialize
    private JTextField aid, aname;
    private JPasswordField apass;
    private JLabel l1, l2, l3, title, title1, title2, title3, title4, title5, title6, title7;
    private JLabel background;
    private JButton logbtn, exitbtn, backbtn, showPasswordBtn;
    private JFrame flgn;
    private Color Color2;
    private  boolean isPasswordVisible = false;
	private Cursor cursor;
	
    // Admins
    admin a1, a2, a3, a4;
    admin admins[];

    // login
    public login() {

        // Admins log in data
        a1 = new admin("SHIZAN", "23-52291-2", "11112");
        a2 = new admin("MARIN",  "23-52296-2", "22221");
        a3 = new admin("FARDIN", "23-52154-2", "33334");
        a4 = new admin("JUTHI",  "23-52145-2", "44443");
        admins = new admin[4];
        admins[0] = a1;
        admins[1] = a2;
        admins[2] = a3;
        admins[3] = a4;

        flgn = new JFrame();

        flgn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flgn.setTitle("Lost&Found");
        flgn.setSize(1250, 740);
        flgn.setLocationRelativeTo(null);
        flgn.setResizable(false);
        flgn.setLayout(null);
        flgn.setVisible(true);

        // Load icon
        ImageIcon icon = new ImageIcon(".\\images\\icon.png");
        flgn.setIconImage(icon.getImage());

        // Load background image
        ImageIcon backgroundImage = new ImageIcon(".\\images\\background.jpg");
        Image img = backgroundImage.getImage();
        Image scaledImg = img.getScaledInstance(flgn.getWidth(), flgn.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBackground = new ImageIcon(scaledImg);
        background = new JLabel(scaledBackground);
        background.setSize(flgn.getSize());
        flgn.add(background);
		
		// Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);
		
        // Title
        JLabel title = new JLabel("ADMIN LOGIN");
        title.setBounds(870, 70, 400, 30);
        title.setForeground(new Color(1, 88, 136)); // Set text color using RGB color code (White)
        title.setFont(new Font("Britannic Bold", Font.BOLD, 28));
        background.add(title);

        JLabel title1 = new JLabel("-log in with your organizational admin id.");
        title1.setBounds(730, 120, 400, 20);
        title1.setForeground(Color.BLACK); // Set text color using RGB color code (White)
        title1.setFont(new Font("Aparajita", Font.PLAIN, 15));
        background.add(title1);

        JLabel title2 = new JLabel("AIUB LOST & FOUND");
        title2.setBounds(140, 310, 400, 30);
        title2.setForeground(Color.BLACK);
        title2.setFont(new Font("Britannic Bold", Font.BOLD, 35));
        background.add(title2);

        JLabel title3 = new JLabel("Discover-Recover-Uncover");
        title3.setBounds(180, 350, 400, 30);
        title3.setForeground(Color.WHITE);
        title3.setFont(new Font("Footlight MT Light", Font.BOLD, 18));
        background.add(title3);

        JLabel title4 = new JLabel("AMERICAN INTERNATIONAL");
        title4.setBounds(300, 50, 400, 30);
        title4.setForeground(Color.BLACK);
        title4.setFont(new Font("Footlight MT Light", Font.PLAIN, 20));
        background.add(title4);

        JLabel title5 = new JLabel("UNIVERSITY-BANGLADESH");
        title5.setBounds(300, 80, 400, 30);
        title5.setForeground(Color.BLACK);
        title5.setFont(new Font("Footlight MT Light", Font.PLAIN, 20));
        background.add(title5);

        JLabel title6 = new JLabel("-where leaders are created.");
        title6.setBounds(300, 140, 400, 30);
        title6.setForeground(Color.GRAY);
        title6.setFont(new Font("Aparajita", Font.PLAIN, 14));
        background.add(title6);

        // Image
        ImageIcon imgIcon = new ImageIcon(".\\images\\aiub.png");
        JLabel title7 = new JLabel(imgIcon);
        title7.setBounds(50, 40, 228, 128);
        background.add(title7);

        // Name
        l1 = new JLabel("FULL NAME");
        l1.setBounds(730, 160, 400, 20);
        l1.setForeground(Color.BLACK); // Set text color
        l1.setFont(new Font("Aptos (Body)", Font.PLAIN, 20));
        aname = new JTextField();
        aname.setBounds(730, 185, 400, 30);
        Color2 = new Color(106, 199, 235); //(R,G,B)
        aname.setBackground(Color2);
        aname.setForeground(Color.WHITE);
        aname.setFont(new Font("Segoe UI", Font.BOLD, 20));
        aname.setBorder(null);

        // User
        l2 = new JLabel("ADMIN ID");
        l2.setBounds(730, 250, 400, 20);
        l2.setForeground(Color.BLACK); // Set text color
        l2.setFont(new Font("Aptos (Body)", Font.PLAIN, 20));
        aid = new JTextField();
        aid.setBounds(730, 275, 400, 30);
        Color2 = new Color(106, 199, 235); //(R,G,B)
        aid.setBackground(Color2);
        aid.setForeground(Color.WHITE);
        aid.setFont(new Font("Segoe UI", Font.BOLD, 20));
        aid.setBorder(null);

        // Password
        l3 = new JLabel("PASSWORD");
        l3.setBounds(730, 335, 400, 30);
        l3.setForeground(Color.BLACK); // Set text color
        l3.setFont(new Font("Aptos (Body)", Font.PLAIN, 20));
        apass = new JPasswordField("");
        apass.setBounds(730, 365, 400, 30);
        Color2 = new Color(106, 199, 235); //(R,G,B)
        apass.setBackground(Color2);
        apass.setForeground(Color.WHITE);
        apass.setFont(new Font("Segoe UI", Font.BOLD, 20));
        apass.setBorder(null);
		apass.setEchoChar('*');

        // Login button
        logbtn = new JButton("LOGIN");
        logbtn.setBounds(730, 550, 140, 35);
        logbtn.setFocusable(false);
        Color2 = new Color(106, 199, 235); //(R,G,B)
        logbtn.setBackground(Color2); // Set text color
        logbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        logbtn.setForeground(Color.WHITE);
        logbtn.setCursor(cursor);
        logbtn.setBorder(null);

        // Back Btn
        backbtn = new JButton("BACK");
        backbtn.setBounds(900, 550, 110, 35);
        backbtn.setFocusable(false);
        Color2 = new Color(106, 199, 235); //(R,G,B)
        backbtn.setBackground(Color2); // Set text color
        backbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        backbtn.setForeground(Color.WHITE);
        backbtn.setCursor(cursor);
        backbtn.setBorder(null);

        // Exit Btn
        exitbtn = new JButton("EXIT");
        exitbtn.setBounds(1040, 550, 90, 35);
        exitbtn.setFocusable(false);
        Color2 = new Color(106, 199, 235); //(R,G,B)
        exitbtn.setBackground(Color2); // Set text color
        exitbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        exitbtn.setForeground(Color.RED);
        exitbtn.setCursor(cursor);
        exitbtn.setBorder(null);

        // Show password button
        showPasswordBtn = new JButton();
        showPasswordBtn.setIcon(new ImageIcon("eye.png")); // Set icon for button
        showPasswordBtn.setBounds(1130, 365, 30, 30); // Adjust position as needed
        showPasswordBtn.setBorderPainted(false);
        showPasswordBtn.setContentAreaFilled(false);
        showPasswordBtn.setCursor(cursor);
        showPasswordBtn.setFocusPainted(false);
        showPasswordBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (apass.getEchoChar() != 0) {
                    apass.setEchoChar((char) 0); // Show password
                    showPasswordBtn.setIcon(new ImageIcon("eye_slash.png")); // Set icon for button
                } else {
                    apass.setEchoChar('*'); // Hide password
                    showPasswordBtn.setIcon(new ImageIcon("eye.png")); // Set icon for button
                }
            }
        });

       

        // Add components to the frame
        background.add(aid);
        background.add(aname);
        background.add(apass);
        background.add(l1);
        background.add(l2);
        background.add(l3);
        background.add(backbtn);
        background.add(logbtn);
    
        background.add(exitbtn);
        background.add(showPasswordBtn);

        // Add Action Listeners
        logbtn.addActionListener(this);
        backbtn.addActionListener(this);
        exitbtn.addActionListener(this);
        showPasswordBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logbtn) {
            String name = aname.getText();
            String id = aid.getText();
            String pass = apass.getText();

            int flag = 0;
            for (int i = 0; i < admins.length; i++) {
                if (name.equals(admins[i].getName()) && id.equals(admins[i].getId())
                        && pass.equals(admins[i].getAdPass())) {
                    flag = 1;
                    break;
                }

            }
            if (flag == 1) {
                new adashboard();
                flgn.dispose();
            } else {
                showMessageDialog(null, "Invalid Username,Admin id or password!");
            }

        } else if (e.getSource() == backbtn) {
            new welcome();
            flgn.dispose();
        }  else if (e.getSource() == exitbtn) {
            System.exit(0);
        } 
    }
}
