import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Checks if password input is valid
 *
 * @author Kyle Park
 *
 */
public final class CheckPassword {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CheckPassword() {
    }

    /**
     * Checks whether the given String satisfies the OSU criteria for a valid
     * password. Prints an appropriate message to the given output stream.
     *
     * @param passwordCandidate
     *            the String to check
     * @param out
     *            the output stream
     */
    private static void checkPassword(String passwordCandidate, SimpleWriter out) {
        boolean upperCase = containsUpperCaseLetter(passwordCandidate);
        boolean lowerCase = containsLowerCaseLetter(passwordCandidate);
        boolean digit = containsDigit(passwordCandidate);

        if (passwordCandidate.length() > 8) {
            out.println("Password is too short.");
        } else if (!upperCase) {
            out.println("Password does not have an uppercase letter.");
        } else if (!lowerCase) {
            out.println("Password does not have a lowercase letter.");
        } else if (!digit) {
            out.println("Password does not have a digit.");
        } else {
            out.println("Valid password!");
        }
    }

    /**
     * Checks if the given String contains an upper case letter.
     *
     * @param str
     *            the String to check
     * @return true if str contains an upper case letter, false otherwise
     */
    private static boolean containsUpperCaseLetter(String str) {
        boolean upperCase = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                upperCase = true;
            }
        }
        return upperCase;
    }

    /**
     * Checks if the given String contains a lower case letter.
     *
     * @param str
     *            the String to check
     * @return true if str contains a lower case letter, false otherwise
     */
    private static boolean containsLowerCaseLetter(String str) {
        boolean lowerCase = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) {
                lowerCase = true;
            }
        }
        return lowerCase;
    }

    /**
     * Checks if the given String contains a digit.
     *
     * @param str
     *            the String to check
     * @return true if str contains a digit, false otherwise
     */
    private static boolean containsDigit(String str) {
        boolean digit = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                digit = true;
            }
        }
        return digit;
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

        out.println("Enter a passord: ");
        String password = in.nextLine();
        checkPassword(password, out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
