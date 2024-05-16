package practice8.Mediator;

public interface Mediator {
    void addNewDevice(DeviceInHome device);
    void NotifyDevice(DeviceInHome sender, String message);
}
