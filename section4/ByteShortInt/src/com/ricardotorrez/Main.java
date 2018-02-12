package com.ricardotorrez;

public class Main {

    public static void main(String[] args) {

        // long has a width of 64
        long myLongValueMin = -9_223_372_036_854_775_808L;
        long myLongValueMax = 9_223_372_036_854_775_807L;

        // int has a width of 32
        int myMinValue = -2_147_483_648;
        int myMaxValue = 2_147_483_647;
        int myTotal = (myMinValue/2);

        // short has a width of 16
        short myShortValueMin = -32768;
        short myShortValueMax = 32767;
        short myNewShort = (short) (myShortValueMin / 2); //casting

        // byte has a width of 8
        byte myByteValueMin = -128;
        byte myByteValueMax = 127;
        byte myNewByte = (byte )(myByteValueMin/2); // casting

        // casting tells Java to treat the int 2 as a byte for the math function

//        System.out.println(myTotal);
//        System.out.println(myNewByte);

        // Challenge //
        // 1 //
        byte newByte = 12;

        // 2 //
        short myShort = 1234;

        // 3 //
        int myInt = 1234567;

        // 4 //
        long myLong = 50000 + 10 * (newByte +  + myShort + myInt);
        short shortTotal = (short) (1000 + 10 * (newByte +  + myShort + myInt));
        System.out.println("longTotal = " + myLong);
        System.out.println("shortTotal = " + shortTotal);



    }
}
