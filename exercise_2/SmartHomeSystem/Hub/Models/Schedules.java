package exercise_2.SmartHomeSystem.Hub.Models;

public class Schedules {
    private final int id;
    private final String time;
    private final String command;

    public Schedules(int id,String time,String cmd){
        this.id = id;
        this.time = time;
        this.command = cmd;
    }

    public int getId(){
        return id;
    }

    public String getTime() {
        return time;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public String toString(){
        return "{device "+ id + ", time: "+ time + ", command: " + command + "}";
    }
}
