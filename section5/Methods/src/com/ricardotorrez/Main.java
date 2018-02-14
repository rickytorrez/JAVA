package com.ricardotorrez;

public class Main {

    public static void main(String[] args) {

        int highScore = calculateScore(true, 800, 5, 100);
        System.out.println("Your final score was " + highScore);

        calculateScore(true, 10000, 8, 200);

    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        if(gameOver){                                                   //same as if(gameOver == true)
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;System.out.println("Your final score was " + finalScore);
            return finalScore;

        } else {
            return -1;
        }

    }
}
