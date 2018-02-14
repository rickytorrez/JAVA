package com.ricardotorrez;

public class Main {

    public static void main(String[] args) {
	    int myVariable = 50;
	    if (myVariable == 50) {
            System.out.println("Printed");
        }

	    myVariable++;
	    myVariable--;
        System.out.println("This is a test");   //Method call

        System.out.println("This is" + " another " +  "statement");

        int anotherVariable = 50; myVariable--; System.out.println("This is still valid");

    }
}
