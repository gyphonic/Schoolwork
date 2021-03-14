//Todd Mills
//Unit 3 Case Problem
//This program displays Sammy's banner and calculates rental price
import java.util.Scanner;
public class SammysRentalPriceWithMethods {

	public static void main(String[] args) {
		//Create a new Scanner
		Scanner input = new Scanner(System.in);
		//Get the rental time in minutes
		int rentTime = getRentalTime(input);
		//Close the Scanner
		input.close();
		//Print the motto
		printMotto();
		//Calculate and display results
		printResults(rentTime);
	}
	
	//THis method prompts the user for rental time in minutes, and returns the result to main
	public static int getRentalTime(Scanner input) {
		int rentTimeInput;
		System.out.println("Please enter the amount of time the equipment was rented in minutes.");
		rentTimeInput = input.nextInt();
		return rentTimeInput;
	}
	
	//This method prints the motto
	public static void printMotto() {
		System.out.println("\nSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
		System.out.println("Sammy's makes it fun in the sun.");
		System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
		
	}
	
	//This method gets the rental time, calculates the total cost, and displays the results
	public static void printResults(int rentTime) {
		int totalCost;
		int hours;
		int minutes;
		//Split the rental time into hours and minutes, then calculate the cost
		hours = rentTime/60;
		minutes = rentTime%60 ;
		if (hours >= 1) {
			totalCost = (hours * 40) + minutes;
		} else {
			totalCost = 40;
		}
		//Display the results
		System.out.println("The equipment was rented for " + rentTime + " minutes.");
		System.out.println("The cost per hour is $40, plus $1 for each remaining minute.");
		System.out.println("The total cost of the rental is $" + totalCost );
	}	
						

		
	}

