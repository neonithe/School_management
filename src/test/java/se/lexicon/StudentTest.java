package se.lexicon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StudentTest {

    private Student testStudent;

    @Before
    public void setup(){
        testStudent = new Student(StudentId.nextId(),"TestName","Test@email.com","TestAddress");
    }

    @After
    public void destroy(){
        StudentId.reset();
    }

    @Test
    public void get_fields(){

       int id = testStudent.getId();
       String name = testStudent.getName();
       String email = testStudent.getEmail();
       String address = testStudent.getAddress();

       assertEquals(1, id);
       assertEquals("TestName", name);
       assertEquals("Test@email.com", email);
       assertEquals("TestAddress", address);

    }


}
