package practice7.FacadeDecorator;

public class TestFacade {
    public static void main(String[] args) {
        SmartStationFacade smartstation = new SmartStationFacade();

        //Умный дом автоматически включит все электронные приборы, когда человек вызвал команды "Я дома"
        smartstation.iAmHome();
    }
}
