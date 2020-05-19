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
            if(student.getEmail() == email) {
                return student;
            }}
        return null;
    }
    @Override
    public List<Student> findByName(String name) {
        List<Student> tempArray = new ArrayList<>();
            for(Student student : students){
                if(student.getName() == name){
                    tempArray.add(student);
                }
            }
        return tempArray;
    }
    @Override
    public Student findById(int id) {
        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }return null;
    }
    @Override
    public boolean deleteStudent(Student student) {
        students.remove(student);
        return true;
    }


}
