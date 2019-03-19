public class Trio implements MenuItem
{
    public Sandwich sandwich;
    public Salad salad;
    public Drink drink;
    
    public Trio (Sandwich a, Salad b, Drink c)
    {
        sandwich = a;
        salad = b;
        drink = c;
    }
    
    public String getName()
    {
        return sandwich.getName() + " / " + salad.getName() + " / " + drink.getName() + " Trio";
    }
    
    public double getPrice()
    {
        double min = 0;
        if (sandwich.getPrice() < salad.getPrice())
            min = sandwich.getPrice();
        else
            min = salad.getPrice();
        if (min < drink.getPrice())
            min = drink.getPrice();
        
        return sandwich.getPrice() + salad.getPrice() + drink.getPrice() - min;
    }
}
