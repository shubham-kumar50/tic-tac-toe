package controllers;

import models.Game;
import models.GameState;
import models.Player;
import services.BoardService;
import services.GameService;
import strategies.winningStrategies.ColWinningStrategy;
import strategies.winningStrategies.RowWinningStrategy;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> playerList){
        return Game.getBuilder().setPlayers(playerList)
                .addWinningStrategy(new ColWinningStrategy())
                .addWinningStrategy(new RowWinningStrategy())
                .setDimension(dimension)
                .build();
    }

    public void undo() {
    }

    public void displayBoard(Game game) {
        BoardService.display(game.getBoard());
    }

    public GameState getGameStatus(Game game) {
        return game.getGameState();
    }

    public void executeNextMove(Game game) {
        GameService gameService = new GameService(game);
        gameService.executeNextMove();
    }

    public String getWinner(Game game) {
        return game.getWinner().getName();
    }
}
