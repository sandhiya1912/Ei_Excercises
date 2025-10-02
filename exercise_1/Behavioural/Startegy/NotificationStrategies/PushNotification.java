package exercise_1.Behavioural.Startegy.NotificationStrategies;

public class PushNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Notification send using App: "+message);
    }
}
