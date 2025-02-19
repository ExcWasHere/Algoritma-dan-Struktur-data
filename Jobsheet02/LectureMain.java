package Jobsheet02;

public class LectureMain {
    public static void main(String[] args) {
        LecturerBahan Lecture1 = new LecturerBahan(null, null, false, 0, null);
        Lecture1.lectureID = "L001";
        Lecture1.Name = "Mr. Afif";
        Lecture1.status = true;
        Lecture1.startYear = 2010;
        Lecture1.calculateTenure(2025);
        Lecture1.expertiseField = "Database Progamming";
        Lecture1.printData();

        LecturerBahan Lecture2 = new LecturerBahan("P002", "Mrs. Adevian", true, 2015, "Data Scientist");
        Lecture2.calculateTenure(2025);
        Lecture2.printData();
    }
}
