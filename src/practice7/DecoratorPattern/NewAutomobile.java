package practice7.DecoratorPattern;

public class NewAutomobile implements Automobile {
    @Override
    public String addComponents() {
        return "Автомобиль с данной комплектацией: пусто";
    }

    @Override
    public int getCost() {
        return 100000;
    }
}
