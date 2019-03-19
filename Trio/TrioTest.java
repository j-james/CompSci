public class TrioTest
{
    public static void main(String[] args)
    {
        Sandwich thenumberone = new Sandwich("hot god", 1025.0);
        Salad thenumbertwo = new Salad("saladed", 11.1111);
        Drink thenumberthree = new Drink("jelly", 4143.13);
        Trio thenumbers = new Trio (thenumberone, thenumbertwo, thenumberthree);

        // the selection has too many
        System.out.println("PRICES AND VAULES: ");
        System.out.println(thenumberone.getName() + " : $" + thenumberone.getPrice());
        System.out.println(thenumbertwo.getName() + " : $" + thenumbertwo.getPrice());
        System.out.println(thenumberthree.getName() + " : $" + thenumberthree.getPrice());
    }
}
