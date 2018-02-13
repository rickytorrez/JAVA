package com.ricardotorrez;

public class Main {

    public static void main(String[] args) {
	    char myChar = 'D';
	    // Stores only one character or number
        // width of 16
        // 2 bytes
        char mySym = '\u00A9';
        System.out.println("Copyright symbol = " + mySym);

        boolean myBoolean = true;
        // true or false

        // Challenge //

        // 1
        // U+00AE

        // 2
        char myReg = '\u00AE';

        // 3
        System.out.println("Registered symbol = " + myReg);
    }
}
