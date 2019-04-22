public class binarySearch
{

    public static int binarySearch(int[] array, int start, int end, int key) 
    {
        if (start < end) 
        {
            int mid = start + (end - start) / 2;

            if (key < array[mid])
            {
                System.out.println(mid);
                return binarySearch(array, start, mid, key);
            }
            else if (key > array[mid]) 
            {
                System.out.println(mid);
                return binarySearch(array, mid++, end, key);
            }
            else
                return mid;
        }
        return -1;  
    }

    public static void main(String[] args) 
    {
        int number = 13;
        int[] array = {-1,  3,  5,  8, 15, 18, 22, 39, 40, 42, 50, 57};
        int index = binarySearch(array, 0, array.length, number);
        System.out.println("Found " + number + " at " + index + " index");
    }
}
