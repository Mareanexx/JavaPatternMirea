package practice8.Mediator;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeMediator implements Mediator {
    private List<DeviceInHome> deviceInHomeList = new ArrayList<DeviceInHome>();

    @Override
    public void addNewDevice(DeviceInHome device) {
        this.deviceInHomeList.add(device);
    }
    @Override
    public void NotifyDevice(DeviceInHome sender, String message) {
        if (deviceInHomeList.isEmpty()) {
            System.out.println("Нет подключенных устройств!");
            return;
        }
        for (DeviceInHome device : deviceInHomeList) {
            if (device != sender) {
                device.receiveMessage(message);
            }
        }
    }
}
