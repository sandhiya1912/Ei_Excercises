package exercise_1.Behavioural.Startegy;

import exercise_1.Behavioural.Startegy.NotificationStrategies.EmailNotification;
import exercise_1.Behavioural.Startegy.NotificationStrategies.PushNotification;
import exercise_1.Behavioural.Startegy.NotificationStrategies.SMSNotification;
import exercise_1.Behavioural.Startegy.NotificationStrategies.WhatsAppNotification;

public class Main {
    public static void main(String[] args){
        NotificationClient client = new NotificationClient();

        try {
            client.setStrategy(new EmailNotification());
            client.notifyUser("Hi sandhiya! have you seen the pdf that I sent?");

            client.setStrategy(new SMSNotification());
            client.notifyUser("Hello jasmine! how is your day");

            client.setStrategy(new PushNotification());
            client.notifyUser("Theme applied successfully!");

            client.setStrategy(new WhatsAppNotification());
            client.notifyUser("your booking confirmed! see app for more details.");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
