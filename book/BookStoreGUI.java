import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookStoreGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Kannan Book Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 2));

        // Components
        JLabel bookIdLabel = new JLabel("Book ID:");
        JTextField bookIdField = new JTextField();
        JLabel bookNameLabel = new JLabel("Book Name:");
        JTextField bookNameField = new JTextField();
        JLabel authorLabel = new JLabel("Author Name:");
        JTextField authorField = new JTextField();
        JLabel editionLabel = new JLabel("Edition:");
        JTextField editionField = new JTextField();
        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField();
        JLabel yearLabel = new JLabel("Year:");
        String[] years = {"2023", "2022", "2021", "2020"}; // Example years
        JComboBox<String> yearComboBox = new JComboBox<>(years);
        JLabel availabilityLabel = new JLabel("Availability:");
        JRadioButton availableRadioButton = new JRadioButton("Available");
        JRadioButton notAvailableRadioButton = new JRadioButton("Not Available");
        ButtonGroup availabilityGroup = new ButtonGroup();
        availabilityGroup.add(availableRadioButton);
        availabilityGroup.add(notAvailableRadioButton);

        JButton submitButton = new JButton("Submit");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        // Add components to the frame
        frame.add(bookIdLabel);
        frame.add(bookIdField);
        frame.add(bookNameLabel);
        frame.add(bookNameField);
        frame.add(authorLabel);
        frame.add(authorField);
        frame.add(editionLabel);
        frame.add(editionField);
        frame.add(priceLabel);
        frame.add(priceField);
        frame.add(yearLabel);
        frame.add(yearComboBox);
        frame.add(availabilityLabel);
        frame.add(availableRadioButton);
        frame.add(notAvailableRadioButton);
        frame.add(submitButton);
        frame.add(resultArea);

        // Submit button action listener
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get values from fields
                String bookId = bookIdField.getText();
                String bookName = bookNameField.getText();
                String author = authorField.getText();
                String edition = editionField.getText();
                String price = priceField.getText();
                String year = (String) yearComboBox.getSelectedItem();
                String availability = availableRadioButton.isSelected() ? "Available" : "Not Available";

                // Display the details in the result area
                resultArea.setText("Book ID: " + bookId + "\n" +
                                   "Book Name: " + bookName + "\n" +
                                   "Author: " + author + "\n" +
                                   "Edition: " + edition + "\n" +
                                   "Price: $" + price + "\n" +
                                   "Year: " + year + "\n" +
                                   "Availability: " + availability);
            }
        });

        // Set frame properties
        frame.pack();
        frame.setVisible(true);
    }
}
