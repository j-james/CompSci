/*
 * Tic Tac Toe
 *
 * I've got some bugs that I haven't been able to fix.
 * I'm turning it in now because of the midnight deadline.
 * Over the weekend, I'm going to figure out the last couple and fix them.
 * I did fix the Scanner bug! Thanks a lot for the hint on that one.
 *
 * Bug(s):
 * For some reason, my drawBoard method isn't drawing. Which is weird, it was working before.
 * I know that the compInput part is bugged, but I can't test it until I fix the drawBoard bug.
 *
 * Features:
 * Pick X or O!
 * Asks if you want to play again, + keeps your win / loss record!
 * Checks if your move is legal!
 *
 * I've been working on this for hours over the past couple of days.
 * Even though I'm turning it in now, I'm still going to work on it over the weekend.
 *
 */

import java.util.*;

public class TicTacToe {

    public static void main(String[] args) {
        // declare variables
        boolean intro = true; // later I'll ask if the user wants to play again
        boolean game = true; // keeps the game running until someone wins
        int wins = 0;
        int ties = 0;
        int losses = 0;
        int input = 0;
        String playerMoves;
        String computerMoves;
        String playerX;
        String computerX;
        String xoAnswer;
        Scanner scan = new Scanner(System.in);
        while (intro) {
            // assign values to variables
            computerMoves = "0";
            playerMoves = "0";
            playerX = "x";
            computerX = "x";
            System.out.println("TicTacToe\n");
            System.out.println("_|_|_     1|2|3");
            System.out.println("_|_|_     4|5|6");
            System.out.println(" | |      7|8|9");
            System.out.println("To place a piece, enter in the box number.");

            // ask the player if they want to be Xs or Os
            System.out.println("\nPick Xs or Os.");
            xoAnswer = scan.next();

            // tell the user which one they picked - if not X/x/O/o, defaults to o
            if (xoAnswer.equals("x") || xoAnswer.equals("X")) {
                System.out.println("\nYou picked X.");
                playerX = "x";
                computerX = "o";
            } else {
                System.out.println("\nYou picked O.");
                playerX = "o";
                computerX = "x";
            }
            while (game) { // game loop

                // ask the user's input
                System.out.println("\nEnter in a position:");
                // check if that input works
                while (!scan.hasNextInt()) {
                    scan.next(); // to discard the input
                    System.out.println("Not a valid input, try again");
                    System.out.println("Enter in a position:");
                }
                input = scan.nextInt();

                // is your move legal?
                if ((input < 10 && input > 0) && !(index(playerMoves, input) && index(computerMoves, input))) {
                    // adds the input to the end of the list
                    playerMoves += input;

                    // print the board
                    drawBoard(playerMoves, computerMoves, playerX, computerX);

                } else {
                    System.out.println("Your move is not legal! Skipping turn.");
                }

                // check if anyone's won
                if (won(playerMoves, computerMoves) == 1) { // checks for wins
                    wins++;
                    game = false;
                }
                if (won(playerMoves, computerMoves) == 2) { // checks for ties
                    ties++;
                    game = false;
                }

                if (game) { // if the player just won, it will skip and exit
                    // computer's turn (random choice that works)

                    // adds the computer's move to the end of the move list
                    computerMoves += compInput(playerMoves, computerMoves);

                    // print the board
                    drawBoard(playerMoves, computerMoves, playerX, computerX);
                    // }
                    // check if anyone's won
                    if (won(computerMoves, playerMoves) == 1) { // checks for losses
                        losses++;
                        game = false;
                    }
                    if (won(computerMoves, playerMoves) == 2) { // checks for ties
                        ties++;
                        game = false;
                    }
                }
            }

            // print the scoreboard here
            System.out.println("Player: " + wins + " wins");
            System.out.println("Computer: " + losses + " wins");
            System.out.println("Ties: " + ties + " ties");

            // asks the player if they want to play again
            System.out.println("Play again? true/false");
            while (!scan.hasNextBoolean()) {
                scan.next();
                System.out.println("Not a valid input, try again");
                System.out.println("Play again? true/false");
            }
            intro = scan.nextBoolean();
        }
        scan.close();
    }

    // draws the board
    public static void drawBoard(String playerMoves, String computerMoves, String playerX, String computerX) {
        for (int i = 1; i <= 9; i++) {
            if (index(playerMoves, i)) {
                System.out.print(playerX);
            } else if (index(computerMoves, i)) {
                System.out.print(computerX);
            } else {
                if (i < 7) {
                    System.out.print("_");
                } else {
                    System.out.print(" ");
                }
            }
            if (i % 3 != 0) {
                System.out.print("|");
            } else {
                System.out.println();
            }
        }
    }

    // should pick a random int, check if it's legal, if not pick a new random int and repeat
    public static int compInput(String playerMoves, String computerMoves) { // @TODO has problems
        int randomNumber;
        while (true) {
            Random rand = new Random();
            randomNumber = rand.nextInt(3) + 1;
            if (index(playerMoves, randomNumber) && index(computerMoves, randomNumber)) {
                return randomNumber;
            }
        }
    }

    // checks if a user has won or if the board is full
    public static int won(String playerMoves, String computerMoves) { // playerMoves are computerMoves sometimes
        String moves = playerMoves + computerMoves;
        int count = 0;

        if ((index(playerMoves, 1) && index(playerMoves, 2) && index(playerMoves, 3))
                || (index(playerMoves, 4) && index(playerMoves, 5) && index(playerMoves, 6))
                || (index(playerMoves, 7) && index(playerMoves, 8) && index(playerMoves, 9))
                || (index(playerMoves, 1) && index(playerMoves, 4) && index(playerMoves, 7))
                || (index(playerMoves, 2) && index(playerMoves, 5) && index(playerMoves, 8))
                || (index(playerMoves, 3) && index(playerMoves, 6) && index(playerMoves, 9))
                || (index(playerMoves, 1) && index(playerMoves, 5) && index(playerMoves, 9))
                || (index(playerMoves, 7) && index(playerMoves, 5) && index(playerMoves, 3))) { // checks every possible winning combination (only 8)
            return 1; // this user has won!
        } else {

            for (int i = 1; i <= 9; i++) {
                if (index(moves, i)) {
                    count++;
                }
            }
            if (count >= 9) {
                return 2; // board is full
            }
            return 3; // no winners yet
        }

    }

    // checks if a string contains a character
    public static boolean index(String str, int pos) {
        if (str.indexOf(pos) != -1) {
            return true;
        } else {
            return false;
        }
    }
}