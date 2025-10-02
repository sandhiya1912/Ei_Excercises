package exercise_2.SmartHomeSystem.Observer;

import exercise_2.SmartHomeSystem.Device.Device;
import java.util.*;

public class ObserverDevice implements Observer {
    private final Map<Device,List<Device>> observers;

    public ObserverDevice(){
        this.observers = new HashMap<>();
    }

    public void addObserver(Device publisher, Device observer) {
        if (!observers.containsKey(publisher)) {
            observers.put(publisher, new ArrayList<>());
        }
        observers.get(publisher).add(observer);
    }

    public void removeObserver(Device device) {
        if (observers.remove(device) != null) {
            System.out.println("Publisher " + device.getId() + " removed with all its observers.");
        }
        for (Map.Entry<Device,List<Device>> subs : observers.entrySet()) {
            if (subs.getValue().remove(device)) {
                Device observer = subs.getKey();
                System.out.println(device.getType() + device.getId() + " removed from publisher " + observer.getType() +" " +observer.getId());
            }
        }
    }

    public void notifyObserver(Device publisher, String action) {
        if (observers.containsKey(publisher)) {
            for (Device observer : observers.get(publisher)) {
                update(publisher,observer,action); // notify the device using update() method
            }
        }
    }

    @Override
    public void update(Device publisher,Device observer,String action) {
        System.out.println(observer.getType() + " " + observer.getId() + " is notified about the action (" + action
                + ") by " + publisher.getType() + " " +publisher.getId());
    }

    public Map<Device,List<Device>> getObservers(){
        return observers;
    }
}
