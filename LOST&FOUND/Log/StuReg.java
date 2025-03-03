package Log;

import AllClass.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class StuReg implements ActionListener {
    // Initialize
    private student[] students = new student[50];

    private JTextField tf1, tf2, tf3;
    private JPasswordField tp1;
    private JLabel l1, l2, l3, l4, l5,l6,title, title1,title2,title3,title4,title5,title6,title7;
    private JLabel background;
    private JButton Regbtn, logbtn, exitbtn,backbtn,showPasswordBtn;
    private JFrame fg;
    private JRadioButton r1, r2, r3, r4, r5;
    private ButtonGroup bg;
    private JCheckBox c1;
    private Color Color2;
    private JComboBox jb;
	private ImageIcon imgIcon;
	private Cursor cursor;
	
    // Constructor
    public StuReg() {
        fg = new JFrame();
        fg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fg.setTitle("Lost&Found");
        fg.setSize(1250, 740);
        fg.setLocationRelativeTo(null);
        fg.setResizable(false);
        fg.setLayout(null);
        fg.setVisible(true);

        // Load icon
        ImageIcon icon = new ImageIcon(".\\images\\icon1.png");
        fg.setIconImage(icon.getImage());

        // Load background image
        ImageIcon backgroundImage = new ImageIcon(".\\images\\background1.jpg");
        Image img = backgroundImage.getImage();
        Image scaledImg = img.getScaledInstance(fg.getWidth(), fg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBackground = new ImageIcon(scaledImg);
        background = new JLabel(scaledBackground);
        background.setSize(fg.getSize());
        fg.add(background);
		
		// Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        title = new JLabel("SIGN UP");
        title.setBounds(870, 70, 400, 30);
        title.setForeground(new Color(1, 88, 136)); // Set text color using RGB color code (White)
        title.setFont(new Font("Britannic Bold", Font.BOLD, 28));
        background.add(title);

        title1 = new JLabel("-sign up with your organizational id.");
        title1.setBounds(730, 120, 400, 20);
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
		
        // Name
        l1 = new JLabel("FULL NAME");
        l1.setBounds(730, 160, 400, 20);
        l1.setForeground(Color.BLACK); // Set text color
        l1.setFont(new Font("Aptos (Body)", Font.PLAIN, 20));
        tf1 = new JTextField();
        tf1.setBounds(730, 185, 400, 30);
		Color2 = new Color(106, 199, 235); //(R,G,B)
		tf1.setBackground(Color2);
		tf1.setForeground(Color.WHITE);
        tf1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tf1.setBorder(null);

        // ID
        l2 = new JLabel("STUDENT ID");
        l2.setBounds(730, 230, 400, 20);
        l2.setForeground(Color.BLACK); // Set text color
        l2.setFont(new Font("Aptos (Body)", Font.PLAIN, 20));
        tf2 = new JTextField("xx-xxxxx-x");
        tf2.setBounds(730, 255, 400, 30);
		Color2 = new Color(106, 199, 235); //(R,G,B)
		tf2.setBackground(Color2);
		tf2.setForeground(Color.GRAY);
		tf2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tf2.setBorder(null);
		
		tf2.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (tf2.getText().equals("xx-xxxxx-x")) {
            tf2.setText("");
            tf2.setForeground(Color.WHITE); // Change text color to white when typing
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (tf2.getText().isEmpty()) {
            tf2.setForeground(Color.GRAY); // Change text color back to gray if the field is empty
            tf2.setText("xx-xxxxx-x");
        }
    }
});

        // MAIL
        l3 = new JLabel("MAIL");
        l3.setBounds(730, 300, 400, 20);
        l3.setForeground(Color.BLACK); // Set text color
        l3.setFont(new Font("Aptos (Body)", Font.PLAIN, 20));
        tf3 = new JTextField("xx-xxxxx-x@student.aiub.edu");
        tf3.setBounds(730, 325, 400, 30);
		Color2 = new Color(106, 199, 235); //(R,G,B)
		tf3.setBackground(Color2);
		tf3.setForeground(Color.GRAY);
		tf3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tf3.setBorder(null);
		
		tf3.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (tf3.getText().equals("xx-xxxxx-x@student.aiub.edu")) {
            tf3.setText("");
            tf3.setForeground(Color.WHITE); // Change text color to white when typing
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (tf3.getText().isEmpty()) {
            tf3.setForeground(Color.GRAY); // Change text color back to gray if the field is empty
            tf3.setText("xx-xxxxx-x@student.aiub.edu");
        }
    }
});

        // DEPARTMENT
        l4 = new JLabel("DEPARTMENT");
        l4.setBounds(730, 365, 400, 30);
        l4.setForeground(Color.BLACK); // Set text color
        l4.setFont(new Font("Aptos (Body)", Font.PLAIN, 20));
		

        // Department Options
        String[] arr1 = new String[] {"  ", "CSE", "EEE", "BBA", "LLB", "OTHERS"};
        jb = new JComboBox(arr1);
        jb.setBounds(730, 395, 400, 30);
		Color2 = new Color(106, 199, 235); //(R,G,B)
		jb.setBackground(Color2);
		jb.setForeground(Color.WHITE);
		jb.setFont(new Font("Segoe UI", Font.BOLD, 20));
		jb.setBorder(null);
		jb.setCursor(cursor);
        background.add(jb);

        // Password
        l5 = new JLabel("PASSWORD");
        l5.setBounds(730, 435, 400, 30);
        l5.setForeground(Color.BLACK); // Set text color
        l5.setFont(new Font("Aptos (Body)", Font.PLAIN, 20));
        tp1 = new JPasswordField("");
        tp1.setBounds(730, 465, 400, 30);
		Color2 = new Color(106, 199, 235); //(R,G,B)
		tp1.setBackground(Color2);
		tp1.setForeground(Color.WHITE);
		tp1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tp1.setBorder(null);
		tp1.setEchoChar('*');

        // Terms
        c1 = new JCheckBox("Accept Terms & Condition.");
        c1.setBounds(730, 500, 180, 30);
        c1.setForeground(Color.BLACK); // Set text color
		c1.setFont(new Font("Segoe UI", Font.PLAIN,12));
        c1.setOpaque(false); // Make background transparent
        c1.setVisible(true);
        c1.setBorder(null);
        c1.setCursor(cursor);
	

        // Register button
        Regbtn = new JButton("SIGN UP"); 
		Regbtn.setBounds(730, 550, 140, 35);
        Regbtn.setFocusable(false);
		Color2 = new Color(106, 199, 235); //(R,G,B)
        Regbtn.setBackground(Color2); // Set text color
        Regbtn.setFont(new Font("Segoe UI Black",Font.BOLD,20));
        Regbtn.setForeground(Color.WHITE);
		Regbtn.setCursor(cursor);
		Regbtn.setBorder(null);
		
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
		l6 = new JLabel("Already have an Account?");
        l6.setBounds(730, 635, 220, 20);
        l6.setForeground(Color.BLACK); // Set text color
        l6.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		//login button
        logbtn = new JButton("LOGIN");
        logbtn.setBounds(950,620,140,35);
        logbtn.setFocusable(false);
		Color2 = new Color(106, 199, 235); //(R,G,B)
        logbtn.setBackground(Color2); // Set text color
        logbtn.setFont(new Font("Segoe UI Black",Font.BOLD,20));
		logbtn.setForeground(Color.BLACK);
		logbtn.setCursor(cursor);
		logbtn.setBorder(null);
		
		 // Show password button
        showPasswordBtn = new JButton();
        showPasswordBtn.setIcon(new ImageIcon(".\\images\\eye.png")); // Set icon for button
        showPasswordBtn.setBounds(1130, 465, 30, 30); // Adjust position as needed
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
        background.add(l1);
        background.add(l2);
        background.add(l3);
        background.add(l4);
        background.add(l5);
        background.add(l6);

        background.add(tf1);
        background.add(tf2);
        background.add(tf3);

        background.add(tp1);

        background.add(c1);

        background.add(logbtn);
        background.add(Regbtn);
        background.add(exitbtn);
        background.add(backbtn);
        background.add(showPasswordBtn);

        // Add Action Listeners
        Regbtn.addActionListener(this);
        logbtn.addActionListener(this);
        exitbtn.addActionListener(this);
        backbtn.addActionListener(this);
        showPasswordBtn.addActionListener(this);
    }

    public void addStudent(student s) {
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = s;
                count++;
                this.students = students;
                break;
            }
        }
        if (count == 0) {
            System.out.println("Registered.");
        } else {
            System.out.println("Not Registered.");
        }
    }

    public student[] getStu() {
        return students;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logbtn) {
            new StuLog(students);
            fg.dispose();
        }else if (e.getSource() ==backbtn) {
            new welcome();
            fg.dispose(); 
		}else if (e.getSource() == exitbtn) {
            System.exit(0); // Dispose frame instead of setting visibility false
        } else if (e.getSource() == Regbtn) {
            String sname = tf1.getText();
            String sid = tf2.getText();
            String smail = tf3.getText();
            String spass = tp1.getText();
            String selectedDep = (String) jb.getSelectedItem(); // Get selected department from JComboBox
			
			// Check if any field contains default text
			if (sid.equals("xx-xxxxx-x") || smail.equals("xx-xxxxx-x@student") ) {
            JOptionPane.showMessageDialog(fg, "Please fill in all required fields.");
            return;}

            if (sname.length() >= 3 && sid.length() >= 3 && smail.length() >= 3 && !spass.isEmpty()) {
                if (!sname.isEmpty() && !sid.isEmpty() && !smail.isEmpty()) {
                    if (c1.isSelected()) {
                        try {
                            student s = new student(sname, sid, smail, selectedDep, spass);
                            addStudent(s);
                            new StuLog(students);
                            fg.dispose();

                            System.out.println("Student Added");
                            File file = new File(".\\File\\Student.txt");
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            FileWriter fw = new FileWriter(file, true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter pw = new PrintWriter(bw);
							
							
                            pw.println("Name       : " + sname);
                            pw.println("ID         : " + sid);
							pw.println("Password   : " + spass);
                            pw.println("Department : " + selectedDep);
                            pw.println("Mail       : " + smail);
                          

                            pw.close();
						
                        } catch (Exception ex) {
                            System.out.print(ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(fg, "Please accept the Terms & Conditions.");
                    }

                } else {
                    JOptionPane.showMessageDialog(fg, "Please fill in all fields.");
                }

            } else {
                JOptionPane.showMessageDialog(fg, "Invalid input. Please ensure all fields meet the requirements.");
            }
        }
    }
}
