package CardDemo;

//Todd Mills
//CSC335 Project 1
//This project demos a 52 card deck using the Card class

/*
This program creates a virtual deck of cards and assigns them random numbers. It then deals the cards into 4 hands
of 13 cards each, calculates their real-world card values, and displays them. It then sorts the deck in both directions,
 dealing and printing the hands each time.
 */
public class CardDemo {
    public static void main(String[] args) {

        //Create a new Card object
        Card deck = new Card();
        //Initialize the deck of cards to 0
        deck.initArray();

        //First deal - random cards
        //Fill the array with random cards
        deck.generateRandomNum();
        //Deal the cards into 4 hands
        deck.dealCards();
        //Print the cards held in each hand
        deck.printHands();

        //Second deal -- ascending sort
        //Sort the deck
        deck.sortArray("Ascending");
        //Deal the sorted cards to the hands
        deck.dealCards();
        //Print the sorted hands
        deck.printHands();

        //Third deal -- descending sort
        //Sort the deck
        deck.sortArray("Descending");
        //Deal the sorted cards to the hands
        deck.dealCards();
        //Print the sorted hands
        deck.printHands();

    }
}
