package models;

import constants.SnlConstants;

public class Dice
{

    int faces;

    int noOfDice;

    public Dice()
    {
        noOfDice = SnlConstants.NO_OF_DICES;
        faces = SnlConstants.NO_OF_FACES + 1;
    }

    public int getFaces()
    {
        return faces;
    }

    public void setFaces(int faces)
    {
        this.faces = faces;
    }

    public int getNoOfDice()
    {
        return noOfDice;
    }

    public void setNoOfDice(int noOfDice)
    {
        this.noOfDice = noOfDice;
    }
}