package exercise_2.SmartHomeSystem.Device;

public class Thermostat extends Device {
    private int temperature;

    public Thermostat(int id, int initialTemp) {
        super(id, "thermostat",true);
        this.temperature = initialTemp;
    }

    public void setTemperature(int temp){
        this.temperature = temp;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public String getStatusDescription() {
        return "{Thermostat " + getId() + " is " + (getStatus()? "on" : "off") + " set to " + temperature + " degrees.}";
    }
}
