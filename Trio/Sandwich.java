public class Sandwich implements MenuItem
{
    public String name;
    public double price;

    public Sandwich (String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }
}
