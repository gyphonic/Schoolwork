package CSC335.SammysRentals;
//Todd Mills
//Unit 13 Case Problems
//This class creates rental objects, displays their information, and compares sizes
//Updated to write rental information to file
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.*;

public class RentalDemoAndCreateFile {

	public static void main(String[] args) {
		//Ask the user for rental object data, and start over if an exception is thrown
		boolean validRental = true;
		while(validRental) {
			validRental = createRental();
		}
		//Print closing message
		System.out.println("~~~~~~Closing Program~~~~~~");
	}
	//Class methods
	//Method to instantiate and sort rental objects
	public static boolean createRental() {
		boolean rentalCreationInProgress = true;
		try {
			//Create a new Scanner
			Scanner input = new Scanner(System.in);
			//Create rental objects based on user input
			System.out.println("How many rentals would you like to enter?");
			int numRentals = input.nextInt();
			Rental[] rentals = new Rental[numRentals];
			//Option to autofill data
			boolean autofillOptionChosen = false;
			while (!autofillOptionChosen) {
				System.out.println("Autofill rental data? Y or N");
				String autofillChoice = input.next();
				//If Y, randomize rental data
				if (autofillChoice.equals("Y")) {
					for (int i = 0; i < numRentals; i++) {
						rentals[i] = new Rental();
						rentals[i].randomizeRental();
					}
					autofillOptionChosen = true;
				}
				if (autofillChoice.equals("N")) {
					for (int i = 0; i < numRentals; i++) {
						System.out.println("Enter details for rental no# " + (i + 1));
						rentals[i] = new Rental(enterContractNumber(input), enterRentalTimeInput(input),
								enterEquipType(input));
					}
				}
			}
			//Print the banner/motto for Sammy's Rentals
			printMotto();
			//Get the results and print the bill to console for each rental
			for ( int i = 0; i < numRentals; i++) {
				printResults(rentals[i]);
			}
			//Ask if the user would like to save the rental information to file
			System.out.println("\nWould you like to save rental information to file? Y or N");
			String writeInput = input.next();
			if (writeInput.equals("Y")) {
				Path file = Paths.get("out/production/Schoolwork/CSC335/SammysRentals/RentalInfo.txt");
				System.out.println("Writing data to RentalInfo.txt");
				String rentalString = null;
				OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, TRUNCATE_EXISTING));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
				for (int i = 0; i < rentals.length; i++) {
					rentalString = rentals[i].getContractNumber() + ", hours: " + rentals[i].getRentalHours()
							+ ", minutes: " + rentals[i].getMinutesOverHour() + ", equipment: "
							+ rentals[i].getEquipName() + ", equipment code: " + rentals[i].getEquipTypeInt()
							+ ", price: $" + rentals[i].getTotalRentalPrice();
					System.out.println(rentalString);
					writer.write(rentalString, 0, rentalString.length());
					writer.newLine();

				}
				writer.close();
				System.out.println("Data saved. File path is " + file.toAbsolutePath());
			}
			//Ask if the user would like to sort event data
			System.out.println("\nWould you like to sort rentals? Y or N");
			String sortInput = input.next();
			if (sortInput.equals("Y")) {
				boolean keepSorting = true;
				System.out.println("\nSorting rentals");
				while (keepSorting) {
					keepSorting = sortRentals(input, rentals);
				}
			}
			//Return a value to end the main loop
			rentalCreationInProgress = false;
		}
		//If exceptions are thrown, print them and restart the loop
		catch(Exception e) {
			System.out.println("\nIssue creating rental " + e);
			System.out.println("Please try again.\n");
		}
		return rentalCreationInProgress;
	}
	//This method prompts the user for the contract number
	public static String enterContractNumber(Scanner input) {
		System.out.println("Please enter the contract number.");
		return input.next();
	}
	//This method gets the type of equipment rented
	public static int enterEquipType(Scanner input) {
		System.out.println("Enter the type of equipment rented.\nPersonal Watercraft = 0, Pontoon Boat = 1," +
				"\nRowboat = 2, Canoe = 3,\nKayak = 4, Beach Chair = 5,\nUmbrella = 6, Other = 7");
		return input.nextInt();
	}
	//This method prompts the user for the rental time in minutes
	public static int enterRentalTimeInput(Scanner input) {
		int rentalTimeInput = 0;
		//Rentals must be between 60 and 7200 minutes
		while (rentalTimeInput < 60 || rentalTimeInput > 7200) {
			System.out.println("Please enter the rental time in minutes.");
			rentalTimeInput = input.nextInt();
			//Checks if the user entered less than 60 minutes
			if (rentalTimeInput < 60) {
				System.out.println("Rental too short!");
			//Checks if the user entered more than 7200 minutes
			} else if (rentalTimeInput > 7200) {
				System.out.println("Rental too long!");
			} else {
				break;
			}
		}
		return rentalTimeInput;
	}
	//This method prints the final bill for the rental
	public static void printResults(Rental rental) {
		System.out.println("\nContract #" + rental.getContractNumber());
		System.out.println("Equipment rented = " + rental.getEquipment().getEquipName());
		System.out.println("Equipment surcharge is $" + rental.getRentalSurcharge());
		System.out.println(rental.getEquipment().getLessonPolicy());
		System.out.println("Rental price is $" + rental.getRentalRate() +
				" per hour, and $1 for each additional minute, up to $" + rental.getRentalRate() + ".");
		System.out.println("The total rental time is " + rental.getTotalTime() + " minutes.");
		System.out.println("The billable rental time is " + rental.getRentalHours() + " hours and " +
				rental.getMinutesOverHour() + " minutes.");
		System.out.println("Price for the time of the rental is $" + rental.getBasePrice());
		System.out.println("The total cost for the rental is $" + rental.getTotalRentalPrice() + ".");
	}
	//This method prints the motto for Sammy's Rentals
	public static void printMotto() {
		System.out.println("\nSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
		System.out.println("Sammy's makes it fun in the sun.");
		System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
	}
	//Method for sorting rental data
	public static boolean sortRentals(Scanner input, Rental[] rentals) {
		System.out.println("\nSort by contract number = 1 Sort by rental price = 2 " +
				"Sort by equipment type = 3 Cancel = 0");
		String sortType = input.next();
		//Sort by contract number
		if (sortType.equals("1")) {
			System.out.println("Sort by contract number");
			String[] rentalNumArray = new String[rentals.length];
			String tempNum;
			//Display initial data and clone to another array for sorting
			for (int i = 0; i < rentals.length; i++) {
				System.out.println("Rental no# " + rentals[i].getContractNumber());
				rentalNumArray[i] = rentals[i].getContractNumber();
			}
			//Bubble sort contract numbers
			for (int x = 0; x < rentalNumArray.length; x++) {
				for (int i = 1; i < (rentalNumArray.length - 1); i++) {
					if (rentalNumArray[i - 1].compareTo(rentalNumArray[i]) > 0) {
						tempNum = rentalNumArray[i];
						rentalNumArray[i] = rentalNumArray[(i - 1)];
						rentalNumArray[( i - 1)] = tempNum;
					}
				}
			}
			//Display the sorted data
			System.out.println("\nRentals sorted by contract number.");
			for (int i = 0; i < rentalNumArray.length; i++) {
				System.out.println("Rental no# " + rentalNumArray[i]);
			}
			return true;
		}
		//Sort by rental price
		if (sortType.equals("2")) {
			System.out.println("Sort by rental price");
			int[] rentalPriceArray = new int[rentals.length];
			String[] rentalPriceNumArray = new String[rentals.length];
			int tempPrice;
			String tempPriceNum;
			//Display initial data and clone to another array for sorting
			for (int i = 0; i < rentals.length; i++) {
				System.out.println(rentals[i].getContractNumber() + " costs $" + rentals[i].getTotalRentalPrice());
				rentalPriceArray[i] = rentals[i].getTotalRentalPrice();
				rentalPriceNumArray[i] = rentals[i].getContractNumber();
			}
			//Bubble sort rental time and contract numbers
			for (int x = 0; x < rentalPriceArray.length; x++){
				for (int i = 1; i < rentalPriceArray.length; i++) {
					if (rentalPriceArray[(i - 1)] > rentalPriceArray[(i)]) {
						tempPrice = rentalPriceArray[i];
						rentalPriceArray[i] = rentalPriceArray[(i - 1)];
						rentalPriceArray[(i - 1)] = tempPrice;
						tempPriceNum = rentalPriceNumArray[i];
						rentalPriceNumArray[i] = rentalPriceNumArray[(i - 1)];
						rentalPriceNumArray[(i - 1)] = tempPriceNum;
					}
				}
			}
			//Display the sorted data
			System.out.println("\nRentals sorted by rental price.");
			for (int i = 0; i < rentalPriceArray.length; i++) {
				System.out.println(rentalPriceNumArray[i] + " cost $ " + rentalPriceArray[i]);
			}
			return true;
		}
		//Sort by equip type integer
		if (sortType.equals("3")) {
			System.out.println("Sort by equipment type");
			int[] equipTypeArray = new int[rentals.length];
			String[] equipTypeNumArray = new String[rentals.length];
			int tempType;
			String tempTypeNum;
			//Display initial data and clone to another array for sorting
			for (int i = 0; i < rentals.length; i++) {
				System.out.println(rentals[i].getContractNumber() + " is a " + rentals[i].getEquipment().getEquipName() + " rental.");
				equipTypeArray[i] = rentals[i].getEquipment().getEquipType();
				equipTypeNumArray[i] = rentals[i].getContractNumber();
			}
			//Bubble sort equip types and contract numbers
			for (int x = 0; x < equipTypeArray.length; x++) {
				for (int i = 1; i < (equipTypeArray.length - 1); i++) {
					if (equipTypeArray[i - 1] > equipTypeArray[i]) {
						tempType = equipTypeArray[i];
						equipTypeArray[i] = equipTypeArray[(i - 1)];
						equipTypeArray[(i - 1)] = tempType;
						tempTypeNum = equipTypeNumArray[i];
						equipTypeNumArray[i] = equipTypeNumArray[(i - 1)];
						equipTypeNumArray[(i - 1)] = tempTypeNum;
					}
				}
			}
			//Display the sorted data
			System.out.println("\nRentals sorted by equipment type");
			for (int i = 0; i < equipTypeArray.length; i++) {
				System.out.println(equipTypeNumArray[i] + " is a " +
						rentals[i].getEquipment().checkEquipType(equipTypeArray[i]) + " rental.");
			}
			return true;
		}
		//Quit sorting
        return !sortType.equals("0");

	}
}

