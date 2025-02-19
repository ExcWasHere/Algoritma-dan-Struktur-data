package Jobsheet02;

public class LecturerBahan {
    static String lectureID;
    static String Name;
    static boolean status;
    static int startYear;
    static String expertiseField;

    public LecturerBahan(String id, String name, boolean Status, int year, String expert){
        lectureID = id;
        Name = name;
        status = Status;
        startYear = year;
        expertiseField = expert;
    }

    static void printData(){
        System.out.println("Lecture ID: " + lectureID);
        System.out.println("Name: " + Name);
        System.out.println("Status (true/false = active/inactive): " + status);
        System.out.println("Start Join: " + startYear);
        System.out.println("Expertise Field: " + expertiseField);
    }

    static void setStatus(boolean status){
        if (status = true) {
            System.out.println("Status: The Lecture is Active");
        } else {
            System.out.println("Status: The Lecture is Inactive");
        }
    }

    static void calculateTenure(int yearNow){
        int tenure = yearNow - startYear;
        System.out.println("Tenure: " + tenure);
    }

    static void changeExpertise(String newExpertise){
        expertiseField = newExpertise;
    }
}
