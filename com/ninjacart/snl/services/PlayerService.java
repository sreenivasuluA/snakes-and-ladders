package services;

import models.Game;
import models.Player;

public class PlayerService
{

    BoardService boardService = new BoardService();

    public void makeMove(Game game, Player player, int position)
    {

        int oldPosition = game.getBoard().getPlayerPieces().get(player.getId());
        if (oldPosition == 0 && position == 6)
        {
            position = 1;
            System.out.println(player.getName() + " Got the dice of 6 hence moving 1 position");
        }
        else if (oldPosition == 0)
        {
            position = 0;

            System.out.println(player.getName()
                    + " yet to get the dice of 6 hence there is no move and the current position is still "
                    + position);
        }
        if (position != 0)
        {
            int newPosition = oldPosition
                    + position; // Based on the dice value, the player moves their piece forward that number of cells.

            int boardSize = game.getBoard().getSize();

            // Can modify this logic to handle side case when there are multiple dices (Optional requirements)
            if (newPosition > boardSize)
            {
                newPosition = oldPosition; // After the dice roll, if a piece is supposed to move outside position 100, it does not move.
            }
            else
            {
                newPosition = boardService
                        .getNewPositionAfterGoingThroughSnakesAndLadders(game.getBoard(), player, oldPosition,
                                newPosition);
            }

            game.getBoard().getPlayerPieces().put(player.getId(), newPosition);

            System.out.println(player.getName() + " rolled a " + position + " and moved from " + oldPosition + " to "
                    + newPosition);
        }

    }
}
