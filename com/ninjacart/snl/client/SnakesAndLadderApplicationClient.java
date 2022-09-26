package client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import models.Board;
import models.Game;
import models.Ladder;
import models.Player;
import models.Snake;
import services.GameService;

public class SnakesAndLadderApplicationClient
{
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> playerPieces = new HashMap<>();
        List<Player> players = new ArrayList<>();
        List<Snake> snakes = new ArrayList<>();
        List<Ladder> ladders = new ArrayList<>();

        System.out.println("Enter number of players");
        int numberOfPlayers = scanner.nextInt();
        System.out.println("Enter number of snakes");
        int noOfSnakes = scanner.nextInt();
        System.out.println("Enter number of ladders");
        int numLadders = scanner.nextInt();

        for (int i = 0; i < noOfSnakes; i++)
        {
            System.out.println("Enter snake start and end position");
            snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
        }

        for (int i = 0; i < numLadders; i++)
        {
            System.out.println("Enter Ladder start and end position");
            ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
        }

        for (int i = 0; i < numberOfPlayers; i++)
        {
            System.out.println("Enter player name");
            String pName = scanner.next();
            Player player = new Player(pName);
            playerPieces.put(player.getId(), 0);
            players.add(player);
        }

        Board board = Board.getBuilder().setPlayerPieces(playerPieces).setSnakes(snakes).setLadders(ladders).build();
        GameService gameService = new GameService();
        Game game = gameService.createGame(board, players);
        gameService.startGame(game);
    }
}
