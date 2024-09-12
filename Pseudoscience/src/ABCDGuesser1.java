import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Put a short phrase describing the program here. Uses deJager formula through
 * inputs from the user.
 *
 * @author Kyle Park
 *
 */

public final class ABCDGuesser1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser1() {
    }

    /**
     * Magic number for the number of exponents to iterate through.
     */

    private static final int NUMBEROFEXPONENTS = 17;

    /**
     * Magic number for the error that double numbers have.
     */

    private static final double DOUBLEERROR = 0.0001;

    /**
     * Error bound for the deJager formula.
     */

    private static final double JAGERERROR = 0.01;

    /**
     * Magic number for number of numbers that were inputted.
     */

    private static final int NUMBEROFINPUTS = 4;

    /**
     * Magic number for the position that said value is in an array.
     */

    private static final int POSITION = 3;

    /**
     *  * Repeatedly asks the user for a positive real number until the user
     * enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *              the output stream  *
     * @return a positive real number entered by the user  
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {

        //Initialize values

        String input;
        double output;

        //Prompt user to input a positive double value

        out.print("Enter a positive double value to calculate using deJager: ");
        input = in.nextLine();

        //Continue to ask user to input a positive value

        while (Double.parseDouble(input) <= 0
                || !FormatChecker.canParseDouble(input)) {
            out.print(
                    "Invalid. Enter a positive double value to calculate using "
                            + "deJager: ");
            input = in.nextLine();
        }
        output = Double.parseDouble(input);
        return output;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {

        //Initialize values

        String input;
        double output;

        //Prompt user to enter a value that isn't 1

        out.print("Enter a positive double value that isn't 1: ");
        input = in.nextLine();

        //Continue to ask user if input is 1 or negative

        while (Double.parseDouble(input) - 1.0 <= DOUBLEERROR
                || !FormatChecker.canParseDouble(input)
                || Double.parseDouble(input) <= 0) {
            out.print("Invalid. Enter a positive double value that isn't 1: ");
            input = in.nextLine();
        }
        output = Double.parseDouble(input);
        return output;
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

        //Initialize arrays

        final double[] exponents = { -5.0, -4.0, -3.0, -2.0, -1.0, -1 / 2.0,
                -1 / 3.0, -1 / 4.0, 0.0, 1 / 2.0, 1 / 3.0, 1 / 4.0, 1.0, 2.0,
                3.0, 4.0, 5.0 };
        double[] input = { 0, 0, 0, 0 };
        int[] exponent = { 0, 0, 0, 0 };

        //Initialize input and guesses

        double mu;
        double guess = 1;

        //Initialize errors
        double error;
        double lowestError = 1;

        //Initialize whileloop values

        int whileLoop1 = 0, whileLoop2 = 0, whileLoop3 = 0, whileLoop4 = 0;

        //Get user input to calculate around

        mu = getPositiveDouble(in, out);

        //Get 4 user inputs for deJager

        int i = 0;

        while (i < NUMBEROFINPUTS) {
            input[i] = getPositiveDoubleNotOne(in, out);
            i++;
        }

        //Iterate throughout all 17 exponents for each of the 4 inputs given

        while (whileLoop1 < NUMBEROFEXPONENTS) {
            while (whileLoop2 < NUMBEROFEXPONENTS) {
                while (whileLoop3 < NUMBEROFEXPONENTS) {
                    while (whileLoop4 < NUMBEROFEXPONENTS) {
                        guess = Math.pow(input[0], exponents[whileLoop1])
                                * Math.pow(input[1], exponents[whileLoop2])
                                * Math.pow(input[2], exponents[whileLoop3])
                                * Math.pow(input[POSITION],
                                        exponents[whileLoop4]);

                        //Find error bound

                        error = Math.abs(guess - mu) / mu;

                        //Find lowest error

                        if (error < JAGERERROR) {
                            if (error < lowestError) {
                                exponent[0] = whileLoop1;
                                exponent[1] = whileLoop2;
                                exponent[2] = whileLoop3;
                                exponent[POSITION] = whileLoop4;
                                lowestError = error;
                            }
                        }
                        whileLoop4++;
                    }
                    whileLoop4 = 0;
                    whileLoop3++;
                }
                whileLoop3 = 0;
                whileLoop2++;
            }
            whileLoop2 = 0;
            whileLoop1++;
        }

        //Print out exponents that are best accurate

        int j = 0;

        while (j < NUMBEROFINPUTS) {
            out.println("Exponent value for " + input[j] + "is "
                    + exponents[exponent[j]]);
            j++;

        }

        //Print out errors and calculations

        out.println("Error value is " + lowestError);

        double calculatedValue = Math.pow(input[0], exponents[exponent[0]])
                * Math.pow(input[1], exponents[exponent[1]])
                * Math.pow(input[2], exponents[exponent[2]])
                * Math.pow(input[POSITION], exponents[exponent[POSITION]]);

        out.println("Calculated value using deJager is " + calculatedValue);

        //Close

        in.close();
        out.close();

    }

}