package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Board;
import models.Game;
import models.Ladder;
import models.Player;
import models.Snake;
import services.GameService;

class SnakesAndLaddersApplicationTests
{

    public static void main(String[] args)
    {

        Map<String, Integer> playerPieces = new HashMap<>();

        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(71, 15));

        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(12, 34));

        List<Player> players = new ArrayList<>();
        Player player1 = new Player("Sreeni");
        Player player2 = new Player("Arora");
        players.add(player1);
        players.add(player2);

        playerPieces.put(player1.getId(), 0);
        playerPieces.put(player2.getId(), 0);

        Board board = Board.getBuilder().setPlayerPieces(playerPieces).setSnakes(snakes).setLadders(ladders).build();
        GameService gameService = new GameService();
        Game game = gameService.createGame(board, players);
        gameService.startGame(game);
    }

}
