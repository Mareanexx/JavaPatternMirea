package practice8.Mediator;

public abstract class DeviceInHome {
    private final Mediator mediator;

    public DeviceInHome(Mediator mediator) {
        this.mediator = mediator;
    }
    public void sendMessage(String message) {
        mediator.NotifyDevice(this, message);
    }
    abstract void receiveMessage(String message);
}
