import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Hailstone1 {

    /**
     * Even divisor.
     */

    private static final int EVEN_DIVISOR = 2;

    /**
     * Odd divisor.
     */

    private static final int ODD_MULTIPLIER = 3;

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone1() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        int currentNumber = n;
        while (currentNumber != 1) {
            if (currentNumber % 2 == 0) {
                currentNumber = currentNumber / EVEN_DIVISOR;
                out.print(currentNumber + " ");
            } else {
                currentNumber = ODD_MULTIPLIER * currentNumber + 1;
                out.print(currentNumber + " ");
            }

        }

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
         * Put your main program code here; it may call myMethod as shown
         */
        out.print("Enter an integer greater than 0: ");
        int n = in.nextInteger();
        out.print(n + " ");

        generateSeries(n, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
