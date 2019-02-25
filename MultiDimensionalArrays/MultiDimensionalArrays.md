# MultiDimensionalArrays

Justice James - v1.1

## Content
- Advanced programming structures
- Uses of pre-built data structures

Multidimensional arrays have quite a few uses. They can serve as grids for
seating plans or for board games such as chess and checkers. Some students
enjoy recreating the game of battleship using two dimensional arrays.

As you learn about their use, remember to consider how you might use
multidimensional arrays in your future projects.

---

This worksheet must be submitted electronically – not handwritten.
The code you provide will be tested by copying and executing in Eclipse.
Therefore, you should write the code in an IDE, just to make sure you have not
made an error. For example, I have provided the answer to #1. As you can see,
I am only asking for the snippet of code that answers the question – not an
entire program. Yet, the syntax for this statement needed to be correct,
including the semi-colon.

## Questions

1. Write one line of code that correctly initializes an array that holds 1028
    values of type double.

    ```java
    double[] arr = new double[1028];
    ```

2. Write one line of code that correctly declares a two dimensional array with
    5 rows and 4 columns.

    ```java
    int[][] twoArray = new int[5][4];
    ```

3. Write one line of code to construct a String two dimensional array called
    studentSeating that will be used as a seating chart for our classroom.
    You do not need to fill in any of the elements of the array, and you can
    assume that the final array will have empty seats (you do not need to
    construct a jagged array).

    ```java
    String[][] studentSeating = new String[4][8];
    ```

4. Draw (by typing) a picture that illustrates what the memory looks like for
    the array studentSeating. This will show the values that have been auto-initialized!

    ```java
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    | null | null | null | null | null | null | null | null |
    | null | null | null | null | null | null | null | null |
    | null | null | null | null | null | null | null | null |
    | null | null | null | null | null | null | null | null |
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ```

5. Write code that fills in the elements (by inputting from the console) of the
    array from studentSeating with the names of students seated in each spot.

    ```java
    import java.util.Scanner;
    String nextName;
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
            System.out.println(“Enter name for column “ + i + “ and row “ + j);
            studentSeating[i][j] = scan.nextLine();
    }
    }
    scan.close();
    ```

6. If you wanted to print the name of the person in the last desk of the second
    row, what code would you write?

    ```java
    System.out.println(studentSeating[1][7]);
    ```

7. Teachers get tired being on their feet all day! Write a line of code that
    would assign one of the student seats to your teacher.

    ```java
    studentSeating[3][0] = “Mr. Turner”;
    ```

8. It’s your lucky day! You get to switch seats with any one student in the class.
    Write the code that will switch seats for you and the other student in the
    studentSeating array.

    ```java
    String temp = studentSeating[0][0];
    studentSeating[0][0] = studentSeating[2][4];
    studentSeating[2][4] = temp;
    ```

9. Your cousin is in charge of cooking pernil for your family holiday party.
    It’s her first time doing it, and so she takes the temperature of the pernil
    two times an hour, for all 10 hours (she’s really nervous!). Write a
    declaration for a two dimensional array to store all of the temperatures
    she collects.

    ```java
    String[][] cousinTemp = new String[2][10];
    ```

10. Write a two dimensional String array declaration that would represent a
    chess board (a chess board is 8 spaces by 8 spaces). Pawns occupy all spaces
    in the 2nd and 7th row of a chess board when the game first starts. Write
    code to fill those spaces with the word “pawn.”

    ```java
    String[][] chessboard = new String[8][8];
    for (int i = 0; i < 8; i++) {
        chessboard[1][i] = “pawn”;
        chessboard[6][i] = “pawn”;
    }
    ```

11. Assume that a two-dimensional rectangular array of integers called data has
    been declared with four rows and seven columns. Write a loop to initialize
    the third row of data to store the numbers 1 through 7.

    ```java
    for (int i = 0; i < 7; i++)
        data[2][i] = i + 1;
    ```

12. Assume that a two-dimensional rectangular array of integers called matrix
    has been declared with six rows and eight columns. Write a loop to copy the
    contents of the second column into the fifth column.

    ```java
    for (int i = 0; i < 8; i++)
        matrix[i][4] = matrix[i][1];
    ```

13. Consider the following method:

```java
public static void mystery(int[][] a){
for(int r = 0; r < a.length; r++){
for(int c = 0; c < a[0].length – 1; c++){
if (a[r][c + 1] > a[r][c]){
a[r][c] =a[r][c+1];
}
}
}
}
```

If a two-dimensional array numbers is initialized to store the following
integers, what are its contents after the call shown below:

```java
int[][] numbers = {{3, 4, 5, 6}, {4, 5, 6, 7}, {5, 6, 7, 8}};
mystery(numbers);
```

    ```java
    4566
    5677
    6788
    ```

14. Declare, fill, and print a 10 x 12 array that we could give to the
    elementary classes to help students learn their multiplication tables.
    Hint: it might help to draw the output first, and work your way backwards.
    Include comments and pseudocode to explain your program to others.

    ```java
    int[][] multiTable = new int[10][12];
    for (int i = 1; i <= 10; i++) {
        System.out.print("| ");
        for (int j = 1; j <= 12; j++) {
            multiTable[i-1][j-1] = i * j;
            System.out.print(multiTable[i-1][j-1] + " | ");
        }
        System.out.println();
    }
    ```

15. The elementary teachers are probably going to want to test their students on
    their multiplication tables. Write code that will copy the contents of the
    third column into the seventh column, so students will have to find and
    correct errors in the table.

    ```java
    for (int k = 0; k < 10; k++)
        multiTable[k][6] = multiTable[k][2];
    ```

16. [Bonus] Write a special multiplication table that only includes even numbers
    multiplied by other even numbers. Your first row should read the
    multiplication results `{4, 8, 12, 16, 20}`. [i.e. `2*2, 2*4, 2*6, 2*8, 2*10`]

    ```java
    int[][] multiTable = new int[10][12];
    for (int i = 1; i <= 10; i++) {
        if (i % 2 == 0) {
            System.out.print("| ");
            for (int j = 1; j <= 12; j++) {
                if (j % 2 == 0) {
                    multiTable[i-1][j-1] = i * j;
                    System.out.print(multiTable[i-1][j-1] + " | ");
                }
            }
            System.out.println();
        }
    }
    ```

17. [Bonus] Adjust the special multiplication table so that it only includes
    even number multiplied by odd numbers. Your first row should read the
    multiplication results `{2, 6, 10, 14, 18}`. [`i.e. 2*1, 2*3, 2*5, 2*7, 2*9`]

    ```java
    int[][] multiTable = new int[10][12];
    for (int i = 1; i <= 10; i++) {
        System.out.print("| ");
        for (int j = 1; j <= 12; j++) {
            if (((i % 2 != 0) && (j % 2 == 0)) || ((i % 2 == 0) && (j % 2 != 0)))
            {
                multiTable[i-1][j-1] = i * j;
                System.out.print(multiTable[i-1][j-1] + " | ");
            }
        System.out.println();
        }
    }
    ```
