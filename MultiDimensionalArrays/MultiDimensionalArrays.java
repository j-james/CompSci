import java.util.Scanner;

public class MultiDimensionalArrays {

    public static void main(String[] args) {
        int[][] multiTable = new int[10][12];
        for (int i = 1; i <= 10; i++) {
                System.out.print("| ");
                for (int j = 1; j <= 12; j++) {
                    if (((i % 2 != 0) && (j % 2 == 0)) || ((i % 2 == 0) && (j % 2 != 0))) {
                        multiTable[i-1][j-1] = i * j;
                        System.out.print(multiTable[i-1][j-1] + " | ");
                    }
                }
                System.out.println();
        }
    }
}