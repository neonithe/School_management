package se.lexicon;

import se.lexicon.data_access.CourseDao;
import se.lexicon.data_access.CourseDaoList;
import se.lexicon.data_access.StudentDao;
import se.lexicon.data_access.StudentDaoList;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

/**
 "1: Add course\n" +
 "2: Add student\n" +
 "3: Register student to course\n" +
 "4: Remove student from course\n" +
 "5: Find student\n" +
 "6: Find course\n" +
 "7: Edit student\n" +
 "8: Edit course\n" +
 "0: Exit / Quit\n" +
 "Input:");
 **/

public class Menu {

    private static CourseDao getCourse = new CourseDaoList();
    private static StudentDao getStudent = new StudentDaoList();

    public static Scanner input(){
        Scanner input = new Scanner(System.in);
        return input;
    }
    public static void addCourse(){

        // Input information
        System.out.println("Add a course");
        System.out.print("Enter course name:");
        String name = input().nextLine();
        System.out.print("Enter start date:");
        String date = input().nextLine();
        System.out.print("Enter duration in weeks:");
        int dura = input().nextInt();

        // Add the course & save
        Course course = new Course(CourseId.nextId(),name,LocalDate.parse(date),dura);
        getCourse.saveCourse(course);

        System.out.println("Course saved");

    }
    public static void addStudent(){

        System.out.println("Add student");
        System.out.print("Name: ");
        String name = input().nextLine();
        System.out.print("Email: ");
        String mail = input().nextLine();
        System.out.println("Address: ");
        String adre = input().nextLine();

        Student student = new Student(StudentId.nextId(), name, mail, adre);
        System.out.println("Student added");
    }
    public static void findCourse(){
        boolean runUntil = true;
        int selection = 0;
    do {
        System.out.println("Find Course\n" +
                "1. Find via ID\n" +
                "2. Find by name\n" +
                "3. Find by date\n" +
                "4. Find all\n"+
                "5. Quit / Back");
        System.out.print("Input:");

        selection = input().nextInt();

        switch (selection) {
            case 1:
                System.out.println("Find via ID");
                System.out.print("Id:");
                int selInt = input().nextInt();
                System.out.println(getCourse.findById(selInt).toString());
                break;
            case 2:
                System.out.println("Find by name");
                System.out.print("Name:");
                String selStr = input().nextLine();
                System.out.println(getCourse.findByName(selStr).toString());
                break;
            case 3:
                System.out.println("Find by date");
                System.out.println("Date:");
                LocalDate selDate = LocalDate.parse(input().nextLine());
                System.out.println(getCourse.findByDate(selDate).toString());
                break;
            case 4:
                System.out.println("Find all");
                System.out.println("Here is all the courses");
                getCourse.findAll().forEach(System.out::println);
                break;
            case 5:
                System.out.println("Return to main menu");
                runUntil = false;
            default:
                System.out.println("Unknown selection");
        }
    } while(runUntil);
    }

}
