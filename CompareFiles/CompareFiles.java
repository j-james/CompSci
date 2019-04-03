// This program compares two files to find lines that differ.

import java.io.*;
import java.util.*;

public class CompareFiles {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("This program compares two files for differences.");
        System.out.println();

        Scanner console = new Scanner(System.in);
        System.out.print("Enter a first file name: ");
        String name1 = console.nextLine();
        System.out.print("Enter a second file name: ");
        String name2 = console.nextLine();
        System.out.println();

        Scanner infile1 = new Scanner(new File(name1));
        Scanner infile2 = new Scanner(new File(name2));
        compareFiles(infile1, infile2);
        console.close();
    }

    public static void compareFiles(Scanner infile1, Scanner infile2) {
        boolean different = false;
        int line = 0;
        while (infile1.hasNextLine() || infile2.hasNextLine()) {
            String line1 = readFrom(infile1);
            String line2 = readFrom(infile2);
            line++;
            if (!line1.equals(line2)) {
                if (!different) {
                    System.out.println("Differences found:");
                    different = true;
                }
                System.out.println("Line " + line + ":");
                printLine("<", line1);
                printLine(">", line2);
                System.out.println();
            }
        }
        if (!different) {
            System.out.println("No differences found.");
        }
    }

    // reads and returns a line of text from the given infile if possible;
    // returns null if no such line exists
    public static String readFrom(Scanner infile) {
        if (infile.hasNextLine()) {
            return infile.nextLine();
        } else {
            return null;
        }
    }

    // prints the given line or prints end-of-file message if line is null
    public static void printLine(String prefix, String line) {
        System.out.print(prefix + " ");
        if (line == null) {
            System.out.println("no such line (end-of-file)");
        } else {
            System.out.println(line);
        }
    }
}