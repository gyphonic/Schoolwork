package CSC335.SammysRentals;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.*;

//Todd Mills
//Unit 13 case problems
//This class reads and displays information written to RentalInfo.txt by RentalDemoAndCreateFile

public class DisplayRentalFile {
    public static void main(String[] args) {
        System.out.println("Reading rental data....");
        try {
            //Get the filepath
            Path file = Paths.get("out/production/Schoolwork/CSC335/SammysRentals/RentalInfo.txt");
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
