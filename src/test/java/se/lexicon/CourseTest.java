package se.lexicon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.data_access.CourseDao;
import se.lexicon.data_access.CourseDaoList;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class CourseTest {

    private Course testCourse;
    private Student testStudent;
    private CourseDao getCourse = new CourseDaoList();

    @Before
    public void setup(){
        testStudent = new Student(StudentId.nextId(),"Test","Test","Test");
        testCourse = new Course(CourseId.nextId(),"Test", LocalDate.parse("2020-04-06"),7);
    }

    @After
    public void destroy(){
        CourseId.reset();
    }

    @Test
    public void get_fields(){

        int id = testCourse.getId();
        String name = testCourse.getCourseName();
        LocalDate start = testCourse.getStartDate();
        int week = testCourse.getWeekDuration();

        //Expected
        LocalDate date = LocalDate.parse("2020-04-06");

        assertEquals(1, id);
        assertEquals("Test", name);
        assertEquals(date, start);
        assertEquals(7, week);

    }
    @Test
    public void register_student(){


    }
    @Test
    public void add_student_return_size_of_list(){
        // Add students to course
        Student student0 = new Student(StudentId.nextId(),"TestS1","@Email","Address");
        Student student1 = new Student(StudentId.nextId(),"TestS1","@Email2","Address");
        Student student2 = new Student(StudentId.nextId(),"TestS2","@Email3","Address");
        Course course1 = new Course(CourseId.nextId(),"TestC1", LocalDate.parse("2020-04-06"),7);

        getCourse.saveCourse(course1);
        getCourse.saveCourse(course1).register(student0);
        getCourse.saveCourse(course1).register(student1);
        getCourse.saveCourse(course1).register(student2);

        // Return size of list, should be 3
        int actual = course1.getStudents().size();

        assertEquals(3,actual);


    }
    @Test
    public void remove_student_from_list_return_one_less_in_size(){
        // Add students to course
        Student student0 = new Student(StudentId.nextId(),"TestS1","@Email","Address");
        Student student1 = new Student(StudentId.nextId(),"TestS1","@Email2","Address");
        Student student2 = new Student(StudentId.nextId(),"TestS2","@Email3","Address");
        Course course1 = new Course(CourseId.nextId(),"TestC1", LocalDate.parse("2020-04-06"),7);

        getCourse.saveCourse(course1);
        getCourse.saveCourse(course1).register(student0);
        getCourse.saveCourse(course1).register(student1);
        getCourse.saveCourse(course1).register(student2);

        // Return size of list, should be 3 - 1 = 2
        getCourse.saveCourse(course1).unregister(student0);
        int actual = course1.getStudents().size();

        assertEquals(2,actual);
    }

}
