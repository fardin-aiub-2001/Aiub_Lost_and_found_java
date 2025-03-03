package Log;

import AllClass.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class welcome extends JFrame implements ActionListener {
    // Initialize
    private JLabel title,title1,title2,title3,title4,title5,title6,title7,title8; // Title
    private JLabel background;
    private JButton stubtn, adminbtn,loginbtn,exitbtn;
    private student[] students = new student[50];
	private Color Color1, Color2, Color3;
	private ImageIcon imgIcon,imgIcon1;
	private Cursor cursor;
	
    // Constructor
    public welcome() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Lost&Found");
        setSize(1250,740);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        // Load icon
        ImageIcon icon = new ImageIcon(".\\images\\icon.png");
        setIconImage(icon.getImage());

        // Load background image
        ImageIcon backgroundImage = new ImageIcon(".\\images\\background.jpg");
        Image img = backgroundImage.getImage();
        Image scaledImg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBackground = new ImageIcon(scaledImg);
        background = new JLabel(scaledBackground);
        background.setSize(getSize());
        add(background);

        // Title
        JLabel title = new JLabel("LOOKING FOR SOMETHING?");
        title.setBounds(730,110,400,30);
		Color1 = new Color(1,88,136); //(R,G,B=DarkBLUE)
        title.setForeground(Color1); // Set text color
        title.setFont(new Font("Britannic Bold",Font.BOLD,28));
		
		JLabel title1 = new JLabel("JUST LOGIN!!");
		title1.setBounds(730,160,400,30);
		Color1 = new Color(1,88,136); //(R,G,B=DarkBLUE)
        title1.setForeground(Color1); // Set text color
        title1.setFont(new Font("Britannic Bold",Font.BOLD,28));
		
		JLabel title2 = new JLabel("AIUB LOST & FOUND");
        title2.setBounds(140,310,400,30);
		title2.setForeground(Color.BLACK);
        title2.setFont(new Font("Britannic Bold",Font.BOLD,35));
        
		JLabel title3 = new JLabel("Discover-Recover-Uncover");
        title3.setBounds(180,350,400,30);
		title3.setForeground(Color.WHITE);
        title3.setFont(new Font("Footlight MT Light",Font.BOLD,18));
		
		JLabel title4 = new JLabel("AMERICAN INTERNATIONAL");
        title4.setBounds(300,50,400,30);
		title4.setForeground(Color.BLACK);
        title4.setFont(new Font("Footlight MT Light",Font.PLAIN,20));
		
		JLabel title5 = new JLabel("UNIVERSITY-BANGLADESH");
        title5.setBounds(300,80,400,30);
		title5.setForeground(Color.BLACK);
        title5.setFont(new Font("Footlight MT Light",Font.PLAIN,20));
		
		JLabel title6 = new JLabel("-where leaders are created.");
        title6.setBounds(300,140,400,30);
		title6.setForeground(Color.GRAY);
        title6.setFont(new Font("Aparajita",Font.PLAIN,14));
		
		JLabel title8 = new JLabel("Have an Account?");
        title8.setBounds(730,485,150, 20);
        title8.setForeground(Color.BLACK); // Set text color
        title8.setFont(new Font("Segoe UI", Font.PLAIN,18));
		
		//image
		ImageIcon imgIcon = new ImageIcon(".\\images\\aiub.png");
		JLabel title7= new JLabel(imgIcon);
		title7.setBounds(50,40,228,128);
		

		// Target
        JLabel target = new JLabel("SIGN UP AS");
        target.setBounds(730, 235, 400, 20);
        target.setForeground(Color.BLACK); // Set text color
        target.setFont(new Font("Aptos (Body)", Font.BOLD, 22));
		
		// Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);
		
        // Admin Btn
        adminbtn = new JButton("ADMIN");
        adminbtn.setBounds(930, 320,140,35);
        adminbtn.setFocusable(false);
		Color2 = new Color(106, 199, 235); //(R,G,B)
        adminbtn.setBackground(Color2); // Set text color
        adminbtn.setFont(new Font("Segoe UI Black",Font.BOLD,20));
		adminbtn.setForeground(Color.WHITE);
		adminbtn.setBorder(null);
		adminbtn.setCursor(cursor);

        // Student Btn
        stubtn = new JButton("STUDENT");
        stubtn.setBounds(730, 320, 140, 35);
        stubtn.setFocusable(false);
		Color2 = new Color(106, 199, 235); //(R,G,B)
        stubtn.setBackground(Color2); // Set text color
        stubtn.setFont(new Font("Segoe UI Black",Font.BOLD,20));
		stubtn.setForeground(Color.WHITE);
		stubtn.setBorder(null);
		stubtn.setCursor(cursor);
		
		 // Login Btn
        loginbtn = new JButton("LOGIN");
        loginbtn.setBounds(880,475,140,35);
		loginbtn.setCursor(cursor);
        loginbtn.setFocusable(false);
		Color2 = new Color(106, 199, 235); //(R,G,B)
        loginbtn.setBackground(Color2); // Set text color
        loginbtn.setFont(new Font("Segoe UI Black",Font.BOLD,20));
		loginbtn.setForeground(Color.BLACK);
		loginbtn.setBorder(null);
		
		
		 // exit Btn
        exitbtn = new JButton("EXIT");
        exitbtn.setBounds(1050,475,90,35);
		exitbtn.setCursor(cursor);
        exitbtn.setFocusable(false);
		Color2 = new Color(106, 199, 235); //(R,G,B)
        exitbtn.setBackground(Color2); // Set text color
        exitbtn.setFont(new Font("Segoe UI Black",Font.BOLD,20));
		exitbtn.setForeground(Color.RED);
		exitbtn.setBorder(null);
		
		
        // Add components to the background label
        background.add(title);
        background.add(title1);
        background.add(title2);
        background.add(title3);
        background.add(title4);
        background.add(title5);
        background.add(title6);
        background.add(title7);
        background.add(title8);
        
        background.add(target);
        background.add(adminbtn);
        background.add(stubtn);
        background.add(loginbtn);
        background.add(exitbtn);

        // Add Action Listeners
        adminbtn.addActionListener(this);
        stubtn.addActionListener(this);
		loginbtn.addActionListener(this);
		exitbtn.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminbtn) {
			new login();
			dispose();// Dispose frame instead of setting visibility false
        } else if (e.getSource() == stubtn) {
            new StuReg();
            dispose(); // Dispose frame instead of setting visibility false
        }else if (e.getSource() == loginbtn) {
            student[] students = new student[50]; // Initialize the array
			new StuLog(students); // Pass the array to StuLog constructor
			dispose(); /// Dispose frame instead of setting visibility false
        }else if (e.getSource() == exitbtn) {
            System.exit(0); // Dispose frame instead of setting visibility false
        }
    }
}
