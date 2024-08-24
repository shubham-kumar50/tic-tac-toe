package models;

import strategies.bot.BotPlayingStrategy;

public class Bot extends Player {

    BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;

    public Bot(int id, String name, char symbol, PlayerType playerType,
               BotDifficultyLevel botDifficultyLevel,
               BotPlayingStrategy botPlayingStrategy)
    {
        super(id, name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = botPlayingStrategy;
    }
}
