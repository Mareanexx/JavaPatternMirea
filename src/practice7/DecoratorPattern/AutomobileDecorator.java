package practice7.DecoratorPattern;

public abstract class AutomobileDecorator implements Automobile {
    private Automobile automobile;

    public AutomobileDecorator(Automobile automobile) {
        this.automobile = automobile;
    }

    @Override
    public int getCost() {
        return automobile.getCost();
    }
    @Override
    public String addComponents() {
        return automobile.addComponents();
    }

}
