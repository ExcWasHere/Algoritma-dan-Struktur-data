package Jobsheet03;

public class Lecturer11 {
    String name, id;
    int age;
    boolean isMale;

    public Lecturer11(String name, String id, int age, boolean isMale) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.isMale = isMale;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + (isMale ? "Male" : "Female"));
        System.out.println("Age: " + age);
        System.out.println("------------------------");
    }
}