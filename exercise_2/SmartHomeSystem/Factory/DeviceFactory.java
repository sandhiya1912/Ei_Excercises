package exercise_2.SmartHomeSystem.Factory;

import exercise_2.SmartHomeSystem.Device.Device;

public interface DeviceFactory {
    Device createDevice(int id, String type,boolean status);
    Device createDevice(int id, String type, int temperature);
}
