package Board;

import Cards.Cards;
import Cards.GoldFront;
import Cards.Objective;
import Cards.ResourceFront;
import Deck.Hand;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int score;
    private Hand hand;
    private GoldFront goldCard;
    private ResourceFront resourceCard;
    private Objective objectiveCard;
    private Token token;
    public List<Cards> playedCards = new ArrayList<>();
    public Table table = new Table();

    public Player(String name) {
        this.name = name;
        this.score = 17;
        this.hand = new Hand();
    }

    public List<Cards> getPlayedCards(){
        return playedCards;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Hand getHand() {
        return hand;
    }

    /**
     * Adds a gold card to the player.
     * @param goldCard The gold card to be added.
     */
    public void addGoldCard(GoldFront goldCard) {
        this.goldCard = goldCard;
    }

    /**
     * Adds a resource card to the player.
     * @param resourceCard The resource card to be added.
     */
    public void addResourceCard(ResourceFront resourceCard) {
        this.resourceCard = resourceCard;
    }

    /**
     * Adds an objective card to the player.
     * @param objectiveCard The objective card to be added.
     */
    public void addObjectiveCard(Objective objectiveCard) {
        this.objectiveCard = objectiveCard;
    }

    /**
     * Creates a token for the player.
     * @param color The color of the token.
     * @param point The point value of the token.
     * @return The created token.
     */
    public Token makeToken(String color, int point) {
        return new Token(color, point);
    }

    /**
     * Sets the token for the player.
     * @param token The token to be set.
     */
    public void setToken(Token token) {
        this.token = token;
    }

    /**
     * Prints the player's token information.
     */
    public void printToken() {
        if (token != null) {
            token.printToken();
        } else {
            System.out.println("No token assigned.");
        }
    }

    /**
     * Adds points to the player's score.
     * @param player The player to whom points are added.
     * @param point The points to be added.
     */
    public void addPoint(Player player, int point){
        score = score + point;
    }

    /**
     * Adds conditional points to the player's score based on the gold card and the table state.
     * @param player The player to whom points are added.
     * @param card The gold card providing the conditional points.
     * @param table The table state.
     */
    public void addConditionalPoints(Player player, GoldFront card, Table table){
        if(card.getConditionalPoint().equals("bottle")) score = score + table.objOnTable[0];
        if(card.getConditionalPoint().equals("paper")) score = score + table.objOnTable[1];
        if(card.getConditionalPoint().equals("feather")) score = score + table.objOnTable[2];

        if(card.getConditionalPoint().equals("corner")) score = score + 2; //add possibility to cover more than one corner;
    }

    /**
     * Adds objective points to the player's score based on the objective card and the table state.
     * @param player The player to whom points are added.
     * @param card The objective card providing the points.
     * @param table The table state.
     */
    public void addObjectivePoints(Player player, Objective card, Table table){
        if(card.getType().equals("objects") && card.getObjective().length == 2){
            if(card.getObjective()[0].equals("bottle")){
                score = score + ((table.objOnTable[0]/2) * 2);
            }
            if(card.getObjective()[0].equals("paper")){
                score = score + ((table.objOnTable[1]/2) * 2);
            }
            if(card.getObjective()[0].equals("feather")){
                score = score + ((table.objOnTable[2]/2) * 2);
            }
        }

        if(card.getType().equals("objects") && card.getObjective().length == 3){
            score = score + ((Math.min(table.objOnTable[0], Math.min(table.objOnTable[1], table.objOnTable[2]))) * 3);
        }

        if(card.getType().equals("resources")){
            if(card.getObjective()[0].equals("leaf")){
                score = score +((table.resOnTable[0]/3) * 2);
            }
            if(card.getObjective()[0].equals("insect")){
                score = score + ((table.resOnTable[1]/3) * 2);
            }
            if(card.getObjective()[0].equals("animal")){
                score = score +((table.resOnTable[2]/3) * 2);
            }
            if(card.getObjective()[0].equals("mushroom")){
                score = score + ((table.resOnTable[3]/3) * 2);
            }
        }

        if(card.getType().equals("diagonal pattern")) {
            for(int i = 0; i < playedCards.size(); i++) {
                if (playedCards.get(i).getKingdom().equals(card.getObjective())) {
                    int j = i++;
                    while (table.card2.get(i) != table.card1.get(j)) j++;
                    if (playedCards.get(i).getKingdom().equals(playedCards.get(j).getKingdom())) {

                        if (card.getKingdom().equals("leaf") || card.getKingdom().equals("insect")) {
                            if (table.cardCorner.get(j) == 1) {
                                while (!(table.cardCorner.get(j) == 4 && table.card1.get(j) == table.card2.get(i))) j++;
                                if (card.getKingdom().equals("leaf") && playedCards.get(j).getKingdom().equals("leaf"))
                                    score = score + 2;
                                if (card.getKingdom().equals("insect") && playedCards.get(j).getKingdom().equals("insect"))
                                    score = score + 2;
                            }
                            if (table.cardCorner.get(j) == 4) {
                                while (!(table.cardCorner.get(j) == 1 && table.card1.get(j) == table.card2.get(i))) j++;
                                if (card.getKingdom().equals("leaf") && playedCards.get(j).getKingdom().equals("leaf"))
                                    score = score + 2;
                                if (card.getKingdom().equals("insect") && playedCards.get(j).getKingdom().equals("insect"))
                                    score = score + 2;
                            }
                        }

                        if (card.getKingdom().equals("animal") || card.getKingdom().equals("mushroom")) {
                            if(table.cardCorner.get(j) == 2) {
                                while(!(table.cardCorner.get(j) == 3 && table.card1.get(j) == table.card2.get(i))) j++;
                                if (card.getKingdom().equals("animal") && playedCards.get(j).getKingdom().equals("animal"))
                                    score = score + 2;
                                if (card.getKingdom().equals("mushroom") && playedCards.get(j).getKingdom().equals("mushroom"))
                                    score = score + 2;
                            }
                            if(table.cardCorner.get(j) == 3) {
                                while(!(table.cardCorner.get(j) == 2 && table.card1.get(j) == table.card2.get(i))) j++;
                                if (card.getKingdom().equals("animal") && playedCards.get(j).getKingdom().equals("animal"))
                                    score = score + 2;
                                if (card.getKingdom().equals("mushroom") && playedCards.get(j).getKingdom().equals("mushroom"))
                                    score = score + 2;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', score=" + score + ", hand=" + hand.getHandCount() + " cards, goldCard=" + goldCard + ", resourceCard=" + resourceCard + ", objectiveCard=" + objectiveCard + ", token=" + token + "}";
    }
}
