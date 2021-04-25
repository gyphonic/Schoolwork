package CSC335.PropReader;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

//Todd Mills
//CSC335 Project 2
//This class reads data from Prop.txt, parses it into SalesReport objects, and saves data to Prop2.txt

public class PropReader {


    //Main
    public static void main(String[] args) {
        //Data fields
        Path startFile = Paths.get("src/CSC335/PropReader/Prop.txt");
        Path destFile = Paths.get("src/CSC335/PropReader/Prop2.txt");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        SalesReport[] reports = new SalesReport[9];

        try {
            //Open the file and create IO streams
            System.out.println("Opening file " + startFile.getFileName());
            try {
                //Create a new input stream
                reader = new BufferedReader(new InputStreamReader(Files.newInputStream(startFile)));

                //Create a new output stream, if the destination does not exist, create the file
                if(Files.exists(destFile)) {
                    writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(destFile,TRUNCATE_EXISTING)));
                } else {
                    writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(destFile,CREATE)));
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            } catch (IOException e) {
                System.out.println("IO exception.");
            }

            //Parse the information from Prop.txt into SalesReport Objects
            System.out.println("Reading information from " + startFile.getFileName());
            parseReports(reports, reader, writer);
            System.out.println("Report information saved to " + destFile.toAbsolutePath());

            //Close the input streams
            closeStreams(reader, writer);

            //Program finishes
            System.out.println("****** Closing Program ******");

        } catch (Exception e) {
            System.out.println("Exception handling files " + e);
            System.out.println("Please try again.");
        }
    }

    //Method for transferring data from startFile into Objects
    public static void parseReports (SalesReport[] reports, BufferedReader reader, BufferedWriter writer) {
        String heading = "";
        String info = "";
        String[] parsedInfo;
        int reportCounter = 0;
        //Read the information from the starting file and parse into SalesReports
        try {
            heading = reader.readLine();
            info = reader.readLine();
            while(info != null) {
                parsedInfo = info.split("\\|");
                reports[reportCounter] = new SalesReport(parsedInfo[0], parsedInfo[1], parsedInfo[2], parsedInfo[3],
                        parsedInfo[4], parsedInfo[5], parsedInfo[6], parsedInfo[7]);
                reportCounter++;
                info = reader.readLine();
            }
        } catch(Exception e) {
            System.out.println("Error parsing reports " + e);
        }

        //Print the information to console and save in the destination file
        try {
            System.out.println("Report information");
            String s;
            writer.write(heading, 0, heading.length());
            writer.newLine();
            for (SalesReport report : reports) {
                s = report.print();
                System.out.println(s);
                writer.write(s, 0, s.length());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error saving files " + e);
        }
    }
    //Method to close input and output streams
    public static void closeStreams(BufferedReader reader, BufferedWriter writer) {
        try {
            reader.close();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error closing streams" + e);
        }
    }
}
