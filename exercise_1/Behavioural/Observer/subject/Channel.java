package exercise_1.Behavioural.Observer.subject;

import static exercise_1.Utils.TransientError.SimulateTransientError;

import java.util.*;

import exercise_1.Behavioural.Observer.models.Content;
import exercise_1.Behavioural.Observer.observer.Subscriber;

public class Channel implements YouTubeChannel {
    private final String channelName;
    private final List<Subscriber> subscribers;

    public Channel(String channelName) {
        this.channelName = channelName;
        this.subscribers = new ArrayList<>();
    }

    public String getChannelName() {
        return channelName;
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }


    public void uploadContent(Content content) {
        SimulateTransientError("YouTube server temporarily unavailable");

        System.out.println("\nChannel " + channelName + " uploaded " + content.getType() + ": " + content.getTitle());
        notifySubscribers(content);
    }

    @Override
    public void notifySubscribers(Content content) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(content.getType(), content.getTitle());
        }
        System.out.println("All subscribers notified about: " + content.getTitle());
    }
}
