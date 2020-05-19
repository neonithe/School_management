package se.lexicon;

import com.sun.deploy.net.MessageHeader;
import se.lexicon.data_access.StudentDao;
import se.lexicon.data_access.StudentDaoList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 ** Hello world!
 **/
public class App
{

    public static void main( String[] args )
    {

        StudentDao test = new StudentDaoList();
        List<Student> students = new ArrayList<>();

        Course course = new Course(CourseId.nextId(),"Test2", LocalDate.parse("2020-04-06"),7);

        Student student0 = new Student(StudentId.nextId(),"TestAus","@Email","Address");
        Student student1 = new Student(StudentId.nextId(),"Test","@Email2","Address");
        Student student2 = new Student(StudentId.nextId(),"Test2","@Email3","Address");
        Student student3 = new Student(StudentId.nextId(),"Test2","@Email4","Address");
        Student student4 = new Student(StudentId.nextId(),"Test2","@Email5","Address");

        test.saveStudent(student0); students.add(student0);
        test.saveStudent(student1); students.add(student1);
        test.saveStudent(student2); students.add(student2);
        test.saveStudent(student3); students.add(student3);
        test.saveStudent(student4); students.add(student4);

        // course.register(student);
        System.out.println(test.returnList());
        test.deleteStudent(student0);
        test.deleteStudent(student1);
        test.deleteStudent(student2);
        System.out.println(test.returnList());





    }


}
/**
 *

 System.out.println(test.findByName("Test"));

 System.out.println(test.findByEmail("@Email4").getId());
 test.findByEmail("Kebab");

 System.out.println(test.findByName("Test").size());
 System.out.println(test.findById(1).getName());

 *
 ***/