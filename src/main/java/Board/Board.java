package Board;

import Cards.Cards;
import Cards.GoldFront;
import Cards.Objective;
import Deck.GoldDeck;
import Deck.ObjectiveDeck;
import Deck.ResourceDeck;
import Deck.StarterDeck;
import Client.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private ScoreBoard scoreBoard;
    private GoldDeck goldDeck;
    private ResourceDeck resourceDeck;
    private ObjectiveDeck objectiveDeck;
    private StarterDeck starterDeck;
    private List<Player> players;
    private Table table;
    private int currentPlayerIndex = 0; 

    public Board() {
        this.scoreBoard = new ScoreBoard();
        this.goldDeck = new GoldDeck();
        this.resourceDeck = new ResourceDeck();
        this.objectiveDeck = new ObjectiveDeck();
        this.starterDeck = new StarterDeck();
        this.players = new ArrayList<>();
        this.table = new Table();
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public GoldDeck getGoldDeck() {
        return goldDeck;
    }

    public ResourceDeck getResourceDeck() {
        return resourceDeck;
    }

    public ObjectiveDeck getObjectiveDeck() {
        return objectiveDeck;
    }

    public StarterDeck getStarterDeck() {
        return starterDeck;
    }

    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Initializes the players for the game.
     * @param numPlayers The number of players.
     * @param in BufferedReader for reading input.
     * @param out PrintWriter for writing output.
     * @return List of initialized players.
     * @throws IOException If an input or output exception occurred.
     */
    public List<Player> initializePlayers(int numPlayers, BufferedReader in, PrintWriter out) throws IOException {
        List<Player> players = new ArrayList<>();

        out.println("Initializing players...\n");
        out.flush();

        out.println("Enter name for Player1 (red token):");
        out.flush();
        String player1Name = in.readLine();
        Player player1 = new Player(player1Name);
        Cards startCard1 = starterDeck.getRandomCard();
        player1.getPlayedCards().add(startCard1);
        player1.table.initializeCorners(startCard1);
        player1.table.setResOnTable(player1, startCard1, 0 , 999 );
        Token token1 = player1.makeToken("red", 0);
        player1.setToken(token1);
        scoreBoard.addPlayer(player1);
        players.add(player1);

        out.println("Enter name for Player2 (blue token):");
        out.flush();
        String player2Name = in.readLine();
        Player player2 = new Player(player2Name);
        Cards startCard2 = starterDeck.getRandomCard();
        player2.getPlayedCards().add(startCard2);
        player2.table.initializeCorners(startCard2);
        table.setResOnTable(player2, startCard2, 0 , 999 );
        Token token2 = player2.makeToken("blue", 0);
        player2.setToken(token2);
        scoreBoard.addPlayer(player2);
        players.add(player2);

        if (numPlayers == 3) {
            out.println("Enter name for Player3 (green token):");
            out.flush();
            String player3Name = in.readLine();
            Player player3 = new Player(player3Name);
            Cards startCard3 = starterDeck.getRandomCard();
            player3.getPlayedCards().add(startCard3);
            player3.table.initializeCorners(startCard3);
            table.setResOnTable(player3, startCard3, 0 , 999 );
            Token token3 = player3.makeToken("green", 0);
            player3.setToken(token3);
            scoreBoard.addPlayer(player3);
            players.add(player3);
        } else if (numPlayers == 4) {
            out.println("Enter name for Player3 (green token):");
            out.flush();
            String player3Name = in.readLine();
            Player player3 = new Player(player3Name);
            Cards startCard3 = starterDeck.getRandomCard();
            player3.getPlayedCards().add(startCard3);
            player3.table.initializeCorners(startCard3);
            table.setResOnTable(player3, startCard3, 0 , 999 );
            Token token3 = player3.makeToken("green", 0);
            player3.setToken(token3);
            scoreBoard.addPlayer(player3);
            players.add(player3);

            out.println("Enter name for Player4 (yellow token):");
            out.flush();
            String player4Name = in.readLine();
            Player player4 = new Player(player4Name);
            Cards startCard4 = starterDeck.getRandomCard();
            player4.getPlayedCards().add(startCard4);
            player4.table.initializeCorners(startCard4);
            table.setResOnTable(player4, startCard4, 0 , 999 );
            Token token4 = player4.makeToken("yellow", 0);
            player4.setToken(token4);
            scoreBoard.addPlayer(player4);
            players.add(player4);
        }

        this.players = players;

        for (Player player : players) {
            startingHand(player);
        }
        return players;
    }

    /**
     * Gives the starting hand to a player.
     * @param player The player to whom the starting hand is given.
     */
    public void startingHand(Player player) {
        if (players == null || players.isEmpty()) {
            throw new IllegalStateException("Players are not initialized.");
        }

        if (goldDeck.getDeckSize() != 0) {
            player.getHand().addCard(goldDeck.getRandomCard());
        }

        if (resourceDeck.getDeckSize() != 0) {
            player.getHand().addCard(resourceDeck.getRandomCard());
            player.getHand().addCard(resourceDeck.getRandomCard());
        }
        if (objectiveDeck.getDeckSize() != 0) {
            player.getHand().addCard(objectiveDeck.getRandomCard());
        }
    }

    /**
     * Prepares the starting table for a player.
     * @param player The player for whom the starting table is prepared.
     * @return List of cards placed on the starting table.
     */
    public List<Cards> startingTable(Player player) {
        Cards goldCard1 = goldDeck.getRandomCard();
        Cards goldCard2 = goldDeck.getRandomCard();

        Cards resCard1 = resourceDeck.getRandomCard();
        Cards resCard2 = resourceDeck.getRandomCard();

        Cards objCard1 = objectiveDeck.getRandomCard();
        Cards objCard2 = objectiveDeck.getRandomCard();

        List<Cards> cards = new ArrayList<>();
        cards.add(goldCard1);
        cards.add(goldCard2);
        cards.add(resCard1);
        cards.add(resCard2);
        cards.add(objCard1);
        cards.add(objCard2);
        
        return cards;
    }

    /**
     * Displays the table with the cards.
     * @param cards The list of cards to be displayed on the table.
     * @return A formatted string representing the table.
     */
    public synchronized String showTable(List<Cards> cards) {
        if (cards == null) {
            throw new IllegalArgumentException("The list must contain exactly 7 cards.");
        }

        StringBuilder sb = new StringBuilder();

        sb.append("\n2 visible Gold Cards:\n")
          .append("Gold Card 1:\n")
          .append(cards.get(0).printBackFront(cards.get(0))).append("\n")
          .append("Gold Card 2:\n")
          .append(cards.get(1).printBackFront(cards.get(1))).append("\n");

        sb.append("\n2 visible Resource Cards:\n")
          .append("Resource Card 1:\n")
          .append(cards.get(2).printBackFront(cards.get(2))).append("\n")
          .append("Resource Card 2:\n")
          .append(cards.get(3).printBackFront(cards.get(3))).append("\n");

        sb.append("\n2 visible Objective Cards:\n")
          .append("Objective Card 1:\n")
          .append(cards.get(4).getPrettyPrint()).append("\n")
          .append("Objective Card 2:\n")
          .append(cards.get(5).getPrettyPrint()).append("\n");

        sb.append(showDecks());

        return sb.toString();
    }

    /**
     * Ends the game and calculates the objective points for a player.
     * @param player The player for whom the game is ended.
     * @param cards The list of cards on the table.
     * @param sb StringBuilder for appending output messages.
     */
    public void endGame(Player player, List<Cards> cards, StringBuilder sb){
        player.addObjectivePoints(player, (Objective)player.getHand().getCard(4), table);
        player.addObjectivePoints(player, (Objective)cards.get(4), table);
        player.addObjectivePoints(player, (Objective)cards.get(5), table);
    }

    /**
     * Displays the menu for the player and handles menu options.
     * @param player The player whose menu is displayed.
     * @param in BufferedReader for reading input.
     * @param out PrintWriter for writing output.
     * @param cards List of cards on the table.
     * @return A string representing the player's choices.
     * @throws IOException If an input or output exception occurred.
     */
    public synchronized String displayMenu(Player player, BufferedReader in, PrintWriter out, List<Cards> cards) throws IOException {

        String cardsOnTable = player.getPlayedCards().get(0).toString();
        StringBuilder sb = new StringBuilder();

        while (true) {

            out.println("\nChoose an option:\n"
                      + "1. Display Scoreboard\n"
                      + "2. Display Table\n"
                      + "3. Display Cards on the Table\n"
                      + "4. Display Hand\n"
                      + "5. Play\n"
                      + "6. Exit\n");
            out.flush();

            String choiceLine = in.readLine();
            int choice;
            try {
                choice = Integer.parseInt(choiceLine);
            } catch (NumberFormatException e) {
                out.println("Invalid input. Please enter a number.");
                out.flush();
                continue;
            }

            switch (choice) {
                case 1:
                    sb.append(getScoreBoard().toString()).append("\n");
                    break;

                case 2:
                    sb.append(showTable(cards)).append("\n");
                    break;

                case 3:
                    sb.append("\nCards currently on Table:\n")
                      .append(player.table.displayAllCards(player));
                    break;

                case 4:
                    sb.append("\n\nYour Hand:\n")
                      .append(player.getHand().printHand()).append("\n");
                    break;

                case 5:
                    cardsOnTable = putCard(player, cards, in, out, cardsOnTable);
                    break;

                case 6:
                    return sb.toString(); // Exit the menu

                default:
                    sb.append("Invalid choice. Please try again.\n");
            }

            out.println(sb.toString());
            out.flush();

            if (choice == 5 || choice == 6) {
                break;
            }
        }
        return "";
    }

    /**
     * Displays the deck sizes for the gold, resource, and objective decks.
     * @return A formatted string representing the deck sizes.
     */
    public String showDecks() {
        String goldDeckBox = 
              "┌─────────────────────────┐\n"
            + "|                         |\n"
            + "│       Gold Card         │\n"
            + "|          Deck           |\n"
            + "|                         |\n"
            + "|                         |\n"
            + "|           " + goldDeck.getDeckSize() + "            |\n"
            + "|       cards left        |\n" 
            + "└─────────────────────────┘";
        
        String resourceDeckBox = 
              "┌─────────────────────────┐\n"
            + "|                         |\n"
            + "│     Resource Card       │\n"
            + "|          Deck           |\n"
            + "|                         |\n"
            + "|                         |\n"
            + "|           " + resourceDeck.getDeckSize() + "            |\n"
            + "|       cards left        |\n" 
            + "└─────────────────────────┘";
            
        String objectiveDeckBox = 
              "┌─────────────────────────┐\n"
            + "|                         |\n"
            + "│     Objective Card      │\n"
            + "|          Deck           |\n"
            + "|                         |\n"
            + "|                         |\n"
            + "|           " + objectiveDeck.getDeckSize() + "            |\n"
            + "|       cards left        |\n" 
            + "└─────────────────────────┘";
        
        String[] goldDeckLines = goldDeckBox.split("\n");
        String[] resourceDeckLines = resourceDeckBox.split("\n");
        String[] objectiveDeckLines = objectiveDeckBox.split("\n");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < goldDeckLines.length; i++) {
            sb.append(goldDeckLines[i]).append("    ")
              .append(resourceDeckLines[i]).append("    ")
              .append(objectiveDeckLines[i]).append("\n");
        }

        return sb.toString();
    }

    /**
     * Handles the logic for playing a card from the player's hand onto the table.
     * @param player The player who is playing the card.
     * @param cards List of cards on the table.
     * @param in BufferedReader for reading input.
     * @param out PrintWriter for writing output.
     * @param cardsOnTable Current cards on the table as a string.
     * @return Updated string of cards on the table.
     * @throws IOException If an input or output exception occurred.
     */
    public synchronized String putCard(Player player, List<Cards> cards, BufferedReader in, PrintWriter out, String cardsOnTable) throws IOException {
        out.println(player.getHand().printHand());
        out.println("\nPlease enter the index of the card you want to play:");
        out.flush();
        String handIndexLine = in.readLine();
        int handIndex = Integer.parseInt(handIndexLine);

        while (handIndex > 3) {
            out.println("Index out of bounds, try again:");
            out.flush();
            handIndexLine = in.readLine();
            handIndex = Integer.parseInt(handIndexLine);
        }

        if (handIndex == 1) {
            if (!player.table.goldCardPlayable((GoldFront) player.getHand().getCard(handIndex))) {
                out.println("Card not playable, choose another card:");
                out.flush();
                handIndexLine = in.readLine();
                handIndex = Integer.parseInt(handIndexLine);
            }
        }

        out.println("\nChoose which side do you want to play:\n1. Front\n2. Back");
        out.flush();
        int side = Integer.parseInt(in.readLine());
        while(side > 2) {
            out.println("Index out of bounds, try again:");
            out.flush();
            side = Integer.parseInt(in.readLine());
        }

        if (side == 2) {
            player.getHand().getCard(handIndex).setVar1("empty");
            player.getHand().getCard(handIndex).setVar2("empty");
            player.getHand().getCard(handIndex).setVar3("empty");
            player.getHand().getCard(handIndex).setVar4("empty");
        }

        Cards cardToBePlayed = player.getHand().getCard(handIndex);

        out.println("\nCards currently on the table: \n" + player.table.displayAllCards(player));
        out.flush();
        int prevcard;
        if (player.getPlayedCards().size() > 1) {
            out.println("Choose which card do you want to connect:");
            out.flush();
            String prevcardLine = in.readLine();
            prevcard = Integer.parseInt(prevcardLine);
            while(prevcard > player.playedCards.size() -1){
                out.println("Index out of bounds, try again:");
                out.flush();
                prevcard = Integer.parseInt(in.readLine());
            }
        } else {
            prevcard = 0;
        }

        while (Arrays.equals(player.table.corners.get(prevcard), new int[]{0, 0, 0, 0})) {
            out.println("Card not playable all corner used, choose another card:");
            out.flush();
            prevcard = Integer.parseInt(in.readLine());
        }

        out.println("Upper left corner = 1\nUpper right corner = 2\nBottom left corner = 3\nBottom right corner = 4\nGo back = 5\nOn which corner of the starter do you wish to put your card on:");
        out.flush();
        String cornerLine = in.readLine();
        Integer corner = Integer.parseInt(cornerLine);

        cardsOnTable = player.table.addCard(player, cardToBePlayed, prevcard, corner, in, out);

        player.getHand().playCard(handIndex);

        player.addPoint(player, cardToBePlayed.getPoint());
        if (handIndex == 1) {
            player.addConditionalPoints(player, (GoldFront) cardToBePlayed, table);
        }

        out.println("Card placed successfully.\n" + cardsOnTable);
        out.flush();

        drawCard(player, cards, in, out, handIndex);

        return cardsOnTable;
    }

    /**
     * Handles the logic for drawing a card from the decks or from the table.
     * @param player The player who is drawing the card.
     * @param cards List of cards on the table.
     * @param in BufferedReader for reading input.
     * @param out PrintWriter for writing output.
     * @param index The index of the card to be replaced in the hand.
     * @throws IOException If an input or output exception occurred.
     */
    public synchronized void drawCard(Player player, List<Cards> cards, BufferedReader in, PrintWriter out, int index) throws IOException {
        out.println("Draw a card from the decks or from the table:");
        out.flush();

        while (true) {
            out.println("1. Draw from Table\n2. Draw from decks");
            out.flush();

            String choiceLine = in.readLine();
            if (choiceLine == null || choiceLine.isEmpty()) {
                out.println("Invalid input. Please enter a number.");
                out.flush();
                continue;
            }

            int choice;
            try {
                choice = Integer.parseInt(choiceLine);
            } catch (NumberFormatException e) {
                out.println("Invalid input. Please enter a number.");
                out.flush();
                continue;
            }

            switch (choice) {
                case 1:
                    out.println("Choose one of the cards on the table:");
                    out.println(showTable(cards));
                    out.flush();

                    switch (index) {
                        case 1:
                            out.println("1. Gold Card 1\n2. Gold Card 2");
                            out.flush();
                            String goldLine = in.readLine();
                            int gold = Integer.parseInt(goldLine);
                            player.getHand().replaceCard(cards.get(gold - 1), index - 1);
                            Cards goldCard = goldDeck.getRandomCard();
                            cards.add(gold - 1, goldCard);
                            cards.remove(gold);
                            break;

                        case 2:
                        case 3:
                            out.println("1. Resource Card 1\n2. Resource Card 2");
                            out.flush();
                            String resLine = in.readLine();
                            int res = Integer.parseInt(resLine);
                            player.getHand().replaceCard(cards.get(res + 1), index - 1);
                            Cards resourceCard = resourceDeck.getRandomCard();
                            cards.add(res + 2, resourceCard);
                            cards.remove(res + 1);
                            break;
                    }
                    break;

                case 2:
                    switch (index) {
                        case 1:
                            Cards goldCards = goldDeck.getRandomCard();
                            player.getHand().replaceCard(goldCards, index - 1);
                            out.println("Drew a Gold Card");
                            out.flush();
                            break;

                        case 2:
                        case 3:
                            Cards resourceCard = resourceDeck.getRandomCard();
                            player.getHand().replaceCard(resourceCard, index - 1);
                            out.println("Drew a Resource Card");
                            out.flush();
                            break;
                    }
                    break;

                default:
                    out.println("Invalid choice. Please try again.");
                    out.flush();
                    continue;
            }
            out.println("Card drawn successfully.");
            out.flush();
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        Board board = new Board();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);
        StringBuilder sb = new StringBuilder();

        int numPlayers = 0;

        Menu menu = new Menu();
        out.println("\n" +menu.CodexNaturalis);
        out.println(menu.choice);

        while (true) {
            out.println("Enter the number of players (2, 3, or 4):");
            String numPlayersLine = in.readLine();
            numPlayers = Integer.parseInt(numPlayersLine);

            if (numPlayers >= 2 && numPlayers <= 4) {
                break;
            } else {
                out.println("Invalid number of players. There must be 2, 3, or 4 players.");
            }
        }

        List<Player> players = board.initializePlayers(numPlayers, in, out);

        out.println("\n\nBoard initialized...");
        List<Cards> cards = board.startingTable(players.get(0));

        while (true) {
            Player currentPlayer = players.get(board.currentPlayerIndex);
            if (currentPlayer.getScore() >= 20 || board.goldDeck.getDeckSize() < 0 || board.resourceDeck.getDeckSize() < 0) {
                List<Integer> scores = new ArrayList<>();
                for(Player player: players){
                    board.endGame(player, cards, sb);
                    scores.add(player.getScore());
                }
                out.println(board.getScoreBoard().toString());
                int highestScore = Integer.MIN_VALUE;
                int highestScoreIndex = -1;
                for (int i = 0; i < scores.size(); i++) {
                    if (scores.get(i) > highestScore) {
                        highestScore = scores.get(i);
                        highestScoreIndex = i;
                    }
                }
                out.println("Player: " + players.get(highestScoreIndex).getName() + " win!!!");
                System.exit(0);

            }
            out.println("Current Player: " + currentPlayer.getName());
            out.flush();
            out.println(board.displayMenu(currentPlayer, in, out, cards));
            out.flush();
            board.currentPlayerIndex = (board.currentPlayerIndex + 1) % players.size(); // Switch to next player
        }
    }
}
