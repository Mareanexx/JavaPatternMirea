package practice7.DecoratorPattern;

public class PanoramicRoof extends AutomobileDecorator {
    public PanoramicRoof(Automobile automobile) {
        super(automobile);
    }

    public String addComponents() {
        if (super.addComponents().contains("пусто")) {
            return super.addComponents().replace(" пусто", "") + " " + addPanoramicRoof();
        }
        return super.addComponents() + " " + addPanoramicRoof();
    }

    public String addPanoramicRoof() {
        return " Панорамная крыша;";
    }

    public int getCost() {
        return super.getCost() + 4000;
    }
}
