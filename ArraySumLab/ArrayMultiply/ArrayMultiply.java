
/* This program reads an input file that contains sequences of integers to be added together.
 * The program reads them as Strings so that it can process large integers.
 * Reset the constant DIGITS to allow it to handle larger integers. (50)
 *
 * Justice James - 7/12/18
 */

import java.io.*;
import java.util.*;

public class ArrayMultiply {
    public static final int DIGITS = 50; // Changed to 50 to accommodate much larger numbers by multiplying

    // Good
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("ArrayMultiply.txt"));
        processFile(input);
    }

    // Good
    public static void processFile(Scanner input) {
        int lines = 0;
        while (input.hasNextLine()) {
            String text = input.nextLine();
            Scanner data = new Scanner(text);
            processLine(data);
            lines++;
        }
        System.out.println();
        System.out.println("Total lines = " + lines);
    }

    // Good
    public static void processLine(Scanner data) {
        int[] result = new int[DIGITS];

        String next = data.next();
        transfer(next, result);
        System.out.print(next);

        while (data.hasNext()) {
            next = data.next();
            int[] number = new int[DIGITS];
            transfer(next, number);
            multiplyBy(result, number);
            System.out.print(" * " + next);

            // debugging code
            /* System.out.print(" ");
            for (int i = 0; i < DIGITS; i++)
                System.out.print(result[i]); */
        }
        System.out.print(" = ");
        print(result);
        System.out.println();
    }

    // Good
    public static void transfer(String data, int[] digits) {
        int i = data.length() - 1;
        int j = DIGITS - 1;
        while (i >= 0) {
            digits[j] = Character.getNumericValue(data.charAt(i));
            i--;
            j--;
        }
    }

    // Good!
    public static void multiplyBy(int[] sum, int[] number) {
        int carry = 0;
        int zeroNum; // tracks how many zeros must be put starting at the end of the sum
        int tempSum[] = new int[DIGITS];

        // Iterates through the sum number
        for (int msumPos = DIGITS - 1; msumPos >= 0; msumPos--) {

            // now working!
            zeroNum = Math.abs((DIGITS - 1) - msumPos);

            // carrying doesn't work adding to tempSum - FIXED

            // Iterates through the multiplier number
            for (int mnumPos = DIGITS - 1; (mnumPos - zeroNum) >= 0; mnumPos--) {
                int next = tempSum[mnumPos - zeroNum] + (sum[msumPos] * number[mnumPos]) + carry;
                tempSum[mnumPos - zeroNum] = next % 10;
                carry = next / 10;
            }

        }

        // The carry number cannot be larger than 8, because (9*9)+9=89
        if (carry > 8)
            throw new RuntimeException("overflow");

        // Overwrites the old array with tempSum
        for (int i = 0; i < tempSum.length; i++)
            sum[i] = tempSum[i];

    }

    // Good
    public static void print(int[] digits) {
        int start = 0;
        while (start < DIGITS - 1 && digits[start] == 0)
            start++;
        for (int i = start; i < DIGITS; i++)
            System.out.print(digits[i]);
    }
}

/* helpful debugging code
for (int i = 0; i < DIGITS; i++)
    System.out.print(result[i]);
*/