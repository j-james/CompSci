// Program to sort an input file of names, ignoring case, using the mergesort algorithm.
// Tested and working - j-james

import java.io.*;
import java.util.*;

public class SortNames
{
    public static void main (String[] args) throws FileNotFoundException
    {
        Scanner console = new Scanner(System.in);
        System.out.print("What is the input file? ");
        String fileName = console.nextLine();
        Scanner input = new Scanner(new File(fileName));
        System.out.println();

        String[] names = readNames(input);
        mergeSort(names);
        for (String s : names)
            System.out.println(s);
        console.close();
    }

    public static String[] readNames(Scanner input)
    {
        List<String> data = new ArrayList<String>();
        while (input.hasNextLine())
            data.add(input.nextLine());
        String[] result = new String[data.size()];
        data.toArray(result);
        return result;
    }

    // Swaps a[i] with a[j].
    public static void swap(String[] a, int i, int j)
    {
        if (i != j)
        {
            String temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    // post: list is in sorted (nondecreasing) order
    public static void mergeSort(String[] array)
    {
    	// 1) split array into two smaller arrays
    	// 2) recursively sort the two smaller arrays
        // 3) merge the sorted halves into a sorted whole

        // main weird thing is the lack of return statements - because it's arrays, you just don't need return statements.

        if (array.length > 1)
        {
            // break into two arrays
            String[] first = new String[array.length / 2];
            String[] last = new String[array.length - first.length];

            // assign values to the broken arrays
            for (int j = 0; j < first.length; j++)
                first[j] = array[j];
            for (int k = 0; k < last.length; k++)
                last[k] = array[first.length + k];

            // recursive part
            mergeSort(first);
            mergeSort(last);

            // not recursive part - just merge the arrays gotten together
            merge(array, first, last);
        }

    }

    // pre : result is empty; list1 is sorted; list2 is sorted
    // post: result contains result of merging sorted lists;
    public static void merge(String[] result, String[] list1, String[] list2)
    {
        // merge the two lists into result array
        int i = 0;
        int firstIndex = 0;
        int lastIndex = 0;
        while (i < result.length)
        {
            if (firstIndex >= list1.length) // needed if the "first" array is completely sorted in before the "last" one
            {
                result[i] = list2[lastIndex];
                lastIndex++;
            }
            else if (lastIndex >= list2.length) // needed if the "last" array is completely sorted in before the "first" one
            {
                result[i] = list1[firstIndex];
                firstIndex++;
            }
            else if (String.CASE_INSENSITIVE_ORDER.compare(list1[firstIndex], list2[lastIndex]) < 0) // compares strings and makes it easy to sort them
            {
                result[i] = list1[firstIndex];
                firstIndex++; // incremented so that we don't sort "first" values more than once
            }
            else
            {
                result[i] = list2[lastIndex];
                lastIndex++; // incremented so that we don't sort "last" values more than once
            }
            i++; // increments each loop so that the "result" array is constantly filled
        }

    }
}
