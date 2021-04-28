package CSC335.CarlysCatering;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

//Todd Mills
//CSC335 Unit 14 case Problems
//This class uses a GUI to record Event information for Carly's Catering

public class JCarlysCatering extends JFrame {

    //Main
    public static void main(String[] args) {
        try {
            javax.swing.SwingUtilities.invokeLater(JCarlysCatering::new);
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
    private final Path SAVEFILE = Paths.get("src/CSC335/CarlysCatering/EventInfo.txt");
    private final ImageIcon IMG = new ImageIcon("src/CSC335/CarlysCatering/woman.png");

    //Event info
    private boolean missingInfo  = true;
    private final int PRICE_PER_GUEST = 35;
    private String eventNum;
    private String phoneNum;
    private int guestNum;
    private int totalCost;
    private static final String[] entreeChoices = {"Steak", "Cheeseburgers", "Salmon", "Pizza", "Chicken", "Pasta"};
    private static final String[] sideChoices = {"Macaroni", "Ceaser salad", "Mixed vegetables", "Fruit salad",
            "Cheese tray", "Meat tray"};
    private static final String[] dessertChoices = {"Angel food cake", "Brownies", "Chocolate chip cookies",
            "Peach cobbler"};
    private boolean validEventNum = false;
    private boolean validGuestnum = false;
    private boolean validPhoneNum = false;
    private boolean validEntree = false;
    private boolean validSide1 = false;
    private boolean validSide2 = false;
    private boolean validDessert = false;


    //Constructor
    public JCarlysCatering() {

        //Frame info
        super("Carly's Catering Event Creator");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color bgColor = new Color(107, 118, 135);
        getContentPane().setBackground(bgColor);
        setIconImage(IMG.getImage());
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
        JLabel welcome = new JLabel("Carly's Catering Event Creator");
        welcome.setFont(HEADING);
        con.gridx = 0;
        con.gridy = 0;
        con.gridwidth = 3;
        add(welcome, con);

        //Subheading for input
        JLabel welcome2 = new JLabel("Enter event information");
        welcome2.setFont(SUBHEADING);
        con.gridx = 0;
        con.gridy = 1;
        add(welcome2, con);

        //Event number input
        JLabel eventNumLabel = new JLabel("Event number:");
        eventNumLabel.setFont(PLAIN);
        JTextField eventNumInput = new JTextField(15);
        con.gridx = 0;
        con.gridy = 2;
        con.gridwidth = 1;
        add(eventNumLabel, con);
        con.gridx = 2;
        con.gridy = 2;
        add(eventNumInput, con);

        //Guest number input
        JLabel guestNumLabel = new JLabel("Number of guests:");
        JTextField guestNumInput = new JTextField(15 );
        guestNumLabel.setFont(PLAIN);
        con.gridx = 0;
        con.gridy = 3;
        add(guestNumLabel, con);
        con.gridx = 2;
        con.gridy = 3;
        add(guestNumInput, con);

        //Phone number input
        JLabel phoneNumLabel = new JLabel("Contact phone number:");
        JTextField phoneNumInput = new JTextField(15);
        phoneNumLabel.setFont(PLAIN);
        con.gridx = 0;
        con.gridy = 4;
        add(phoneNumLabel, con);
        con.gridx = 2;
        con.gridy = 4;
        add(phoneNumInput, con);

        //Entree combo box
        JLabel entreeLabel = new JLabel("Entree choice:");
        entreeLabel.setFont(PLAIN);
        JComboBox entreeInput = new JComboBox();
        entreeInput.addItem("");
        for (String s : entreeChoices) {
            entreeInput.addItem(s);
        }
        con.gridx = 0;
        con.gridy = 5;
        add(entreeLabel, con);
        con.gridx = 2;
        con.gridy = 5;
        add(entreeInput, con);


        //Side1 combo box
        JLabel side1Label = new JLabel("First side choice:");
        side1Label.setFont(PLAIN);
        JComboBox side1Input = new JComboBox();
        side1Input.addItem("");
        for (String s : sideChoices) {
            side1Input.addItem(s);
        }
        con.gridx = 0;
        con.gridy = 6;
        add(side1Label, con);
        con.gridx = 2;
        con.gridy = 6;
        add(side1Input, con);

        //Side2 combo box
        JLabel side2Label = new JLabel("Second side choice:");
        side2Label.setFont(PLAIN);
        JComboBox side2Input = new JComboBox();
        side2Input.addItem("");
        for (String s : sideChoices) {
            side2Input.addItem(s);
        }
        con.gridx = 0;
        con.gridy = 7;
        add(side2Label, con);
        con.gridx = 2;
        con.gridy = 7;
        add(side2Input, con);

        //Dessert combo box
        JLabel dessertLabel = new JLabel("Dessert choice:");
        dessertLabel.setFont(PLAIN);
        JComboBox dessertInput = new JComboBox();
        dessertInput.addItem("");
        for (String s : dessertChoices) {
            dessertInput.addItem(s);
        }
        con.gridx = 0;
        con.gridy = 8;
        add(dessertLabel, con);
        con.gridx = 2;
        con.gridy = 8;
        add(dessertInput, con);

        //Event info output:
        JLabel outputHeader = new JLabel("Event info");
        outputHeader.setFont(SUBHEADING);
        con.gridx = 0;
        con.gridy++;
        add(outputHeader, con);
        JLabel[] eventOutput = new JLabel[8];
        eventOutput[0] = new JLabel("Event number: ");
        eventOutput[1] = new JLabel("Guests: ");
        eventOutput[2] = new JLabel("Phone: ");
        eventOutput[3] = new JLabel("Entree: ");
        eventOutput[4] = new JLabel("First side: ");
        eventOutput[5] = new JLabel("Second side: ");
        eventOutput[6] = new JLabel("Dessert: ");
        eventOutput[7] = new JLabel("Price: $0");
        for (JLabel i : eventOutput) {
            i.setFont(PLAIN);
            con.gridy++;
            add(i, con);
        }
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
        saveButton.setEnabled(false);
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
                try {
                    OutputStream output;
                    BufferedWriter writer;
                    if (SAVEFILE.toFile().exists()) {
                        output = new BufferedOutputStream(Files.newOutputStream(SAVEFILE, TRUNCATE_EXISTING));
                    } else {
                        output = new BufferedOutputStream(Files.newOutputStream(SAVEFILE, CREATE));
                    }
                    writer = new BufferedWriter(new OutputStreamWriter(output));
                    for (JLabel i : eventOutput) {
                        String s = i.getText();
                        writer.write(s, 0, i.getText().length());
                        writer.newLine();
                    }
                    writer.close();
                    warning.setText("Saved to: " + SAVEFILE.getFileName());
                } catch (IOException i) {
                    System.out.println("IO error" + i);
                }
            }
        });

