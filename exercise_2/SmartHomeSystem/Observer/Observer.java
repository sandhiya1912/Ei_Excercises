package exercise_2.SmartHomeSystem.Observer;

import exercise_2.SmartHomeSystem.Device.Device;

public interface Observer {
    void update(Device publisher,Device observer, String action);
}
