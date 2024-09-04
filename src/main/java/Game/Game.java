package Game;

import Board.Board;
import Cards.Cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Game {
    private Board board;
    private BufferedReader in;
    private PrintWriter out;

    public Game(Board board, BufferedReader in, PrintWriter out) {
        this.board = board;
        this.in = in;
        this.out = out;
    }

    public String launchGame(int numPlayers) throws IOException {
        board.initializePlayers(numPlayers, in, out);

        StringBuilder response = new StringBuilder("\n\nGame ended...");
        List<Cards> cards = board.startingTable(board.getPlayers().get(0));

        response.append(board.displayMenu(board.getPlayers().get(0), in, out, cards));

        out.println("exited display menu");

        return response.toString();
    }
}
