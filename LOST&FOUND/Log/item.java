package Log;
import java.awt.*;
import AllClass.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;



public class item implements ActionListener
{
	//Initillize
	private JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	private JLabel background,tl,title1,title2,title3;
	private JButton ItemReg,bbtn,ebtn,shbtn,exitbtn,resetbtn;
	private JFrame fi;
	private JRadioButton r1,r2,r3,r4,r5;
	private JRadioButton i1,i2,i3,i4;
	private JRadioButton bag1,bag2,bag3,bag4;
    private ButtonGroup bg,bg1,bg2;
	private JComboBox dlist;
	private JPanel datePanel,rp1,rp2;
	private JFormattedTextField dateField,timeField;
	private SimpleDateFormat dateFormat;
	private ImageIcon icon,imgIcon,imgIcon1;
	private Cursor cursor;
	private Color Color2;


	//login
	public item()
	{
		JFrame fi = new JFrame();
        fi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fi.setTitle("Lost&Found");
        fi.setSize(1250, 740);
        fi.setLocationRelativeTo(null);
        fi.setResizable(false);
        fi.setLayout(null);
        fi.setVisible(true);
		

        // Load icon
        ImageIcon icon = new ImageIcon(".\\images\\icon.png");
        fi.setIconImage(icon.getImage());

        // Load background image
        ImageIcon backgroundImage = new ImageIcon(".\\images\\dashback.png");
        Image img = backgroundImage.getImage();
        Image scaledImg = img.getScaledInstance(fi.getWidth(), fi.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBackground = new ImageIcon(scaledImg);
        background = new JLabel(scaledBackground);
        background.setSize(fi.getSize());
        fi.add(background);

        // Title
        title1 = new JLabel("STUDENT DASHBOARD");
        title1.setBounds(415, 50, 500, 30);
        title1.setForeground(Color.WHITE);
        title1.setFont(new Font("Britannic Bold", Font.BOLD, 45));

        // Image aiub logo
        imgIcon = new ImageIcon(".\\images\\aiublogo.png");
        title2 = new JLabel(imgIcon);
        title2.setBounds(9, 10, 368, 117);

        // Title img
        imgIcon1 = new ImageIcon(".\\images\\title.png");
        title3 = new JLabel(imgIcon1);
        title3.setBounds(920, 10, 309, 102);
		
		  // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

		 

		 //////////////////////////////////////////////////////////////Radio
		r1 = new JRadioButton("Devices");
		r1.setBounds(220, 160, 120, 30);
        r1.setFocusable(false);
        Color2 = new Color(106, 199, 235); //(R,G,B)
        r1.setBackground(Color2); // Set text color
        r1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        r1.setForeground(Color.WHITE);
        r1.setBorder(null);
        r1.setCursor(cursor);
        r2 = new JRadioButton("ID card");
		r2.setBounds(420, 160, 120, 30);
        r2.setFocusable(false);
        Color2 = new Color(106, 199, 235); //(R,G,B)
        r2.setBackground(Color2); // Set text color
        r2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        r2.setForeground(Color.WHITE);
        r2.setBorder(null);
        r2.setCursor(cursor);
        r3 = new JRadioButton("Book");
		r3.setBounds(620, 160, 120, 30);
        r3.setFocusable(false);
        Color2 = new Color(106, 199, 235); //(R,G,B)
        r3.setBackground(Color2); // Set text color
        r3.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        r3.setForeground(Color.WHITE);
        r3.setBorder(null);
        r3.setCursor(cursor);
        r4 = new JRadioButton("Wallet/Bag");
		r4.setBounds(820, 160, 150, 30);
        r4.setFocusable(false);
        Color2 = new Color(106, 199, 235); //(R,G,B)
        r4.setBackground(Color2); // Set text color
        r4.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        r4.setForeground(Color.WHITE);
        r4.setBorder(null);
        r4.setCursor(cursor);
        r5 = new JRadioButton("Others");
        r5.setBounds(1050, 160, 120, 30);
        r5.setFocusable(false);
        Color2 = new Color(106, 199, 235); //(R,G,B)
        r5.setBackground(Color2); // Set text color
        r5.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        r5.setForeground(Color.WHITE);
        r5.setBorder(null);
        r5.setCursor(cursor);

		bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        bg.add(r5);

		/////////////////////////////////////////////////////////////////////Devices
		 String[] devices=new String[] { "Select Device","Mobile","Airpods", "Laptop","Charger","Powerbank","Ear Phones","Watch","Calculator","Others"};
		 dlist = new JComboBox(devices);
         dlist.setBounds(220, 260, 200, 30);
		 Color2 = new Color(106, 199, 235); //(R,G,B)
		 dlist.setBackground(Color2);
		 dlist.setForeground(Color.WHITE);
		 dlist.setFont(new Font("Segoe UI", Font.BOLD, 20));
		 dlist.setBorder(null);
		 dlist.setCursor(cursor);
		 dlist.setVisible(false);
		 

		 ///////////////////////////////////////////////////////////////////Brand
		 
		 tf6 = new JTextField("Brand");
		 tf6.setBounds(570,260,200,30); 
		 Color2 = new Color(106, 199, 235); //(R,G,B)
		 tf6.setBackground(Color2);
		 tf6.setForeground(Color.WHITE);
		 tf6.setFont(new Font("Segoe UI", Font.BOLD, 20));
		 tf6.setBorder(null);
		 tf6.setVisible(false);
		 
		 tf6.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (tf6.getText().equals("Brand")) {
            tf6.setText("");
            tf6.setForeground(Color.WHITE); // Change text color to white when typing
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (tf6.getText().isEmpty()) {
            tf6.setForeground(Color.GRAY); // Change text color back to gray if the field is empty
            tf6.setText("Brand");
        }
    }
});
		 
         

