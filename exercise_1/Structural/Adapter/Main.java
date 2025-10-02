package exercise_1.Structural.Adapter;

import exercise_1.Structural.Adapter.adaptee.oldAttendenceSystem;
import exercise_1.Structural.Adapter.adapter.NewAttendanceSystem;
import exercise_1.Structural.Adapter.model.Student;
import exercise_1.Utils.AppLogger;
import exercise_1.Utils.TransientException;

import java.util.*;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = AppLogger.getLogger();

    public static void main(String[] args) throws InterruptedException {
        Map<String, Student> students = new HashMap<>();
        students.put("fp#0124",new Student(1, "sandhiya", "fp#0124"));
        students.put("fp#8394",new Student(2,"jasmine","fp#8394"));
        students.put("fp#8012",new Student(3, "aadhi","fp#8012"));

        oldAttendenceSystem oldSystem = new oldAttendenceSystem();
        NewAttendanceSystem newSystem = new NewAttendanceSystem(oldSystem);

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("Attendance System is running...");

        while (running) {
            System.out.println("\nselect option: (Mark | Show | Exit)");
            String choice = sc.nextLine().trim().toUpperCase();

            switch (choice) {
                case "MARK":
                    System.out.print("Enter Fingerprint ID: ");
                    String fingerprint = sc.nextLine().trim();
                    try {
                        newSystem.MarkAttendanceByFingerPrint(students, fingerprint);
                        logger.info("Attendance marked successfully for fingerprint: " + fingerprint);
                        System.out.println("Attendance marked successfully.");
                    } catch (TransientException e) {
                        logger.warning("Transient error occurred: " + e.getMessage());
                        Thread.sleep(2000);
                        System.out.println("Retry after some time...");
                    } catch (IllegalArgumentException e) {
                        logger.warning(e.getMessage());
                        System.out.println("Fingerprint not matched. Try again!");
                    }
                    break;
                case "SHOW":
                    System.out.println("Attendance Records:");
                    for (Student s : students.values()) {
                        System.out.println(s.getName() + " → " + (s.getAttendance() ? "Present" : "Absent"));
                    }
                    break;
                case "EXIT":
                    running = false;
                    System.out.println("Exiting Attendance System.");
                    break;
                default:
                    System.out.println("Invalid option. Please enter MARK, SHOW, or EXIT.");
            }
        }
        sc.close();
    }
}
