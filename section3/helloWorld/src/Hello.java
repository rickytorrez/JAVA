public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello Udemy!");

        int myFirstNumber = (10 + 5) + (2 * 10);
        int mySecondNumber = 12;
        int myThirdNumber = myFirstNumber * 2;

        int myTotal = myFirstNumber + mySecondNumber + myThirdNumber;

        // Challenge //
        // Create a variable of 1000 and substract myTotal, print the result //

        // int aGrand = 1000;
        // int newTotal = aGrand - myTotal;

        int newTotal = 1000 - myTotal;

        System.out.println(myTotal);
        System.out.println(newTotal);
    }
}

