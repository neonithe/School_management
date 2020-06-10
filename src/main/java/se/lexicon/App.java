package se.lexicon;

import com.sun.deploy.net.MessageHeader;
import se.lexicon.data_access.CourseDao;
import se.lexicon.data_access.CourseDaoList;
import se.lexicon.data_access.StudentDao;
import se.lexicon.data_access.StudentDaoList;
import sun.rmi.server.LoaderHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static se.lexicon.Menu.*;

/**

 • Create new Courses and Students
 • Register and remove Students to/from Courses
 • Finding Students and Courses in various ways
 • Edit Students and Courses

**/
public class App
{
    private static CourseDao getCourse = new CourseDaoList();
    private static StudentDao getStudent = new StudentDaoList();

    public static void main( String[] args ) {

        Course course0 = new Course(CourseId.nextId(), "Test1",LocalDate.parse("2020-01-01"),3);
        Course course1 = new Course(CourseId.nextId(), "Test2",LocalDate.parse("2020-01-02"),4);
        Course course2 = new Course(CourseId.nextId(), "Test3",LocalDate.parse("2020-01-03"),5);
        getCourse.saveCourse(course0);
        getCourse.saveCourse(course1);
        getCourse.saveCourse(course2);

        Student student0 = new Student(StudentId.nextId(),"TestName1","testMail1","TestAddress0");
        Student student1 = new Student(StudentId.nextId(),"TestName2","testMail2","TestAddress1");
        Student student2 = new Student(StudentId.nextId(),"TestName3","testMail3","TestAddress2");
        getStudent.saveStudent(student0);
        getStudent.saveStudent(student1);
        getStudent.saveStudent(student2);

        course0.register(student0);
        course0.register(student1);

        Scanner input = new Scanner(System.in);
        String line = "-----------------------------------------------------------------------------";
        boolean runUntil = true;
        int selection = 0;

        do {
            System.out.println("Menu:\n" +
                    "1: Add course\n" +
                    "2: Add student\n" +
                    "3: Register student to course\n" +
                    "4: Remove student from course\n" +
                    "5: Find student\n" +
                    "6: Find course\n" +
                    "7: Edit student\n" +
                    "8: Edit course\n" +
                    "9: Students on a course\n" +
                    "0: Exit / Quit");
            System.out.print("Input:");

            while (!input.hasNextInt())
            {
                System.out.println("Not valid number");
                System.out.println("Input:");
                input.next();
            }
            selection = input.nextInt();
            switch (selection) {
                case 1:
                    System.out.println(line);
                    addCourse();
                    break;
                case 2:
                    System.out.println(line);
                    addStudent();
                    break;
                case 3:
                    System.out.println(line);
                    addToCourse();
                    break;
                case 4:
                    System.out.println(line);
                    removeFromCourse();
                    break;
                case 5:
                    System.out.println(line);
                    findStudent();
                    break;
                case 6:
                    System.out.println(line);
                    findCourse();
                    break;
                case 7:
                    System.out.println(line);
                    editStudent();
                    break;
                case 8:
                    System.out.println(line);
                    editCourse();
                    break;
                case 9:
                    System.out.println(line);
                    studentCourse();
                    break;
                case 0:
                    System.out.println("Closing application");
                    runUntil = false;
                    break;
                default:
                    System.out.println("Unknown selection, please try again");

            }
        } while(runUntil);
    }
}

