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

3) The game of Twenty-One is played with a deck of fifty-two cards.
    Ranks run from ace (highest) down to deuce (lowest).
    Suits are spades, hearts, diamonds, and clubs as in many other games.
    A face card has point value ten; an ace has point value eleven; point values
    for two, ..., ten are two, ..., ten respectively. Specify the contents of the
    `ranks`, `suits`, and `pointValues` array so that the statement

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
1) Write a static method named `flip` that simulates a flip of a weighted coin
    by returning either "`heads`" or "`tails`" each time it is called.
    The coin is twice as likely to turn up heads as tails.
    Thus, `flip` should return "`heads`" about twice as often as it returns "`tails`".

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

2) Write a static method named `arePermutations` that, given two `int` arrays of
    the same length but with no duplicate elements, returns `true` if one array
    is a permutation of the other (i.e., the arrays differ in only how their
    contents are arranged. Otherwise, it should return false.)

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

3) Suppose that the initial contents of the `values` array in `Shuffler.java` are `{1, 2, 3, 4}`.
    For what sequence of random integers would the efficients selection shuffle
    change `values` to contain `{4, 3, 2, 1}`?

    1) `{3, 2, 1, 0}`.

## A4: Adding a Shuffle Method to the Deck Class
No questions.
