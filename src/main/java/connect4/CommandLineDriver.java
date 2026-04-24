package connect4;

import java.util.Scanner;

import connect4.response.ListStrategiesResponse;
import connect4.response.MoveResponse;
import connect4.response.NewGameResponse;
import connect4.response.OKResponse;
import connect4.response.StatusResponse;

public class CommandLineDriver 
{

    public static void main(String[] args)
    {
        //TODO: you have to switch to euclid to run this on campus
        // localhost means "the current machine", and unless you
        // are running your own server, localhost won't work
        //String baseUrl = "http://euclid.knox.edu:8083/connect4";
        String baseUrl = "http://localhost:8080/connect4";
        String user = "spacco";
        Connector conn = new Connector(baseUrl, user);
        
        System.out.println("Welcome!");
        help();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.next();
                if (command.equals("new")) {
                    NewGameResponse response = conn.newGame();
                    System.out.println(response.toString());
                } else if (command.equals("move")) {
                    int col = scanner.nextInt();
                    MoveResponse move = conn.makeMove(col);
                    System.out.println(move);
                    if (move.gameOver) {
                        System.out.println("Game over! Winner: " + move.winner);
                        break;
                    }
                } else if (command.equals("quit")) {
                    break;
                } else if (command.equals("status")) {
                    StatusResponse status = conn.status();
                    System.out.println(status.toString());
                } else if (command.equals("list")) {
                    ListStrategiesResponse list = conn.listStrategies();
                    for (Strategy strategy : list.getStrategies()) {
                        System.out.println(strategy.name + ": " + strategy.description);
                    }
                } else if (command.equals("strategy")) {
                    String strategy = scanner.next();
                    conn.setStrategy(strategy);
                    System.out.println("Strategy set to " + strategy);
                } else if (command.equals("help")) {
                    help();
                } else {
                    System.out.println("Unknown command: " + command);
                }


            }
        }
        System.out.println("Goodbye");
    }

    private static void help() {
        System.out.println("new - start a new game");
        System.out.println("move <col> - make a move in column <col>");
        System.out.println("quit - quit the game");
        System.out.println("status - check the status of the game");
        System.out.println("list - list the available strategies");
        System.out.println("strategy <name> - choose the given server strategy");
        System.out.println("help - show this help message");
    }
}
