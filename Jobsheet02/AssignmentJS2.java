package Jobsheet02;

public class AssignmentJS2 {
static String Course;
static String Name;
static int credit;
static int hour;

public AssignmentJS2(String id, String name, int crdt, int Hour){
    Course = id;
    Name = name;
    credit = crdt;
    hour = Hour;
}

    static void printData(){
        System.out.println("Course: " + Course);
        System.out.println("Name: " + Name);
        System.out.println("SKS: " + credit);
        System.out.println("Hour: " + hour);
    }

    static void changeCredit(int newCredit){
        credit = newCredit;
    }

    static void addHour(int additionalHour){
        hour += additionalHour;
    }

    static void reducedHour(int reducedHour){
        hour -= reducedHour;
    }
}
