package models;

import strategies.bot.BotPlayingStrategy;
import strategies.bot.BotPlayingStrategyFactory;

import java.util.Scanner;

public class Bot extends Player {

    BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;

    public Bot(int id, String name, char symbol, Scanner scanner,
               BotDifficultyLevel botDifficultyLevel)
    {
        super(id, name, symbol, PlayerType.BOT, scanner);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    @Override
    public Move makeMove(Board board) {

        Move move = botPlayingStrategy.suggestMove(board);

        // NPE Check
        if (move == null) {
            return null;
        }

        System.out.printf("the bot is making a move %d %d.\n", move.getCell().getRow(), move.getCell().getCol());

        move.getCell().setPlayer(this);
        move.getCell().setCellStatus(CellStatus.OCCUPIED);

        return move;
    }
}