		////////////////////////////////////////////////////////////////////Id department
		rp1 = new JPanel();
		i1 = new JRadioButton("FST");
		i1.setFocusable(false);
		i1.setBounds(220,260,120,40);
		Color2 = new Color(106, 199, 235); //(R,G,B)
        i1.setBackground(Color2); // Set text color
        i1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        i1.setForeground(Color.BLUE);
        i1.setBorder(null);
        i1.setCursor(cursor);
        i2 = new JRadioButton("FE");
		i2.setFocusable(false);
		i2.setBounds(320,260,120,40);
		Color2 = new Color(106, 199, 235); //(R,G,B)
        i2.setBackground(Color2); // Set text color
        i2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        i2.setForeground(Color.ORANGE);
        i2.setBorder(null);
        i2.setCursor(cursor);
        i3 = new JRadioButton("FBA");
		i3.setFocusable(false);
		i3.setBounds(420,260,120,40);
		Color2 = new Color(106, 199, 235); //(R,G,B)
        i3.setBackground(Color2); // Set text color
        i3.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        i3.setForeground(Color.GREEN);
        i3.setBorder(null);
        i3.setCursor(cursor);
        i4 = new JRadioButton("FASS");
		i4.setFocusable(false);
		i4.setBounds(520,260,120,40);
		Color2 = new Color(106, 199, 235); //(R,G,B)
        i4.setBackground(Color2); // Set text color
        i4.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        i4.setForeground(Color.RED);
        i4.setBorder(null);
        i4.setCursor(cursor);
       
  

        bg1 = new ButtonGroup();
        bg1.add(i1);
        bg1.add(i2);
        bg1.add(i3);
        bg1.add(i4);

		//adding the button in panel
		rp1.add(i1);
		rp1.add(i2);
		rp1.add(i3);
		rp1.add(i4);
		rp1.setBounds(200,255,280,40);
		rp1.setBackground(Color.WHITE);
		rp1.setVisible(false);
		rp1.setBorder(null);

