// This program reads an input file that contains sequences of integers to
// be added together.  The program reads them as Strings so that it can
// process large integers.  Reset the constant DIGITS to allow it to handle
// larger integers.

import java.io.*;
import java.util.*;

public class Sum {
    public static final int DIGITS = 25;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("sum.txt"));
        processFile(input);
    }

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

    public static void processLine(Scanner data) {
        int[] result = new int[DIGITS];
        String next = data.next();
        transfer(next, result);
        System.out.print(next);
        while (data.hasNext()) {
            next = data.next();
            int[] number = new int[DIGITS];
            transfer(next, number);
            addTo(result, number);
            System.out.print(" + " + next);
        }
        System.out.print(" = ");
        print(result);
        System.out.println();
    }

    public static void transfer(String data, int[] digits) {
        int i = data.length() - 1;
        int j = DIGITS - 1;
        while (i >= 0) {
            digits[j] = Character.getNumericValue(data.charAt(i));
            i--;
            j--;
        }
    }

    public static void addTo(int[] sum, int[] number) {
        int carry = 0;
        for (int i = DIGITS - 1; i >= 0; i--) {
            int next = sum[i] + number[i] + carry;
            sum[i] = next % 10;
            carry = next / 10;
        }
        if (carry > 0)
            throw new RuntimeException("overflow");
    }

    public static void print(int[] digits) {
        int start = 0;
        while (start < DIGITS - 1 && digits[start] == 0)
            start++;
        for (int i = start; i < DIGITS; i++)
            System.out.print(digits[i]);
    }
}
