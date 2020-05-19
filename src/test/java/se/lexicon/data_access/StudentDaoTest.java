package se.lexicon.data_access;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.Student;
import se.lexicon.StudentId;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentDaoTest {

    private StudentDao testInterface = new StudentDaoList();


    @Before
    public void setup(){
       Student testStudent = new Student(StudentId.nextId(),"Test1","Test1mail","Test1Adress");
       Student testStudent1 = new Student(StudentId.nextId(),"Test2","Test2mail","Test2Adress");
       Student testStudent2 = new Student(StudentId.nextId(),"Test3","Test3mail","Test3Adress");
       testInterface.saveStudent(testStudent);
       testInterface.saveStudent(testStudent1);
       testInterface.saveStudent(testStudent2);
    }

    @After
    public void destroy(){
        StudentId.reset();
    }

    @Test
    public void add_student(){

        Student testStudent = new Student(4,"Test1Local","Test1Local","Test1Local");
        //Expected getid =4
        int actual = testInterface.saveStudent(testStudent).getId();

        assertEquals(4,actual);

    }
    @Test
    public void find_students_email_return_right_id(){

        //Should find id 1
        int actual = testInterface.findByEmail("Test1mail").getId();

        assertEquals(1,actual);


    }
    @Test
    public void find_by_name_return_length_of_list(){

        //Return right size of the List
        int actual = testInterface.findByName("Test1").size();

       // assertEquals(1,actual);

    }
    @Test
    public void find_by_id_return_name_of_id(){

        String actual = testInterface.findById(1).getName();

        assertEquals("Test1",actual);

    }
    @Test
    public void delete_from_List_return_true(){

        Student testStudent = new Student(5,"Deleted","Deleted","Deleted");

        assertTrue(testInterface.deleteStudent(testStudent));

    }




}
