import controllers.GameController;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GameController gameController = new GameController();

        System.out.println("Let's begin Tic-Tac-Toe Game ...");

        System.out.println("What dimension of board do you need?");
        int dimension = scanner.nextInt();

        System.out.println("How many total players will play?");
        int numberOfPlayers = scanner.nextInt();

        System.out.println("Is there a bot? (y/n)");
        String isBot = scanner.next();

        int nonBotPlayers = numberOfPlayers;
        if(isBot.equals("y") || isBot.equals("yes")){
            nonBotPlayers -= 1;
        }

        List<Player> playerList = new ArrayList<>();

        for (int i = 0; i < nonBotPlayers; i++) {
            System.out.println("Enter the name of the player " + i);
            String playerName = scanner.next();
            System.out.println("Enter the symbol for the player ");
            String symbol = scanner.next();

            playerList.add(new Player(i, playerName, symbol.charAt(0), PlayerType.HUMAN, scanner));
        }

        if (isBot.equals("y") || isBot.equals("yes")) {
            System.out.println("Enter the name of the bot ");
            String playerName = scanner.next();
            System.out.println("Enter the symbol for the bot ");
            String symbol = scanner.next();

            playerList.add(new Bot(nonBotPlayers,playerName,symbol.charAt(0),
                    scanner,BotDifficultyLevel.EASY));
        }

        Game game = gameController.createGame(dimension,playerList);

        while(gameController.getGameStatus(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);

            // TODO: Add undo check here.

            gameController.executeNextMove(game);
        }

        System.out.println("Result of the game: ");

        if (gameController.getGameStatus(game).equals(GameState.DRAW)) {
            System.out.println("DRAW");
        } else {
            System.out.println("The winner is: " + gameController.getWinner(game));
        }
    }
}