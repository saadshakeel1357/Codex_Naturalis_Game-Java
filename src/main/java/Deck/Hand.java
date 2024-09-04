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

    public void replaceCard(Cards card, int index){ cards.add(index, card);}

    public void removeCard(int index){ cards.remove(index); }


    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    public boolean playCard(int index) {
        if (index >= 0 && index < cards.size()) {
            cards.remove(index -1);
            System.out.println("Card at index " + index + " played.");
            return true;
        } else {
            return false;
        }
    }

    public Cards getCard(int index) {
        if (index >= 0 && index < cards.size()+1) {
            return cards.get(index-1);
        } else {
            throw new IndexOutOfBoundsException("Invalid card index: " + index);
        }
    }

    public List<String> getCardTypes() {
        List<String> cardTypes = new ArrayList<>();
        for (Cards card : cards) {
            cardTypes.add(card.getType());
        }
        return cardTypes;
    }

    public String printHand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < cards.size() + 1; i++) {
            sb.append("Card ").append(i).append(":\n");
            String cardType = getCardTypes().get(i - 1);
            if (!cardType.equals("Gold") && !cardType.equals("Resource")) {
                cardType = "Objective";
            }
            if(cardType == "Objective"){
                sb.append("Card Type: ").append(cardType).append("\n");
                sb.append(cards.get(i - 1).printBackFront(cards.get(i - 1))).append("\n\n");
            }
            else {
                sb.append("Card Type: ").append(cardType).append("     Kingdom: ").append(cards.get(i - 1).getKingdom()).append("\n");
                sb.append(cards.get(i - 1).printBackFront(cards.get(i - 1))).append("\n\n");
            }
        }
        sb.append("Number of cards in Hand: ").append(getHandCount()).append("\n");
        return sb.toString();
    }
    
    public int getHandCount() {
        return cards.size();
    }
}
