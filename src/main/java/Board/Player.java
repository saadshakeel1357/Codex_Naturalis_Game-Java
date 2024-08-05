package Board;

import Deck.Hand;
import Cards.GoldFront;
import Cards.ResourceFront;
import Cards.Objective;

public class Player {
    private String name;
    private int score;
    private Hand hand;
    private GoldFront goldCard;
    private ResourceFront resourceCard;
    private Objective objectiveCard;
    private Token token;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.hand = new Hand();
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

    public void addGoldCard(GoldFront goldCard) {
        this.goldCard = goldCard;
    }

    public void addResourceCard(ResourceFront resourceCard) {
        this.resourceCard = resourceCard;
    }

    public void addObjectiveCard(Objective objectiveCard) {
        this.objectiveCard = objectiveCard;
    }

    public Token makeToken(String color, int point) {
        return new Token(color, point);
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public void printToken() {
        if (token != null) {
            token.printToken();
        } else {
            System.out.println("No token assigned.");
        }
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', score=" + score + ", hand=" + hand.getHandCount() + " cards, goldCard=" + goldCard + ", resourceCard=" + resourceCard + ", objectiveCard=" + objectiveCard + ", token=" + token + "}";
    }
}