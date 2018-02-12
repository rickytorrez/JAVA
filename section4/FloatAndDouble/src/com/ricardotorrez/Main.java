package com.ricardotorrez;

public class Main {

    public static void main(String[] args) {
        // width of int = 32 (4 bytes)
        int myIntValue = 5 / 3;
        // width of float = 32 (4 bytes)
        float myFloatValue = 5f / 3f;       // seven digits of precision
        // width of double = 64 (8 bytes)
        double myDoubleValue = 5d / 3d;     // 16 digits of precision

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("myFloatValue = " + myFloatValue);
        System.out.println("myDoubleValue = " + myDoubleValue);

        // Challenge //
        // 1 //
        double pounds = 100d;

        // 2 //
        double kgInPounds = (pounds * 0.45359237d);

        // 3 //
        System.out.println("Kg = " + kgInPounds);
        // 45.359237


    }
}
