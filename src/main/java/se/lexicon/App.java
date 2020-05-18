package se.lexicon;

import java.time.LocalDate;

/**
 ** Hello world!
 **/
public class App
{
    public static void main( String[] args )
    {

        Student student = new Student(StudentId.nextId(),"Test","@Email","Address");
        Course course = new Course(CourseId.nextId(),"Test", LocalDate.parse("2020-04-06"),7);

        // course.register(student);
        System.out.println(student.getAddress());


    }
}
