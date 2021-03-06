package se.lexicon;

public class Student {

    private int id;
    private String name;
    private String email;
    private String address;

    /*** CONSTRUCTOR ***/
    public Student(int id, String name, String email, String address) {
        this.id = id;
        setName(name);
        setEmail(email);
        setAddress(address);
    }

    /*** GETTERS AND SETTERS ***/
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student:  Id: " + id + " | Name: " + name + " | Email: " + email + " | Address: " + address;

    }
}
