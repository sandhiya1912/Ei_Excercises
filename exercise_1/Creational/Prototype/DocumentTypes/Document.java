package exercise_1.Creational.Prototype.DocumentTypes;

public interface Document {
    Document clone();
    void edit(String content);
    void show();
}
