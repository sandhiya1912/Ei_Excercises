package exercise_2.SmartHomeSystem.Hub;

import exercise_2.SmartHomeSystem.Device.Device;
import exercise_2.SmartHomeSystem.Device.Door;
import exercise_2.SmartHomeSystem.Device.Thermostat;
import exercise_2.SmartHomeSystem.Factory.DeviceFactories;
import exercise_2.SmartHomeSystem.Factory.DeviceFactory;
import exercise_2.SmartHomeSystem.Hub.Models.Schedules;
import exercise_2.SmartHomeSystem.Hub.Models.Triggers;
import exercise_2.SmartHomeSystem.Observer.ObserverDevice;
import static exercise_2.SmartHomeSystem.Utils.Exceptions.TransientError.SimulateTransientError;

import java.util.*;
import java.time.*;
import java.time.format.*;


public class SmartHomeHub implements SmartHomeAccess {
    private final Map<Integer, Device> devices;
    private final List<Schedules> schedules;
    private final List<Triggers> triggers;
    private final DeviceFactory deviceFactory;
    ObserverDevice observers;

    public SmartHomeHub(){
        devices = new HashMap<>();
        schedules = new ArrayList<>();
        triggers = new ArrayList<>();
        deviceFactory = new DeviceFactories();
        observers = new ObserverDevice();
    }

    public void addDevice(int id, String type) {
        if (devices.containsKey(id)) {
            throw new IllegalArgumentException("Device with ID " + id + " already exists.");
        }

        Device device = null;
        Scanner sc = new Scanner(System.in);

        switch (type.toLowerCase()) {
            case "light":
                System.out.println("Enter the initial status for the light (on/off): ");
                String lightStatus = sc.nextLine().trim().toLowerCase();
                boolean isLightOn = lightStatus.equals("on");
                device = deviceFactory.createDevice(id,type,isLightOn);
                System.out.println("Light " + id + " is " + lightStatus + ".");
                break;
            case "thermostat":
                System.out.println("Enter the initial temperature for the thermostat: ");
                int temperature = Integer.parseInt(sc.nextLine());
                device = deviceFactory.createDevice(id,type,temperature);
                System.out.println("Thermostat " + id +" is set to " + temperature + " degrees.");
                break;
            case "door":
                System.out.println("Enter the initial status for the door (locked/unlocked): ");
                String doorStatus = sc.nextLine().trim().toLowerCase();
                boolean isLocked = doorStatus.equals("locked");
                device = deviceFactory.createDevice(id,type,isLocked);
                System.out.println("Door " + id + " is " + doorStatus + ".");
                break;
            default:
                throw new NoSuchElementException("Invalid device type");
        }

        devices.put(id, device);
        observers.notifyObserver(devices.get(id), "device added");
    }

    public void removeDevice(int id) {
        Device removed = devices.remove(id);
        if (removed != null) {
            System.out.println(removed.getType() + " " + removed.getId() + " is removed sucessfully.");
            //remove the schedules, triggers and observers once after the device is removed.
            schedules.removeIf(s -> s.getId() == id);
            triggers.removeIf(t -> t.getAction().contains("(" + id + ")"));
            observers.removeObserver(removed);
            observers.notifyObserver(removed,"device removed"); // notify observers
        } else {
            throw new NoSuchElementException("Device with ID " + id + " not found.");
        }
    }

    public void turnOn(int id) {
        Device d = devices.get(id);
        if (d != null) {
            d.turnOn();
            observers.notifyObserver(d,"turnOn");
            if(d.getType().equals("door")) System.out.println(d.getType() + " " + id + " is locked.");
            else  System.out.println(d.getType() + " " + id + " is turned on.");
        }else {
            throw new NoSuchElementException("Device with ID " + id + " not found.");
        }
    }

    public void turnOff(int id) {
        Device d = devices.get(id);
        if (d != null) {
            d.turnOff();
            observers.notifyObserver(d,"turned Off");
            if(d.getType().equals("door")) System.out.println(d.getType() + " " + id + " is unlocked.");
            else  System.out.println(d.getType() + " " + id + " is turned off.");
        }else {
            throw new NoSuchElementException("Device with ID " + id + " not found.");
        }
    }

