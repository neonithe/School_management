package se.lexicon.data_access;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.Course;
import se.lexicon.CourseId;
import se.lexicon.Student;
import se.lexicon.StudentId;

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
        Course testCourse1 = new Course(CourseId.nextId(),"TestC2", LocalDate.parse("2020-02-01"),2);
        Course testCourse2 = new Course(CourseId.nextId(),"TestC3", LocalDate.parse("2023-01-01"),3);
        testInterface.saveCourse(testCourse0); testInterface.saveCourse(testCourse0); testInterface.saveCourse(testCourse0);
        testInterface.saveCourse(testCourse1);
        testInterface.saveCourse(testCourse2);

    }
    @After
    public void destroy(){
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

        //Return length of list
        int actual = testInterface.findByName("TestC1").size();

  /*      for(Course p : testInterface.findByName("TestC1")) {
            System.out.println(p.getCourseName());
        }*/
        System.out.println(actual);
        for(Course pp : testInterface.findAll()){
            System.out.println(pp.getCourseName());
        }


      //  assertEquals(2,actual);

    }
/*    @Test
    public void find_by_id_return_name_of_id(){

        String actual = testInterface.findById(1).getName();

        assertEquals("Test1",actual);

    }
    @Test
    public void delete_from_List_return_true(){

        Student testStudent = new Student(5,"Deleted","Deleted","Deleted");

        assertTrue(testInterface.deleteStudent(testStudent));

    }*/

}
