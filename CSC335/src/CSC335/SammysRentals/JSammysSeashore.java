package CSC335.SammysRentals;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.*;

import static java.awt.GridBagConstraints.*;
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
    private boolean validRentalNum = false;
    private boolean validHours = false;
    private boolean validEquipment = false;
    private String rentalNum;
    private double rentalHours;
    private int equipType;
    private boolean lessonWithRental;
    private int finalPrice = 0;
    private final String[] EQUIPMENT = {"Personal watercraft", "Pontoon boat", "Rowboat", "Canoe", "Kayak",
                                        "Beach chair", "Umbrella"};
    private final int[] PRICES = {40, 40, 20, 20, 20, 7, 7};
    private final int LESSON_PRICE = 5;
    private final String[] rentalOutputText = {"Rental Number: ","Rental Hrs: ", "Equipment rented: ",
                                            "Lesson? ", "Price: $"};


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
        con.fill = HORIZONTAL;
        con.anchor = CENTER;

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
        JComboBox<String> equipmentTypeInput = new JComboBox<String>();
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
        con.fill = CENTER;
        con.anchor = LINE_START;
        con.gridx = 2;
        add(lessonBox, con);

        //Rental info output
        JLabel outputHeader = new JLabel("Rental info");
        outputHeader.setFont(SUBHEADING);
        con.fill = HORIZONTAL;
        con.anchor = LINE_START;
        con.gridwidth = 3;
        con.gridx = 0;
        con.gridy++;
        add(outputHeader, con);
        JLabel[] rentalOutput = new JLabel[5];
        for (int i = 0; i < rentalOutput.length; i++) {
            con.gridy++;
            rentalOutput[i] = new JLabel(rentalOutputText[i]);
            rentalOutput[i].setFont(PLAIN);
            add(rentalOutput[i], con);
        }

        //Notify the user of missing information
        JLabel warning = new JLabel("Missing information");
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
        saveButton.addActionListener(z -> {
            if (!missingInfo) {
                try {
                    OutputStream output;
                    BufferedWriter writer;
                    if (SAVEFILE.toFile().exists()) {
                        output = new BufferedOutputStream((Files.newOutputStream(SAVEFILE, TRUNCATE_EXISTING)));
                    } else {
                        output = new BufferedOutputStream((Files.newOutputStream(SAVEFILE, CREATE)));
                    }
                    writer = new BufferedWriter(new OutputStreamWriter(output));
                    for (JLabel i : rentalOutput) {
                        String s = i.getText();
                        writer.write(s, 0, s.length());
                        writer.newLine();
                    }
                    writer.close();
                } catch (IOException i) {
                    System.out.println("IO error" + i);
                }
            }
        });
        //ActionListener to update the frame
        updateButton.addActionListener(y -> {
            //Check if a rental number was entered and is not crazy long
            rentalNum = rentalNumInput.getText();
            if (rentalNum.length() < 10) {
                rentalOutput[0].setText(rentalOutputText[0] + rentalNum);
                validRentalNum = true;
            } else {
                rentalOutput[0].setText(rentalOutputText[0]);
                validRentalNum = false;
            }
            //Check to see if the hour amount entered is valid and not ridiculous as well
            for (char c : rentalTimeInput.getText().toCharArray()) {
                if (Character.isDigit(c) || c == '.') {
                    validHours = true;
                } else {
                    validHours = false;
                    break;
                }
            }
            if (validHours) {
                rentalHours = Double.parseDouble(rentalTimeInput.getText());
                rentalOutput[1].setText(rentalOutputText[1] + rentalHours);
            } else {
                rentalOutput[1].setText(rentalOutputText[1]);
            }
            //Check to see if an equipment type was selected
            if (equipmentTypeInput.getSelectedIndex() == 0) {
                rentalOutput[2].setText(rentalOutputText[2]);
                validEquipment = false;
            } else {
                equipType = equipmentTypeInput.getSelectedIndex() + 1;
                rentalOutput[2].setText(rentalOutputText[2] + EQUIPMENT[equipType]);
                validEquipment = true;
            }
            //Update the lesson field
            if (lessonBox.isSelected()) {
                rentalOutput[3].setText(rentalOutputText[3] + "Yes");
                lessonWithRental = true;
            } else {
                rentalOutput[3].setText(rentalOutputText[3] + "No");
                lessonWithRental = false;
            }
            //Update the final price
            if (lessonWithRental) {
                finalPrice = Math.toIntExact(Math.round(rentalHours * PRICES[equipType] + 7));
            } else {
                finalPrice = Math.toIntExact(Math.round(rentalHours * PRICES[equipType]));
            }
            rentalOutput[4].setText(rentalOutputText[4] + finalPrice);
            //If all the req info is entered, allow the user to save information to file
            if (validEquipment && validHours && validRentalNum) {
                missingInfo = false;
                warning.setText("Ready to save");
            } else {
                missingInfo = true;
                warning.setText("Missing info");
            }
        });
    }

}
