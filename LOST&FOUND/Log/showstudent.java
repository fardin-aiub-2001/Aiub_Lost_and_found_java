package Log;

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

public class showstudent extends JFrame implements ActionListener {
    private JButton bbtn, ebtn, shbtn, exitbtn, deleteBtn, updateBtn;
    private JTableHeader header;
    private JTable table;
    private Cursor cursor;
    private Color Color2;

    public showstudent() {
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
        deleteBtn.setBounds(650, 650, 142, 35);
        deleteBtn.setCursor(cursor);
        deleteBtn.setFocusable(false);
        deleteBtn.setBackground(Color.RED);
        deleteBtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setBorder(null);

        // Update Btn
        updateBtn = new JButton("UPDATE");
        updateBtn.setBounds(500, 650, 142, 35);
        updateBtn.setCursor(cursor);
        updateBtn.setFocusable(false);
        updateBtn.setBackground(Color.ORANGE);
        updateBtn.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        updateBtn.setForeground(Color2);
        updateBtn.setBorder(null);

        // Create table model and table
        String[] columnNames = {"STUDENTS DETAILS"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model) {
            // Override the isCellEditable method to make all cells non-editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setFont(new Font("aptos", Font.BOLD, 12));
        Color2 = new Color(106, 199, 235);
        table.setBackground(Color2);
        table.setForeground(Color.BLACK);
        table.setRowHeight(30);

        // Set font for column names (table header)
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 15));

        // Set cell selection mode to allow multiple selection
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

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
        background.add(updateBtn);

        // Add Action Listeners
        ebtn.addActionListener(this);
        shbtn.addActionListener(this);
        bbtn.addActionListener(this);
        exitbtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        updateBtn.addActionListener(this);

        setVisible(true);
    }

    // Method to resize column widths
    private void resizeColumnWidth() {
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumnModel columnModel = table.getColumnModel();
            int width = 20; // Minimum width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private void deleteStudent() {
        int[] selectedRows = table.getSelectedRows();
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this, "Please select at least one student to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        // Iterate through the selected rows in reverse order to avoid issues with index changes
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            model.removeRow(selectedRows[i]);
        }
        // After removing the rows, you may want to update your data file to reflect the changes.
        updateDataFile();
    }

    private void updateDataFile() {
        // You need to write the updated data back to your data file
        String fileName = ".\\File\\Student.txt";
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

    private void loadItemsFromFile() {
        List<String> data = readDataFromFile(".\\File\\Student.txt");

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (String item : data) {
            // Concatenate all details into a single string separated by a delimiter (e.g., comma)
            String[] details = item.split(","); // Assuming details are separated by commas
            StringBuilder concatenatedDetails = new StringBuilder();
            for (String detail : details) {
                concatenatedDetails.append(detail.trim()).append(" "); // Append each detail with a space
            }
            model.addRow(new Object[]{concatenatedDetails.toString().trim()});
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bbtn) {
            new adashboard();
            dispose();
        } else if (e.getSource() == shbtn) {
            new ashowitems();
            dispose();

        } else if (e.getSource() == ebtn) {
            new showstudent();
            dispose();
        } else if (e.getSource() == exitbtn) {
            System.exit(0); // Dispose frame instead of setting visibility false
        } else if (e.getSource() == deleteBtn) {
            deleteStudent();
        } else if (e.getSource() == updateBtn) {
            updateStudent();
        }
    }

    private void updateStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Retrieve current details
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String currentDetails = (String) model.getValueAt(selectedRow, 0);

        // Display a dialog or form to allow the user to modify the details
        String updatedDetails = JOptionPane.showInputDialog(this, "Enter updated details:", currentDetails);

        if (updatedDetails != null && !updatedDetails.isEmpty()) {
            // Update the table with the new details
            model.setValueAt(updatedDetails, selectedRow, 0);

            // Update your data file to reflect the changes
            updateDataFile();
        }
    }

}
