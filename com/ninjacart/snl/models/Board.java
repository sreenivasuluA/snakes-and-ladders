package models;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import constants.SnlConstants;

public class Board
{
    private int size;

    private List<Snake> snakes; // The board also contains some snakes and ladders.

    private List<Ladder> ladders;

    private Map<String, Integer> playerPieces;

    public Board()
    {
        this.size = SnlConstants.BOARD_SIZE;
    }

    public int getSize()
    {
        return size;
    }

    public List<Snake> getSnakes()
    {
        return Collections.unmodifiableList(snakes);
    }

    public List<Ladder> getLadders()
    {
        return Collections.unmodifiableList(ladders);
    }

    public Map<String, Integer> getPlayerPieces()
    {
        return playerPieces;
    }

    public static Builder getBuilder()
    {
        return new Builder();
    }

    public static class Builder
    {

        private Board board;

        public Builder()
        {
            this.board = new Board();
        }

        public Builder setSize(int size)
        {
            board.size = size;
            return this;
        }

        public Builder setSnakes(List<Snake> snakes)
        {
            board.snakes = snakes;
            return this;
        }

        public Builder setLadders(List<Ladder> ladders)
        {
            board.ladders = ladders;
            return this;
        }

        public Builder setPlayerPieces(Map<String, Integer> playerPieces)
        {
            board.playerPieces = playerPieces;
            return this;
        }

        public Board build()
        {

            return this.board;
        }

    }

}