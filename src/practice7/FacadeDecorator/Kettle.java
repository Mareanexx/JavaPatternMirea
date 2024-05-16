package practice7.FacadeDecorator;

public class Kettle {
    private int numberOfWater;
    public void pourWater() {
        this.numberOfWater = 100;
    }
    public void turnOn() {
        if (numberOfWater < 30)
            System.out.println("Воды недостаточно. Чайник не поставлен!");
        else
            System.out.println("Воды достаточно! Чайник поставлен.");
    }
}
