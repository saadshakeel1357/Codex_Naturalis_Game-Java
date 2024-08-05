package Deck;

import Cards.GoldFront;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GoldDeck {

    private List<Object[]> valid_req_resources; 
    private List<GoldFront> all_gold_cards; 

    public GoldDeck() {
        this.valid_req_resources = new ArrayList<>();
        this.all_gold_cards = new ArrayList<>();
        initializeValidReqResources();
        initializeAllGoldCards();
    }

    public int getDeckSize() {
        return all_gold_cards.size();
    }

    // Method to return a random card from the gold deck
    public GoldFront getRandomCard() {
        if (all_gold_cards.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(all_gold_cards.size());
        return all_gold_cards.remove(index);
    }


    private void initializeValidReqResources() {

        //valid req for animal
        valid_req_resources.add(new Object[]{"animal", "animal", "animal", "animal", "animal"});
        valid_req_resources.add(new Object[]{"animal", "animal", "animal"});
        valid_req_resources.add(new Object[]{"animal", "animal", "animal", "leaf"});
        valid_req_resources.add(new Object[]{"animal", "animal", "animal", "insect"});
        valid_req_resources.add(new Object[]{"animal", "animal", "animal", "mushroom"});
        valid_req_resources.add(new Object[]{"animal", "animal", "leaf"});
        valid_req_resources.add(new Object[]{"animal", "animal", "insect"});
        valid_req_resources.add(new Object[]{"animal", "animal", "mushroom"});

        //valid req for mushroom
        valid_req_resources.add(new Object[]{"mushroom", "mushroom", "mushroom", "mushroom", "mushroom"});
        valid_req_resources.add(new Object[]{"mushroom", "mushroom", "mushroom"});
        valid_req_resources.add(new Object[]{"mushroom", "mushroom", "mushroom", "leaf"});
        valid_req_resources.add(new Object[]{"mushroom", "mushroom", "mushroom", "insect"});
        valid_req_resources.add(new Object[]{"mushroom", "mushroom", "mushroom", "animal"});
        valid_req_resources.add(new Object[]{"mushroom", "mushroom", "leaf"});
        valid_req_resources.add(new Object[]{"mushroom", "mushroom", "insect"});
        valid_req_resources.add(new Object[]{"mushroom", "mushroom", "animal"});

        //valid req for insect
        valid_req_resources.add(new Object[]{"insect", "insect", "insect", "insect", "insect"});
        valid_req_resources.add(new Object[]{"insect", "insect", "insect"});
        valid_req_resources.add(new Object[]{"insect", "insect", "insect", "leaf"});
        valid_req_resources.add(new Object[]{"insect", "insect", "insect", "mushroom"});
        valid_req_resources.add(new Object[]{"insect", "insect", "insect", "animal"});
        valid_req_resources.add(new Object[]{"insect", "insect", "leaf"});
        valid_req_resources.add(new Object[]{"insect", "insect", "mushroom"});
        valid_req_resources.add(new Object[]{"insect", "insect", "animal"});

        //valid req for leaf
        valid_req_resources.add(new Object[]{"leaf", "leaf", "leaf", "leaf", "leaf"});
        valid_req_resources.add(new Object[]{"leaf", "leaf", "leaf"});
        valid_req_resources.add(new Object[]{"leaf", "leaf", "leaf", "insect"});
        valid_req_resources.add(new Object[]{"leaf", "leaf", "leaf", "mushroom"});
        valid_req_resources.add(new Object[]{"leaf", "leaf", "leaf", "animal"});
        valid_req_resources.add(new Object[]{"leaf", "leaf", "insect"});
        valid_req_resources.add(new Object[]{"leaf", "leaf", "mushroom"});
        valid_req_resources.add(new Object[]{"leaf", "leaf", "animal"});

    }

    // Method to get a specific combination from validReqResources by index
    public Object[] getReqResourcesByIndex(int index) {
        if (index < 0 || index >= valid_req_resources.size()) {
            throw new IllegalArgumentException("Invalid index for valid req_resources");
        }
        return valid_req_resources.get(index);
    }

    // Method to initialize all gold cards
    private void initializeAllGoldCards() {

        //mushroom cards
        all_gold_cards.add(new GoldFront(null, "empty", "empty","feather", "mushroom", 1, "feather", valid_req_resources.get(15)));
        all_gold_cards.add(new GoldFront("empty", "bottle", null,"empty", "mushroom", 1, "bottle", valid_req_resources.get(13)));
        all_gold_cards.add(new GoldFront("paper", "empty", "empty",null, "mushroom", 1, "paper", valid_req_resources.get(14)));
        all_gold_cards.add(new GoldFront("empty", "empty", null,"empty", "mushroom", 2, "corner", valid_req_resources.get(12)));
        all_gold_cards.add(new GoldFront("empty", "empty", "empty",null, "mushroom", 2, "corner", valid_req_resources.get(10)));
        all_gold_cards.add(new GoldFront("empty", null, "empty","empty", "mushroom", 2, "corner", valid_req_resources.get(11)));
        all_gold_cards.add(new GoldFront("empty", null, "bottle",null, "mushroom", 3, null, valid_req_resources.get(9)));
        all_gold_cards.add(new GoldFront("feather", "empty", null,null, "mushroom", 3, null, valid_req_resources.get(9)));
        all_gold_cards.add(new GoldFront(null, "paper", null,"empty", "mushroom", 3, null, valid_req_resources.get(9)));
        all_gold_cards.add(new GoldFront("empty", null, "empty",null, "mushroom", 5, null, valid_req_resources.get(8)));

        //leaf cards
        all_gold_cards.add(new GoldFront("feather", "empty", "empty",null, "leaf", 1, "feather", valid_req_resources.get(29)));
        all_gold_cards.add(new GoldFront("empty", "paper", null,"empty", "leaf", 1, "paper", valid_req_resources.get(30)));
        all_gold_cards.add(new GoldFront("empty", null, "bottle","empty", "leaf", 1, "bottle", valid_req_resources.get(31)));
        all_gold_cards.add(new GoldFront(null, "empty", "empty","empty", "leaf", 2, "corner", valid_req_resources.get(26)));
        all_gold_cards.add(new GoldFront("empty", "empty", "empty",null, "leaf", 2, "corner", valid_req_resources.get(28)));
        all_gold_cards.add(new GoldFront("empty", null, "empty","empty", "leaf", 2, "corner", valid_req_resources.get(27)));
        all_gold_cards.add(new GoldFront("empty", null, "feather",null, "leaf", 3, null, valid_req_resources.get(25)));
        all_gold_cards.add(new GoldFront("paper", "empty", null,null, "leaf", 3, null, valid_req_resources.get(25)));
        all_gold_cards.add(new GoldFront(null, "bottle", null,"empty", "leaf", 3, null, valid_req_resources.get(25)));
        all_gold_cards.add(new GoldFront("empty", "empty", null,null, "leaf", 5, null, valid_req_resources.get(24)));

        //animal cards
        all_gold_cards.add(new GoldFront("bottle", "empty", "empty",null, "animal", 1, "bottle", valid_req_resources.get(6)));
        all_gold_cards.add(new GoldFront(null, "empty", "empty","paper", "animal", 1, "paper", valid_req_resources.get(5)));
        all_gold_cards.add(new GoldFront("empty", null, "feather","empty", "animal", 1, "feather", valid_req_resources.get(7)));
        all_gold_cards.add(new GoldFront("empty", "empty", null,"empty", "animal", 2, "corner", valid_req_resources.get(3)));
        all_gold_cards.add(new GoldFront("empty", null, "empty","empty", "animal", 2, "corner", valid_req_resources.get(4)));
        all_gold_cards.add(new GoldFront(null, "empty", "empty","empty", "animal", 2, "corner", valid_req_resources.get(2)));
        all_gold_cards.add(new GoldFront("empty", null, "paper",null, "animal", 3, null, valid_req_resources.get(1)));
        all_gold_cards.add(new GoldFront("empty", "bottle", null,null, "animal", 3, null, valid_req_resources.get(1)));
        all_gold_cards.add(new GoldFront(null, "empty", null,"feather", "animal", 3, null, valid_req_resources.get(1)));
        all_gold_cards.add(new GoldFront(null, "empty", null,"empty", "animal", 5, null, valid_req_resources.get(0)));

        //insect cards
        all_gold_cards.add(new GoldFront("empty", "feather", null,"empty", "insect", 1, "feather", valid_req_resources.get(21)));
        all_gold_cards.add(new GoldFront("empty", null, "paper","empty", "insect", 1, "paper", valid_req_resources.get(23)));
        all_gold_cards.add(new GoldFront(null, "empty", "empty","bootle", "insect", 1, "bottle", valid_req_resources.get(22)));
        all_gold_cards.add(new GoldFront("empty", "empty", null,"empty", "insect", 2, "corner", valid_req_resources.get(20)));
        all_gold_cards.add(new GoldFront("empty", "empty", "empty",null, "insect", 2, "corner", valid_req_resources.get(18)));
        all_gold_cards.add(new GoldFront("empty", null, "empty","empty", "insect", 2, "corner", valid_req_resources.get(19)));
        all_gold_cards.add(new GoldFront("bottle", null, "empty",null, "insect", 3, null, valid_req_resources.get(17)));
        all_gold_cards.add(new GoldFront("empty", "paper", null,null, "insect", 3, null, valid_req_resources.get(17)));
        all_gold_cards.add(new GoldFront(null, null, "feather","empty", "insect", 3, null, valid_req_resources.get(17)));
        all_gold_cards.add(new GoldFront("empty", "empty", null,null, "insect", 5, null, valid_req_resources.get(16)));

    }

    public List<GoldFront> getAllGoldCards() {
        return new ArrayList<>(all_gold_cards); // Returning a copy of the list
    }

    // Override toString method to display the details of the gold deck
   @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GoldDeck contains the following cards:\n");
        for (GoldFront card : all_gold_cards) {
            sb.append(card.toString()).append("\n");
            card.prettyPrint();
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        // GoldDeck goldDeck = new GoldDeck();

        // // Print the goldDeck details (not prettyprint) loop is used for prettyprinting
        // System.out.println(goldDeck.toString());

        // // Test getRandomCard method
        // GoldFront randomCard = goldDeck.getRandomCard();
        // System.out.println("Random card drawn from the deck:");
        // randomCard.prettyPrint();
    }
}