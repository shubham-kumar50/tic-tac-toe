package strategies.winningStrategies;

import models.*;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        Player player = move.getCell().getPlayer();
        int boardSize = board.getBoard().size();

        for (int i = 0; i < boardSize; i++) {
            Cell cell = board.getBoard().get(i).get(i);
            if (cell.getCellStatus().equals(CellStatus.EMPTY)
                    || !cell.getPlayer().equals(player)) {
                return false;
            }
        }

        for (int i = boardSize-1; i >= 0; i--) {
            Cell cell = board.getBoard().get(i).get(boardSize-1-i);
            if (cell.getCellStatus().equals(CellStatus.EMPTY)
                    || !cell.getPlayer().equals(player)) {
                return false;
            }
        }

        return true;
    }
}
