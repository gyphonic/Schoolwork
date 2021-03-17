//Todd Mills
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
		for (int i = 0; i < numRentals; i++) {
			System.out.println("Enter details for rental no# " + (i + 1));
			rentals[i] = new Rental(enterContractNumber(input), enterEquipType(input), enterRentalTimeInput(input),
					enterPhoneNumber(input));
		}
		//Close the Scanner
		input.close();
		//Print the banner/motto for Sammy's Rentals
		printMotto();
		//Get the results and print the bill to console for each rental
		for ( int i = 0; i < numRentals; i++) {
			printResults(rentals[i]);
		}
	}
	//Class methods
	//This method prompts the user for the contract number
	public static String enterContractNumber(Scanner input) {
		String contractNum;
		System.out.println("Please enter the contract number.");
		contractNum = input.next();
		return contractNum;
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
	public static String enterPhoneNumber(Scanner input) {
		String phoneInput;
		System.out.println("Enter a phone number.");
		phoneInput = input.next();
		return phoneInput;
	}
	public static int enterEquipType(Scanner input) {
		int equipTypeInput = 0;
		System.out.println("Enter the type of equipment rented.\nPersonal Watercraft = 0, Pontoon Boat = 1," +
				"\nRowboat = 2, Canoe = 3,\nKayak = 4, Beach Chair = 5,\nUmbrella = 6, Other = 7");
		equipTypeInput = input.nextInt();
		return equipTypeInput;
	}
	//This method prints the final bill for the rental
	public static void printResults(Rental rental) {
		System.out.println("\nContract #" + rental.getContractNumber());
		System.out.println("Equipment rented = " + rental.getEquipType());
		System.out.println("Phone number - " + rental.getPhoneNumber());
		System.out.println("Rental price is $" + rental.getRentalRate() +
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
}
