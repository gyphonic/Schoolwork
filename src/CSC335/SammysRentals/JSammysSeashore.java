package CSC335.SammysRentals;

import javax.swing.*;
import java.awt.*;

//Todd Mills
//CSC335 Unit 14 case problems
//This class creates a GUI for some aspects of Sammy Seashore Rentals Rental Objects
public class JSammysSeashore extends JFrame {

    //Main
    public static void main(String[] args) {
        try {
            javax.swing.SwingUtilities.invokeLater(JSammysSeashore::new);
        } catch (Exception e) {
            System.out.println("Unexpected error " + e);
        }
    }

    //Frame data fields
    private final int FRAME_HEIGHT = 750;
    private final int FRAME_WIDTH = 600;
    private final Font HEADING = new Font("Arial", Font.BOLD, 36);
    private final Font SUBHEADING = new Font("Arial", Font.PLAIN, 28);
    private final Font PLAIN = new Font("Arial", Font.PLAIN, 16);
    private final Font TINY = new Font("Arial", Font.ITALIC, 10);

    //Rental info
    private boolean missingInfo = true;

    //Constructor
    public JSammysSeashore() {

        //Frame info
        super("Sammy's Seashore Rental Creator");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color bgColor = new Color(107,118,135);
        getContentPane().setBackground(bgColor);
        setResizable(false);
        setVisible(true);

        //Layout info
        setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.insets = new Insets(5,5,5,5);
        con.fill = GridBagConstraints.HORIZONTAL;
        con.anchor = GridBagConstraints.CENTER;

        //Build components
        createFrame(con);
    }
    //Build and place components
    private void createFrame(GridBagConstraints con) {

        //Main heading
        JLabel welcome = new JLabel("Sammy's Seashore Rental Creator");
        welcome.setFont(HEADING);
        con.gridx = 0;
        con.gridy = 0;
        con.gridwidth = 3;
        add(welcome, con);

        //Subheading for input
        JLabel welcome2 = new JLabel("Enter rental information");
        welcome2.setFont(SUBHEADING);
        con.gridx = 0;
        con.gridy = 1;
        add(welcome2, con);

        //Rental number input
        JLabel rentalNumLabel = new JLabel("Rental number:");
        rentalNumLabel.setFont(PLAIN);
        JTextField rentalNumInput = new JTextField(15);
        con.gridx = 0;
        con.gridy = 2;
        add(rentalNumLabel, con);
        con.gridx = 2;
        con.gridy = 2;
        add(rentalNumInput, con);

        //Rental time input
        JLabel rentalTimeLabel= new JLabel("Rental time");
        rentalTimeLabel.setFont(PLAIN);
        JTextField rentalTimeInput = new JTextField(15);
        con.gridx = 0;
        con.gridy = 3;
        add(rentalTimeLabel, con);
        con.gridx = 2;
        con.gridy = 3;
        add(rentalTimeInput, con);

        //Rental phone number
        JLabel rentalPhoneLabel = new JLabel("Phone number");
        rentalPhoneLabel.setFont(PLAIN);
        JTextField rentalPhoneInput = new JTextField(15);
        con.gridx = 0;
        con.gridy = 4;
        add(rentalPhoneLabel, con);
        con.gridx = 2;
        con.gridy = 4;
        add(rentalPhoneInput, con);

        //Equipment type combo box
        JLabel equipmentTypeLabel = new JLabel("Equipment rented");
        equipmentTypeLabel.setFont(PLAIN);
        JComboBox equipmentTypeInput = new JComboBox();
        equipmentTypeInput.addItem("");


        //Rental info output
        JLabel outputHeader = new JLabel("Rental info");
        outputHeader.setFont(SUBHEADING);
        con.gridx = 0;
        con.gridy++;
        add(outputHeader, con);
        JLabel[] rentalOutput = new JLabel[8];

        //Notify the user of missing information
        JLabel warning = new JLabel("Missing information");
        warning.setFont(PLAIN);
        con.gridwidth = 3;
        con.gridx = 1;
        con.gridy++;
        add(warning, con);

        //Update button
        JButton updateButton = new JButton();
        updateButton.setText("Update");
        con.gridwidth = 1;
        con.gridx = 1;
        con.gridy++;
        add(updateButton, con);

        //Save button
        JButton saveButton = new JButton();
        saveButton.setText("Save to file");
        con.gridx = 1;
        con.gridy++;
        add(saveButton, con);

        //Tiny watermark on the bottom
        JLabel todd = new JLabel("Todd Mills ---- CSC335 ---- 2021");
        todd.setFont(TINY);
        con.gridx = 1;
        con.gridy++;
        add(todd, con);
    }
}
