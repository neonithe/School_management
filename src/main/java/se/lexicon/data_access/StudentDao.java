package se.lexicon.data_access;

import se.lexicon.Student;

import java.util.List;

public interface StudentDao {

    Student saveStudent(Student student);
    Student findByEmail(String email);
    List<Student> findByName(String name);
    Student findById(int id);
    boolean deleteStudent(Student student);

}