    public void configureDevice(int id) {
        Scanner sc = new Scanner(System.in);
        Device d = devices.get(id);
        if(d == null) {
            throw new NoSuchElementException("Device with ID " + id + " not found.");
        }
        if(d instanceof Thermostat) {
            System.out.print("Enter new temperature: ");
            int temp = Integer.parseInt(sc.nextLine());
            ((Thermostat) d).setTemperature(temp);
            System.out.println(d.getType() + " " + d.getId() + " set to " + temp + " degrees.");

            initiateTriggers();  // Trigger actions & notify observers once trigger is added.
        } else if (d instanceof Door) {
            System.out.print("Enter status (locked/unlocked): ");
            String status = sc.nextLine();
            ((Door) d).setLocked(status.equalsIgnoreCase("locked"));
            System.out.println("Door " + id + " is " + status);

            observers.notifyObserver(d,"Door is " + status + " now.");
        } else {
            throw new IllegalArgumentException("Configuration not supported for device type " + d.getType());
        }
    }

    public void setSchedule(int id, String time, String command) {
        schedules.add(new Schedules(id,time,command));
        System.out.println(devices.get(id).getType() + " " + id + " is scheduled on time " + time);

        //Here I simulated the transient error - (e.g. network failure)
        SimulateTransientError("Temporary Network failure");
    }

    public void startScheduleMonitor() {
        new Thread(() -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            while (true) {
                String currentTime = LocalTime.now().format(formatter);

                for (Schedules schedule : schedules) {
                    if (schedule.getTime().equals(currentTime)) {
                        String action = schedule.getCommand() + "(" + schedule.getId() + ")";
                        executeAction(action);
                    }
                }
                try {
                    //every 2 minutes, schedule is monitored & if time == current time
                    // then it is scheduled automatically
                    Thread.sleep(120000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }
        }).start();
    }

    public void addTrigger(String condition, String action) {
        triggers.add(new Triggers(condition,action));
        System.out.println("Trigger " + condition + " "  + action + " added successfully.\n");
        subscribeToDevice(condition,action);
        initiateTriggers();
    }

    public void subscribeToDevice(String condition, String action){
        int observerId = Integer.parseInt(action.replaceAll("[^0-9]", ""));
        Device observer = devices.get(observerId);

        if (observer == null) {
            throw new NoSuchElementException("Observer not found for trigger: " + condition);
        }
        for (Device publisher : devices.values()) {
            if (publisher instanceof Thermostat) {
                observers.addObserver(publisher,observer);
                System.out.println(observer.getType() + " " + observerId + " subscribed to " + publisher.getType() + " " + publisher.getId());
            }
        }
    }

    private void initiateTriggers() {
        for (Triggers trig : triggers) {
            String[] parts = trig.getCondition().split(" ");
            if (parts.length != 3) continue;

            String operator = parts[1];
            int threshold = Integer.parseInt(parts[2]);

            for (Device d : devices.values()) {
                if (d instanceof Thermostat) {
                    double currentTemp = ((Thermostat) d).getTemperature();
                    boolean conditionMet = false;

                    switch (operator) {
                        case ">": conditionMet = currentTemp > threshold; break;
                        case "<": conditionMet = currentTemp < threshold; break;
                        case ">=": conditionMet = currentTemp >= threshold; break;
                        case "<=": conditionMet = currentTemp <= threshold; break;
                        case "==": conditionMet = currentTemp == threshold; break;
                    }

                    if (conditionMet) {
                        System.out.println("Trigger initiated: " + trig);
                        executeAction(trig.getAction());

                        String action = trig.getAction().startsWith("turnOn")? "turned on" : "turned off";
                        observers.notifyObserver(d,action);
                    }
                }
            }
        }
    }

    private void executeAction(String action) {
        int id = Integer.parseInt(action.replaceAll("[^0-9]", ""));
        Device d = devices.get(id);
        if(d!=null){
            if (action.startsWith("turnOff")) {
                if (d.getStatus()) turnOff(id);
            }else if(action.startsWith("turnOn")) {
                if (!d.getStatus()) turnOn(id);
            }else{
                throw new IllegalArgumentException("Invalid action command: " + action);
            }
        }else{
            throw new NoSuchElementException("Device for action " + action + " not found.");
        }
    }

    public void showStatus() {
        if(!devices.isEmpty()) {
            System.out.println("Devices: ");
            for (Device d : devices.values()) {
                System.out.println(d.getStatusDescription());
            }
        }else{
            System.out.println("No devices Available.");
        }
    }

    public void showSchedules() {
        if(!schedules.isEmpty()) {
            System.out.println("Schedules: ");
            schedules.forEach(System.out::println);
        }else{
            System.out.println("No schedules available.");
        }
    }

    public void showTriggers() {
        if(!schedules.isEmpty()){
            System.out.println("Triggers: ");
            triggers.forEach(System.out::println);
        }else{
            System.out.println("No Triggers available.");
        }
    }
}