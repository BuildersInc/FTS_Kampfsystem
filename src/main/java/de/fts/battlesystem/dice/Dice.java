package de.fts.battlesystem.dice;

import java.util.Random;

public class Dice {
    private final int minValue = 1;
    private final int maxValue;
    private final int amount;

    public Dice(int maxValue, int amount) {
        this.maxValue = maxValue;
        this.amount = amount;
    }

    public int makeDiceThrow() {
        int points = 0;
        for (int i = 0; i < amount; i++) {
            points += new Random().nextInt((maxValue - minValue) + 1) + minValue;
        }
        return points;
    }
}
