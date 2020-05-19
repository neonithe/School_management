package se.lexicon.data_access;

import se.lexicon.Course;

import java.time.LocalDate;
import java.util.List;

public class CourseDaoList implements CourseDao{

    private static List <Course> courses;

    @Override
    public Course saveCourse(Course course) {

        return null;
    }
    @Override
    public Course findById(int id) {
        return null;
    }
    @Override
    public List<Course> findByName(String name) {
        return null;
    }
    @Override
    public List<Course> findByDate(LocalDate date) {
        return null;
    }
    @Override
    public List<Course> findAll() {
        return null;
    }
    @Override
    public boolean removeCourse(Course course) {
        return false;
    }
}
