package exercise_2.SmartHomeSystem.Proxy;

import exercise_2.SmartHomeSystem.Hub.SmartHomeHub;

public class SmartHomeProxy {
    private final boolean isAdmin;
    private final SmartHomeHub hub;
    private boolean scheduleStarted;

    public SmartHomeProxy(boolean isAdmin) {
        this.isAdmin = isAdmin;
        this.hub = new SmartHomeHub();
        this.scheduleStarted = false;
    }

    private boolean checkAccess() {
        if (!isAdmin) return false;
        return true;
    }

    public boolean authenticate(String operation) {
        if (!checkAccess()) {
            System.out.println("Guest access denied for " + operation + ". Read-only mode.");
            return true;
        }
        return false;
    }

    public void addDevice(int id, String type) {
        hub.addDevice(id, type);
    }

    public void removeDevice(int id) {
        hub.removeDevice(id);
    }

    public void turnOn(int id) {
        if (checkAccess()) hub.turnOn(id);
    }

    public void turnOff(int id) {
        hub.turnOff(id);
    }

    public void configureDevice(int id) {
        hub.configureDevice(id);
    }

    public void setSchedule(int id, String time, String command) {
        hub.setSchedule(id, time, command);
        if(!scheduleStarted){
            scheduleStarted = true;
            hub.startScheduleMonitor();
        }
    }

    public void addTrigger(String condition, String action) {
        hub.addTrigger(condition, action);
    }

    public void showStatus() {
        hub.showStatus();
    }

    public void showSchedules() {
        hub.showSchedules();
    }

    public void showTriggers() {
        hub.showTriggers();
    }

}
