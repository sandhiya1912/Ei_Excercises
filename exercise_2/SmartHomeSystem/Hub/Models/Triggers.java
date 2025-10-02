package exercise_2.SmartHomeSystem.Hub.Models;

public class Triggers {
    private final String condition;
    private final String action;

    public Triggers(String condition,String action){
        this.condition = condition;
        this.action = action;
    }

    public String getCondition() {
        return condition;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "[{condition: " + condition + ", action: " + action + "]}";
    }
}
