/** Trio.java
 *
 * Trio.java `implements` the MenuItem interface. 
 * This means it _must_ have the abstract methods specificed in `MenuItem.java`.
 *
 * It also contains a contructor to be able to use parameters.
 */

public class Trio implements MenuItem
{
    public Sandwich sandwich;
    public Salad salad;
    public Drink drink;
    
    public Trio (Sandwich sandwich, Salad salad, Drink drink)
    {
        // The `this` keyword lets you use the same name for variables up above in the class
        // and the ones passed through the constructor.
        this.sandwich = sandwich;
        this.salad = salad;
        this.drink = drink;
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
