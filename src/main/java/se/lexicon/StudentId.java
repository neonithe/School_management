package se.lexicon;

public class StudentId {

    private static int studentId;

    /*** ID GENERATOR ***/
    public static int nextId(){
        return ++studentId;
    }

    /*** RESET ***/
    public static void reset(){
        studentId = 0;
    }
}
