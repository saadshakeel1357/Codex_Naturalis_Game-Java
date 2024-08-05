package Deck;

import Cards.StarterFront;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StarterDeck {

    private List<StarterFront> all_starter_cards;

    public StarterDeck(){
        this.all_starter_cards = new ArrayList<>();
        initializeAllStarterCards();
    }

    public int getDeckSize() {
        return all_starter_cards.size();
    }

    public StarterFront getRandomCard() {
        if (all_starter_cards.isEmpty()) {
            return null; 
        }
        Random random = new Random();
        int index = random.nextInt(all_starter_cards.size());
        return all_starter_cards.remove(index);
    }

    private void initializeAllStarterCards(){
        all_starter_cards.add(new StarterFront("empty", "leaf", "insect", "empty", new String[]{"insect"}));
        all_starter_cards.add(new StarterFront("animal", "empty", "empty", "mushroom", new String[]{"mushroom"}));
        all_starter_cards.add(new StarterFront("empty", "empty", "empty", "empty", new String[]{"leaf", "mushroom"}));
        all_starter_cards.add(new StarterFront("empty", "empty", "empty", "empty", new String[]{"animal", "insect"}));
        all_starter_cards.add(new StarterFront("empty", "empty", null, null, new String[]{"animal", "insect", "leaf"}));
        all_starter_cards.add(new StarterFront("empty", "empty", null, null, new String[]{"leaf", "animal", "mushroom"}));

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("StarterDeck contains the following cards:\n");
        for(StarterFront card : all_starter_cards){
            sb.append(card.toString()).append("\n");
            card.prettyPrint();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // // Initialize the GoldDeck and manually add valid req_resources
        // StarterDeck starterDeck = new StarterDeck();

        // // Print the goldDeck details
        // System.out.println(starterDeck.toString());

    }
}