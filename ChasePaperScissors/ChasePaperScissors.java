import java.util.*;

public class ChasePaperScissors {

    public static void main(String[] args) {
        Scanner turns = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        Scanner restart = new Scanner(System.in);
        boolean start = true;
        int userScore = 0;
        int compScore = 0;

        while (start) {

            System.out.println("Welcome to a Java Program for the Rock, Paper, Scissors Game.");
            System.out.println("\nTo throw rock, press \"R\" key");
            System.out.println("To throw paper, press the \"P\" key.");
            System.out.println("To throw scissors, press the \"S\" key.");
            System.out.println("Then press the \"ENTER\" key.");
            System.out.println("****************");
            System.out.println("How many turns would you like to play?");
            int turnsNumber = turns.nextInt();
            if (turnsNumber == 1) {
                System.out.println("\nAlright, you chose " + turnsNumber + " turn.");
            } else if (turnsNumber > 1) {
                System.out.println("\nAlright, you chose " + turnsNumber + " turns.");
            } else {
                System.out.println(
                        "\nOops! The character you inputed is not a positive number. Press \"ENTER\" to restart the game. \n");
                start = false;
                String again = restart.nextLine();
                if (again.equals("find")) {
                    start = true;
                    System.out.println(
                            "\nRestarting Program... \n\n\n\n\n\n\n\n\n\n\n\n***Congratulations, you found an easter egg!***\n");
                } else {
                    start = true;
                    System.out.println("\nRestarting Program... \n\n\n\n\n\n\n\n\n\n\n\n***Program Restarted***\n");
                }
            }

            for (int gameNumber = 1; gameNumber <= turnsNumber; gameNumber++) {
                Random rand = new Random();
                int compThrow = rand.nextInt(3) + 1;
                System.out.println("\n****************\nWhat do you want to throw?");
                String userInput = input.nextLine();
                if (userInput.equals("r") || userInput.equals("R")) {
                    System.out.println("\nYou threw rock!");
                    start = false;
                    if (compThrow == 1) {
                        System.out.println("The computer threw rock!\nYou TIED with the computer!");
                        displayScore(userScore, compScore);
                    } else if (compThrow == 2) {
                        System.out.println("The computer threw paper!\nYou WON against the computer!");
                        userScore++;
                        displayScore(userScore, compScore);
                    } else if (compThrow == 3) {
                        System.out.println("The computer threw scissors!\nYou LOST against the computer!");
                        compScore++;
                        displayScore(userScore, compScore);
                    }
                } else if (userInput.equals("p") || userInput.equals("P")) {
                    System.out.println("\nYou threw paper!");
                    start = false;
                    if (compThrow == 1) {
                        System.out.println("The computer threw rock!\nYou WON against the computer!");
                        userScore++;
                        displayScore(userScore, compScore);
                    } else if (compThrow == 2) {
                        System.out.println("The computer threw paper!\nYou TIED against the computer!");
                        displayScore(userScore, compScore);
                    } else if (compThrow == 3) {
                        System.out.println("The computer threw scissors!\nYou LOST against the computer!");
                        compScore++;
                        displayScore(userScore, compScore);
                    }
                } else if (userInput.equals("s") || userInput.equals("S")) {
                    System.out.println("\nYou threw scissors!");
                    start = false;
                    if (compThrow == 1) {
                        System.out.println("The computer threw rock!\nYou LOST against the computer!");
                        compScore++;
                        displayScore(userScore, compScore);
                    } else if (compThrow == 2) {
                        System.out.println("The computer threw paper!\nYou WON against the computer!");
                        userScore++;
                        displayScore(userScore, compScore);
                    } else if (compThrow == 3) {
                        System.out.println("The computer threw scissors!\nYou TIED against the computer!");
                        displayScore(userScore, compScore);
                    }
                } else {
                    System.out.println(
                            "\nOops! The character you inputed is not \"R\", \"P\", or \"S\". Press \"ENTER\" to restart the game. \n");
                    start = false;
                    String again = restart.nextLine();
                    if (again.equals("find")) {
                        start = true;
                        System.out.println(
                                "\nRestarting Program... \n\n\n\n\n\n\n\n\n\n\n\n***Congratulations, you found an easter egg!***\n");
                    } else {
                        start = true;
                        System.out.println("\nRestarting Program... \n\n\n\n\n\n\n\n\n\n\n\n***Program Restarted***\n");

                    }
                }
                if (gameNumber == turnsNumber) {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n****************");
                    if (userScore > compScore) {
                        System.out.println("Congratulations! You WON against the computer!");
                    } else if (compScore > userScore) {
                        System.out.println("Oh no! You LOST against the computer!");
                    } else if (compScore == userScore) {
                        System.out.println("You TIED against the computer!");
                    }
                    displayScore(userScore, compScore);
                    System.out.println("\nIf you would like to play again, press \"ENTER\".");
                    start = false;
                    String again = restart.nextLine();
                    if (again.equals("find")) {
                        start = true;
                        System.out.println(
                                "\nRestarting Program... \n\n\n\n\n\n\n\n\n\n\n\n***Congratulations, you found an easter egg!***\n");
                    } else {
                        start = true;
                        System.out.println("\nRestarting Program... \n\n\n\n\n\n\n\n\n\n\n\n***Program Restarted***\n");

                    }
                }

            }
        }
        turns.close();
        input.close();
        restart.close();

    }

    public static void displayScore(int userScore, int compScore) {
        System.out.println("\n--P---C--");
        System.out.println("| " + userScore + " | " + compScore + " |");
        System.out.print("---------");
    }

}