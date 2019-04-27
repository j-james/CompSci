# Elevens Lab - Questions

## A1: Design and Create a Card Class

No questions.

## A2: Initial Design of a Deck Class

1) Explain in your own words the relationship between a `deck` and a `card`.

    1) A deck `has-a` card.

2) Consider the deck initialized with the statements below.
    How many cards does the deck contain?

    ```java
    String[] ranks = {"jack", "queen", "king"};
    String[] suits = {"blue", "red"};
    int[] pointValues = {11, 12, 13};
    Deck d = new Deck(ranks, suits, pointValues);
    ```

    1) The deck contains six cards.

3) The game of Twenty-One is played with a deck of fifty-two cards. Ranks run from ace (highest) down to deuce (lowest). Suits are spades, hearts, diamonds, and clubs as in many other games. A face card has point value ten; an ace has point value eleven; point values for two, ..., ten are two, ..., ten respectively. Specify the contents of the `ranks`, `suits`, and `pointValues` array so that the statement

    ```java
    Deck d = new Deck (ranks, suits, pointValues);
    ```

    initializes a deck for a Twenty-One game.

    1)

    ```java
    String[] ranks = {"ace", "two", ..., "ten", "jack", "queen", "king"};
    String[] suits = {"spades", "hearts", "clubs", "diamonds"};
    int[] pointValues = {11, 2, ..., 10, 10, 10, 10};
    ```

4) Does the order of elements of the `ranks`, `suits`, and `pointValues` arrays matter?

    1) The order of elements in `suits` doesn't matter, but `ranks` has to correspond to `pointValues`.

## A3: Shuffling the Cards in a Deck

1) Write a static method named `flip` that simulates a flip of a weighted coin by returning either "`heads`" or "`tails`" each time it is called. The coin is twice as likely to turn up heads as tails. Thus, `flip` should return "`heads`" about twice as often as it returns "`tails`".

    ```java
    public static String flip()
    {
        Random rand = new Random();

        if (rand.nextInt(3) == 0)
            return "tails";
        else
            return "heads";
    }
    ```

2) Write a static method named `arePermutations` that, given two `int` arrays of the same length but with no duplicate elements, returns `true` if one array is a permutation of the other (i.e., the arrays differ in only how their contents are arranged. Otherwise, it should return false.)

    ```java
    public static boolean arePermutations(int[] arrayOne, int[] arrayTwo)
    {
        for (int i = 0; i < arrayOne.length; i++)
        {
            productOne *= arrayOne[i];
            productTwo *= arrayTwo[i];
        }
        return productOne == productTwo;
    }
    ```

3) Suppose that the initial contents of the `values` array in `Shuffler.java` are `{1, 2, 3, 4}`. For what sequence of random integers would the efficients selection shuffle change `values` to contain `{4, 3, 2, 1}`?

    1) `{3, 2, 1, 0}`.

## A4: Adding a Shuffle Method to the Deck Class
No questions.

## A5: Testing with Assertations (Optional)

1) Buggy 1:

    The problem is in the `isEmpty` method of `Deck.java`.
    It is checking for `size < 0`, where it should check for `size <= 0`.

2) Buggy 2:

    The problem is in the constructor of `Deck.java`.
    The for loop there starts with `int j = 1`, but that excludes the first value.
    Since arrays are zero-indexed, it should start with `int j = 0`.

3) Buggy 3:

    The problem is in `shuffle` method of `Deck.java`.
    The `for` loop is all kinds of messed up. It just won't execute as it is now.

4) Buggy 4:

    The problem is in the `deal` method of `Deck.java`.
    It decreases the size before calling `isEmpty`.

5) Buggy 5:

    `Deck.java` is fixed.

## A6: Playing Elevens

Play a few games of Elevens. How many did you win?

I won two out of five.

1) List all the possible plays for the board 5♠ 4♥ 2♦ 6♣ A♠ J♥ K♦ 5♣ 2♠

    5♠6♣ or 5♣6♣.

2) If the deck is empty and the board has three cards lieft, must they be a Jack, a Queen, and a King? Why or why not?

    Yes, they must be. Cards are sorted into pools of eight cards each (for example, 5♠5❤5♣5♦6♠6❤6♣6♦) that can form pairs. These groupings are even. There is no possible way to have 3 cards left that aren't face cards when playing the game correctly.

3) Does the game involve any strategy? That is, when more than one play is possible, does it matter which one is chosen? Briefly explain your answer.

    The game involves zero strategy. Per the pool grouping I described above, each card has a certain equivalent. Neither the order of pairs removed nor the suit of card chosen, the only two pillars of choice which the game allows you, have any relevance on the outcome.

