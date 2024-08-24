package models;

import strategies.winningStrategies.WinningStrategy;

import java.util.List;

public class Game {
    Board board;
    List<Player> players;
    List<Move> moves;
    Player nextPlayerTurn;
    GameState gameState;
    List<WinningStrategy> winningStrategies;
}
