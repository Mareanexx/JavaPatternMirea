package practice6.Factory;

public class PizzaFactory {
    public Pizza createPizza(int choice) {
        if (choice == 1)
            return new Pepperoni();
        else if (choice == 2)
            return new MeatPizza();
        else if (choice == 3)
            return new FourCheeses();
        return null;
    }
}
