package practice6.Factory;

public class FourCheeses implements Pizza {
    @Override
    public void makePizza() {
        System.out.println("Сделали пиццу 4 сыра");
    }

    @Override
    public void wrapPizza() {
        System.out.println("Завернули пиццу 4 сыра");
    }

    @Override
    public void deliverPizza() {
        System.out.println("Доставили пиццу 4 сыра");
    }
}
