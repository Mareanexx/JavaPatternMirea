package practice6.Factory;

public class Pepperoni implements Pizza {
    @Override
    public void makePizza() {
        System.out.println("Сделали пиццу пепперони");
    }

    @Override
    public void wrapPizza() {
        System.out.println("Завернули пиццу пепперони");
    }

    @Override
    public void deliverPizza() {
        System.out.println("Доставили пиццу пепперони");
    }
}
