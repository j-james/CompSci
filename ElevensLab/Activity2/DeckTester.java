/**
 * This is a class that tests the Deck class.
 */
public class DeckTester
{

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args)
	{
		String[] myRanks = {"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
		String[] mySuits = {"spades", "hearts", "clubs", "diamonds"};
		int[] myValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

		String[] yourRanks = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez"};
		String[] yourSuits = {"cups", "stars", "crowns", "axes"};
		int[] yourValues = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		String[] samisRanks = {"un", "deux", "trois", "quadre"};
		String[] samisSuits = {"puppets"};
		int[] samisValues = {0, 1, 10, 11};

		Deck myDeck = new Deck(myRanks, mySuits, myValues);
		Deck yourDeck = new Deck(yourRanks, yourSuits, yourValues);
		Deck samisDeck = new Deck(samisRanks, samisSuits, samisValues);

		System.out.println(myDeck.isEmpty());
		System.out.println(myDeck.size());
		System.out.println(myDeck.deal());
		System.out.println(myDeck + "\n");

		System.out.println(yourDeck.isEmpty());
		System.out.println(yourDeck.size());
		System.out.println(yourDeck.deal());
		System.out.println(yourDeck + "\n");

		System.out.println(samisDeck.isEmpty());
		System.out.println(samisDeck.size());
		System.out.println(samisDeck.deal());
		System.out.println(samisDeck.deal());
		System.out.println(samisDeck.deal());
		System.out.println(samisDeck.deal());
		System.out.println(samisDeck.isEmpty());
		System.out.println(samisDeck);
	}
}
