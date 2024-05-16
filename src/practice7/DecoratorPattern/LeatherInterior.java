package practice7.DecoratorPattern;

public class LeatherInterior extends AutomobileDecorator {
    public LeatherInterior(Automobile automobile) {
        super(automobile);
    }

    public String addComponents() {
        if (super.addComponents().contains("пусто")) {
            return super.addComponents().replace(" пусто", "") + " " + addLeatherInterior();
        }
        return super.addComponents() + " " + addLeatherInterior();
    }

    public String addLeatherInterior() {
        return " Кожаный салон;";
    }

    public int getCost() {
        return super.getCost() + 5000; // 5 к долларов за кожаный салон
    }

}
