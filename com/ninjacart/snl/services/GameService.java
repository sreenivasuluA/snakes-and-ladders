package services;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import models.Board;
import models.Dice;
import models.Game;
import models.Player;

public class GameService
{

    DiceService diceService = new DiceService();

    PlayerService playerService = new PlayerService();

    Queue<Player> players = new LinkedList<>();

    public Game createGame(Board board, List<Player> players)
    {

        Game game = Game.getBuilder().setBoard(board).setPlayers(players).build();
        return game;

    }

    public void startGame(Game game)
    {
        players.addAll(game.getPlayers());

        while (!isGameCompleted(game))
        {
            int totalDiceValue = getTotalValueAfterDiceRolls(); // Each player rolls the dice when their turn comes.
            Player currentPlayer = players.poll();
            playerService.makeMove(game, currentPlayer, totalDiceValue);
            if (hasPlayerWon(game, currentPlayer))
            {
                System.out.println(currentPlayer.getName() + " wins the game");
                game.getBoard().getPlayerPieces().remove(currentPlayer.getId());
            }
            else
            {
                players.add(currentPlayer);
            }
        }

    }

    private boolean hasPlayerWon(Game game, Player player)
    {
        // Can change the logic a bit to handle special cases when there are more than one dice (Optional requirements)
        int playerPosition = game.getBoard().getPlayerPieces().get(player.getId());
        int winningPosition = game.getBoard().getSize();
        return playerPosition
                == winningPosition; // A player wins if it exactly reaches the position 100 and the game ends there.
    }

    private boolean isGameCompleted(Game game)
    {
        // Can use shouldGameContinueTillLastPlayer to change the logic of determining if game is completed (Optional requirements)
        int currentNumberOfPlayers = players.size();

        return currentNumberOfPlayers < game.getPlayers().size();
    }

    private int getTotalValueAfterDiceRolls()
    {
        // Can use noOfDices and setShouldAllowMultipleDiceRollOnSix here to get total value (Optional requirements)
        int totalDiceValue = 0;

        Dice dice = new Dice();

        for (int i = 0; i < dice.getNoOfDice(); i++)
        {

            totalDiceValue = totalDiceValue + diceService.roll();

        }
        return totalDiceValue;
    }
}

