package exercise_1.Creational.Prototype.DocumentTypes;

import static exercise_1.Utils.TransientError.SimulateTransientError;

public class Resume implements Document {
    private String content;

    public Resume(String content){
        this.content = content;
    }

    public Document clone(){
        return new Resume(this.content);
    }

    public void edit(String addContent){
        content += " " + addContent;
    }

    public void show() {
        SimulateTransientError("Heavy Load");
        System.out.println("Resume Template: \n"+content);
    }
}
