package Jobsheet10;

import java.util.Scanner;

class Student {
    public String nim;
    public String name;
    public String className;
    public int grade;
    
    public Student(String nim, String name, String className, int grade) {
        this.nim = nim;
        this.name = name;
        this.className = className;
        this.grade = grade;
    }
    
    public Student(String nim, String name, String className) {
        this.nim = nim;
        this.name = name;
        this.className = className;
        this.grade = 0;
    }
    
    public String getNim() {
        return nim;
    }
    
    public String getName() {
        return name;
    }
    
    public String getClassName() {
        return className;
    }
    
    public int getGrade() {
        return grade;
    }
    
    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    public String getGradeBinary() {
        return Integer.toBinaryString(grade);
    }
}

class StudentAssignmentStack {
    public Student[] stack;
    public int size;
    public int top;
    
    public StudentAssignmentStack(int size) {
        this.size = size;
        this.stack = new Student[size];
        this.top = -1;
    }
    
    public boolean isFull() {
        return top == size - 1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public void push(Student student) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot submit more assignments.");
            return;
        }
        stack[++top] = student;
    }
    
    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No assignments to grade.");
            return null;
        }
        return stack[top--];
    }
    
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No assignments to view.");
            return null;
        }
        return stack[top];
    }
    
    public void print() {
        if (isEmpty()) {
            System.out.println("No assignments submitted yet.");
            return;
        }
        
        System.out.println("All submitted assignments:");
        for (int i = top; i >= 0; i--) {
            Student student = stack[i];
            System.out.println("Name: " + student.getName() + 
                               ", NIM: " + student.getNim() + 
                               ", Class Name: " + student.getClassName() +
                               ", Grade: " + (student.getGrade() == 0 ? "Not graded yet" : student.getGrade()));
        }
    }
}

public class ConvertionBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentAssignmentStack stack = new StudentAssignmentStack(27);
        while (true) {
            displayMenu();
            System.out.print("Choose a menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    submitAssignment(scanner, stack);
                    break;
                case 2:
                    gradeAssignment(scanner, stack);
                    break;
                case 3:
                    viewTopAssignment(stack);
                    break;
                case 4:
                    viewAllAssignments(stack);
                    break;
                case 5:
                    System.out.println("Thankyou and have a nice day ^_^. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static void displayMenu() {
        System.out.println("\nMenu LMS Polinema:");
        System.out.println("1. Submit Assignment");
        System.out.println("2. Grade Assignment");
        System.out.println("3. View Top Assignment");
        System.out.println("4. View All Assignments");
        System.out.println("5. Exit");
    }
    
    public static void submitAssignment(Scanner scanner, StudentAssignmentStack stack) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("NIM: ");
        String nim = scanner.nextLine();
        
        System.out.print("Class Name: ");
        String className = scanner.nextLine();
        
        Student student = new Student(nim, name, className);
        stack.push(student);
        
        System.out.println(name + "'s assignment has been successfully submitted!!");
    }
    
    public static void gradeAssignment(Scanner scanner, StudentAssignmentStack stack) {
        if (stack.isEmpty()) {
            System.out.println("No assignments to grade.");
            return;
        }
        
        Student student = stack.peek();
        System.out.println("Grading assignment from " + student.getName());
        System.out.print("Input grade (0-100): ");
        int grade = scanner.nextInt();
        scanner.nextLine();
        
        student.setGrade(grade);
        
        System.out.println("Assignment grade of " + student.getName() + " is " + grade);
        System.out.println("Assignment grade in binary is " + student.getGradeBinary());
    }
    
    public static void viewTopAssignment(StudentAssignmentStack stack) {
        if (stack.isEmpty()) {
            System.out.println("No assignments to view.");
            return;
        }
        
        Student student = stack.peek();
        System.out.println("Top assignment:");
        System.out.println("Name: " + student.getName());
        System.out.println("NIM: " + student.getNim());
        System.out.println("Class Name: " + student.getClassName());
        
        if (student.getGrade() > 0) {
            System.out.println("Grade: " + student.getGrade());
            System.out.println("Grade in binary: " + student.getGradeBinary());
        } else {
            System.out.println("Grade: Not graded yet");
        }
        
        System.out.println("The last assignment comes from " + student.getName());
    }
    
    public static void viewAllAssignments(StudentAssignmentStack stack) {
        stack.print();
    }
}