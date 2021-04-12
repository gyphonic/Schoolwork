package CSC335.CarlysCatering;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
//Todd Mills
//Unit 11 Case Problems
//This class creates dinner events and assigns employees
public class StaffDinnerEvent {
    public static void main(String args[]){
        //Create a new Scanner
        Scanner input = new Scanner(System.in);
        //int to hold the value of side1
        //Instantiate a dinner event
        DinnerEvent DemoEvent = new DinnerEvent(getEventNum(input), getGuestNum(input), getPhoneNum(input),
                getEntree(input), getSide1(input), getSide2(input, side1), getDessert(input));
        assignEmployees(input, DemoEvent);
        printDetails(DemoEvent);
    }
    //Class fields and methods
    //int to hold the value of side1
    private static int side1;
    //Class methods
    //Enter the number for the event
    public static String getEventNum(Scanner input) {
        System.out.println("Enter the event no#");
        return input.next();
    }//Enter the number of guests
    public static int getGuestNum(Scanner input) {
        System.out.println("Enter the number of guests.");
        return input.nextInt();
    }
    //Enter a contact phone number
    public static String getPhoneNum(Scanner input) {
        System.out.println("Enter a contact phone number.");
        return input.next();
    }
    //Get the entree choice
    public static int getEntree(Scanner input) {
        boolean entreeChosen = false;
        int entreeInput = 9;
        while (!entreeChosen) {
            System.out.println("Enter a no# for entree choice\nSteak = 0, Cheeseburgers = 1, Salmon = 2," +
                    "\nPizza = 3, Chicken = 4, Pasta = 5");
            entreeInput = input.nextInt();
            if (entreeInput >= 0 && entreeInput < 6){
                entreeChosen = true;
            }
        }
        return entreeInput;
    }
    //Get the first side choice
    public static int getSide1(Scanner input) {
        boolean sideChosen = false;
        int side1Input = 9;
        while (!sideChosen) {
            System.out.println("Enter a no# for first side choice\nMacaroni = 0, Ceaser salad = 1, " +
                    "Mixed vegetables = 2,\nFruit salad = 3, Cheese tray = 4, Meat tray = 5");
            side1Input = input.nextInt();
            if (side1Input >= 0 && side1Input < 6){
                sideChosen = true;
            }
        }
        side1 = side1Input;
        return side1Input;
    }
    //Get the second side choice, cannot match side1
    public static int getSide2(Scanner input, int side1Input) {
        boolean sideChosen = false;
        int side2Input = 9;
        while (!sideChosen) {
            System.out.println("Enter a no# for second side choice\nMacaroni = 0, Ceaser salad = 1, " +
                    "Mixed vegetables = 2,\nFruit salad = 3, Cheese tray = 4, Meat tray = 5");
            side2Input = input.nextInt();
            if (side2Input == side1Input) {
                System.out.println("Side already chosen! Pick another side.");
            } else if (side2Input >= 0 && side2Input < 6){
                sideChosen = true;
            }
        }
        return side2Input;
    }
    //Get the dessert choice
    public static int getDessert(Scanner input) {
        boolean dessertChosen = false;
        int dessertInput = 0;
        while (!dessertChosen) {
            System.out.println("Enter a no# for dessert choice\nAngel food cake = 0, Brownies = 1,\n" +
                    "Chocolate chip cookies= 2, Peach cobbler = 3");
            dessertInput = input.nextInt();
            if (dessertInput >= 0 && dessertInput < 4) {
                dessertChosen = true;
            }
        }
        return dessertInput;
    }
    public static void assignEmployees(Scanner input, DinnerEvent DemoEvent) {
        System.out.println("Enter the employees attending the event.");
        int numOfGuests = DemoEvent.getNumberOfGuests();
        int positionCounter = 0;
        int waitstaffNeeded = (numOfGuests/10);
        int bartendersNeeded = (numOfGuests/25);
        int coordinatorsNeeded = 1;
        System.out.println("Number of waitstaff, min " + waitstaffNeeded + ":");
        int waitstaff = input.nextInt();
        for(int i = 0; i < waitstaff; i++) {
            int idNum = positionCounter + 101;
            System.out.println("Enter a first name");
            String firstName = input.next();
            System.out.println("Enter a last name.");
            String lastName = input.next();
            System.out.println("Enter the pay rate of the employee");
            double payRate = input.nextDouble();
            Employee tempEmp = new Waitstaff(idNum, firstName, lastName, payRate);
            DemoEvent.setEmployees(tempEmp, positionCounter);
            positionCounter++;
        }
        System.out.println("Number of bartenders, min " + bartendersNeeded + ":");
        int bartenderAmount = input.nextInt();
        for(int i = 0; i < bartenderAmount; i++) {
            int idNum = positionCounter + 101;
            System.out.println("Enter a first name");
            String firstName = input.next();
            System.out.println("Enter a last name.");
            String lastName = input.next();
            System.out.println("Enter the pay rate of the employee");
            double payRate = input.nextDouble();
            Employee tempEmp = new Bartender(idNum, firstName, lastName, payRate);
            DemoEvent.setEmployees(tempEmp, positionCounter);
            positionCounter++;
        }
        System.out.println("Number of coordinators, min " + coordinatorsNeeded + ":");
        int coordinatorAmount = input.nextInt();
        for(int i = 0; i < coordinatorAmount; i++) {
            int idNum = positionCounter + 101;
            System.out.println("Enter a first name");
            String firstName = input.next();
            System.out.println("Enter a last name.");
            String lastName = input.next();
            System.out.println("Enter the pay rate of the employee");
            double payRate = input.nextDouble();
            Employee tempEmp = new Coordinator(idNum, firstName, lastName, payRate);
            DemoEvent.setEmployees(tempEmp, positionCounter);
            positionCounter++;
        }
    }
    public static void printDetails(DinnerEvent DemoEvent) {
        Employee[] empArray = DemoEvent.getEmployees();
        System.out.println("Details of event no# " + DemoEvent.getEventNumber());
        System.out.println("Contact phone no# " + DemoEvent.getPhoneNum());
        System.out.println("Planned number of guests: " + DemoEvent.getNumberOfGuests());
        System.out.println("Price per guest will be: " + DemoEvent.getPricePerGuest());
        System.out.println("Total cost for the event will be: " + DemoEvent.getEventPrice());
        System.out.println("\nEmployees attending:");
        System.out.println("Waitstaff:");
        for(int i = 0; i < (empArray.length -1); i++) {
            if (empArray[i] != null && empArray[i].getEmpJobTitle().equals("Waitstaff")){
                empArray[i].printEmployee();
            }
        }
        System.out.println("Bartenders:");
        for(int i = 0; i < (empArray.length -1); i++) {
            if (empArray[i] != null && empArray[i].getEmpJobTitle().equals("Bartender")){
                empArray[i].printEmployee();
            }
        }
        System.out.println("Coordinators:");
        for(int i = 0; i < (empArray.length -1); i++) {
            if (empArray[i] != null && empArray[i].getEmpJobTitle().equals("Coordinator")){
                empArray[i].printEmployee();
                System.out.println();
                            }
        }
    }
}
