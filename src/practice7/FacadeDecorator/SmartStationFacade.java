package practice7.FacadeDecorator;

public class SmartStationFacade {
    Kettle kettle = new Kettle();
    Lighting lighting = new Lighting();
    Television television = new Television();

    public void iAmHome() {
        kettle.pourWater();
        kettle.turnOn();
        lighting.turnOn();
        television.turnOn();
    }
}
