package exercise_1.Creational.Prototype.DocumentTypes;

import static exercise_1.Utils.TransientError.SimulateTransientError;

public class Report implements Document {
    private String content;

    public Report(String content){
        this.content = content;
    }

    public Document clone() {
        return new Report(this.content);
    }

    public void edit(String addContent) {
        content+= " " + addContent;
    }

    public void show() {
        SimulateTransientError("Heavy Load");
        System.out.println("Report template: "+content);
    }
}
