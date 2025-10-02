package exercise_1.Behavioural.Startegy.NotificationStrategies;

public class WhatsAppNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Notification send using WhatsApp: "+message);
    }
}
