package CSC335.SammysRentals;//Todd Mills
//Unit 12 Case Problems
//This class holds data for the Rental object for Sammy's Rentals Demo
//Updated for error handling
import java.util.Random;
public class Rental {
	//Class data fields
	public static final int rentalRate = 40;
	private String contractNumber;
	private int rentalHours;
	private int minutesOverHour;
	private int totalRentalTime;
	private Equipment Equipment;
	private int rentalSurcharge;
	private int basePrice;
	private int totalRentalPrice;

	//Default and overloaded class constructors
	public Rental() {
		setContractNumber("A000");
		setHoursAndMinutes(0);
		setEquipment(8);
	}
	public Rental(String contractNum, int rentalTimeInput, int equipTypeInput) {
		setContractNumber(contractNum);
		setHoursAndMinutes(rentalTimeInput);
		setEquipment(equipTypeInput);
	}
	//Method to autofill rental data
	public void randomizeRental() {
		//Create new Random instance
		Random rand = new Random();
		//Random rental time (1 - 3 hrs)
		int randomTime = (60 + rand.nextInt(120));
		//Random equip type
		int randomEquipType = (rand.nextInt(8));
		//And this nonsense is to randomize rental numbers
		char[] contractChars = {'A', 'B', 'C', 'D', 'E', 'F', 'H', 'I', 'J'};
		int randomContractDigits = (100 + rand.nextInt(899));
		String randomContractNum = (contractChars[rand.nextInt(7)] + String.valueOf(randomContractDigits));
		//Set the random values
		setContractNumber(randomContractNum);
		setHoursAndMinutes(randomTime);
		setEquipment(randomEquipType);
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
		rentalHours = rentalTimeInput / 60;
		minutesOverHour = rentalTimeInput % 60;
		//Caps the extra minute price at $40
		if (minutesOverHour > 40 ) {
			minutesOverHour = 40;
		}
		//Calculates the price for rentals, $40 per hour, plus $1 for each extra minute up to $40
		if (rentalTimeInput == 0) {
			totalRentalPrice = 0;
		} else if (rentalHours >=1) {
			basePrice = (rentalHours * 40) + minutesOverHour;
		} else {
			basePrice = 40;
		}
	}
	public void setEquipment(int equipTypeInput) {
		if(equipTypeInput == 1 || equipTypeInput == 6 ||
				equipTypeInput == 7 || equipTypeInput == 8) {
			Equipment = new EquipmentWithoutLesson(equipTypeInput);
		} else {
			Equipment = new EquipmentWithLesson(equipTypeInput);
		}
		rentalSurcharge = Equipment.getRentalFee();
		totalRentalPrice = basePrice + rentalSurcharge + Equipment.getLessonFee();
	}
	//Class return methods
	public int getRentalHours() {
		return rentalHours;
	}
	public int getMinutesOverHour() {
		return minutesOverHour;
	}
	public int getTotalRentalPrice() {
		return totalRentalPrice;
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
	public int getRentalSurcharge() {
		return rentalSurcharge;
	}
	public Equipment getEquipment() {
		return Equipment;
	}
	public String getEquipName() {
		return Equipment.getEquipName();
	}
	public int getEquipTypeInt() {
		return Equipment.getEquipType();
	}
	public int getBasePrice() {
		return basePrice;
	}

}
