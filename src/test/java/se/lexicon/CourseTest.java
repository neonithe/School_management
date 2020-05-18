package se.lexicon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class CourseTest {

    private Course testCourse;
    private Student testStudent;

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

}
