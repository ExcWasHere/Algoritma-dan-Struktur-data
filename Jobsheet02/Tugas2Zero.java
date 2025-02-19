package Jobsheet02;

public class Tugas2Zero {
static String NIM;
static String Name;
static String className;
static double IPK;

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
        IPK = newIPK;
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
