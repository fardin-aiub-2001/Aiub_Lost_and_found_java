package Log;
import AllClass.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.ListSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ashowitems extends JFrame implements ActionListener {
    private JButton bbtn, ebtn,shbtn, exitbtn, deleteBtn;
    private JTableHeader header;
    private JTable table;
    private Cursor cursor;
    private Color Color2;
    
    public ashowitems() {
        setTitle("Lost&Found");
        setSize(1250, 740);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        JLabel background = new JLabel(scaledBackground);
        background.setSize(getSize());
        getContentPane().add(background);

        // Title
        JLabel title1 = new JLabel("ADMIN DASHBOARD");
        title1.setBounds(415, 50, 500, 30);
        title1.setForeground(Color.WHITE);
        title1.setFont(new Font("Britannic Bold", Font.BOLD, 45));
        background.add(title1);

        // Image aiub logo
        ImageIcon imgIcon = new ImageIcon(".\\images\\aiublogo.png");
        JLabel title2 = new JLabel(imgIcon);
        title2.setBounds(9, 10, 368, 117);
        background.add(title2);

        // Title img
        ImageIcon imgIcon1 = new ImageIcon(".\\images\\title.png");
        JLabel title3 = new JLabel(imgIcon1);
        title3.setBounds(920, 10, 309, 102);
        background.add(title3);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Enter Btn
        ebtn = new JButton("STUDENTS");
        ebtn.setBounds(0, 200, 142, 35);
        ebtn.setFocusable(false);
        ebtn.setBackground(Color.WHITE);
        Color2 = new Color(28, 105, 144);
        ebtn.setForeground(Color2);
        ebtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        ebtn.setBorder(null);
        ebtn.setCursor(cursor);

        // Show Btn
        shbtn = new JButton("SHOW");
        shbtn.setBounds(0, 320, 142, 35);
        shbtn.setFocusable(false);
        shbtn.setBackground(Color.WHITE);
        shbtn.setForeground(Color2);
        shbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        shbtn.setBorder(null);
        shbtn.setCursor(cursor);

      

        // Back Btn
        bbtn = new JButton("BACK");
        bbtn.setBounds(0, 440, 142, 35);
        bbtn.setCursor(cursor);
        bbtn.setFocusable(false);
        bbtn.setBackground(Color.WHITE);
        bbtn.setForeground(Color2);
        bbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        bbtn.setBorder(null);

        // Exit Btn
        exitbtn = new JButton("EXIT");
        exitbtn.setBounds(0, 560, 142, 35);
        exitbtn.setCursor(cursor);
        exitbtn.setFocusable(false);
        exitbtn.setBackground(Color.WHITE);
        exitbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        exitbtn.setForeground(Color.RED);
        exitbtn.setBorder(null);

        // Delete Btn
        deleteBtn = new JButton("DELETE");
        deleteBtn.setBounds(600, 650, 142, 35);
        deleteBtn.setCursor(cursor);
        deleteBtn.setFocusable(false);
        deleteBtn.setBackground(Color.RED);
        deleteBtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setBorder(null);

        // Create table model and table
        String[] columnNames = {"ITEMS DESCRIPTION"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model) {
            // Override the isCellEditable method to make all cells non-editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setFont(new Font("Aptos", Font.BOLD, 12));
        Color2 = new Color(106, 199, 235);
        table.setBackground(Color2);
        table.setForeground(Color.BLACK);
        table.setRowHeight(30);

        // Set font for column names (table header)
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 15));

        // Set cell selection mode to allow only single selection
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Create scroll pane and add table to it
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(150, 143, 1090, 500);
        scrollPane.setBackground(Color.WHITE); // Set background color to white
        background.add(scrollPane);

        // Load items into the table
        loadItemsFromFile();
        
        // Adjust column widths
        resizeColumnWidth();

        background.add(ebtn);
        background.add(shbtn);
        background.add(bbtn);
        background.add(exitbtn);
        background.add(deleteBtn);

        // Add Action Listeners
        ebtn.addActionListener(this);
        shbtn.addActionListener(this);
       
        bbtn.addActionListener(this);
        exitbtn.addActionListener(this);
        deleteBtn.addActionListener(this);

        setVisible(true);
    }

    // Method to resize column widths
    private void resizeColumnWidth() {
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumnModel columnModel = table.getColumnModel();
            int width =20; // Minimum width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private void loadItemsFromFile() {
        List<String> data = readDataFromFile(".\\File\\item.txt");

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (String item : data) {
            model.addRow(new Object[]{item});
        }
    }

    private List<String> readDataFromFile(String fileName) {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private void deleteItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.removeRow(selectedRow);
        // After removing the row, you may want to update your data file to reflect the changes.
        updateDataFile();
    }

    private void updateDataFile() {
        // You need to write the updated data back to your data file
        String fileName = ".\\File\\item.txt";
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                writer.write(model.getValueAt(i, 0).toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while updating the data file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bbtn) {
            new adashboard();
            dispose();
		}else if (e.getSource() ==shbtn) {
            new ashowitems();
			dispose();
        }else if (e.getSource() ==ebtn) {
            new showstudent();
			dispose();
		}else if (e.getSource() == exitbtn) {
            System.exit(0); // Dispose frame instead of setting visibility false
        }else if (e.getSource() == deleteBtn) {
            deleteItem();
        }
    }

    
}
