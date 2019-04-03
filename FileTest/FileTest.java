import java.io.*;

public class MyTest {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("example.txt");

        if (f.exists()) {
            System.out.println("I found it");
            f.delete();
            System.out.println("I deleted it");
        }
        else {
            System.out.println("I did not find it");
        }
    }
}