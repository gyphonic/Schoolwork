package CSC335.SammysRentals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;

import static java.awt.GridBagConstraints.NONE;
import static java.nio.file.StandardOpenOption.*;

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
    private final int FRAME_HEIGHT = 680;
    private final int FRAME_WIDTH = 450;
    private final Font HEADING = new Font("Impact", Font.BOLD, 36);
    private final Font SUBHEADING = new Font("Impact", Font.PLAIN, 28);
    private final Font PLAIN = new Font("Impact", Font.PLAIN, 16);
    private final Font TINY = new Font("Arial", Font.ITALIC, 10);
    private final Path SAVEFILE = Paths.get("src/CSC335/SammysRentals/RentalInfo.txt");
    private final ImageIcon IMG = new ImageIcon("src/CSC335/SammysRentals/kayak.png");
    final Insets GLOBAL = new Insets(5,5,5,5);
    final Insets TEXTFIELD = new Insets(5,5,5,115);


    //Rental info
    private boolean missingInfo = true;
    private final String[] EQUIPMENT = {"Personal watercraft", "Pontoon boat", "Rowboat", "Canoe", "Kayak",
            "Beach chair", "Umbrella"};
    private final int[] PRICES = {40, 40, 20, 20, 20, 7, 7};
    private final int LESSON_PRICE = 5;

    //Constructor
    public JSammysSeashore() {

        //Frame info
        super("Sammy's Seashore Rental Creator");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color bgColor = new Color(80,80,80);
        getContentPane().setBackground(bgColor);
        setIconImage(IMG.getImage());
        setResizable(false);
        setVisible(true);

        //Layout info
        setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.insets = GLOBAL;
        con.fill = GridBagConstraints.HORIZONTAL;
        con.anchor = GridBagConstraints.CENTER;

        //Build components
        createFrame(con);
    }
    //Build and place components
    private void createFrame(GridBagConstraints con) {

        //Main heading
        JLabel welcome = new JLabel("Sammy's Seashore");
        welcome.setFont(HEADING);
        con.gridx = 0;
        con.gridy = 0;
        con.gridwidth = 3;
        add(welcome, con);

        JLabel welcome2 = new JLabel("Rentals Creator");
        welcome2.setFont(HEADING);
        con.gridy++;
        add(welcome2, con);

        //Subheading for input
        JLabel inputHeader = new JLabel("Enter rental information");
        inputHeader.setFont(SUBHEADING);
        con.gridy++;
        add(inputHeader, con);

        //Rental number input
        JLabel rentalNumLabel = new JLabel("Rental number:");
        rentalNumLabel.setFont(PLAIN);
        JTextField rentalNumInput = new JTextField(10);
        con.gridy++;
        add(rentalNumLabel, con);
        con.insets = TEXTFIELD;
        con.gridx = 2;
        add(rentalNumInput, con);

        //Rental time input
        JLabel rentalTimeLabel= new JLabel("Rental hrs:");
        rentalTimeLabel.setFont(PLAIN);
        JTextField rentalTimeInput = new JTextField(5);
        con.insets = GLOBAL;
        con.gridx = 0;
        con.gridy++;
        add(rentalTimeLabel, con);
        con.insets = TEXTFIELD;
        con.gridx = 2;
        add(rentalTimeInput, con);


        //Equipment type combo box
        JLabel equipmentTypeLabel = new JLabel("Equipment rented:");
        equipmentTypeLabel.setFont(PLAIN);
        JComboBox equipmentTypeInput = new JComboBox();
        equipmentTypeInput.addItem("");
        for (int i = 0; i < EQUIPMENT.length; i++) {
            equipmentTypeInput.addItem(EQUIPMENT[i] + " $" + PRICES[i]);
        }
        con.insets = GLOBAL;
        con.gridx = 0;
        con.gridy++;
        add(equipmentTypeLabel, con);
        con.gridx = 2;
        add(equipmentTypeInput, con);

        //Lesson Checkbox
        JLabel lessonLabel = new JLabel("Lesson w/ rental?");
        lessonLabel.setFont(PLAIN);
        JCheckBox lessonBox = new JCheckBox();
        con.gridx = 0;
        con.gridy++;
        add(lessonLabel, con);
        con.fill = GridBagConstraints.CENTER;
        con.gridx = 2;
        add(lessonBox, con);

        //Rental info output
        JLabel outputHeader = new JLabel("Rental info");
        outputHeader.setFont(SUBHEADING);
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridwidth = 3;
        con.gridx = 0;
        con.gridy++;
        add(outputHeader, con);
        JLabel[] rentalOutput = new JLabel[5];
        rentalOutput[0] = new JLabel("Rental Number: ");
        rentalOutput[1] = new JLabel("Rental Hrs: ");
        rentalOutput[2] = new JLabel("Equipment rented: ");
        rentalOutput[3] = new JLabel("Lesson? ");
        rentalOutput[4] = new JLabel("Price: $");
        for (JLabel l : rentalOutput) {
            con.gridy++;
            l.setFont(PLAIN);
            add(l, con);
        }

        //Notify the user of missing information
        JLabel warning = new JLabel("*Missing information*");
        warning.setFont(PLAIN);
        con.gridx = 1;
        con.gridy++;
        add(warning, con);

        //Update button
        JButton updateButton = new JButton();
        updateButton.setText("Update");
        updateButton.setFont(PLAIN);
        con.gridwidth = 1;
        con.gridx = 1;
        con.gridy++;
        add(updateButton, con);

        //Save button
        JButton saveButton = new JButton();
        saveButton.setText("Save to file");
        saveButton.setFont(PLAIN);
        con.gridx = 1;
        con.gridy++;
        add(saveButton, con);

        //Tiny watermark on the bottom
        JLabel todd = new JLabel("Todd Mills ---- CSC335 ---- 2021");
        todd.setFont(TINY);
        con.gridx = 1;
        con.gridy++;
        add(todd, con);

        //ActionListener to save files
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //ActionListener to update the frame
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
