package Deck;

import Cards.Cards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    private List<Cards> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Cards card) {
        cards.add(card);
    }


    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    public boolean playCard(int index) {
        if (index >= 0 && index < cards.size()) {
            cards.remove(index);
            System.out.println("Card at index " + index + " played.");
            return true;
        } else {
            return false;
        }
    }

    public List<String> getCardTypes() {
        List<String> cardTypes = new ArrayList<>();
        for (Cards card : cards) {
            cardTypes.add(card.getType());
        }
        return cardTypes;
    }

    public void printHand() {
        for (int i = 1; i < cards.size() + 1; i++) {
            System.out.println("Card " + i + ":");
            String cardType = getCardTypes().get(i - 1);
            if (!cardType.equals("Gold") && !cardType.equals("Resource")) {
                cardType = "Objective";
            }
            System.out.println("Card Type: " + cardType);
            cards.get(i - 1).prettyPrint();
            System.out.println("\n");
        }
        System.out.println("Number of cards in Hand: " + getHandCount());
    }
    
    public int getHandCount() {
        return cards.size();
    }
}