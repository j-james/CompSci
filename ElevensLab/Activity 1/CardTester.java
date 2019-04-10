/**
 * This is a class that tests the Card class.
 */
public class CardTester
{
    /**
     * The main method in this class checks the Card operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args)
    {
        Card aceOfSpades = new Card("King", "Spades", 14);
        Card jackOfSpades = new Card("Jack", "Spades", 11);
        Card twoOfClubs = new Card("two", "Clubs", 2);

        System.out.println(aceOfSpades.suit());
        System.out.println(aceOfSpades.rank());
        System.out.println(aceOfSpades.pointValue());
        System.out.println(aceOfSpades.matches(jackOfSpades));
        System.out.println(aceOfSpades);

        System.out.println(jackOfSpades.suit());
        System.out.println(jackOfSpades.rank());
        System.out.println(jackOfSpades.pointValue());
        System.out.println(jackOfSpades.matches(jackOfSpades));
        System.out.println(jackOfSpades);

        System.out.println(twoOfClubs.suit());
        System.out.println(twoOfClubs.rank());
        System.out.println(twoOfClubs.pointValue());
        System.out.println(twoOfClubs.matches(jackOfSpades));
        System.out.println(twoOfClubs);
    }
}
