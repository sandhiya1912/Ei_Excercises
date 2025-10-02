package exercise_1.Behavioural.Observer.observer;

public class User implements Subscriber {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void update(String contentType, String contentTitle) {
        System.out.println(name + " received notification about the new " + contentType + " uploaded " + contentTitle);
    }

    public String getName() {
        return name;
    }
}