        //Update event information output when the update button is pressed
        //Checks to see if the information entered is somewhat valid
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Update event num, make sure it's not too long
                eventNum = eventNumInput.getText();
                if (eventNum.length() < 10) {
                    eventOutput[0].setText("Event number: " + eventNum);
                    validEventNum = true;
                } else {
                    eventOutput[0].setText("Event number: ");
                    validEventNum = false;
                }
                //Update guest Num
                //Hacky way to check if the guest number entered is a number
                for (char c : guestNumInput.getText().toCharArray()) {
                    if (Character.isDigit(c)) {
                        validGuestnum = true;
                    } else {
                        validGuestnum = false;
                        break;
                    }
                }
                if (validGuestnum) {
                    guestNum = Integer.parseInt(guestNumInput.getText());
                    eventOutput[1].setText("Guests: " + guestNum);
                } else {
                    eventOutput[1].setText("Guests: ");
                }
                //Update phone num, make sure it's not too long as well
                phoneNum = phoneNumInput.getText();
                if (phoneNum.length() < 14) {
                    eventOutput[2].setText("Phone: " + phoneNum);
                    validPhoneNum = true;
                } else {
                    eventOutput[2].setText("Phone: ");
                    validPhoneNum = false;
                }
                //Check for entree choice
                if (entreeInput.getSelectedIndex() == 0) {
                    eventOutput[3].setText("Entree: ");
                    validEntree = false;
                } else {
                    eventOutput[3].setText("Entree: " + entreeInput.getSelectedItem().toString());
                    validEntree = true;
                }
                //Check for first side choice
                if (side1Input.getSelectedIndex() == 0) {
                    eventOutput[4].setText("First side: ");
                    validSide1 = false;
                } else {
                    eventOutput[4].setText("First side: " + side1Input.getSelectedItem().toString());
                    validSide1 = true;
                }
                //Check for second side choice
                if (validSide1 || side2Input.getSelectedIndex()!= 0) {
                    eventOutput[5].setText("Second side: " + side2Input.getSelectedItem().toString());
                    validSide2 = true;
                } else {
                    eventOutput[5].setText("Second side: ");
                }
                //Check for dessert choice
                if (dessertInput.getSelectedIndex() == 0) {
                    eventOutput[6].setText("Dessert: ");
                    validDessert = false;
                } else {
                    eventOutput[6].setText("Dessert: " + dessertInput.getSelectedItem().toString());
                    validDessert = true;
                }
                //Set total price in output
                totalCost = guestNum * PRICE_PER_GUEST;
                eventOutput[7].setText("Price: $" + totalCost);
                //If all values are valid, notify the user that data is ready to be saved
                missingInfo = checkInfo();
                if (!missingInfo) {
                    warning.setText("Ready to save to file");
                    saveButton.setEnabled(true);
                } else {
                    warning.setText("Missing information");
                    saveButton.setEnabled(false);
                }
                validate();
                repaint();
            }
        });

    }
    //Check if the event information is valid
    private boolean checkInfo() {
        if (validEventNum && validGuestnum && validPhoneNum && validEntree &&
                validSide1 && validSide2 && validDessert) {
            return false;
        } else {
            return  true;
        }
    }
}