## A7: Elevens Board Class Design

1) What items would be necessary if you were playing a game of Elevens at your desk (not on the computer)? List the private instance variables needed for the `ElevensBoard` class.

    A deck of cards.

2) Write an algorithm that describes the actions necessary to play the Elevens game.

    Create a new game with a deck of fifty-two cards.
    Place nine cards on the board.
    Fill any empty spots with cards.
    Look for a set of two cards adding up to eleven.
    If there is such a set, remove them from the game and go back to 'fill any empty spots'.
    Look for a set of a Jack, Queen, and King.
    If there is such a set, remove them from the game and go back to 'fill any empty spots'.
    If there are no more cards on the board, you've won the game.
    Else, you've lost.

3) Now examine the partially implemented `ElevensBoard.java` file found in the Activity7 Starter Code directory. Does the `ElevensBoard` class contain all the state and behavior necessary to play the game?

    Yes, it does.

4) `ElevensBoard.java` contains three helper methods. These helper methods are `private` because they are only called from the `ElevensBoard` class.

    a) Where is the `dealMyCards` method called in `ElevensBoard`?

    In its constructor and its `newGame()` function.

    b) Which `public` methods should call the `containsPairSum11` and `containsJQK` methods?

    `isLegal()` and `anotherPlayIsPossible()`.

    c) It's important to understand how the `cardIndexes` method works, and how the list that it returns is used. Suppose that `cards` contains the elements shown below. Trace the execution of the `cardIndexes` method to determine what list will be returned. Complete the diagram below by filling in the elements of the returned list, and by showing how those values index `cards`. Note that the returned list may have less than nine elements.

    | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
    |---|---|---|---|---|---|---|---|---|
    | 0 | 1 | 3 | 6 | 7 |

    d) Complete the following `printCards` method to print all of the elements of cards that are indexed by `cIndexes`.

    ```
    public static printCards(ElevensBoard board)
    {
        List<Integer> cIndexes = board.cardIndexes();

        for (int i = 0; i < cIndexes.size(); i++)
            System.out.println(board.cards[i]);
    }
    ```

    e) Which one of the methods that you identified in question 4B above needs to call the `cardIndexes` method before calling the `containsPairSum11` and `containsJQK` methods? Why?

    `anotherPlayIsPossible()`, I believe. You need to know all of the cards on the board, not just the ones you have selected.

## A8: Using an Abstract Board Class

1) Discuss the similarities and differences beween _Elevens_, _Thirteens_, and _Tens_.

    You need a deck of cards for all of these games. There are universal similarities, such as dealing a card and checking if a deck is empty. There are slightly changed mechanics, such as checking if a play is legal or other plays are possible. There are entirely different functions, such as checking for the Jack-Queen-King combination.

2) As discussed previously, all of the instance variables are declared in the `Board` class. But it is the `ElevensBoard` class that "knows" the board size, and the ranks, suits, and point values of the cards in the deck. How do the `Board` instance variables get initialized with the `ElevensBoard` values? What is the exact mechanism?

    Inside the `ElevensBoard` constructor, instance variables are passed to the superclass's constructor.

3) Now examine the files `Board.java` and `ElevensBoard.java`, found in the __Activity8 Starter Code__ directory. Identify the `abstract` methods in `Board.java`. See how those methods are implemented in `ElevensBoard`. Do they cover all the differences between _Elevens_, _Thirteens_, and _Tens_ as discussed in question 1? Why or why not?

    Yes. All of the functions that stay identical in all three games are implemented in `Board.java`. All of the functions that are implemented differently per game are written as abstract methods.

## A9: Implementing the Elevens Board

1) The size of the board is one of the differences between _Elevens_ and _Thirteens_. Why is `size` not an abstract method?

    1) `size` is not an abstract method because `size` is already a parameter.

2) Why are there no abstract methods dealing with the selection of the cards to be removed or replaced in the array `cards`?

    1) Abstract methods are for functions that differ per implementation. Removing or replacing cards is universal regardless of the size of the deck.

3) Another way to create 'IS-A' relationships is by implementing interfaces. Suppose that instead of creating an `abstract` `Board` class, we created the following `Board` interface, and had `ElevensBoard` implement it. Would this new scheme allow the Elevens GUI to call `isLegal` and `anotherPlayIsPossible` polymorphically? Would this alternate design work as well as the `abstract` `Board` class design? Why or why not?

    1) `isLegal` and `anotherPlayIsPossible` still could be called polymorphically. The alternate design would work as well as the `abstract` `Board` design, but would require all of the methods to be written for every implementation.
