// This program takes a Java program as input and gives the file consistent
// indentation.  Reset the constant INDENT to change the number of spaces of
// indentation.  Assumes you are using K&R style blocks, as in:
//     while (i < 0) {
//         ...
//     }

import java.io.*;
import java.util.*;

public class PrettyPrint {
    public static final int INDENT = 4;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("This program reformats a Java file to give it");
        System.out.println("proper indentation.");
        System.out.println();

        Scanner console = new Scanner(System.in);
        System.out.print("What is the name of the Java file? ");
        String infileName = console.nextLine();
        System.out.print("Where should I send output (must be different)? ");
        String outfileName = console.nextLine();

        Scanner input = new Scanner(new File(infileName));
        PrintStream output = new PrintStream(new File(outfileName));
        echoPretty(input, output);
        console.close();
    }

    public static void echoPretty(Scanner input, PrintStream output) {
        int indent = 0;
        while (input.hasNextLine()) {
            String str = input.nextLine();
            if (str.length() > 0 && str.charAt(str.length() - 1) == '}') {
                indent--;
            }
            for (int i = 1; i <= indent * INDENT; i++) {
                output.print(" ");
            }
            // find first non-whitespace character in string
            int i = 0;
            while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
                i++;
            }
            output.println(str.substring(i));
            if (str.length() > 0 && str.charAt(str.length() - 1) == '{') {
                indent++;
            }
        }
    }
}