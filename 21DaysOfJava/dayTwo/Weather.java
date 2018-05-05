public class Weather {
    public static void main(String[] arguments){
        float fah = 86;
        System.out.println(fah + " degrees Fahrenheit is ...");
        
        // To convert Fahrenheit into Celsius
        // begin by substracting 32

        fah = fah - 32;

        // Divide the answer by 9
        fah = fah / 9;

        // Multiply that answer by 5
        fah = fah * 5;
        
        System.out.println(fah + " degrees Celsius\n");

        float cel = 33;

            System.out.println(cel + " degreees Celsius is ... ");

        // To convert Celsius to Fahrenheit
        // Begin by multiplying by 9

        cel = cel * 9;

        // Divide the answer by 5

        cel = cel / 5;

        cel = cel + 32;

        System.out.println(cel + " degrees Fahrenheit. ");
    }
}