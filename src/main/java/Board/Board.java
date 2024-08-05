package Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Cards.ResourceFront;
import Cards.StarterFront;
import Deck.GoldDeck;
import Deck.ResourceDeck;
import Deck.StarterDeck;
import Deck.ObjectiveDeck;

public class Board {
    private ScoreBoard scoreBoard;
    private GoldDeck goldDeck;
    private ResourceDeck resourceDeck;
    private ObjectiveDeck objectiveDeck;
    private StarterDeck starterDeck;
    private List<Player> players;
    private Table table;

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

    public List<Player> initializePlayers(int numPlayers, Scanner scanner) {
        List<Player> players = new ArrayList<>();

        System.out.println("Initializing players...");

        System.out.println("Enter name for Player1 (red token):");
        String player1Name = scanner.nextLine();
        Player player1 = new Player(player1Name);
        Token token1 = player1.makeToken("red", 0);
        player1.setToken(token1);
        scoreBoard.addPlayer(player1);
        players.add(player1);

        System.out.println("Enter name for Player2 (blue token):");
        String player2Name = scanner.nextLine();
        Player player2 = new Player(player2Name);
        Token token2 = player2.makeToken("blue", 0);
        player2.setToken(token2);
        scoreBoard.addPlayer(player2);
        players.add(player2);

        if (numPlayers == 3) {
            System.out.println("Enter name for Player3 (green token):");
            String player3Name = scanner.nextLine();
            Player player3 = new Player(player3Name);
            Token token3 = player3.makeToken("green", 0);
            player3.setToken(token3);
            scoreBoard.addPlayer(player3);
            players.add(player3);
        } else if (numPlayers == 4) {
            System.out.println("Enter name for Player3:");
            String player3Name = scanner.nextLine();
            Player player3 = new Player(player3Name);
            Token token3 = player3.makeToken("green", 0);
            player3.setToken(token3);
            scoreBoard.addPlayer(player3);
            players.add(player3);

            System.out.println("Enter name for Player4 (yellow token):");
            String player4Name = scanner.nextLine();
            Player player4 = new Player(player4Name);
            Token token4 = player4.makeToken("yellow", 0);
            player4.setToken(token4);
            scoreBoard.addPlayer(player4);
            players.add(player4);
        }

        this.players = players;
        return players;
    }

    public void startingHand() {
        if (players == null || players.isEmpty()) {
            throw new IllegalStateException("Players are not initialized.");
        }

        Player player1 = players.get(0);

        if (goldDeck.getDeckSize() != 0) {
            player1.getHand().addCard(goldDeck.getRandomCard());
        }
        if (objectiveDeck.getDeckSize() != 0) {
            player1.getHand().addCard(objectiveDeck.getRandomCard());
        }
        if (resourceDeck.getDeckSize() != 0) {
            player1.getHand().addCard(resourceDeck.getRandomCard());
            player1.getHand().addCard(resourceDeck.getRandomCard());
        }

    }

    public void startingTable(Player player, Scanner scanner) {
        displayMenu(player, scanner);

        System.out.println("\n2 visible Gold Cards:");
        goldDeck.getRandomCard().prettyPrint();
        goldDeck.getRandomCard().prettyPrint();

        System.out.println("\n2 visible Resource Cards:");
        resourceDeck.getRandomCard().prettyPrint();
        resourceDeck.getRandomCard().prettyPrint();

        System.out.println("\n2 visible Objective Cards:");
        objectiveDeck.getRandomCard().prettyPrint();
        objectiveDeck.getRandomCard().prettyPrint();

        showDecks();

        System.out.println("\nStarter Card:");
        
        starterDeck.getRandomCard().prettyPrint();
    }

    public void displayMenu(Player player, Scanner scanner) {
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display Scoreboard");
            System.out.println("2. Display Table");
            System.out.println("3. Display Hand");
            System.out.println("4. Play");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println(getScoreBoard());

                    break;

                case 2:
                    System.out.println("\n2 visible Gold Cards:");
                    goldDeck.getRandomCard().prettyPrint();
                    goldDeck.getRandomCard().prettyPrint();

                    System.out.println("\n2 visible Resource Cards:");
                    resourceDeck.getRandomCard().prettyPrint();
                    resourceDeck.getRandomCard().prettyPrint();

                    System.out.println("\n2 visible Objective Cards:");
                    objectiveDeck.getRandomCard().prettyPrint();
                    objectiveDeck.getRandomCard().prettyPrint();

                    showDecks();

                    System.out.println("\nStarter Card:");
        
                    starterDeck.getRandomCard().prettyPrint();

                    break;

                case 3:
                    System.out.println("\n\nYour Hand:  \n");
                    player.getHand().printHand();

                    break;
                    
                case 4:
                    System.out.println("TO be developed...");
                    
                    break;

                case 5:
                    return; // Exit the menu

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void showDecks() {
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
        
        for (int i = 0; i < goldDeckLines.length; i++) {
            System.out.println(goldDeckLines[i] + "    " + resourceDeckLines[i] + "    " + objectiveDeckLines[i]);
        }
    }

    public void playCard(Player player) {
        
        // still testing, not fully developed
        StarterFront starterCard = starterDeck.getRandomCard();
        ResourceFront resourceCard = (ResourceFront) resourceDeck.getRandomCard(); 

        String[] starterCardLines = starterCard.getPrettyPrint().split("\n");
        String[] resourceCardLines = resourceCard.getPrettyPrint().split("\n");

        table.addCardBottomLeftCorner(starterCard, resourceCard, starterCardLines, resourceCardLines);
    }
    

    public static void main(String[] args) {
        Board board = new Board();

        Scanner scanner = new Scanner(System.in);
        int numPlayers = 0;

        while (true) {
            System.out.println("Enter the number of players (2, 3, or 4):");
            numPlayers = scanner.nextInt();
            scanner.nextLine(); 

            if (numPlayers >= 2 && numPlayers <= 4) {
                break;
            } else {
                System.out.println("Invalid number of players. There must be 2, 3, or 4 players.");
            }
        }

        List<Player> players = board.initializePlayers(numPlayers, scanner);
        board.startingHand();


        // Added one of the table function to the Board class, now I have to make sure this function works in the playCard function when called from the switch statements.... 
        System.out.println("wjfbw");

        board.playCard(players.get(0));
        System.out.println("wjfbw");
        // Added one of the table function to the Board class, now I have to make sure this function works in the playCard function when called from the switch statements.... 

        System.out.println("\n\nBoard initialized...");
        board.startingTable(players.get(0), scanner);

        System.out.println("Gold Deck size: " + board.getGoldDeck().getDeckSize());
        System.out.println("Resource Deck size: " + board.getResourceDeck().getDeckSize());
        System.out.println("Objective Deck size: " + board.getObjectiveDeck().getDeckSize());

        scanner.close();
    }
}