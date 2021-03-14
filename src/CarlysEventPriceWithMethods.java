//Todd Mills
//Unit 3 Case Problem
//This program is modified to use methods
import java.util.Scanner;
public class CarlysEventPriceWithMethods{

	public static void main(String[] args) {
		//Gets the number of guests
		int numOfGuests = getNumberOfGuests();
		//Prints the motto
		printMotto();
		//Calculates the cost and whether the event is large
		calculateCost(numOfGuests);
	}
	
	//This method prompts the user for number of guests
	public static int getNumberOfGuests() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the number of guests.");
		int numOfGuests = input.nextInt();
		input.close();
		return numOfGuests;
	}
	
	//This method prints the motto
	public static void printMotto() {
		System.out.println("********************************************");
		System.out.println("Carly's makes the food that makes it a party.");
		System.out.println("********************************************");
	}
	
	//This method does final calculations for cost and event size
	public static void calculateCost(int numOfGuests) {
		int costPerGuest = 35;
		int totalCost;
		int isLargeEvent = 50;
		//This part prints the final costs
		totalCost = costPerGuest * numOfGuests;
		System.out.println("Cost per guest is " + costPerGuest + ".");
		System.out.println("The number of guests that will be attending is " + numOfGuests + ".");
		System.out.println("The total cost for the event is " + totalCost + ".");
		
		//This portion calculates whether the event is large or small
		if (numOfGuests >= isLargeEvent) {
			System.out.println("The event is a large event.");
		} else {
			System.out.println("The event is very very small.");
		}
	}
}
