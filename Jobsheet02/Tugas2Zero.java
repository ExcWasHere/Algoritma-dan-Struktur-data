package Jobsheet02;

public class Tugas2Zero {
static String NIM;
static String Name;
static String className;
static double IPK;

public Tugas2Zero(String id, String name, String cls, double ipk){
    NIM = id;
    Name = name;
    className = cls;
    IPK = ipk;
}

    static void printData(){
        System.out.println("NIM: " + NIM);
        System.out.println("Name: " + Name);
        System.out.println("Class: " + className);
        System.out.println("IPK: " + IPK);
    }

    void changeClass(String newClassString){
        className = newClassString;
    }

    void updateIPK(double newIPK){
        if (IPK >= 0.0 && IPK <= 4.0) {
            IPK = newIPK;
        } else {
            System.out.println("IPK is Invalid!, IPK must be between 0.0 - 4.0");
        }
    }

    String evaluate(){
        if (IPK >= 3.5) {
            return "Cumlaude";
        } else if (IPK >= 3.0) {
            return "Good";
        } else if (IPK >= 2.0) {
            return "Fair";
        } else {
            return "Poor";
        }
    }
}
