package Deck;

import Cards.Objective;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectiveDeck {

    private List<Objective> all_objective_cards;

    public ObjectiveDeck() {
        this.all_objective_cards = new ArrayList<>();
        initializeAllObjectiveCards();
    }

    public int getDeckSize() {
        return all_objective_cards.size();
    }

    public Objective getRandomCard() {
        if (all_objective_cards.isEmpty()) {
            return null; 
        }
        Random random = new Random();
        int index = random.nextInt(all_objective_cards.size());
        return all_objective_cards.remove(index);
    }

    // Method to initialize all objective cards
    private void initializeAllObjectiveCards() {

        all_objective_cards.add(new Objective(2, "objects", new String[]{"feather", "feather"}, "2 points per pair of feathers visible in the play area of the player."));
        all_objective_cards.add(new Objective(2, "objects", new String[]{"bottle", "bottle"}, "2 points per pair of bottles visible in the play area of the player."));
        all_objective_cards.add(new Objective(2, "objects", new String[]{"paper", "paper"}, "2 points per pair of papers visible in the play area of the player."));
        all_objective_cards.add(new Objective(3, "objects", new String[]{"feather", "bottle", "paper"}, "3 points per set of 3 different objects visible in the play area of the player."));

        all_objective_cards.add(new Objective(2, "resources", new String[]{"insect"}, "2 points per set of 3 insect visible in the play area of the player."));
        all_objective_cards.add(new Objective(2, "resources", new String[]{"animal"}, "2 points per set of 3 animal visible in the play area of the player."));
        all_objective_cards.add(new Objective(2, "resources", new String[]{"leaf"}, "2 points per set of 3 leaf visible in the play area of the player."));
        all_objective_cards.add(new Objective(2, "resources", new String[]{"mushroom"}, "2 points per set of 3 mushroom visible in the play area of the player."));

        all_objective_cards.add(new Objective(3, "vertical pattern", new String[]{"insect"}, "3 points for each matching of the following pattern: 2 vertical insect cards, the upper one should be connected to an animal card on the upper left corner."));
        all_objective_cards.add(new Objective(3, "vertical pattern", new String[]{"animal"}, "3 points for each matching of the following pattern: 2 vertical animal cards, the upper one should be connected to an mushroom card on the upper right corner."));
        all_objective_cards.add(new Objective(3, "vertical pattern", new String[]{"leaf"}, "3 points for each matching of the following pattern: 2 vertical leaf cards, the lower one should be connected to an insect card on the lower left corner."));
        all_objective_cards.add(new Objective(3, "vertical pattern", new String[]{"mushroom"}, "3 points for each matching of the following pattern: 2 vertical mushroom cards, the lower one should be connected to an leaf card on the lower right corner."));

        all_objective_cards.add(new Objective(2, "diagonal pattern", new String[]{"insect"}, "2 points for each matching of the following pattern: 3 insect cards following a diagonal between top left and bottom right."));
        all_objective_cards.add(new Objective(2, "diagonal pattern", new String[]{"leaf"}, "2 points for each matching of the following pattern: 3 leaf cards following a diagonal between top left and bottom right."));
        all_objective_cards.add(new Objective(2, "diagonal pattern", new String[]{"animal"}, "2 points for each matching of the following pattern: 3 animal cards following a diagonal between top right and bottom left."));
        all_objective_cards.add(new Objective(2, "diagonal pattern", new String[]{"mushroom"}, "2 points for each matching of the following pattern: 3 mushroom cards following a diagonal between top right and bottom left."));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Objective card : all_objective_cards) {
            card.prettyPrint();
        }
        return sb.toString();
    }

    public List<Objective> getAllObjectiveCards() {
        return new ArrayList<>(all_objective_cards); // Returning a copy of the list
    }

    public static void main(String[] args) {
        // ObjectiveDeck objectiveDeck = new ObjectiveDeck();
        // System.out.println(objectiveDeck.toString());
    }
}
