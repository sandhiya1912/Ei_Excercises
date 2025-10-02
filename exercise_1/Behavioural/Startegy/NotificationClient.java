package exercise_1.Behavioural.Startegy;

import static exercise_1.Utils.TransientError.SimulateTransientError;

import exercise_1.Behavioural.Startegy.NotificationStrategies.NotificationService;

public class NotificationClient {
    private NotificationService strategy;

    public void setStrategy(NotificationService strategy){
        this.strategy = strategy;
    }

    public void notifyUser(String message){
        strategy.send(message);
        SimulateTransientError("Notification service down");
    }
}
