package Board;

import java.util.ArrayList;
import java.util.List;
import Deck.GoldDeck;
import Deck.ResourceDeck;
import Deck.ObjectiveDeck;
import Cards.GoldFront;
import Cards.ResourceFront;
import Cards.Objective;

public class ScoreBoard {
    private List<Player> players;

    public ScoreBoard() {
        players = new ArrayList<>();
    }

    public boolean addPlayer(Player player) {
        if (players.size() < 4) {
            players.add(player);
            return true;
        } else {
            System.out.println("Cannot add more players. Maximum number of players is 4.");
            return false;
        }
    }

    public boolean removePlayer(Player player) {
        if (players.size() > 2) {
            players.remove(player);
            return true;
        } else {
            System.out.println("Cannot remove player. Minimum number of players is 2.");
            return false;
        }
    }

    public void distributeGoldCards(GoldDeck goldDeck) {
        List<GoldFront> goldCards = goldDeck.getAllGoldCards();
        for (Player player : players) {
            player.addGoldCard(goldCards.remove(0));
        }
    }

    public void distributeResourceCards(ResourceDeck resourceDeck) {
        List<ResourceFront> resourceCards = resourceDeck.getAllResourceCards();
        for (Player player : players) {
            player.addResourceCard(resourceCards.remove(0));
        }
    }

    public void distributeObjectiveCards(ObjectiveDeck objectiveDeck) {
        List<Objective> objectiveCards = objectiveDeck.getAllObjectiveCards();
        for (Player player : players) {
            player.addObjectiveCard(objectiveCards.remove(0));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int boxWidth = 30; // Width of the box
        int boxHeight = 20; // Total height of the box including borders
        int linesPerSection = (boxHeight - 2) / 2; // Number of lines per section (top and bottom)
        int extraLinesTop = linesPerSection / 2 - 1; // Extra lines between player scores in the top section
        int extraLinesBottom = linesPerSection / 2 - 1; // Extra lines between player scores in the bottom section

        sb.append("┌").append("─".repeat(boxWidth)).append("┐\n");

        // Top section: 1st and 3rd player's scores
        if (players.size() > 0) {
            String playerInfo = String.format("Token: red, Score: %d", players.get(0).getScore());
            sb.append("│").append(centerText(playerInfo, boxWidth)).append("│\n");
        }
        for (int j = 0; j < extraLinesTop; j++) {
            sb.append("│").append(" ".repeat(boxWidth)).append("│\n");
        }
        if (players.size() > 2) {
            String playerInfo = String.format("Token: green, Score: %d", players.get(2).getScore());
            sb.append("│").append(centerText(playerInfo, boxWidth)).append("│\n");
        }
        for (int j = 0; j < extraLinesTop; j++) {
            sb.append("│").append(" ".repeat(boxWidth)).append("│\n");
        }

        // Middle empty section
        int remainingLines = boxHeight - 2 - (2 * linesPerSection);
        for (int i = 0; i < remainingLines; i++) {
            sb.append("│").append(" ".repeat(boxWidth)).append("│\n");
        }

        // Bottom section: 4th and 2nd player's scores
        for (int j = 0; j < extraLinesBottom; j++) {
            sb.append("│").append(" ".repeat(boxWidth)).append("│\n");
        }
        if (players.size() > 3) {
            String playerInfo = String.format("Token: yellow, Score: %d", players.get(3).getScore());
            sb.append("│").append(centerText(playerInfo, boxWidth)).append("│\n");
        }
        for (int j = 0; j < extraLinesBottom; j++) {
            sb.append("│").append(" ".repeat(boxWidth)).append("│\n");
        }
        if (players.size() > 1) {
            String playerInfo = String.format("Token: blue, Score: %d", players.get(1).getScore());
            sb.append("│").append(centerText(playerInfo, boxWidth)).append("│\n");
        }

        sb.append("└").append("─".repeat(boxWidth)).append("┘\n");

        return sb.toString();
    }

    private String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(Math.max(0, padding))).append(text).append(" ".repeat(Math.max(0, width - text.length() - padding)));
        return sb.toString();
    }

    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard();
        Player player1 = new Player("Pio");
        Player player2 = new Player("Saad");
        Player player3 = new Player("David");
        Player player4 = new Player("Emma");

        player1.setScore(0);
        player2.setScore(0);
        player3.setScore(0);
        player4.setScore(0);

        scoreBoard.addPlayer(player1);
        scoreBoard.addPlayer(player2);
        scoreBoard.addPlayer(player3);
        scoreBoard.addPlayer(player4);

        System.out.println(scoreBoard);
    }
}