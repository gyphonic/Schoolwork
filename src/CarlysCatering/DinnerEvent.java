package CarlysCatering;

import java.util.Random;

//Todd Mills
//Unit 10
//This class holds data for the DinnerEvent child class
public class DinnerEvent extends Event{
    //Class data fields
    private int entree;
    private int side1;
    private int side2;
    private int dessert;
    //Arrays to hold menu choices
    private static final String[] entreeChoices = {"Steak", "Cheeseburgers", "Salmon", "Pizza", "Chicken", "Pasta"};
    private static final String[] sideChoices = {"Macaroni", "Ceaser salad", "Mixed vegetables", "Fruit salad",
            "Cheese tray", "Meat tray"};
    private static final String[] dessertChoices = {"Angel food cake", "Brownies", "Chocolate chip cookies",
            "Peach cobbler"};
    //Default and overloaded constructors
    public DinnerEvent() {
        setEntree(0);
        setSides(0,1);
        setDessert(0);
    }
    public DinnerEvent(String eventNum, int numGuests, String phoneNum, int eventTypeInput, int entreeInput,
                       int side1Input, int side2Input, int dessertInput) {
        setEventNumber(eventNum);
        setGuests(numGuests);
        setPhoneNumber(phoneNum);
        setEventType(eventTypeInput);
        setEntree(entreeInput);
        setSides(side1Input, side2Input);
        setDessert(dessertInput);
    }
    //Method to auto randomize event information (I am tired of typing unique information)
    public void randomizeDinnerEvent() {
        //Create new Random instance
        Random rand = new Random();
        //Random phone number with 501 area code
        String randomPhone = ("501" + String.valueOf(rand.nextInt(9999999)));
        //Random number of guests (6 - 99)
        int randomGuests = (6 + rand.nextInt(93));
        //Random event type
        int randomEventType = rand.nextInt(4);
        //And this nonsense is to randomize event numbers
        char[] eventChars = {'A', 'B', 'C', 'D', 'E', 'F', 'H', 'I', 'J'};
        int randomEventDigits = (100 + rand.nextInt(899));
        String randomEventNum = (eventChars[rand.nextInt(8)] + String.valueOf(randomEventDigits));
        //Randomize menu choices
        int randomEntree = rand.nextInt(5);
        int randomSide1 = rand.nextInt(5);
        int randomSide2 = 0;
        boolean validSides = false;
        while (!validSides) {
            randomSide2 = rand.nextInt(5);
            if (randomSide2 != randomSide1) {
                validSides = true;
            }
        }
        int randomDessert = rand.nextInt(3);
        //Set the random values
        setGuests(randomGuests);
        setEventNumber(randomEventNum);
        setPhoneNumber(randomPhone);
        setEventType(randomEventType);
        setEntree(randomEntree);
        setSides(randomSide1,randomSide2);
        setDessert(randomDessert);
    }
    //Setter methods
    public void setEntree(int entreeInput) {
        entree = entreeInput;
    }
    public void setSides(int side1Input, int side2Input) {
        side1 = side1Input;
        side2 = side2Input;
    }
    public void setDessert(int dessertInput) {
        dessert = dessertInput;
    }
    //Getter methods
    public String getEntree() {
        return entreeChoices[entree];
    }
    public String getSide1() {
        return sideChoices[side1];
    }
    public String getSide2() {
        return sideChoices[side2];
    }
    public String getDessert() {
        return dessertChoices[dessert];
    }
}
