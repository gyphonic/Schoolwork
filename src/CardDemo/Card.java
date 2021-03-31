package CardDemo;

import java.util.Arrays;
import java.util.Random;

//Todd Mills
//CSC335 Project 1
//This class holds data for the Card object

/*
This program can create a deck of 52 cards, assign them random numbers, sort them, or deal them into 4 hands and print
the contents of each hand onscreen. Made with love and sweat.
 */

public class Card {
    //deckArray to simulate a deck of cards
    int[] deckArray = new int[52];
    //Array to hold the individual hands of cards
    int[][] hands = new int[4][13];

    //Class methods

    //Method to initialize array and printing all zeros
    //Does not accept any arguments
    //Does not return any values
    public void initArray() {
        System.out.println("Initializing array......");
        Arrays.fill(deckArray, 0);
        System.out.println(Arrays.toString(deckArray));
        System.out.println("Array initialized.");
    }
    //Method to assign random card values to deckArray
    //Does not accept any arguments
    //Does not return any values
    public void generateRandomNum() {
        System.out.println("\nAssigning values....");
        Random randCard = new Random();
        int[] pickedCards = new int[53];
        boolean isUnique;
        int newCard = 0;
        //set a new random value for each card
        for (int i = 0; i < deckArray.length; i++) {
            isUnique = false;
            while(!isUnique) {
                newCard = randCard.nextInt(53);
                if (pickedCards[newCard] == 0 && newCard != 0) {
                    pickedCards[newCard] = 1;
                    deckArray[i] = newCard;
                    isUnique = true;
                }
            }
        }
        System.out.println("Values assigned.");
    }
    //Method to deal the cards into the 4 hands and print
    public void dealCards() {
        System.out.println("\nDealing cards...\n");
        for (int i = 0; i < 4; i++) {
            System.out.println("Hand " + (i +1));
            for (int x = 0; x < 13; x++) {
                hands[i][x] = deckArray[((i*13) + x)];
                System.out.print(hands[i][x] + " ");
            }
            System.out.println("\n");
        }
        System.out.println("Cards dealt.");
    }
    //Method to convert hands ints to card values and print (it was easier to combine printHand and printCardsInHand)
    //Does not accept any arguments
    //Does not return any values
    public void printHands() {
        System.out.println("\nPrinting hands...\n");
        //Because of how modulo works on numbers that are evenly divisible, "King" has to be in index 0 and 13
        String[] values = {"King", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int tempCard;
        //StringBuilders to hold card real card values
        StringBuilder handClubs = new StringBuilder();
        StringBuilder handDiamonds = new StringBuilder();
        StringBuilder handHearts = new StringBuilder();
        StringBuilder handSpades = new StringBuilder();
        //For each hand...
        for (int i = 0; i < 4; i++){
            //Make sure each StringBuilder is empty
            handClubs.delete(0, handClubs.length());
            handDiamonds.delete(0, handDiamonds.length());
            handHearts.delete(0, handHearts.length());
            handSpades.delete(0, handSpades.length());
            //Sort each hand into ascending order (Only really useful if the deck has not been sorted)
            for (int x = 0; x < 13; x++) {
                for (int y = 1; y < 13; y++) {
                    if (hands[i][y-1] > hands[i][y]) {
                        tempCard = hands[i][y];
                        hands[i][y] = hands[i][y-1];
                        hands[i][y-1] = tempCard;
                    }
                }
            }
            //Get the face values of each card and store it in StringBuilders
            for (int x = 0; x < 13; x++) {
                tempCard = hands[i][x];
                if (tempCard <= 13) {
                    handClubs.append(values[tempCard]);
                    handClubs.append(" ");
                } else if (tempCard >= 14 && tempCard <= 26) {
                    handDiamonds.append(values[(tempCard%13)]);
                    handDiamonds.append(" ");
                } else if (tempCard >= 27 && tempCard <= 39) {
                    handHearts.append(values[(tempCard%13)]);
                    handHearts.append(" ");
                } else if (tempCard >= 40) {
                    handSpades.append(values[(tempCard%13)]);
                    handSpades.append(" ");
                }
            }
            //Print the values of the hand
            System.out.println("\n*** Hand " + (i + 1) + " ***");
            System.out.println("          Clubs: " + handClubs.toString());
            System.out.println("          Diamonds: " + handDiamonds.toString());
            System.out.println("          Hearts: " + handHearts.toString());
            System.out.println("          Spades: " + handSpades.toString());

        }
    }

    //Method to sort the deck of cards and print them to screen
    //Accepts a string for sorting method
    //Does not return a value
    public void sortArray(String sortMethod) {
        System.out.println("\nCurrent deck layout:");
        System.out.println(Arrays.toString(deckArray));
        int tempCard;
        //Sort the deck in ascending order
        if (sortMethod.equals("Ascending")) {
            System.out.println("*** Ascending sort ***");
            System.out.println("Sorting deck...");
            for (int i = 0; i < deckArray.length; i++) {
                for (int x = 1; x < deckArray.length; x++) {
                    if (deckArray[x-1] > deckArray[x]) {
                        tempCard = deckArray[x];
                        deckArray[x] = deckArray[x-1];
                        deckArray[x-1] = tempCard;
                    }
                }
            }
            //Sort the deck in descending order
        } else if (sortMethod.equals("Descending")) {
            System.out.println("*** Descending sort ***");
            System.out.println("Sorting deck...");
            for (int i = 0; i < deckArray.length; i++) {
                for (int x = 1; x < deckArray.length; x++) {
                    if (deckArray[x-1] < deckArray[x]) {
                        tempCard = deckArray[x];
                        deckArray[x] = deckArray[x-1];
                        deckArray[x-1] = tempCard;
                    }
                }
            }
        }
        //Print the sorted deck
        System.out.println("Deck sorted.\n");
        System.out.println(Arrays.toString(deckArray));
    }
}