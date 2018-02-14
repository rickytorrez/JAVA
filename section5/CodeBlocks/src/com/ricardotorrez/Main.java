package com.ricardotorrez;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted =5;
        int bonus = 100;

//        if(score < 5000 && score > 1000) {
//            System.out.println("Your score was less than 5000 but greater than 1000");
//        } else if (score < 1000){
//            System.out.println("Your score was less than 1000");
//        } else {
//            System.out.println("Got here");
//        }

        if(gameOver){                                                   //same as if(gameOver == true)
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score was " + finalScore);
        }

        // Challenge //

//        // 1
//        int secondScore = 10000;
//
//        // 2
//        int levelComp = 8;
//
//        // 3
//        int xtraBonus = 200;
//
//        // 4
//        if(gameOver){
//            int finScore = secondScore + (levelComp * xtraBonus);
//            System.out.println("Your second final score is " + finScore);
//        }

        // Better Way
        // Do not recall the types of variables, just change their values. This process saves memory management for the server
        // Uses memory more efficiently

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        if(gameOver){                                                   //same as if(gameOver == true)
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }


    }
}
