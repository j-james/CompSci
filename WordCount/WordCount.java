// This program counts the total number of lines, words and characters (not
// including whitespace) and average word length in a given text file.

import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("This program reports statistics about a file.");
        System.out.println();

        Scanner console = new Scanner(System.in);
        System.out.print("What file do you want me to examine? ");
        String fileName = console.nextLine();

        Scanner infile = new Scanner(new File(fileName));
        examineFile(infile);
        console.close();
    }

    public static void examineFile(Scanner infile) {
        int lines = 0;
        int words = 0;
        int chars = 0;
        while (infile.hasNextLine()) {
            String line = infile.nextLine();
            lines++;
            Scanner data = new Scanner(line);
            while (data.hasNext()) {
                String word = data.next();
                words++;
                chars += word.length();
            }
        }
        System.out.println("Total lines = " + lines);
        System.out.println("Total words = " + words);
        System.out.println("Total chars = " + chars);
        System.out.println("Word length = " + (double) chars / words);
    }
}