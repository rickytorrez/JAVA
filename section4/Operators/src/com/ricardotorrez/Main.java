package com.ricardotorrez;

public class Main {

    public static void main(String[] args) {
        int result = 1 + 2;
        System.out.println("1 + 2 = " + result);

        int previousResult = result;

        result = result - 1;
        System.out.println(previousResult + " - 1 = " + result);

        previousResult = result;
        result = result * 10;
        System.out.println(previousResult + " * 10 = " + result);

        previousResult = result;
        result = result / 5;
        System.out.println(previousResult + " / 5 = " + result);

        previousResult = result;
        result = result % 3;
        System.out.println(previousResult + " % 3 = " + result); // what is leftover after an operation

        previousResult = result;
        result = result + 1;
        System.out.println("result is now " + result);
        result++;
        System.out.println("result is now " + result);
        result--;
        System.out.println("result is now " + result);
        result+=2;
        System.out.println("result is now " + result);
        result*=10;
        System.out.println("result is now " + result);
        result-=10;
        System.out.println("result is now " + result);
        result/=10;
        System.out.println("result is now " + result);

        boolean isAlien = false; // Assignment
        if (isAlien == true)     // Testing to see a value
            System.out.println("It's not an alien!");

        int topScore = 80;
        if (topScore <= 100)
            System.out.println("You got the high score");

        int secondTopScore = 81;
        if ((topScore > secondTopScore) && (topScore < 100));
            System.out.println("Greater than second top score and less than 100");

        if ((topScore > 90) || (secondTopScore <= 90))
            System.out.println("One of these tests is true");

        int newValue = 50;
        if(newValue == 50);
            System.out.println("This is true");


        boolean isCar = false;
        if (isCar == true)
            System.out.println("This is not supposed to happen");

        isCar = true;
        boolean wasCar = isCar ? true : false;
        if (wasCar)
            System.out.println("wasCar is true");

        // Challenge //

        // 1 //
        double myFirstDouble = 20d;

        // 2 //
        double mySecondDouble = 80d;

        // 3 //
        double myThirdDouble = (myFirstDouble + mySecondDouble) * 25;
        System.out.println("My Total is " + myThirdDouble);

        // 4 //
        double myRemainderDouble = myThirdDouble % 40;
        System.out.println("The remainder is " + myRemainderDouble);

        // 5 //
        if (myRemainderDouble <= 20)
            System.out.println("Total was over the limit");


    }
}
