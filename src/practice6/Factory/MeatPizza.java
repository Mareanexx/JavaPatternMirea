package practice6.Factory;

public class MeatPizza implements Pizza {
    @Override
    public void makePizza() {
        System.out.println("Сделали пиццу мясную");
    }

    @Override
    public void wrapPizza() {
        System.out.println("Завернули пиццу мясную");
    }

    @Override
    public void deliverPizza() {
        System.out.println("Доставили пиццу мясную");
    }
}
