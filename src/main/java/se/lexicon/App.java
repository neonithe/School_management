package se.lexicon;

import se.lexicon.data_access.StudentDao;
import se.lexicon.data_access.StudentDaoList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 ** Hello world!
 **/
public class App
{

    private List<Student> students = new ArrayList<>();

    public static void main( String[] args )
    {

        StudentDao test = new StudentDaoList();
        Student student0 = new Student(StudentId.nextId(),"Test","@Email","Address");
        Student student1 = new Student(StudentId.nextId(),"Test","@Email2","Address");
        Student student2 = new Student(StudentId.nextId(),"Test","@Email3","Address");
        Student student3 = new Student(StudentId.nextId(),"Test","@Email4","Address");
        Student student4 = new Student(StudentId.nextId(),"Test","@Email5","Address");
        Course course = new Course(CourseId.nextId(),"Test", LocalDate.parse("2020-04-06"),7);

        // course.register(student);
        test.saveStudent(student0);
        test.saveStudent(student1);
        test.saveStudent(student2);
        test.saveStudent(student3);
        test.saveStudent(student4);

        System.out.println(test.findByEmail("@Email4").getId());
        test.findByEmail("Kebab");

    }

}
