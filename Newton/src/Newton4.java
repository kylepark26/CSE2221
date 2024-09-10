import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Compute roots using Newton Iteration, works while x = 0, asks for epsilon
 * value, and asks user for number until number entered is negative
 *
 * @author Kyle Park
 *
 */
public final class Newton4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x, double epsilon) {
        double r = x;
        while ((Math.abs(r * r - x) / x) > (epsilon * epsilon)) {
            r = (r + (x / r)) / 2;
        }
        return r;
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

        while (true) {
            out.println("Enter a number: ");
            int x = Integer.valueOf(in.nextLine());
            if (x >= 0) {
                out.println("Enter an epsilon value: ");
                double epsilon = Double.valueOf(in.nextLine());
                out.println(sqrt(x, epsilon));
            } else {
                break;
            }
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
