package services;

import models.Board;
import models.Ladder;
import models.Player;
import models.Snake;

public class BoardService
{
    
    public int getNewPositionAfterGoingThroughSnakesAndLadders(Board board, Player player, int oldPosition,
            int newPosition)
    {
        int previousPosition;

        do
        {
            previousPosition = newPosition;
            for (Snake snake : board.getSnakes())
            {
                if (snake.getStart() == newPosition)
                {
                    System.out.println(
                            player.getName() + " rolled " + (newPosition - oldPosition) + " So moving back to " + snake
                                    .getEnd() + " from " + newPosition + " as snake present in the cell");
                    movePlayerToSnakeTailPosition(player.getName(), newPosition, snake.getEnd());
                    newPosition = snake
                            .getEnd(); // Whenever a piece ends up at a position with the head of the snake, the piece should go down to the position of the tail of that snake.
                }
            }

            for (Ladder ladder : board.getLadders())
            {
                if (ladder.getStart() == newPosition)
                {
                    System.out.println(
                            player.getName() + " rolled " + (newPosition - oldPosition) + " So moving to " + ladder
                                    .getEnd() + " from " + newPosition + " as ladder present in the cell");
                    newPosition = ladder
                            .getEnd(); // Whenever a piece ends up at a position with the start of the ladder, the piece should go up to the position of the end of that ladder.
                }
            }
        }
        while (newPosition
                != previousPosition); // There could be another snake/ladder at the tail of the snake or the end position of the ladder and the piece should go up/down accordingly.
        return newPosition;
    }

    private void movePlayerToSnakeTailPosition(String name, int start, int end)
    {

        while (start >= end)
        {
            System.out.println(name + " moving 2 steps back and new position is " + start);
            start = start - 2;
        }

    }
}
