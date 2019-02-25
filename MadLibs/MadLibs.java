
// CSE 142 Homework 6 (Mad Libs) solution
// Author: Marty Stepp
//
// This program allows the user to play a game of Mad Libs, where the user
// fills in placeholders from an input file to create a funny output story.
// DO NOT DISTRIBUTE!

import java.io.*; // for File
import java.util.*; // for Scanner

public class MadLibs {
    public static void main(String[] args) throws FileNotFoundException {
        intro();

        // overall loop for text UI menu system
        Scanner console = new Scanner(System.in);
        String choice;
        do {
            System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
            choice = console.nextLine();
            if (choice.equalsIgnoreCase("C")) {
                // create a new mad-lib
                Scanner input = getInput(console);
                PrintStream output = getOutput(console);
                System.out.println();
                createMadLib(console, input, output);
                System.out.println("Your mad-lib has been created!\n");
            } else if (choice.equalsIgnoreCase("V")) {
                // view an existing mad-lib
                Scanner input = getInput(console);
                System.out.println();
                while (input.hasNextLine()) {
                    System.out.println(input.nextLine());
                }
                System.out.println();
            }
        } while (!choice.equalsIgnoreCase("Q"));

        System.out.println();
    }

    // Introduces the Mad Libs program.
    public static void intro() {
        System.out.println("Welcome to the game of Mad Libs.");
        System.out.println("I will ask you to provide various words");
        System.out.println("and phrases to fill in a story.");
        System.out.println("The result will be written to an output file.");
        System.out.println();
    }

    // Repeatedly prompts for input file name until file exists; returns Scanner.
    public static Scanner getInput(Scanner console) throws FileNotFoundException {
        System.out.print("Input file name: ");
        File file = new File(console.nextLine());
        while (!file.exists()) {
            System.out.print("File not found. Try again: ");
            file = new File(console.nextLine());
        }

        Scanner input = new Scanner(file);
        return input;
    }

    // Prompts for an output file name; returns PrintStream to write to file.
    public static PrintStream getOutput(Scanner console) throws FileNotFoundException {
        System.out.print("Output file name: ");
        String outFileName = console.nextLine();
        PrintStream output = new PrintStream(outFileName);
        return output;
    }

    // Reads a mad lib story from the given input file and looks for
    // placeholders, prompting the user to enter a substitution for each.
    // Outputs the filled in mad lib story to the given output file.
    public static void createMadLib(Scanner console, Scanner input, PrintStream output) {
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            while (lineScan.hasNext()) {
                String word = lineScan.next();
                if (word.startsWith("<") && word.endsWith(">")) {
                    word = word.substring(1, word.length() - 1);
                    word = word.replace("-", " ");
                    if (startsWithVowel(word)) {
                        System.out.print("Please type an " + word + ": ");
                    } else {
                        System.out.print("Please type a " + word + ": ");
                    }
                    String replacement = console.nextLine();
                    output.print(replacement + " ");
                } else {
                    output.print(word + " ");
                }
            }
            output.println();
            lineScan.close();
        }
    }

    // Returns true if the given string begins with a vowel, case-insensitive.
    public static boolean startsWithVowel(String s) {
        s = s.toLowerCase();
        return s.startsWith("a") || s.startsWith("e") || s.startsWith("i") || s.startsWith("o") || s.startsWith("u");
    }
}