package SammysRentals;//Todd Mills
//Unit 10 Case Problems
//This class holds data for the Rental object for Sammys Rentals Demo
import java.util.Random;
public class Rental {
	//Class data fields
	public static final String[] equipTypes = {"Personal Watercraft", "Pontoon Boat", "Rowboat", "Canoe", "Kayak",
								"Beach Chair", "Umbrella", "Other"};
	public static final int rentalRate = 40;
	private int equipTypeInt;
	private String contractNumber;
	private int rentalHours;
	private int minutesOverHour;
	private int rentalPrice;
	private int totalRentalTime;
	private String phoneNumber;

	//Default and overloaded class constructors
	public Rental() {
		setContractNumber("A000");
		setHoursAndMinutes(0);
		//setPhoneNumber("0000000000");
		//setEquipType(7);
	}
	public Rental(String contractNum, int rentalTimeInput /*int equipTypeInput, String phoneInput*/) {
		setContractNumber(contractNum);
		setHoursAndMinutes(rentalTimeInput);
		//setPhoneNumber(phoneInput);
		//setEquipType(equipTypeInput);
	}
	//Method to autofill rental data
	public void randomizeRental() {
		//Create new Random instance
		Random rand = new Random();
		//Random phone number with 501 area code
		String randomPhone = ("501" + String.valueOf(rand.nextInt(9999999)));
		//Random rental time (1 - 3 hrs)
		int randomTime = (60 + rand.nextInt(120));
		//Random equipment type
		int randomEquipType = rand.nextInt(7);
		//And this nonsense is to randomize rental numbers
		char[] contractChars = {'A', 'B', 'C', 'D', 'E', 'F', 'H', 'I', 'J'};
		int randomContractDigits = (100 + rand.nextInt(899));
		String randomContractNum = (contractChars[rand.nextInt(8)] + String.valueOf(randomContractDigits));
		//Set the random values
		setContractNumber(randomContractNum);
		setHoursAndMinutes(randomTime);
		setPhoneNumber(randomPhone);
		setEquipType(randomEquipType);
	}
	//Class methods for setting contract number, time, and final price
	//This method sets the contract number
	public void setContractNumber(String contractNum) {
		boolean isValidContractNum = false;
		contractNum = contractNum.toUpperCase();
		if (Character.isLetter(contractNum.charAt(0)) && Character.isDigit(contractNum.charAt(1)) && 
				Character.isDigit(contractNum.charAt(2)) && Character.isDigit(contractNum.charAt(3)) &&
				isValidContractNum == false) {
			isValidContractNum = true;
		} 
		if (isValidContractNum == true) {
			contractNumber = contractNum;
		} else {
			contractNumber = "A000";
		}
	}
	//This method sets rental time, and calculates the price
	public void setHoursAndMinutes(int rentalTimeInput) {
		totalRentalTime = rentalTimeInput;
		rentalHours = rentalTimeInput/60;
		minutesOverHour = rentalTimeInput%60;
		//Caps the extra minute price at $40
		if (minutesOverHour > 40 ) {
			minutesOverHour = 40;
		}
		//Calculates the price for rentals, $40 per hour, plus $1 for each extra minute up to $40
		if (rentalTimeInput == 0) {
			rentalPrice = 0;
		} else if (rentalHours >=1) {
			rentalPrice = (rentalHours * 40) + minutesOverHour;
		} else {
			rentalPrice = 40;
		}
	}
	//This method formats the entered phone number, eg. removes hyphens and dashes before setting
	public void setPhoneNumber(String phoneInput) {
		StringBuilder phoneBuilder = new StringBuilder(phoneInput);
		for (int i = phoneInput.length(); i > 0; i--) {
			if (Character.isDigit(phoneInput.charAt(i-1)) == false) {
				phoneBuilder.deleteCharAt(i-1);
			} 
		} 
		if (phoneBuilder.length() == 10) {
			phoneNumber = phoneBuilder.toString();
		} else {
			phoneNumber = "0000000000";
		}
		
	}
	//This method sets the type of equipment rental
	public void setEquipType(int equipTypeInput) {
		if (equipTypeInput < 0 || equipTypeInput > 7) {
			equipTypeInt = 7;
		} else {
			equipTypeInt = equipTypeInput;
		}
	}
	//Class return methods
	//This method reformats the phone number and returns it
	public String getPhoneNumber() {
		StringBuilder phoneBuilder = new StringBuilder(phoneNumber);
		phoneBuilder.insert(0, "(");
		phoneBuilder.insert(4, ")");
		phoneBuilder.insert(5, " ");
		phoneBuilder.insert(9, "-");
		return phoneBuilder.toString();
	}
	public int getRentalHours() {
		return rentalHours;
	}
	public int getMinutesOverHour() {
		return minutesOverHour;
	}
	public int getRentalPrice() {
		return rentalPrice;
	}
	public int getTotalTime() {
		return totalRentalTime;
	}
	public int getRentalRate() {
		return rentalRate;
	}
	public String getContractNumber() {
		return contractNumber;
	}
	//returns the equipment type
	public String getEquipType() {
		return equipTypes[equipTypeInt];
	}
	//returns the int value for equip type, for sorting
	public int getEquipTypeInt() {
		return equipTypeInt;
	}
}
