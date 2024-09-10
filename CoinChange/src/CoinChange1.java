import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Coin change
 *
 * @author Kyle Park
 *
 */
public final class CoinChange1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CoinChange1() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here
         */

        out.println("Enter any amount of cents: ");
        int money = Integer.valueOf(in.nextLine());

        int dollar = 100;
        int halfDollar = 50;
        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int penny = 1;

        out.println((money / dollar) + " dollar coins");
        money = money % dollar;

        out.println((money / halfDollar) + " half dollar coins");
        money = money % halfDollar;

        out.println((money / quarter) + " quarters");
        money = money % quarter;

        out.println((money / dime) + " dimes");
        money = money % dime;

        out.println((money / nickel) + " nickels");
        money = money % nickel;

        out.println((money) + " pennies");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
