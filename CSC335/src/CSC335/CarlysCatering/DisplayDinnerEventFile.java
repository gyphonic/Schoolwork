package CSC335.CarlysCatering;
//Todd Mills
//Unit 13 Case Problems
//This class reads from EventInfo.txt

import java.io.*;
import java.nio.file.*;

public class DisplayDinnerEventFile {
    public static void main(String[] args) {
        System.out.println("Reading event data....");
        try {
            //Get the filepath
            Path file = Paths.get("out/production/Schoolwork/CSC335/CarlysCatering/EventInfo.txt");
            InputStream input = null;
            input = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String s = null;
            //While there are still lines to be read, print the lines to the console
            while ((s = reader.readLine()) != null && s.length() != 0) {
                System.out.println(s);
            }
            //Close the stream
            input.close();
            //Catch any exceptions the program might throw and terminate
        } catch(Exception e) {
            System.out.println("Issue reading from file: " + e);
        }
        System.out.println("~~~~~~ Reading complete. Closing program ~~~~~~");
    }

}
