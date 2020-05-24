package se.lexicon.data_access;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.Course;
import se.lexicon.CourseId;
import se.lexicon.Student;
import se.lexicon.StudentId;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CourseDaoTest {

    /**  **/
    private CourseDao testInterface = new CourseDaoList();

    @Before
    public void setup(){
        Course testCourse0 = new Course(CourseId.nextId(),"TestC1", LocalDate.parse("2020-01-01"),1);
        Course testCourse1 = new Course(CourseId.nextId(),"TestC2", LocalDate.parse("2023-01-01"),2);
        Course testCourse2 = new Course(CourseId.nextId(),"TestC3", LocalDate.parse("2023-01-01"),3);
        testInterface.saveCourse(testCourse0); testInterface.saveCourse(testCourse0); testInterface.saveCourse(testCourse0);
        testInterface.saveCourse(testCourse1);
        testInterface.saveCourse(testCourse2);

    }
    @After
    public void destroy(){
        testInterface.findAll().clear();
        CourseId.reset();

    }
    @Test
    public void add_student(){

        Course testCourse3 = new Course(4,"TestC4",LocalDate.parse("2020-01-04"),4);

        //Expected getid =4
        int actual = testInterface.saveCourse(testCourse3).getId();

        assertEquals(4,actual);

    }
    @Test
    public void find_by_id_return_right_name(){

        //Should find id 1
        String actual = testInterface.findById(1).getCourseName();

        assertEquals("TestC1",actual);


    }
    @Test
    public void find_by_name_return_length_of_list(){

        //Return length of list should be 3 of TestC1
        int actual = testInterface.findByName("TestC1").size();

        System.out.println(actual);
        for(Course pp : testInterface.findAll()){
            System.out.println(pp.getCourseName());
        }

        assertEquals(3,actual);

    }
   @Test
    public void find_by_date_return_name_of_id() {

       // Result should be : 2 in size
       int actual = testInterface.findByDate(LocalDate.parse("2023-01-01")).size();

       assertEquals(2, actual);
   }
    @Test
    public void find_all_return_number_of_list(){

        //Should return all courses is 5
       int actual = testInterface.findAll().size();

       assertEquals(5,actual);

    }
    @Test
    public void delete_from_List_return_true(){

        Course testCourse = new Course(5,"Deleted",LocalDate.parse("2020-01-01"),1);

        assertTrue(testInterface.removeCourse(testCourse));

    }

}
