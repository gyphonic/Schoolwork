package SammysRentals;//Todd Mills
//Unit 8 Case Problems
//This class creates 3 rental objects, displays their information, and compares sizes
import java.util.Scanner;
public class RentalDemo {

	public static void main(String[] args) {
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
					rentals[i] = new Rental(enterContractNumber(input), enterEquipType(input), enterRentalTimeInput(input),
							enterPhoneNumber(input));
				}
			}
		}
		//Print the banner/motto for Sammy's Rentals
		printMotto();
		//Get the results and print the bill to console for each rental
		for ( int i = 0; i < numRentals; i++) {
			printResults(rentals[i]);
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
		//Close the Scanner
		input.close();
		//Print closing message
		System.out.println("~~~~~~Closing Program~~~~~~");
	}
	//Class methods
	//This method prompts the user for the contract number
	public static String enterContractNumber(Scanner input) {
		String contractNum;
		System.out.println("Please enter the contract number.");
		contractNum = input.next();
		return contractNum;
	}
	//This method gets the type of equipment rented
	public static int enterEquipType(Scanner input) {
		int equipTypeInput = 0;
		System.out.println("Enter the type of equipment rented.\nPersonal Watercraft = 0, Pontoon Boat = 1," +
				"\nRowboat = 2, Canoe = 3,\nKayak = 4, Beach Chair = 5,\nUmbrella = 6, Other = 7");
		equipTypeInput = input.nextInt();
		return equipTypeInput;
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
				System.out.println("SammysRentals.Rental too short!");
			//Checks if the user entered more than 7200 minutes
			} else if (rentalTimeInput > 7200) {
				System.out.println("SammysRentals.Rental too long!");
			} else {
				break;
			}
		}
		return rentalTimeInput;
	}
	//Get a phone number from the user
	public static String enterPhoneNumber(Scanner input) {
		String phoneInput;
		System.out.println("Enter a phone number.");
		phoneInput = input.next();
		return phoneInput;
	}
	//This method prints the final bill for the rental
	public static void printResults(Rental rental) {
		System.out.println("\nContract #" + rental.getContractNumber());
		System.out.println("Equipment rented = " + rental.getEquipType());
		System.out.println("Phone number - " + rental.getPhoneNumber());
		System.out.println("SammysRentals.Rental price is $" + rental.getRentalRate() +
				" per hour, and $1 for each additional minute, up to 40.");
		System.out.println("The total rental time is " + rental.getTotalTime() + " minutes.");
		System.out.println("The billable rental time is " + rental.getRentalHours() + " hours and " +
				rental.getMinutesOverHour() + " minutes.");
		System.out.println("The total cost for the rental is $" + rental.getRentalPrice() + ".");
	}
	//This method prints the motto for Sammy's Rentals
	public static void printMotto() {
		System.out.println("\nSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
		System.out.println("Sammy's makes it fun in the sun.");
		System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
	}
	//Method for sorting rental data
	public static boolean sortRentals(Scanner input, Rental[] rentals) {
		System.out.println("\nSort by contract number = 1 Sort by rental time = 2 Sort by equipment type = 3 Cancel = 0");
		String sortType = input.next();
		//Sort by contract number
		if (sortType.equals("1")) {
			System.out.println("Sort by contract number");
			String[] rentalNumArray = new String[rentals.length];
			String tempNum;
			//Display initial data and clone to another array for sorting
			for (int i = 0; i < (rentals.length -1); i++) {
				System.out.println("SammysRentals.Rental no# " + rentals[i].getContractNumber());
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
			for (int i = 0; i < (rentalNumArray.length - 1); i++) {
				System.out.println("SammysRentals.Rental no# " + rentalNumArray[i]);
			}
			return true;
		}
		//Sort by rental time
		if (sortType.equals("2")) {
			System.out.println("Sort by rental time");
			int[] rentalTimeArray = new int[rentals.length];
			String[] rentalTimeNumArray = new String[rentals.length];
			int tempTime;
			String tempTimeNum;
			//Display initial data and clone to another array for sorting
			for (int i = 0; i < (rentals.length - 1); i++) {
				System.out.println(rentals[i].getContractNumber() + " is " + rentals[i].getTotalTime() +
						" minutes");
				rentalTimeArray[i] = rentals[i].getTotalTime();
				rentalTimeNumArray[i] = rentals[i].getContractNumber();
			}
			//Bubble sort rental time and contract numbers
			for (int x = 0; x < rentalTimeArray.length; x++){
				for (int i = 1; i < (rentalTimeArray.length - 1); i++) {
					if (rentalTimeArray[(i - 1)] > rentalTimeArray[(i)]) {
						tempTime = rentalTimeArray[i];
						rentalTimeArray[i] = rentalTimeArray[(i - 1)];
						rentalTimeArray[(i - 1)] = tempTime;
						tempTimeNum = rentalTimeNumArray[i];
						rentalTimeNumArray[i] = rentalTimeNumArray[(i - 1)];
						rentalTimeNumArray[(i - 1)] = tempTimeNum;
					}
				}
			}
			//Display the sorted data
			System.out.println("\nRentals sorted by rental time.");
			for (int i = 0; i < (rentalTimeArray.length - 1); i++) {
				System.out.println(rentalTimeNumArray[i] + " is " + rentalTimeArray[i] + " minutes.");
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
			for (int i = 0; i < (rentals.length -1); i++) {
				System.out.println(rentals[i].getContractNumber() + " is a " + rentals[i].getEquipType() + " rental.");
				equipTypeArray[i] = rentals[i].getEquipTypeInt();
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
			for (int i = 0; i < (equipTypeArray.length - 1); i++) {
				System.out.println(equipTypeNumArray[i] + " is a " + Rental.equipTypes[equipTypeArray[i]] + " rental.");
			}
			return true;
		}
		//Quit sorting
		if (sortType.equals("0")) {
			return false;
		} else {
			return true;
		}

	}
}

