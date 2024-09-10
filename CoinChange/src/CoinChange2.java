import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Coin change, but with arrays
 *
 * @author Kyle Park
 *
 */
public final class CoinChange2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CoinChange2() {
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

        int[] coinAmount = { 100, 50, 25, 10, 5 };
        int[] coinCount = new int[6];

        out.println("Enter any amount of cents: ");
        int money = Integer.valueOf(in.nextLine());

        coinCount[0] = money / coinAmount[0];
        money = money % coinAmount[0];

        coinCount[1] = money / coinAmount[1];
        money = money % coinAmount[1];

        coinCount[2] = money / coinAmount[2];
        money = money % coinAmount[2];

        coinCount[3] = money / coinAmount[3];
        money = money % coinAmount[3];

        coinCount[4] = money / coinAmount[4];
        money = money % coinAmount[4];

        coinCount[5] = money;

        out.println(
                "The following is the amount of coins returned, in dollar, half dollar, quarter, dime, nickel, and pennies");

        for (int i = 0; i < coinCount.length; i++) {
            out.print(coinCount[i] + " ");
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
