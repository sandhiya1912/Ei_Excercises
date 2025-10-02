package exercise_1.Behavioural.Observer.subject;

import exercise_1.Behavioural.Observer.models.Content;
import exercise_1.Behavioural.Observer.observer.Subscriber;

public interface YouTubeChannel {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void uploadContent(Content content);
    void notifySubscribers(Content content);
}
