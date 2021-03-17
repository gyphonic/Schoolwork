//Todd Mills
//Unit 8 case problems
//This program makes multiple event objects, gets data for each, and prints the bill
//Updated for phone numbers and VCS
import java.util.Scanner;
public class EventDemo{

	public static void main(String[] args) {
		//Create a new Scanner
		Scanner input = new Scanner(System.in);
		//Create events and ask the user for their information
		System.out.println("How many events would you like to enter?");
		int numEvents = input.nextInt();
		Event[] events = new Event[numEvents];
		for (int i = 0; i < numEvents; i++) {
			System.out.println("Enter the details for event no# " + (i + 1));
			events[i] = new Event(getEventNumber(input), getNumberOfGuests(input), getPhoneNumber(input),
					getEventType(input));
		}
		//Close the Scanner
		input.close();
		//Prints the motto/banner for Carly's Catering
		printMotto();
		//Print the final bills for each Event object
		for (int i = 0; i < numEvents; i++) {
			printDetails(events[i]);
		}
	}
	//This method prompts the user for the event number
	public static String getEventNumber(Scanner input) {
		System.out.println("Enter the event number.");
		String eventNum = input.next();
		return eventNum;
	}
	//This method prompts the user for a contact phone number
	public static String getPhoneNumber(Scanner input) {
		System.out.println("Enter a phone number.");
		String phoneNum = input.next();
		return phoneNum;
	}
	public static int getEventType(Scanner input) {
		System.out.println("Enter an no# for the type of event.\nWedding = 0, Baptism = 1, " +
				"\nBirthday = 2, Corporate = 3,\nOther = 4");
		int eventTypeInput = input.nextInt();
		return eventTypeInput;
	}
	//This method prompts the user for number of guests
	public static int getNumberOfGuests(Scanner input) {
		int numOfGuests = 0;
		//Events must be between 5 and 100 guests
		while (numOfGuests < 5 || numOfGuests > 100) {
			System.out.println("Enter the number of guests.");
			numOfGuests = input.nextInt();
			//Check if user enter less than 5 guests
			if (numOfGuests < 5) {
				System.out.println("Too few guests!");
			//Check if user entered more than 100 guests
			} else if (numOfGuests > 100) {
				System.out.println("Too many guests!");
			} else {
				break;
			}
		}
		return numOfGuests;
	}
	//This Method prints the bill for the event
	public static void printDetails(Event event) {
		System.out.println("\nBill for event no# " + event.getEventNumber());
		System.out.println(event.getEventType() + " event");
		System.out.println("Contact phone no# " + event.getPhoneNum());
		System.out.println("Number of guests attending is " + event.getNumberOfGuests());
		System.out.println("Price per guest is $" + event.getPricePerGuest());
		//Check if the event is a large event
		boolean largeEvent = event.isLargeEvent(event.getNumberOfGuests());
		if (largeEvent = true) {
			System.out.println("Event is a large event.");
		} else {
			System.out.println("Event is a small event");
		}
		System.out.println("Price for the event is $" + event.getEventPrice());
	}
	//This method prints the motto for Carly's Catering
	public static void printMotto() {
		System.out.println("********************************************");
		System.out.println("Carly's makes the food that makes it a party.");
		System.out.println("********************************************");
	}
}