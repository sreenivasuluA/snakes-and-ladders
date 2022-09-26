package services;

import java.util.Random;

import models.Dice;

public class DiceService
{

    Dice dice = new Dice();

    public int roll()
    {
        return new Random().nextInt(
                dice.getFaces()); // The game will have a 3 sided dice numbered from 0 to 3 and will always give a random number on rolling it.
    }
}
