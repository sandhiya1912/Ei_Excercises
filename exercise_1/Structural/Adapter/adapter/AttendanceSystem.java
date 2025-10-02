package exercise_1.Structural.Adapter.adapter;
import exercise_1.Structural.Adapter.model.Student;

import java.util.*;

public interface AttendanceSystem {
    void MarkAttendanceByFingerPrint(Map<String,Student> students, String fingerPrint);
}
