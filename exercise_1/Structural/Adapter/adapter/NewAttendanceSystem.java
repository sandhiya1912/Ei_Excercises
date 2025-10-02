package exercise_1.Structural.Adapter.adapter;

import exercise_1.Structural.Adapter.adaptee.oldAttendenceSystem;
import exercise_1.Structural.Adapter.model.Student;
import static exercise_1.Utils.TransientError.SimulateTransientError;
import java.util.*;

public class NewAttendanceSystem implements AttendanceSystem {
    private final oldAttendenceSystem oldSystem;

    public NewAttendanceSystem(oldAttendenceSystem oldSystem){
        this.oldSystem = oldSystem;
    }

    public void MarkAttendanceByFingerPrint(Map<String,Student> students, String fingerPrint){
        if(students.containsKey(fingerPrint)){
            Student student = students.get(fingerPrint);
            System.out.println("Student "+student.getName() +" is found");
            oldSystem.markAttendance(student);
        }else{
            throw new IllegalArgumentException("No student match with fingerprint "+fingerPrint);
        }
        SimulateTransientError("Network error");
    }
}
