package se.lexicon.data_access;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import se.lexicon.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao{

    private static List<Student> students = new ArrayList<>();


    @Override
    public Student saveStudent(Student student) {
            students.add(student);
        return student;
    }
    @Override
    public Student findByEmail(String email) {
        for(Student student : students){
            if(students.contains(email)) {
                return student;
            }}
        return null;
    }
    @Override
    public List<Student> findByName(String name) {
        return null;
    }
    @Override
    public Student findById(int id) {
        return null;
    }
    @Override
    public boolean deleteStudent(Student student) {
        return false;
    }
    @Override
    public void find(String email) {
        for(Student p : students) {
            if (p.getEmail() == email) {
                System.out.println("Found him");
            }
        }
    }

}
