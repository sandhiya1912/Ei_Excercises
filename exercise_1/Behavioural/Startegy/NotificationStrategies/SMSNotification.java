package exercise_1.Behavioural.Startegy.NotificationStrategies;

public class SMSNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Notification send using SMS: "+message);
    }
}
