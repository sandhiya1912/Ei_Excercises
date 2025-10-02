package exercise_1.Creational.Prototype.DocumentTypes;


import static exercise_1.Utils.TransientError.SimulateTransientError;

public class PPT implements Document {
    private String content;

    public PPT(String content){
        this.content = content;
    }

    public Document clone() {
        return new PPT(this.content);
    }

    public void edit(String addContent) {
        SimulateTransientError("Network Error");
        content+= " " + addContent;
    }

    public void show() {
        System.out.println("Report template: "+content);
    }
}
