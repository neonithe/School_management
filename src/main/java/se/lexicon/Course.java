package se.lexicon;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {

    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students = new ArrayList<>();

    /*** CONSTRUCTOR ***/
    public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
        this.id = id;
        setCourseName(courseName);
        setStartDate(startDate);
        setWeekDuration(weekDuration);

    }

    /*** GETTERS AND SETTERS ***/
    public int getId() {
        return id;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public int getWeekDuration() {
        return weekDuration;
    }
    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }
    public List<Student> getStudents() {
        return students;
    }

    /*** REGISTER AND REMOVE STUDENTS ***/
    public void register(Student student){
        students.add(student);
    }
    public void unregister(Student student){
        students.remove(student);
    }


}
