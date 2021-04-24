package CSC335.PropReader;

import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

//Todd Mills
//CSC335
//This class reads data from Prop.txt, parses it into SalesReport objects, and saves data to Prop2.txt
public class PropReader {
    public static void main(String[] args) {
        //Data fields
        String startFile = "Prop.txt";
        String destFile = "Prop2.txt";
        SalesReport[] reports;

        System.out.println("Reading information from " + startFile);
        OutputStream output = new BufferedOutputStream(Files.newOutputStream(startFile, TRUNCATE_EXISTING));
    }
}
