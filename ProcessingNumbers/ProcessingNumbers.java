// Updated program to take advantage of for loops
// Has some fancy stuff

import java.util.*;

public class CompSci {

	public static void main(String[] args) {
		int currentMin = 0;
		int currentMax = 0;
		int evenTotal = 0;
		int currentEvenMax = 0;
		int a = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to ProcessingNumbers.");
		System.out.println("Number of integers you would like to enter?");
		int num = 0;
		try {
			num = sc.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("\nERROR: Please enter only integers.");
			System.out.print("Exiting");
			dotdotdot();
			System.exit(0);
		}
		if (num <= 0) {
			System.out.println("Wow okay");
			System.exit(0);
		}
		System.out.println("Enter in " + num + " integers to have the minimum, maximum, sum of even numbers, and the largest even number printed.");
		System.out.println("Enter an integer, then press Return. \n\n");
		for (int i = 0; i < num; i++) {
			try {
				a = sc.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("\nERROR: Please enter only integers.");
				System.out.print("Exiting");
				dotdotdot();
				System.exit(0);
			}
			finally {
				if (i == 0) {
					currentMin = a;
					currentMax = a;
					if (a % 2 == 0) {
						currentEvenMax = a;
					}
				}
				currentMin = Math.min(currentMin, a);
				currentMax = Math.max(currentMax, a);
				if (a % 2 == 0) {
					evenTotal += a;
					currentEvenMax = Math.max(currentEvenMax, a);
				}
				else {}
			}
		}
		sc.close();

		System.out.print("\nProcessing");
		dotdotdot();

		System.out.println("Minumum value: " + currentMin);
		System.out.println("Maximum value: " + currentMax);
		System.out.println("Total value of even numbers: " + evenTotal);
		System.out.println("Even maximum: "+ currentEvenMax);

	}
	public static void dotdotdot() {
		try {
			Thread.sleep(400);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.print(".");
		try {
			Thread.sleep(400);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.print(".");
		try {
			Thread.sleep(400);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.print(".\n\n");
	}

}