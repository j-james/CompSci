# Tic-Tac-Toe Pseudocode

## Start Program

- Initialize variables
    - Set starting values for variables
    - Print the intro to the game
    - Ask the player whether they want to play Xs or Os
    - Tell them which one they picked
    - Start the game
        - Ask the player where they want to play
        - See if that spot is taken
        - If it isn't taken, mark that place
        - Otherwise skip the player's turn
        - Print the board with all places
        - Check if anyone has won or if the board is full
        - Continue if no one has won
        - Start the computer's turn
        - Choose a random number from 1 to 9
        - Check if that number is taken
        - If it is, take it
        - If it isn't, go back and pick another random number
        - Check if anyone has won or if the board is full
        - Go back to "Start the game" if no one has won
    - If someone has won, congratulate them
    - Ask if the player wants to play again
    - If so, go back to "Print the intro to the game"
- Otherwise, exit the program