package Deck;

import Cards.ResourceFront;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ResourceDeck {

    private List<ResourceFront> all_resource_cards;

    public ResourceDeck() {
        this.all_resource_cards = new ArrayList<>();
        initializeAllResourceCards();
    }

    public int getDeckSize() {
        return all_resource_cards.size();
    }

    public ResourceFront getRandomCard() {
        if (all_resource_cards.isEmpty()) {
            return null; 
        }
        Random random = new Random();
        int index = random.nextInt(all_resource_cards.size());
        return all_resource_cards.remove(index);
    }

    //Method to initialize all resource cards
    private void initializeAllResourceCards() {

        //mushroom cards
        all_resource_cards.add(new ResourceFront("mushroom", "empty", "mushroom", null, "mushroom", 0));
        all_resource_cards.add(new ResourceFront("mushroom", "mushroom", null, "empty", "mushroom", 0));
        all_resource_cards.add(new ResourceFront("empty", null, "mushroom", "mushroom", "mushroom", 0));
        all_resource_cards.add(new ResourceFront(null, "mushroom", "empty", "mushroom", "mushroom", 0));
        all_resource_cards.add(new ResourceFront(null, "feather", "leaf", "mushroom", "mushroom", 0));
        all_resource_cards.add(new ResourceFront("bottle", "mushroom", null, "animal", "mushroom", 0));
        all_resource_cards.add(new ResourceFront("mushroom", "insect", "paper", "empty", "mushroom", 0));
        all_resource_cards.add(new ResourceFront("empty", "mushroom", "empty", null, "mushroom", 1));
        all_resource_cards.add(new ResourceFront("mushroom", null, "empty", "empty", "mushroom", 1));
        all_resource_cards.add(new ResourceFront(null, "empty", "mushroom", "empty", "mushroom", 1));

        //leaf cards
        all_resource_cards.add(new ResourceFront("leaf", "empty", "leaf", null, "leaf", 0));
        all_resource_cards.add(new ResourceFront("leaf", "leaf", null, "empty", "leaf", 0));
        all_resource_cards.add(new ResourceFront("empty", null, "leaf", "leaf", "leaf", 0));
        all_resource_cards.add(new ResourceFront(null, "leaf", "empty", "leaf", "leaf", 0));
        all_resource_cards.add(new ResourceFront(null, "insect", "feather", "leaf", "leaf", 0));
        all_resource_cards.add(new ResourceFront("mushroom", "leaf", null, "bottle", "leaf", 0));
        all_resource_cards.add(new ResourceFront("paper", null, "leaf", "animal", "leaf", 0));
        all_resource_cards.add(new ResourceFront("empty", "empty", "leaf", null, "leaf", 1));
        all_resource_cards.add(new ResourceFront("empty", "empty", null, "leaf", "leaf", 1));
        all_resource_cards.add(new ResourceFront(null, "leaf", "empty", "empty", "leaf", 1));

        //animal cards
        all_resource_cards.add(new ResourceFront("animal", "animal", "empty", null, "animal", 0));
        all_resource_cards.add(new ResourceFront(null, "empty", "animal", "animal", "animal", 0));
        all_resource_cards.add(new ResourceFront("animal", null, "animal", "empty", "animal", 0));
        all_resource_cards.add(new ResourceFront("empty", "animal", null, "animal", "animal", 0));
        all_resource_cards.add(new ResourceFront(null, "insect", "bottle", "animal", "animal", 0));
        all_resource_cards.add(new ResourceFront("leaf", "animal", null, "paper", "animal", 0));
        all_resource_cards.add(new ResourceFront("feather", null, "animal", "mushroom", "animal", 0));
        all_resource_cards.add(new ResourceFront(null, "empty", "animal", "empty", "animal", 1));
        all_resource_cards.add(new ResourceFront("empty", null, "empty", "animal", "animal", 1));
        all_resource_cards.add(new ResourceFront("empty", "animal", "empty", null, "animal", 1));

        //insect cards
        all_resource_cards.add(new ResourceFront("insect", "insect", "empty", null, "insect", 0));
        all_resource_cards.add(new ResourceFront(null, "empty", "insect", "insect", "insect", 0));
        all_resource_cards.add(new ResourceFront("insect", null, "insect", "empty", "insect", 0));
        all_resource_cards.add(new ResourceFront("empty", "insect", null, "insect", "insect", 0));
        all_resource_cards.add(new ResourceFront(null, "feather", "animal", "insect", "insect", 0));
        all_resource_cards.add(new ResourceFront("paper", "insect", null, "mushroom", "insect", 0));
        all_resource_cards.add(new ResourceFront("insect", "leaf", "bottle", null, "insect", 0));
        all_resource_cards.add(new ResourceFront("insect", null, "empty", "empty", "insect", 1));
        all_resource_cards.add(new ResourceFront("empty", "empty", null, "insect", "insect", 1));
        all_resource_cards.add(new ResourceFront(null, "insect", "empty", "empty", "insect", 1));

    }

    public List<ResourceFront> getAllResourceCards() {
        return new ArrayList<>(all_resource_cards); // Returning a copy of the list
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResourceDeck contains the following cards:\n");
        for (ResourceFront card : all_resource_cards) {
            sb.append(card.toString()).append("\n");
            card.prettyPrint();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // // Initialize the GoldDeck and manually add valid req_resources
        // ResourceDeck resourceDeck = new ResourceDeck();

        // // Print all the cards in the resource deck for testing
        // List<ResourceFront> cards = resourceDeck.getAllResourceCards();
        // for (ResourceFront card : cards){
        //     card.prettyPrint();
        // }
    }


}

