public class InvestmentCalculator {
    public static void main(String[] arguments){
        double inv = 14000;
        double invTwo;
        System.out.println("How much will $" + inv + " be worth if it increased in value by 40% in it's first year...");

        // Multipy inv by 40%
        invTwo = inv * .40;

        // // Add the 40% to the total
        inv = inv + invTwo;

        System.out.println((int) inv);

        System.out.println("If " + inv + " lost $1500 in value the second year the total would be...");

        inv -= 1500;

        System.out.println(inv);

    }
}