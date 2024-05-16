package practice8.Mediator;

public class TestSmartHome {
    public static void main(String[] args) {
        Mediator mediator = new SmartHomeMediator();

        MotionSensor motionSensor = new MotionSensor(mediator);
        Light light = new Light(mediator);
        Door door = new Door(mediator);


        motionSensor.DetectMovement();
        System.out.println("1. Датчик пробует засечь движение и подать сигнал свету, чтобы он включился,\n но у ПОСРЕДНИКА еще нет добавленных устройств.\n" +
                "Тогда нужно добавить устройства в Посредник");
        mediator.addNewDevice(motionSensor);
        mediator.addNewDevice(light);

        System.out.println("2. Устройства добавлены. Теперь попробуем с помощью датчика движения оповестить 'систему света' о том, что нужно включиться");
        motionSensor.DetectMovement();

        System.out.println("3. Добавим еще одно устройство -- автоматически закрывающуюся дверь.");
        mediator.addNewDevice(door);

        motionSensor.DetectMovement();
    }
}
