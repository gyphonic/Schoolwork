package CSC335.CarlysCatering;//Todd Mills
//Unit 10 case problems
//This program makes multiple event objects, gets data for each, and prints the bill
//Updated for DinnerEvent class
import java.util.Scanner;
public class EventDemo{

	public static void main(String[] args) {
		//Create a new Scanner
		Scanner input = new Scanner(System.in);
		//Ask if user wants to enter simple events or dinner events
		System.out.println("Would you like to enter simple events or dinner events?");
		boolean eventTypeChosen = false;
		while (!eventTypeChosen) {
			System.out.println("Simple events = 0, Dinner Events = 1");
			int eventType = input.nextInt();
			//Simple Events
			if (eventType == 0) {
				//Create events and ask the user for their information
				System.out.println("How many events would you like to enter?");
				int numEvents = input.nextInt();
				Event[] events = new Event[numEvents];
				//Randomize event data option
				boolean autofillOptionChosen = false;
				while (!autofillOptionChosen) {
					System.out.println("Autofill event data? Y or N");
					String autofillChoice = input.next();
					//If Y, randomize event data
					if (autofillChoice.equals("Y")) {
						for (int i = 0; i < numEvents; i++) {
							events[i] = new Event();
							events[i].randomizeEvent();
						}
						autofillOptionChosen = true;
					}
					//If user does not want to randomize
					if (autofillChoice.equals("N")) {
						for (int i = 0; i < numEvents; i++) {
							System.out.println("Enter the details for event no# " + (i + 1));
							events[i] = new Event(getEventNumber(input), getNumberOfGuests(input), getPhoneNumber(input),
									getEventType(input));
						}
						autofillOptionChosen = true;
					}
				}
				//Prints the motto/banner for Carly's Catering
				printMotto();
				//Print the final bills for each Event object
				for (int i = 0; i < numEvents; i++) {
					printDetails(events[i]);
				}
				//Ask if the user would like to sort event data
				System.out.println("\nWould you like to sort events? Y or N");
				String sortInput = input.next();
				if (sortInput.equals("Y")) {
					boolean keepSorting = true;
					System.out.println("\nSorting events");
					while (keepSorting) {
						keepSorting = sortEvents(input, events);
					}
				}
				eventTypeChosen = true;
			}
			//Dinner Events
			if (eventType == 1) {
				//Create events and ask the user for their information
				System.out.println("How many dinner events would you like to enter?");
				int numEvents = input.nextInt();
				DinnerEvent[] events = new DinnerEvent[numEvents];
				//Randomize event data option
				boolean autofillOptionChosen = false;
				while (!autofillOptionChosen) {
					System.out.println("Autofill dinner event data? Y or N");
					String autofillChoice = input.next();
					//If Y, randomize dinner event data
					if (autofillChoice.equals("Y")) {
						for (int i = 0; i < numEvents; i++) {
							events[i] = new DinnerEvent();
							events[i].randomizeDinnerEvent();
						}
						autofillOptionChosen = true;
					}
					//If user does not want to randomize
					if (autofillChoice.equals("N")) {
						for (int i = 0; i < numEvents; i++) {
							System.out.println("Enter the details for event no# " + (i + 1));
							String eventNum = getEventNumber(input);
							int guestsNum = getNumberOfGuests(input);
							String phoneNum = getPhoneNumber(input);
							int eventTypeInput = getEventType(input);
							int entreeNum = getEntreeInput(input);
							int side1Num = getSide1Input(input);
							int side2Num = getSide2Input(input, side1Num);
							int dessertNum = getDessertInput(input);
							events[i] = new DinnerEvent(eventNum, guestsNum, phoneNum, entreeNum, side1Num,
									side2Num, dessertNum);
						}
						autofillOptionChosen = true;
					}
				}
				//Prints the motto/banner for Carly's Catering
				printMotto();
				//Print the final bills for each Event object
				for (int i = 0; i < numEvents; i++) {
					printDinnerDetails(events[i]);
					getMenu(events[i]);
				}
				//Ask if the user would like to sort event data
				System.out.println("\nWould you like to sort events? Y or N");
				String sortInput = input.next();
				if (sortInput.equals("Y")) {
					boolean keepSorting = true;
					System.out.println("\nSorting events");
					while (keepSorting) {
						keepSorting = sortEvents(input, events);
					}
				}
				eventTypeChosen = true;
			}
		}
		//Close the Scanner
		input.close();
		//Print closing message
		System.out.println("~~~~~~Closing program~~~~~~");
	}

