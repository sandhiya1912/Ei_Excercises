package exercise_2.SmartHomeSystem.Hub;

public interface SmartHomeAccess {
    void addDevice(int id, String type);
    void removeDevice(int id);
    void turnOn(int id);
    void turnOff(int id);
    void configureDevice(int id);
    void setSchedule(int id, String time, String command);
    void addTrigger(String condition, String action);
    void showStatus();
    void showSchedules();
    void showTriggers();
}

