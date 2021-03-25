package CardDemo;

import java.util.Arrays;
import java.util.Random;

//Todd Mills
//CSC335 Project 1
//This class holds data for the Card object, and is used by CardDemo
public class Card {
    //deckArray to simulate deck of cards
    int[][] deckArray = new int[4][13];
    //Class methods
    //Method to initialize array and printing all zeros
    public void initArray() {
        System.out.println("Initializing array......");
        for (int i = 0; i < 4; i++) {
            for (int x = 0; x < 13; x++) {
                deckArray[i][x] = 0;
            }
        }
        printDeck();
        System.out.println("Array initialized.");
    }
    //Method to easily print the deck of cards
    public void printDeck() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(deckArray[i]));
        }
    }
    //Method to assign random card values to deckArray
    public void assignCardValues() {
        System.out.println("\nAssigning values....");
        Random randCard = new Random();
        int[] pickedCards = new int[53];
        boolean isUnique;
        int newCard = 0;
        //set a new random value for each card
        for (int i = 0; i < 4; i++) {
            for (int x = 0; x < 13; x++) {
                isUnique = false;
                while(!isUnique) {
                    newCard = randCard.nextInt(53);
                    if (pickedCards[newCard] == 0 && newCard != 0) {
                        pickedCards[newCard] = 1;
                        deckArray[i][x] = newCard;
                        isUnique = true;
                    }
                }
            }
        }
        printDeck();
        System.out.println("Values assigned.");
    }
}