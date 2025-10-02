package exercise_1.Behavioural.Observer.models;

public class Content {
    private final String type;
    private final String title;

    public Content(String type, String title) {
        this.type = type;
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }
}
