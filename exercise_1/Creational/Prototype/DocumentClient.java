package exercise_1.Creational.Prototype;

import exercise_1.Creational.Prototype.DocumentTypes.Document;
import static exercise_1.Utils.TransientError.SimulateTransientError;


public class DocumentClient {
    private final Document prototype;

    public DocumentClient(Document prototype){
        this.prototype = prototype;
    }

    public Document createDocument(){
        SimulateTransientError("Document Client Failed");
        return prototype.clone();
    }
}
