package practice8.Mediator;

public class Light extends DeviceInHome {
    public Light(Mediator mediator) {
        super(mediator);
    }

    @Override
    void receiveMessage(String message) {
        if (message.contains("Обнаружено движение")) {
            System.out.println("Сообщение получено. Включаю свет!");
            this.turnOnLight();
        }
    }

    void turnOnLight() {
        System.out.println("Свет включен!");
    }
}