		///////////////////////////////////////////////////////////////////////////////////Wallet
		rp2 = new JPanel();
		bag1 = new JRadioButton("Ladis Purse");
		Color2 = new Color(106, 199, 235); //(R,G,B)
        bag1.setBackground(Color2); // Set text color
        bag1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        bag1.setForeground(Color.RED);
        bag1.setBorder(null);
        bag1.setCursor(cursor);
        bag2 = new JRadioButton("Wallet");
		Color2 = new Color(106, 199, 235); //(R,G,B)
        bag2.setBackground(Color2); // Set text color
        bag2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        bag2.setForeground(Color.RED);
        bag2.setBorder(null);
        bag2.setCursor(cursor);
        bag3 = new JRadioButton("Bagpack");
		Color2 = new Color(106, 199, 235); //(R,G,B)
        bag3.setBackground(Color2); // Set text color
        bag3.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        bag3.setForeground(Color.RED);
        bag3.setBorder(null);
        bag3.setCursor(cursor);
        bag4 = new JRadioButton("Laptop Bag");
		Color2 = new Color(106, 199, 235); //(R,G,B)
        bag4.setBackground(Color2); // Set text color
        bag4.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        bag4.setForeground(Color.RED);
        bag4.setBorder(null);
        bag4.setCursor(cursor);
        bag1.setBounds(220,260,140,40);
        bag2.setBounds(320,260,140,40);
        bag3.setBounds(420,260,140,40);
        bag4.setBounds(520,260,140,40);
		bag1.setFocusable(false);
		bag2.setFocusable(false);
		bag3.setFocusable(false);
		bag4.setFocusable(false);
		

        bg2 = new ButtonGroup();
        bg2.add(bag1);
        bg2.add(bag2);
        bg2.add(bag3);
        bg2.add(bag4);

