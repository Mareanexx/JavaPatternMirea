package practice8.Mediator;

public class MotionSensor extends DeviceInHome {

    public MotionSensor(Mediator mediator) {
        super(mediator);
    }

    @Override
    void receiveMessage(String message) {
        System.out.println("Датчик работает.");
    }

    void DetectMovement() {
        System.out.println("Датчики движения обнаружили движение))");
        this.sendMessage("Обнаружено движение");
    }
}
