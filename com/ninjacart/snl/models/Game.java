package models;

import java.util.Collections;
import java.util.List;

import constants.SnlConstants;

public class Game
{

    private Board board;

    private List<Player> players;

    public Board getBoard()
    {
        return board;
    }

    public List<Player> getPlayers()
    {
        return Collections.unmodifiableList(players);
    }

    public static Builder getBuilder()
    {

        return new Builder();
    }

    public static class Builder
    {

        private Game game;

        Builder()
        {

            this.game = new Game();
        }

        private boolean validate()
        {
            List<Player> players = game.getPlayers();
            if (players.size() > SnlConstants.MAX_PERSONS_ALLOWED)
            {
                return false;
            }
            return true;
        }

        public Builder setBoard(Board board)
        {
            game.board = board;
            return this;
        }

        public Builder setPlayers(List<Player> players)
        {
            game.players = players;
            return this;
        }

        public Game build()
        {

            boolean isValid = validate();
            if (!isValid)
            {
                throw new RuntimeException("Game is not valid");
            }

            return this.game;
        }

    }

}
