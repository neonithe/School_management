package se.lexicon.data_access;

import se.lexicon.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoList implements CourseDao{

    private static List <Course> courses = new ArrayList<>();

    @Override
    public Course saveCourse(Course course) {
            courses.add(course);
        return course;
    }
    @Override
    public Course findById(int id) {
        for(Course course : courses){
            if(course.getId() == id){
                return course;
            }
        }return null;
    }
    @Override
    public List<Course> findByName(String name) {
        List<Course> tempArray = new ArrayList<>();
        for(Course course : courses){
            if(course.getCourseName() == name){
                tempArray.add(course);
            }
        }
        return tempArray;
    }
    @Override
    public List<Course> findByDate(LocalDate date) {
      List<Course> tempArray = new ArrayList<>();
        for(Course course : courses){
            if(course.getStartDate().isEqual(date)){
                tempArray.add(course);
            }
        }
        return tempArray;
    }
    @Override
    public List<Course> findAll() {
        return courses;
    }
    @Override
    public boolean removeCourse(Course course) {
        courses.remove(course);
        return true;
    }


}
