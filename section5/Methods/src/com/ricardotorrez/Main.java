package com.ricardotorrez;

public class Main {

    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 800;
        int levelCompleted= 5;
        int bonus= 100;

        int highScore = calculateScore(gameOver, score, levelCompleted, bonus);             // Expecting four paramaters from what is being passed in line 23
        System.out.println("Your final score was " + highScore);

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score was " + highScore);


        int highScorePosition = calculateHighScorePosition(1500);
        displayHighScorePosition("Tim", highScorePosition);

        highScorePosition = calculateHighScorePosition(900);
        displayHighScorePosition("Bob", highScorePosition);

        highScorePosition = calculateHighScorePosition(400);
        displayHighScorePosition("Percy", highScorePosition);

        highScorePosition = calculateHighScorePosition(50);
        displayHighScorePosition("Gilbert", highScorePosition);

        highScorePosition = calculateHighScorePosition(1000);
        displayHighScorePosition("Louise", highScorePosition);


        // Create a method called displayHighScorePosition
        // It should display a players name as a parameter, and a 2nd paramater as a position in the high score table
        // You should display the players name along with a message lie "managed to get into position " and the
        // position they got and a further message " on the high score table "

    }

    public static void displayHighScorePosition(String playerName, int highScorePosition) {
        System.out.println(playerName + " managed to get into position " + highScorePosition + " on the high score table.");

    }

    // Create a 2nd method called calculateHighScorePosition
    // It should be sent one argument only, the player score
    // It should return an int
    // The return data should be
    // 1 if the score is >1000
    // 2 if the score is >500 and <1000
    // 3 if the score is >100 and <500
    // 4 in all other cases
    // call both methods and display the results of the following
    // a score of 1500, 900. 400 and 50

    public static int calculateHighScorePosition( int playerScore ) {
        if(playerScore >= 1000) {
            return 1;
        } else if (playerScore >= 500 && playerScore < 1000){
            return 2;
        } else if (playerScore >= 100 && playerScore < 500){
            return 3;
        } else {
            return 4;
        }
    }


    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {  // return an int instead of a void
                                                                                                    // to be able to return data to another
        if(gameOver){                                                                               // method
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            return finalScore;
        } else {
            return -1;
        }


    }












}
