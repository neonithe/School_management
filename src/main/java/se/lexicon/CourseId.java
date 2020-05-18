package se.lexicon;

public class CourseId {

    private static int courseId;

    /*** ID GENERATOR ***/
    public static int nextId(){
        return ++courseId;
    }

    /*** RESET ***/
    public static void reset(){
        courseId = 0;
    }

}