	//Class methods
	//This method prompts the user for the event number
	public static String getEventNumber(Scanner input) {
		System.out.println("Enter the event number.");
		return input.next();
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
	//This method prompts the user for a contact phone number
	public static String getPhoneNumber(Scanner input) {
		System.out.println("Enter a phone number.");
		return input.next();
	}
	public static int getEventType(Scanner input) {
		System.out.println("Enter an no# for the type of event.\nWedding = 0, Baptism = 1, " +
				"\nBirthday = 2, Corporate = 3,\nOther = 4");
		return input.nextInt();
	}
	//Method to get the type of entree for dinner events
	public static int getEntreeInput(Scanner input) {
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
	//Method to get side1 for dinner events
	public static int getSide1Input(Scanner input) {
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
		return side1Input;
	}
	//Method to get side2 for dinner events
	public static int getSide2Input(Scanner input, int side1Input) {
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
		return side1Input;
	}
	//Method to get dessert for dinner events
	public static int getDessertInput(Scanner input) {
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
	//This method prints the motto for Carly's Catering
	public static void printMotto() {
		System.out.println("********************************************");
		System.out.println("Carly's makes the food that makes it a party.");
		System.out.println("********************************************");
	}
	//This method prints the bill for dinner events
	public static void printDinnerDetails(DinnerEvent dinnerEvent) {
		System.out.println("\nBill for event no# " + dinnerEvent.getEventNumber());
		System.out.println(dinnerEvent.getEventType() + " event");
		System.out.println("Contact phone no# " + dinnerEvent.getPhoneNum());
		System.out.println("Number of guests attending is " + dinnerEvent.getNumberOfGuests());
		System.out.println("Price per guest is $" + dinnerEvent.getPricePerGuest());
		//Check if the event is a large event
		boolean largeEvent = dinnerEvent.isLargeEvent();
		if (largeEvent == true) {
			System.out.println("Event is a large event.");
		} else {
			System.out.println("Event is a small event");
		}
		System.out.println("Price for the event is $" + dinnerEvent.getEventPrice());
	}
	//Method to print out a menu
	public static void getMenu(DinnerEvent dinnerEvent) {
		System.out.println("***** Menu *****");
		System.out.println("Entree = " + dinnerEvent.getEntree());
		System.out.println("Side choice 1 = " + dinnerEvent.getSide1());
		System.out.println("Side choice 2 = " + dinnerEvent.getSide2());
		System.out.println("Dessert = " + dinnerEvent.getDessert());
	}
	//This Method prints the bill for events
	public static void printDetails(Event event) {
		System.out.println("\nBill for event no# " + event.getEventNumber());
		System.out.println(event.getEventType() + " event");
		System.out.println("Contact phone no# " + event.getPhoneNum());
		System.out.println("Number of guests attending is " + event.getNumberOfGuests());
		System.out.println("Price per guest is $" + event.getPricePerGuest());
		//Check if the event is a large event
		boolean largeEvent = event.isLargeEvent();
		if (largeEvent == true) {
			System.out.println("Event is a large event.");
		} else {
			System.out.println("Event is a small event");
		}
		System.out.println("Price for the event is $" + event.getEventPrice());
	}
	//Method for sorting event data
	public static boolean sortEvents(Scanner input, Event[] events) {
		System.out.println("Sort by event number = 1 Sort by guests = 2 Sort by event type = 3 Cancel = 0");
		String sortType = input.next();
		//Sort by event number
		if (sortType.equals("1")) {
			System.out.println("Sort by event number");
			String[] eventNumArray = new String[events.length];
			String tempNum;
			//Display initial data and clone to another array for sorting
			for (int i = 0; i < (events.length -1); i++) {
				System.out.println("Event no# " + events[i].getEventNumber());
				eventNumArray[i] = events[i].getEventNumber();
			}
			//Bubble sort event numbers
			for (int x = 0; x < eventNumArray.length; x++) {
				for (int i = 1; i < (eventNumArray.length - 1); i++) {
					if (eventNumArray[i - 1].compareTo(eventNumArray[i]) > 0) {
						tempNum = eventNumArray[i];
						eventNumArray[i] = eventNumArray[(i - 1)];
						eventNumArray[( i - 1)] = tempNum;
					}
				}
			}
			//Display the sorted data
			System.out.println("\nEvents sorted by event number.");
			for (int i = 0; i < (eventNumArray.length - 1); i++) {
				System.out.println("Event no# " + eventNumArray[i]);
			}
			return true;
		}
		//Sort by number of guests
		if (sortType.equals("2")) {
			System.out.println("Sort by number of guests");
			int[] eventGuestsArray = new int[events.length];
			String[] eventGuestsNumArray = new String[events.length];
			int tempGuests;
			String tempGuestsNum;
			//Display initial data and clone to another array for sorting
			for (int i = 0; i < (events.length - 1); i++) {
				System.out.println(events[i].getEventNumber() + " has " + events[i].getNumberOfGuests() +
						" guests.");
				eventGuestsArray[i] = events[i].getNumberOfGuests();
				eventGuestsNumArray[i] = events[i].getEventNumber();
			}
			//Bubble sort event guest amounts and event numbers
			for (int x = 0; x < eventGuestsArray.length; x++){
				for (int i = 1; i < (eventGuestsArray.length - 1); i++) {
					if (eventGuestsArray[(i - 1)] > eventGuestsArray[(i)]) {
						tempGuests = eventGuestsArray[i];
						eventGuestsArray[i] = eventGuestsArray[(i - 1)];
						eventGuestsArray[(i - 1)] = tempGuests;
						tempGuestsNum = eventGuestsNumArray[i];
						eventGuestsNumArray[i] = eventGuestsNumArray[(i - 1)];
						eventGuestsNumArray[(i - 1)] = tempGuestsNum;
					}
				}
			}
			//Display the sorted data
			System.out.println("\nEvents sorted by number of guests.");
			for (int i = 0; i < (eventGuestsArray.length - 1); i++) {
				System.out.println(eventGuestsNumArray[i] + " has " + eventGuestsArray[i] + " guests");
			}
			return true;
		}
		//Sort by event type integer
		if (sortType.equals("3")) {
			System.out.println("Sort by event type");
			int[] eventTypeArray = new int[events.length];
			String[] eventTypeNumArray = new String[events.length];
			int tempType;
			String tempTypeNum;
			//Display initial data and clone to another array for sorting
			for (int i = 0; i < (events.length -1); i++) {
				System.out.println(events[i].getEventNumber() + " is a " + events[i].getEventType() + " event.");
				eventTypeArray[i] = events[i].getEventTypeInt();
				eventTypeNumArray[i] = events[i].getEventNumber();
			}
			//Bubble sort event types and event numbers
			for (int x = 0; x < eventTypeArray.length; x++) {
				for (int i = 1; i < (eventTypeArray.length - 1); i++) {
					if (eventTypeArray[i - 1] > eventTypeArray[i]) {
						tempType = eventTypeArray[i];
						eventTypeArray[i] = eventTypeArray[(i - 1)];
						eventTypeArray[(i - 1)] = tempType;
						tempTypeNum = eventTypeNumArray[i];
						eventTypeNumArray[i] = eventTypeNumArray[(i - 1)];
						eventTypeNumArray[(i - 1)] = tempTypeNum;
					}
				}
			}
			//Display the sorted data
			System.out.println("Events sorted by event type");
			for (int i = 0; i < (eventTypeArray.length - 1); i++) {
				System.out.println(eventTypeNumArray[i] + " is a " + Event.eventType[eventTypeArray[i]] + " event");
			}
			return true;
		}
		//Quit sorting
        return !sortType.equals("0");
	}
}
