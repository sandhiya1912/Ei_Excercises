package exercise_2.SmartHomeSystem.Factory;

import exercise_2.SmartHomeSystem.Device.Device;
import exercise_2.SmartHomeSystem.Device.Door;
import exercise_2.SmartHomeSystem.Device.Light;
import exercise_2.SmartHomeSystem.Device.Thermostat;

public class DeviceFactories implements DeviceFactory{
    public Device createDevice(int id, String type,boolean status) {
        switch(type.toLowerCase()) {
            case "light":
                return new Light(id,status);
            case "door":
                return new Door(id,status);
            default:
                throw new IllegalArgumentException("Invalid device type: " + type);
        }
    }

    public Device createDevice(int id,String type,int temperature){
        if ("thermostat".equalsIgnoreCase(type)) {
            return new Thermostat(id,temperature);
        }
        throw new IllegalArgumentException("Invalid device type.");
    }
}
