package Log;

import AllClass.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException;

public class StuLog implements ActionListener {
    // Initialize
    private JTextField tf1;
    private JPasswordField tp1;
    private JLabel l1, l2,l3,title, title1,title2,title3,title4,title5,title6,title7;
    private JLabel background;
    private JButton logbtn, backbtn, signbtn,exitbtn,showPasswordBtn;
    private JFrame fs;
    private student[] students = new student[50];
	private Color Color2;
	private Cursor cursor;
    // login
    public StuLog(student[] students) {
        this.students = students;
        fs = new JFrame();

        fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fs.setTitle("Lost&Found");
        fs.setSize(1250, 740);
        fs.setLocationRelativeTo(null);
        fs.setResizable(false);
        fs.setLayout(null);
        fs.setVisible(true);

        // Load icon
        ImageIcon icon = new ImageIcon(".\\images\\icon.png");
        fs.setIconImage(icon.getImage());

        // Load background image
        ImageIcon backgroundImage = new ImageIcon(".\\images\\background.jpg");
        Image img = backgroundImage.getImage();
        Image scaledImg = img.getScaledInstance(fs.getWidth(), fs.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBackground = new ImageIcon(scaledImg);
        background = new JLabel(scaledBackground);
        background.setSize(fs.getSize());
        fs.add(background);
		
		// Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);
		
		// Title
        title = new JLabel("LOGIN");
        title.setBounds(870, 70, 400, 30);
        title.setForeground(new Color(1, 88, 136)); // Set text color using RGB color code (White)
        title.setFont(new Font("Britannic Bold", Font.BOLD, 28));
        background.add(title);

        title1 = new JLabel("-log in with your organizational id.");
        title1.setBounds(730, 160, 400, 20);
        title1.setForeground(Color.BLACK); // Set text color using RGB color code (White)
        title1.setFont(new Font("Aparajita", Font.PLAIN, 15));
        background.add(title1);
		
		title2 = new JLabel("AIUB LOST & FOUND");
        title2.setBounds(140,310,400,30);
		title2.setForeground(Color.BLACK);
        title2.setFont(new Font("Britannic Bold",Font.BOLD,35));
        background.add(title2);
		
		title3 = new JLabel("Discover-Recover-Uncover");
        title3.setBounds(180,350,400,30);
		title3.setForeground(Color.WHITE);
        title3.setFont(new Font("Footlight MT Light",Font.BOLD,18));
		background.add(title3);
		
		title4 = new JLabel("AMERICAN INTERNATIONAL");
        title4.setBounds(300,50,400,30);
		title4.setForeground(Color.BLACK);
        title4.setFont(new Font("Footlight MT Light",Font.PLAIN,20));
		background.add(title4);
		
		title5 = new JLabel("UNIVERSITY-BANGLADESH");
        title5.setBounds(300,80,400,30);
		title5.setForeground(Color.BLACK);
        title5.setFont(new Font("Footlight MT Light",Font.PLAIN,20));
		background.add(title5);
		
	    title6 = new JLabel("-where leaders are created.");
        title6.setBounds(300,140,400,30);
		title6.setForeground(Color.GRAY);
        title6.setFont(new Font("Aparajita",Font.PLAIN,14));
		background.add(title6);
		
		//image
		ImageIcon imgIcon = new ImageIcon(".\\images\\aiub.png");
	    title7= new JLabel(imgIcon);
		title7.setBounds(50,40,228,128);
		background.add(title7);
		
        // User
		l1 = new JLabel("STUDENT ID");
        l1.setBounds(730, 230, 400, 20);
        l1.setForeground(Color.BLACK); // Set text color
        l1.setFont(new Font("Aptos (Body)", Font.PLAIN, 20));
        tf1 = new JTextField();
        tf1.setBounds(730, 265, 400, 30);
		Color2 = new Color(106, 199, 235); //(R,G,B)
		tf1.setBackground(Color2);
		tf1.setForeground(Color.WHITE);
		tf1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tf1.setBorder(null);
        
        // Password
        l2 = new JLabel("PASSWORD");
        l2.setBounds(730, 335, 400, 30);
        l2.setForeground(Color.BLACK); // Set text color
        l2.setFont(new Font("Aptos (Body)", Font.PLAIN, 20));
        tp1 = new JPasswordField("");
        tp1.setBounds(730, 370, 400, 30);
		Color2 = new Color(106, 199, 235); //(R,G,B)
		tp1.setBackground(Color2);
		tp1.setForeground(Color.WHITE);
		tp1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tp1.setBorder(null);
		tp1.setEchoChar('*');

        // Login button
		logbtn = new JButton("LOGIN");
        logbtn.setBounds(730, 550, 140, 35);
        logbtn.setFocusable(false);
		Color2 = new Color(106, 199, 235); //(R,G,B)
        logbtn.setBackground(Color2); // Set text color
        logbtn.setFont(new Font("Segoe UI Black",Font.BOLD,20));
        logbtn.setForeground(Color.WHITE);
		logbtn.setCursor(cursor);
		logbtn.setBorder(null);

        // back Btn
        backbtn = new JButton("BACK");
        backbtn.setBounds(900,550,110, 35);
        backbtn.setFocusable(false);
        Color2 = new Color(106, 199, 235); //(R,G,B)
        backbtn.setBackground(Color2); // Set text color
        backbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        backbtn.setForeground(Color.WHITE);
		backbtn.setCursor(cursor);
		backbtn.setBorder(null);
		
		// exit Btn
        exitbtn = new JButton("EXIT");
        exitbtn.setBounds(1040,550, 90, 35);
        exitbtn.setFocusable(false);
        Color2 = new Color(106, 199, 235); //(R,G,B)
        exitbtn.setBackground(Color2); // Set text color
        exitbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        exitbtn.setForeground(Color.RED);
		exitbtn.setCursor(cursor);
		exitbtn.setBorder(null);
		
		//previous account
		l3 = new JLabel("Don't have an Account?");
        l3.setBounds(730, 635, 200, 20);
        l3.setForeground(Color.BLACK); // Set text color
        l3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		//Sign up button
        signbtn = new JButton("SIGN UP");
        signbtn.setBounds(950,620,140,35);
        signbtn.setFocusable(false);
		Color2 = new Color(106, 199, 235); //(R,G,B)
        signbtn.setBackground(Color2); // Set text color
        signbtn.setFont(new Font("Segoe UI Black",Font.BOLD,20));
		signbtn.setForeground(Color.BLACK);
		signbtn.setCursor(cursor);
		signbtn.setBorder(null);
		
		 // Show password button
        showPasswordBtn = new JButton();
        showPasswordBtn.setIcon(new ImageIcon(".\\images\\eye.png")); // Set icon for button
        showPasswordBtn.setBounds(1130, 370, 30, 30); // Adjust position as needed
        showPasswordBtn.setBorderPainted(false);
        showPasswordBtn.setContentAreaFilled(false);
        showPasswordBtn.setCursor(cursor);
        showPasswordBtn.setFocusPainted(false);
        showPasswordBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tp1.getEchoChar() != 0) {
                    tp1.setEchoChar((char) 0); // Show password
                    showPasswordBtn.setIcon(new ImageIcon(".\\images\\eye_slash.png")); // Set icon for button
                } else {
                    tp1.setEchoChar('*'); // Hide password
                    showPasswordBtn.setIcon(new ImageIcon(".\\images\\eye.png")); // Set icon for button
                }
            }
        });
        

        // Add components to the frame
        background.add(tf1);
        background.add(tp1);
        background.add(l1);
        background.add(l2);
        background.add(l3);
        background.add(backbtn);
        background.add(logbtn);
        background.add(signbtn);
        background.add(exitbtn);
		background.add(showPasswordBtn);

        // Add Action Listeners
        logbtn.addActionListener(this);
        signbtn.addActionListener(this);
        backbtn.addActionListener(this);
        exitbtn.addActionListener(this);
        showPasswordBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
    if (e.getSource() == backbtn) {
        new welcome();
        fs.dispose();
    } else if (e.getSource() == logbtn) {
        String uid = tf1.getText();
        String password = new String(tp1.getPassword());
        boolean validCredentials = false;

        if (uid.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
        } else {
            // Load previous ID and password from student.txt
            try (Scanner scanner = new Scanner(new File(".\\File\\Student.txt"))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.startsWith("ID") && line.contains(uid)) {
                        String savedUid = line.substring(9).trim(); // Extract saved ID and trim any leading or trailing whitespace
                        if (scanner.hasNextLine()) { // Ensure there is a next line
                            String passwordLine = scanner.nextLine();
                            if (passwordLine.startsWith("Password")) {
                                String savedPassword = passwordLine.substring(13).trim(); // Extract saved password and trim any leading or trailing whitespace
                                if (password.equals(savedPassword)) {
                                    validCredentials = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                // Handle file not found exception
                ex.printStackTrace();
            }

            if (validCredentials) {
                // Successful login
                fs.dispose();
                // Assuming sdashboard is your dashboard frame class
                new sdashboard(students);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
    } else if (e.getSource() == signbtn) {
        new StuReg();
        fs.dispose();
    } else if (e.getSource() == exitbtn) {
        System.exit(0);
    }
}
}