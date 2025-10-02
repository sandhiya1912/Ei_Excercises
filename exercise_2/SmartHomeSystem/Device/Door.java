package exercise_2.SmartHomeSystem.Device;

public class Door extends Device {
    public Door(int id,boolean status) {
        super(id, "door",status);
    }

    public void setLocked(boolean locked){
        if (locked) {
            turnOn();
        } else {
            turnOff();
        }
    }

    @Override
    public String getStatusDescription() {
        return "{Door " + getId() + " is " + (getStatus()? "Locked" : "Unlocked") + "}";
    }
}