		//adding the button in panel
		rp2.add(bag1);
		rp2.add(bag2);
		rp2.add(bag3);
		rp2.add(bag4);
		rp2.setBounds(215,255,500,40);
		rp2.setBackground(Color.WHITE);
		rp2.setVisible(false);
		rp2.setBorder(null);
		
		
		 //////////////////////////////////////////////////////Others/Book
		 tf1 = new JTextField("Details");
		 tf1.setBounds(220, 260, 550, 30);
		 Color2 = new Color(106, 199, 235); //(R,G,B)
		 tf1.setBackground(Color2);
		 tf1.setForeground(Color.GRAY);
		 tf1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		 tf1.setBorder(null);
		 tf1.setVisible(false);
		 
		
		
		
		 tf1.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (tf1.getText().equals("Details")) {
            tf1.setText("");
            tf1.setForeground(Color.WHITE); // Change text color to white when typing
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (tf1.getText().isEmpty()) {
            tf1.setForeground(Color.GRAY); // Change text color back to gray if the field is empty
            tf1.setText("Details");
        }
    }
});
		
		///////////////////////////////////////////////////////////////////color
		tf7 = new JTextField("Color");
		tf7.setBounds(920,260,200,30); 
		Color2 = new Color(106, 199, 235); //(R,G,B)
		tf7.setBackground(Color2);
		tf7.setForeground(Color.GRAY);
		tf7.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tf7.setBorder(null);
		tf7.setFocusable(true);
		
		tf7.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (tf7.getText().equals("Color")) {
            tf7.setText("");
            tf7.setForeground(Color.WHITE); // Change text color to white when typing
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (tf7.getText().isEmpty()) {
            tf7.setForeground(Color.GRAY); // Change text color back to gray if the field is empty
            tf7.setText("Color");
        }
    }
});

		////////////////////////////////////////////////////////////////////Name
		tf5 = new JTextField("Name");
		tf5.setBounds(220,360,200,30); 
		Color2 = new Color(106, 199, 235); //(R,G,B)
		tf5.setBackground(Color2);
		tf5.setForeground(Color.GRAY);
		tf5.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tf5.setBorder(null);
		tf5.setFocusable(true);
		
				 tf5.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (tf5.getText().equals("Name")) {
            tf5.setText("");
            tf5.setForeground(Color.WHITE); // Change text color to white when typing
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (tf5.getText().isEmpty()) {
            tf5.setForeground(Color.GRAY); // Change text color back to gray if the field is empty
            tf5.setText("Name");
        }
    }
});
		
		
		////////////////////////////////////////////////////////////Teams ID
		tf4 = new JTextField("Teams ID");
		tf4.setBounds(570,360,200,30); 
		tf4.setVisible(true);
		Color2 = new Color(106, 199, 235); //(R,G,B)
		tf4.setBackground(Color2);
		tf4.setForeground(Color.GRAY);
		tf4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tf4.setBorder(null);
		tf4.setFocusable(true);
		
				 tf4.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (tf4.getText().equals("Teams ID")) {
            tf4.setText("");
            tf4.setForeground(Color.WHITE); // Change text color to white when typing
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (tf4.getText().isEmpty()) {
            tf4.setForeground(Color.GRAY); // Change text color back to gray if the field is empty
            tf4.setText("Teams ID");
        }
    }
});
		
		
		//////////////////////////////////////////////////////////////contact
		
		tf3 = new JTextField("Contact");
		tf3.setBounds(920,360,200,30); 
		Color2 = new Color(106, 199, 235); //(R,G,B)
		tf3.setBackground(Color2);
		tf3.setForeground(Color.GRAY);
		tf3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tf3.setBorder(null);
		tf3.setFocusable(true);
		
		 tf3.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (tf3.getText().equals("Contact")) {
            tf3.setText("");
            tf3.setForeground(Color.WHITE); // Change text color to white when typing
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (tf3.getText().isEmpty()) {
            tf3.setForeground(Color.GRAY); // Change text color back to gray if the field is empty
            tf3.setText("Contact");
        }
    }
});

		

		 ///////////////////////////////////////////////////////////////Location
		
		tf2 = new JTextField("Location");
		tf2.setBounds(220,460,200,30); 
		tf2.setVisible(true);
		Color2 = new Color(106, 199, 235); //(R,G,B)
		tf2.setBackground(Color2);
		tf2.setForeground(Color.GRAY);
		tf2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tf2.setBorder(null);
		tf2.setFocusable(true);
		
		 tf2.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (tf2.getText().equals("Location")) {
            tf2.setText("");
            tf2.setForeground(Color.WHITE); // Change text color to white when typing
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (tf2.getText().isEmpty()) {
            tf2.setForeground(Color.GRAY); // Change text color back to gray if the field is empty
            tf2.setText("Location");
        }
    }
});

		

		//////////////////////////////////////////////////////////Date
	
		dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        dateField = new JFormattedTextField("DD-MM-YYYY");
        dateField.setColumns(10);
		dateField.setBounds(570,460,200,30);
		dateField.setVisible(true);
		Color2 = new Color(106, 199, 235); //(R,G,B)
		dateField.setBackground(Color2);
		dateField.setForeground(Color.GRAY);
		dateField.setFont(new Font("Segoe UI", Font.BOLD, 20));
		dateField.setBorder(null);
		dateField.setFocusable(true);
		
		
	    dateField.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (dateField.getText().equals("DD-MM-YYYY")) {
            dateField.setText("");
            dateField.setForeground(Color.WHITE); // Change text color to white when typing
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (dateField.getText().isEmpty()) {
            dateField.setForeground(Color.GRAY); // Change text color back to gray if the field is empty
            dateField.setText("DD-MM-YYYY");
        }
    }
});
		

		/////////////////////////////////////////////////////////Time
		tl = new JLabel("Time");
        tl.setBounds(920, 425, 60, 30);
		tl.setForeground(Color.BLACK);
		tl.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
        

        try {
            MaskFormatter timeMask = new MaskFormatter("##:##");
            timeMask.setPlaceholderCharacter('0'); // Optional: sets the placeholder for empty fields

        timeField = new JFormattedTextField(timeMask);
        timeField.setBounds(920,460,60, 30);
		Color2 = new Color(106, 199, 235); //(R,G,B)
		timeField.setBackground(Color2);
		timeField.setForeground(Color.WHITE);
		timeField.setFont(new Font("Segoe UI", Font.BOLD, 20));
		timeField.setFocusable(true);
		timeField.setBorder(null);
		
		
		
        
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
          //////////////////////////////////////////Lost or found

		 tf8 = new JTextField("Lost/Found");
		 tf8.setBounds(220,560,200,30); 
		 tf8.setVisible(true);
		 Color2 = new Color(106, 199, 235); //(R,G,B)
		 tf8.setBackground(Color2);
		 tf8.setForeground(Color.GRAY);
		 tf8.setFont(new Font("Segoe UI", Font.BOLD, 20));
		 tf8.setFocusable(true);
		 tf8.setBorder(null);
		
		 tf8.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        if (tf8.getText().equals("Lost/Found")) {
            tf8.setText("");
            tf8.setForeground(Color.WHITE); // Change text color to white when typing
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (tf8.getText().isEmpty()) {
            tf8.setForeground(Color.GRAY); // Change text color back to gray if the field is empty
            tf8.setText("Lost/Found");
        }
    }
});

		
		
		//Item Register button

		ItemReg = new JButton("REGISTER ITEM");
		ItemReg.setBounds(570, 560,200, 35);
		ItemReg.setVisible(true);
		ItemReg.setBackground(Color.RED);
		ItemReg.setForeground(Color.WHITE);
		ItemReg.setFont(new Font("Segoe UI", Font.BOLD, 20));
		ItemReg.setFocusable(false);
		ItemReg.setBorder(null);
		ItemReg.setCursor(cursor);


		//resetbtn
		resetbtn = new JButton("RESET");
		resetbtn.setBounds(920, 560,150, 35);
		resetbtn.setVisible(true);
		Color2 = new Color(106, 199, 235); //(R,G,B)
		resetbtn.setBackground(Color2);
		resetbtn.setForeground(Color.RED);
		resetbtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
		resetbtn.setFocusable(false);
		resetbtn.setBorder(null);
		resetbtn.setCursor(cursor);
		
		
		
		
		
		

		//add

		background.add(ItemReg);
		background.add(title1);
		background.add(title2);
		background.add(title3);
		

		background.add(tl);
		background.add(timeField);

        background.add(dlist);


		background.add(r1);
		background.add(r2);
		background.add(r3);
		background.add(r4);
		background.add(r5);

		background.add(rp1);
		background.add(rp2);

		background.add(tf1);
		background.add(tf2);
		background.add(tf3);
		background.add(tf4);
		background.add(tf5);
		background.add(tf6);
		background.add(tf7);
		background.add(tf8);
		
		 // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);


        //Enter Btn
        ebtn = new JButton("ENTER");
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

      
		// add button to background
       
        background.add(ebtn);
        background.add(shbtn);
       
        background.add(bbtn);
        background.add(resetbtn);
        background.add(exitbtn);


		background.add(dateField);
		
		////////////////////////////////////////////////////////////addActionListener
		ItemReg.addActionListener(this);
		r5.addActionListener(this);
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r4.addActionListener(this);
		
		
        ebtn.addActionListener(this);
        shbtn.addActionListener(this);
       
        bbtn.addActionListener(this);
        resetbtn.addActionListener(this);
        exitbtn.addActionListener(this);
	
		
		
		
       
	}
	




	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ItemReg) {
			// Get the entered information
			String Name = tf5.getText();
			String location = tf2.getText();
			String contact = tf3.getText();
			String teamsId = tf4.getText();
			String date = dateField.getText();
			String lf = tf8.getText();
			String time = timeField.getText();
	
			   // Check if any field contains default text
			if (Name.equals("Name") || location.equals("Location") || contact.equals("Contact") || teamsId.equals("Teams ID") || date.equals("DD/MM/YYYY") || lf.equals("Lost/Found") || time.equals("  :  ")) {
            JOptionPane.showMessageDialog(fi, "Please fill in all required fields.");
            return;
        }

			String selectedCategory = "";
			String additionalInfo = "";
			String brand = "";
			String selectedDeviceType = "";
			if (r1.isSelected()) {
				selectedCategory = "Devices";
				selectedDeviceType = dlist.getSelectedItem().toString();
				brand = "Brand: " + tf6.getText();
				 if (dlist.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(fi, "Please select a Device type.");
                return;
            }
			} else if (r2.isSelected()) {
				selectedCategory = "ID card";
				additionalInfo = "";
				if (!i1.isSelected() && !i2.isSelected() && !i3.isSelected() && !i4.isSelected()) {
                JOptionPane.showMessageDialog(fi, "Please select ID Card type.");
                return;
				} else if (i1.isSelected()) {
					additionalInfo += "FST";
				} else if (i2.isSelected()) {
					additionalInfo += "FE";
				} else if (i3.isSelected()) {
					additionalInfo += "FBA";
				} else if (i4.isSelected()) {
					additionalInfo += "FASS";
				}
			} else if (r3.isSelected()) {
				selectedCategory = "Book";
				 if (tf1.equals("Details") ) {
                JOptionPane.showMessageDialog(fi, "Please add Book details.");
                return;
            }
			} else if (r4.isSelected()) {
				selectedCategory = "Wallet/Bag";
				additionalInfo = "Type: ";
				 if (!bag1.isSelected() && !bag2.isSelected() && !bag3.isSelected() && !bag4.isSelected()) {
                JOptionPane.showMessageDialog(fi, "Please select Wallet/Bag type.");
                return;
				} else if (bag1.isSelected()) {
					additionalInfo += "Ladies Purse";
				} else if (bag2.isSelected()) {
					additionalInfo += "Wallet";
				} else if (bag3.isSelected()) {
					additionalInfo += "Bag pack";
				} else if (bag4.isSelected()) {
					additionalInfo += "Laptop Bag";
				}
			} else if (r5.isSelected()) {
				selectedCategory = "Others";
				  if (tf1.equals("Details") ) {
                JOptionPane.showMessageDialog(fi, "Please add Book details.");
                return;
			} else {
            JOptionPane.showMessageDialog(fi, "Please select a category.");
            return;
			}}
	
			// Create a string to write to the file
			String dataToWrite = "Name: " + Name + "\t" +
								 " Category: " + selectedCategory + "\t" +
								 " Device Type: " + selectedDeviceType + "\t" +
								 " Brand: " + brand + "\t" +
								 " Additional: " + additionalInfo + "\t" +
								 " Location: " + location + "\t" +
								 " Contact: " + contact + "\t" +
								 " Teams ID: " + teamsId + "\t" +
								 " Date: " + date + "\t" +
								 " Lost/Found: " + lf + "\t" +
								 " Time: " + time + "\t\n";
	

			try {
				File file = new File(".\\File\\item.txt");
				boolean fileExists = file.exists();
				
				FileWriter fileWriter = new FileWriter(file, true); // true for append mode
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
				if (!fileExists) {
					file.createNewFile();
				}
			
				bufferedWriter.write(dataToWrite);
				bufferedWriter.close();
			

				JOptionPane.showMessageDialog(fi, "Item information saved successfully!");
			}catch (IOException ex) {
				ex.printStackTrace();

			}
			new item();
            fi.dispose();
		}

	
		if (e.getSource() == r5) 
		{
			tf1.setVisible(true);
			dlist.setVisible(false);
			tf6.setVisible(false);
			
			rp1.setVisible(false);
			rp2.setVisible(false);
		} 
		else if (e.getSource() == r1)
		 {
			dlist.setVisible(true);
			tf6.setVisible(true);
			
			tf1.setVisible(false);
			rp1.setVisible(false);
			rp2.setVisible(false);
		} 
		
		else if (e.getSource() == r2) 
		{
			rp1.setVisible(true);  
			dlist.setVisible(false);
			tf6.setVisible(false);
			
			tf1.setVisible(false);
			rp2.setVisible(false);
		} 
			 
		else if (e.getSource() == r4)
		 {
			rp2.setVisible(true);
			dlist.setVisible(false);
			tf6.setVisible(false);
			
			tf1.setVisible(false);
			rp1.setVisible(false);
			
		} 
		else if (e.getSource() == r3)
			 {
			tf6.setVisible(false);
			
			dlist.setVisible(false);
			tf1.setVisible(true);
			rp1.setVisible(false);
			rp2.setVisible(false);
		}
		else 
			 {
			tf6.setVisible(false);
			
			dlist.setVisible(false);
			tf1.setVisible(false);
			rp1.setVisible(false);
			rp2.setVisible(false);
		}
		if (e.getSource() == resetbtn) {
            new item();
            fi.dispose();
        } 
		else if (e.getSource() == ebtn) {
            new item();
            fi.dispose();
        } else if (e.getSource() == bbtn) {
			student[] students = new student[50];
            new sdashboard(students);
            fi.dispose();
        } else if (e.getSource() == shbtn) {
           new showitems();
           fi.dispose();
        } else if (e.getSource() == exitbtn) {
            System.exit(0); // Dispose frame instead of setting visibility false
        }
	
}
	}
