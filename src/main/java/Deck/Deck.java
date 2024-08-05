package Deck;

import Cards.GoldFront;
import Cards.ResourceFront;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Deck {


    public Deck() {
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.initializeAndPlay();
    }

    private void initializeAndPlay() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // initialize the complete golddeck
        List<GoldFront> goldDeck = new GoldDeck().getAllGoldCards();

        // initialize the complete resourcedeck
        List<ResourceFront> resourceDeck = new ResourceDeck().getAllResourceCards();

        Hand hand = new Hand();

        // Add one random card from gold deck to hand
        if (!goldDeck.isEmpty()) {
            int goldCardIndex = random.nextInt(goldDeck.size());
            hand.addCard(goldDeck.get(goldCardIndex)); // Assuming you convert GoldFront to Resource
            goldDeck.remove(goldCardIndex);
        }

        // Add two random cards from resource deck to hand
        for (int i = 0; i < 2; i++) {
            if (!resourceDeck.isEmpty()) {
                int resourceCardIndex = random.nextInt(resourceDeck.size());
                hand.addCard(resourceDeck.get(resourceCardIndex)); // Assuming you convert ResourceFront to Resource
                resourceDeck.remove(resourceCardIndex);
            }
        }

        play(scanner, hand);
        scanner.close();
    }

    private void play(Scanner scanner, Hand hand) {
        boolean playing = true;
        while (playing) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check Hand");
            System.out.println("2. Play");
            System.out.println("3. Exit");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        hand.printHand();
                        break;
                    case 2:
                        playCards(scanner, hand);
                        break;
                    case 3:
                        playing = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private void playCards(Scanner scanner, Hand hand) {
        boolean playing = true;
        while (playing && hand.getHandCount() > 0) {
            System.out.println("Enter the index of the card you want to play (1 to " + hand.getHandCount() + ") or -1 to exit:");
            try {
                int index = scanner.nextInt();

                if (index == -1) {
                    playing = false;
                } else {
                    boolean success = hand.playCard(index - 1);
                    if (!success) {
                        System.out.println("Invalid index. Cannot play card.");
                    } else {
                        hand.printHand();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again.");
                scanner.next(); // Clear the invalid input
            }
        }

        if (hand.getHandCount() == 0) {
            System.out.println("No more cards left to play.");
        }
    }
}