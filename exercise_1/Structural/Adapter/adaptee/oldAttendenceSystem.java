package exercise_1.Structural.Adapter.adaptee;

import exercise_1.Structural.Adapter.model.Student;

public class oldAttendenceSystem {
    public void markAttendance(Student student){
        student.setAttendance();
    }
}
