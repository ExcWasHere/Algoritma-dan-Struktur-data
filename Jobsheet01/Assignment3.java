package Jobsheet01;

import java.util.Scanner;

public class Assignment3 {
    public static void displayCoursesbyDay(int[] courseNumb, String[] courseName, int[] semester, int[] creditHours,
            String[] lectureDay, int input, String day) {
        System.out.println("\nCourses on " + day + ":");
        boolean found = false;
        System.out.printf("%-3s %-50s %-14s %-10s %-10s\n", "No", "Course Name", "Credit Hours", "Semester",
                            "Lecture Day");
        for (int i = 0; i < input; i++) {
            if (lectureDay[i].equalsIgnoreCase(day)) {
                System.out.printf("%-3s %-50s %-14s %-10s %-10s\n", (i+1), courseName[i], creditHours[i],
                        semester[i], lectureDay[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No courses found on " + day + ".");
        }
    }
    public static void displayCoursesbySemester(int[] courseNumb, String[] courseName, int[] semester, int[] creditHours, String[] lectureDay, int input, int semesterSearch) {
        System.out.println("\nCourses in Semester " + semesterSearch + ":");
        boolean found = false;
        System.out.printf("%-3s %-50s %-14s %-10s %-10s\n", "No", "Course Name", "Credit Hours", "Semester",
                            "Lecture Day");
        for (int i = 0; i < input; i++) {
            if (semester[i] == semesterSearch) {
                System.out.printf("%-3s %-50s %-14s %-10s %-10s\n", (i+1), courseName[i], creditHours[i],
                semester[i], lectureDay[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No courses found in Semester " + semesterSearch + ".");
        }
    }
    public static void searchCourse(int[] courseNumb, String[] courseName, int[] semester, int[] creditHours, String[] lectureDay, int input, String searchName) {
        System.out.println("\nSearching for Course: " + searchName);
        boolean found = false;
        System.out.printf("%-3s %-50s %-14s %-10s %-10s\n", "No", "Course Name", "Credit Hours", "Semester",
        "Lecture Day");
        for (int i = 0; i < input; i++) {
            if (courseName[i].equalsIgnoreCase(searchName)) {
                System.out.printf("%-3s %-50s %-14s %-10s %-10s\n", (i+1), courseName[i], creditHours[i],
                semester[i], lectureDay[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Course '" + searchName + "' not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Number of course you take: ");
        int input = sc.nextInt();
        int[] courseNumb = new int[input];
        String[] courseName = new String[input];
        int[] creditHours = new int[input];
        int[] semester = new int[input];
        String[] lectureDay = new String[input];

        for (int i = 0; i < courseNumb.length; i++) {
            courseNumb[i] = i + 1;
            System.out.print("Input Semester: ");
            semester[i] = sc.nextInt();
            sc.nextLine();
            System.out.print("Input Course Name: ");
            courseName[i] = sc.nextLine();
            System.out.print("Input Credit Hours: ");
            creditHours[i] = sc.nextInt();
            sc.nextLine();
            System.out.print("Input Lecture Day: ");
            lectureDay[i] = sc.nextLine();
            System.out.println("======================");

        }
        while (true) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Display All Course");
            System.out.println("2. Display Course by Lecture Day");
            System.out.println("3. Display Course by Semester");
            System.out.println("4. Search for Course by Name");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println(
                            "====================================================================================================");
                    System.out.printf("%-3s %-50s %-14s %-10s %-10s\n", "No", "Course Name", "Credit Hours", "Semester",
                            "Lecture Day");

                    for (int i = 0; i < courseNumb.length; i++) {
                        System.out.printf("%-3s %-50s %-14s %-10s %-10s\n", courseNumb[i], courseName[i],
                                creditHours[i], semester[i], lectureDay[i]);
                    }
                    break;
                case 2:
                    System.out.print("Enter Lecture Day: ");
                    String day = sc.nextLine();
                    displayCoursesbyDay(courseNumb, courseName, semester, creditHours, lectureDay, input, day);
                    break;
                case 3:
                    System.out.print("Enter Semester: ");
                    int semesterSearch = sc.nextInt();
                    displayCoursesbySemester(courseNumb, courseName, semester, creditHours, lectureDay, input, semesterSearch);
                    break;
                case 4:
                    System.out.print("Enter Course Name: ");
                    String searchName = sc.nextLine();
                    searchCourse(courseNumb, courseName, semester, creditHours, lectureDay, input, searchName);
                    break;
                case 5:
                    System.out.println("Exiting Program");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Option. Please Try Again");
                    break;
            }
        }

    }
}