/**
 *


 CourseDao getCourse = new CourseDaoList();

 Course course1 = new Course(CourseId.nextId(),"TestC1", LocalDate.parse("2020-04-06"),7);
 Course course2 = new Course(CourseId.nextId(),"TestC1", LocalDate.parse("2020-04-06"),8);
 Course course3 = new Course(CourseId.nextId(),"TestC2", LocalDate.parse("2020-04-08"),9);
 getCourse.saveCourse(course1);
 getCourse.saveCourse(course2);
 getCourse.saveCourse(course3);

 Student student0 = new Student(StudentId.nextId(),"TestS1","@Email","Address");
 Student student1 = new Student(StudentId.nextId(),"TestS1","@Email2","Address");
 Student student2 = new Student(StudentId.nextId(),"TestS2","@Email3","Address");
 // Course course1 = new Course(CourseId.nextId(),"TestC1", LocalDate.parse("2020-04-06"),7);

 getCourse.saveCourse(course1).register(student0);
 getCourse.saveCourse(course1).register(student1);
 getCourse.saveCourse(course1).register(student2);

 System.out.println(course1.getStudents().size());
 // getCourse.saveCourse(course1).unregister(student0);
 System.out.println(course1.getStudents().size());

 for(Student p : course1.getStudents()){
 System.out.println(p.getName());
 }


 List<Student> students = new ArrayList<>();

 Course course1 = new Course(CourseId.nextId(),"TestC1", LocalDate.parse("2020-04-06"),7);
 Course course2 = new Course(CourseId.nextId(),"TestC1", LocalDate.parse("2020-04-07"),8);
 Course course3 = new Course(CourseId.nextId(),"TestC2", LocalDate.parse("2020-04-08"),9);

 Student student0 = new Student(StudentId.nextId(),"TestS1","@Email","Address");
 Student student1 = new Student(StudentId.nextId(),"TestS1","@Email2","Address");
 Student student2 = new Student(StudentId.nextId(),"TestS2","@Email3","Address");

 test.saveStudent(student0); students.add(student0);
 test.saveStudent(student1); students.add(student1);
 test.saveStudent(student2); students.add(student2);

 test1.saveCourse(course1).register(student0);
 test1.saveCourse(course1).register(student1);
 test1.saveCourse(course1).register(student2);

 test1.saveCourse(course1);

 System.out.println(course1.getStudents().size());
 test1.saveCourse(course1).unregister(student0);
 System.out.println(course1.getStudents().size());



 System.out.println(test.findByName("Test"));

 System.out.println(test.findByEmail("@Email4").getId());
 test.findByEmail("Kebab");

 System.out.println(test.findByName("Test").size());
 System.out.println(test.findById(1).getName());


 for(Course p : getCourse.findByDate(LocalDate.parse("2020-04-06"))){
 System.out.println(p.getCourseName());
 }
 System.out.println(getCourse.findByDate(LocalDate.parse("2020-04-06")).size());

 LocalDate date = LocalDate.parse("2020-04-07");

 if(course1.getStartDate().isEqual(date)){
 System.out.println("True");
 System.out.println(date);
 System.out.println(course1.getStartDate());
 }else{
 System.out.println("False");
 }

 //      for(Course p : getCourse.findByName("TestC1")) {
 //        System.out.println(p.getCourseName());
 //  }




 //System.out.println(getCourse.findByName("TestC1").size());

 ******************************************* Old code

 /** NOT A COMMAND LINE USER INTERFACE, BUT SOMETHING ANYWAY **/
    /**

     • Create new Courses and Students
     • Register and remove Students to/from Courses
     • Finding Students and Courses in various ways
     • Edit Students and Courses

 private StudentDao getStudent = new StudentDaoList();
 private CourseDao getCourse = new CourseDaoList();

 System.out.println("Menu:\n" +
 "1: Add course\n" +
 "2: Add student\n" +
 "3: Register student to course\n" +
 "4: Remove student from course\n" +
 "5: Find student\n" +
 "6: Find course\n" +
 "7: Edit student\n" +
 "8: Edit course\n" +
 "Input:");


 }
 public String input(){
 Scanner myObj = new Scanner(System.in);
 return myObj.nextLine();
 }

 public void addCourse(){

 String name ="";
 String date ="";
 int duration =0;

 System.out.println("Enter information");
 System.out.println("Name:");
 name = input();
 System.out.println("Date:");
 date = input();
 System.out.println("Duration:");
 duration = 1;

 Course course = new Course(CourseId.nextId(),name, LocalDate.parse(date),duration);
 getCourse.saveCourse(course);
 System.out.println("Course added");

 }
 public void addStudent(String name, String email, String address){

 Student student = new Student(StudentId.nextId(),name,email,address);
 getStudent.saveStudent(student);
 System.out.println("Student added");

 }
 public void registerStudent(){



 }

 *
 ***/