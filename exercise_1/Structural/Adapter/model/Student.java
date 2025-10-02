package exercise_1.Structural.Adapter.model;

public class Student {
    private final int sid;
    private final String Name;
    private final String fingerPrint;
    private boolean isPresent;

    public Student(int sid,String name,String fingerPrint){
        this.sid = sid;
        this.Name = name;
        this.fingerPrint = fingerPrint;
        this.isPresent = false;
    }
    public int getSid() {
        return sid;
    }
    public String getName(){
        return Name;
    }
    public String getFingerPrint(){
        return fingerPrint;
    }
    public void setAttendance(){
        this.isPresent = true;
    }
    public boolean getAttendance(){
        return isPresent;
    }
}
