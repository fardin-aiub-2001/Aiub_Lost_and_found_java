package Log;

import AllClass.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adashboard extends JFrame implements ActionListener {
    // Initialize
    private JLabel title1,title2,title3,title4; // Title
    private JLabel background;
    private JButton ebtn,shbtn,bbtn,exitbtn;
    private student[] students = new student[50];
	private Color Color1, Color2, Color3;
	private ImageIcon imgIcon,imgIcon1,imgIcon2;
	private Cursor cursor;
	
    // Constructor
    public adashboard() {
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
        ImageIcon backgroundImage = new ImageIcon(".\\images\\dashback.png");
        Image img = backgroundImage.getImage();
        Image scaledImg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBackground = new ImageIcon(scaledImg);
        background = new JLabel(scaledBackground);
        background.setSize(getSize());
        add(background);

        // Title
		JLabel title1 = new JLabel("ADMIN DASHBOARD");
        title1.setBounds(415,50,500,30);
		title1.setForeground(Color.WHITE);
        title1.setFont(new Font("Britannic Bold",Font.BOLD,45));
		
		//image aiub logo
		ImageIcon imgIcon = new ImageIcon(".\\images\\aiublogo.png");
		JLabel title2= new JLabel(imgIcon);
		title2.setBounds(9,10,368,117);
		
		//title img
		ImageIcon imgIcon1 = new ImageIcon(".\\images\\title.png");
		JLabel title3= new JLabel(imgIcon1);
		title3.setBounds(920,10,309,102);
		
		 //image welcome
        imgIcon2 = new ImageIcon(".\\images\\adminwelcome.png");
        title4 = new JLabel(imgIcon2);
        title4.setBounds(375,210,595,350);


		
		// Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);
		
            //admins Btn
        ebtn = new JButton("STUDENTS");
        ebtn.setBounds(0, 200, 142, 35);
        ebtn.setFocusable(false);
        ebtn.setBackground(Color.WHITE);
        Color2 = new Color(28, 105, 144); //(R,G,B)
        ebtn.setForeground(Color2); // Set text color
        ebtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        ebtn.setBorder(null);
        ebtn.setCursor(cursor);
		
		 // Show Btn
        shbtn = new JButton("SHOW");
        shbtn.setBounds(0, 320, 142, 35);
        shbtn.setFocusable(false);
        shbtn.setBackground(Color.WHITE);
        Color2 = new Color(28, 105, 144); //(R,G,B)
        shbtn.setForeground(Color2); // Set text color
        shbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        shbtn.setBorder(null);
        shbtn.setCursor(cursor);
		
        

    
        //Back Btn
        bbtn = new JButton("BACK");
        bbtn.setBounds(0, 440, 142, 35);
        bbtn.setCursor(cursor);
        bbtn.setFocusable(false);
        bbtn.setBackground(Color.WHITE);
        Color2 = new Color(28, 105, 144); //(R,G,B)
        bbtn.setForeground(Color2); // Set text color
        bbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        bbtn.setBorder(null);

        // exit Btn
        exitbtn = new JButton("EXIT");
        exitbtn.setBounds(0, 560, 142, 35);
        exitbtn.setCursor(cursor);
        exitbtn.setFocusable(false);
        exitbtn.setBackground(Color.WHITE);
        exitbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        exitbtn.setForeground(Color.RED);
        exitbtn.setBorder(null);
		
		
        // Add components to the background label
        
        background.add(title1);
        background.add(title2);
        background.add(title3);
        background.add(title4);
        
        
     
       
        background.add(ebtn);
        background.add(shbtn);
       
        background.add(bbtn);
        background.add(exitbtn);

        // Add Action Listeners
       
        ebtn.addActionListener(this);
        shbtn.addActionListener(this);
		
		bbtn.addActionListener(this);
		exitbtn.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bbtn) {
            new login();
            dispose();
		}else if (e.getSource() ==shbtn) {
              new ashowitems();
			dispose(); /// Dispose frame instead of setting visibility false
        }else if (e.getSource() ==ebtn) {
           new showstudent();
			dispose();
		}else if (e.getSource() == exitbtn) {
            System.exit(0); // Dispose frame instead of setting visibility false
        }
    }
}
