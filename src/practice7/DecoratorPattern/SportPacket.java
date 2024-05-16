package practice7.DecoratorPattern;

public class SportPacket extends AutomobileDecorator {

    public SportPacket(Automobile automobile) {
        super(automobile);
    }

    public String addComponents() {
        if (super.addComponents().contains("пусто")) {
            return super.addComponents().replace(" пусто", "") + " " + addSportPacket();
        }
        return super.addComponents() + " " + addSportPacket();
    }

    public String addSportPacket() {
        return " Спортивный пакет;";
    }
    public int getCost() {
        return super.getCost() + 20000; //20 к долларов за спортивный пакет для автомобиля
    }

}
