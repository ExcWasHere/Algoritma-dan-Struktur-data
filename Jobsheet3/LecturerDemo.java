package Jobsheet3;

import java.util.Scanner;

public class LecturerDemo {
    Lecturer11 data[] = new Lecturer11[5];
    Scanner scanner = new Scanner(System.in);
    int lecturerCount = 0;

    // FORR loop
    public void inputLecturers() {
        // FOR loop
        for (int i = 0; i < data.length; i++) {
            System.out.println("\nEnter details for Lecturer #" + (i + 1) + ":");

            System.out.print("ID: ");
            String id = scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            Boolean isMale = null;
            while (isMale == null) {
                System.out.print("Gender (M/F): ");
                String genderInput = scanner.nextLine().toUpperCase();
                if (genderInput.equals("M")) {
                    isMale = true;
                } else if (genderInput.equals("F")) {
                    isMale = false;
                } else {
                    System.out.println("Invalid input. Please enter M for Male or F for Female.");
                }
            }

            int age = 0;
            boolean validAge = false;
            while (!validAge) {
                try {
                    System.out.print("Age: ");
                    age = Integer.parseInt(scanner.nextLine());
                    if (age > 0) {
                        validAge = true;
                    } else {
                        System.out.println("Age must be a positive number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number for age.");
                }
            }

            data[i] = new Lecturer11(name, id, age, isMale);
            lecturerCount++;

            if (i < data.length - 1) {
                System.out.print("Do you want to add another lecturer? (Y/N): ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    break;
                }
            }
        }

        System.out.println(lecturerCount + " lecturer(s) added successfully!");
    }

    // Method FOREACH loop
    public void displayAllLecturers() {
        if (lecturerCount == 0) {
            System.out.println("No lecturers to display.");
            return;
        }

        System.out.println("\nLecturer Information:");
        System.out.println("========================");

        // FOREACH loop
        for (Lecturer11 lecturer : data) {
            if (lecturer != null) {
                lecturer.displayInfo();
            }
        }
    }

    public void showMenu() {
        int choice = 0;

        do {
            System.out.println("\nLecturer Management System");
            System.out.println("1. Add Lecturers");
            System.out.println("2. Display All Lecturers");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        inputLecturers();
                        break;
                    case 2:
                        displayAllLecturers();
                        break;
                    case 3:
                        System.out.println("Thankyou. Have a Nice Day!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (choice != 3);
    }

    public static void main(String[] args) {
        LecturerDemo demo = new LecturerDemo();
        demo.showMenu();
    }
}