package Client;

import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    /**
     * Main method to start the client and connect to the server.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to the game server");

            String userInput;
            while ((userInput = consoleInput.readLine()) != null) {
                out.println(userInput);
                String response;
                while ((response = in.readLine()) != null) {
                    System.out.println(response);
                    if (!in.ready()) {
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
