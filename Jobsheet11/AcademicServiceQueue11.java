package Jobsheet11;

import java.util.Scanner;

class Student11 {
    public String nim;
    public String name;
    public String studyProgram;
    public String className;
    
    public Student11(String nim, String name, String studyProgram, String className) {
        this.nim = nim;
        this.name = name;
        this.studyProgram = studyProgram;
        this.className = className;
    }
    
    public void print() {
        System.out.println("NIM: " + nim);
        System.out.println("Name: " + name);
        System.out.println("Study Program: " + studyProgram);
        System.out.println("Class Name: " + className);
        System.out.println("--------------------");
    }
}

class StudentQueue {
    public static final int MAX_SIZE = 20;
    public Student11[] queueArray;
    public int front;
    public int rear;
    public int size;
    
    public StudentQueue() {
        queueArray = new Student11[MAX_SIZE];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == MAX_SIZE;
    }
    
    public int size() {
        return size;
    }
    
    public void enqueue(Student11 student) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot add more students.");
            return;
        }
        
        rear = (rear + 1) % MAX_SIZE;
        queueArray[rear] = student;
        size++;
    }
    
    public Student11 dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot remove any student.");
            return null;
        }
        
        Student11 removedStudent = queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % MAX_SIZE;
        size--;
        
        return removedStudent;
    }
    
    public Student11 peek() {
        if (isEmpty()) {
            return null;
        }
        return queueArray[front];
    }
    
    public void displayAll() {
        if (isEmpty()) {
            System.out.println("The queue is empty!");
            return;
        }
        
        System.out.println("Students in the queue:");
        int position = 1;
        int index = front;
        
        for (int i = 0; i < size; i++) {
            System.out.println("Position " + position + ":");
            queueArray[index].print();
            position++;
            index = (index + 1) % MAX_SIZE;
        }
    }
}

public class AcademicServiceQueue11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentQueue queue = new StudentQueue();
        
        int choice;
        
        do {
            System.out.println("\n===== ACADEMIC SERVICE by Exc =====");
            System.out.println("1. Enqueue Student");
            System.out.println("2. Dequeue Student");
            System.out.println("3. Display Front");
            System.out.println("4. Display All Data");
            System.out.println("5. Check Queue Size");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    enqueueStudent(scanner, queue);
                    break;
                case 2:
                    dequeueStudent(queue);
                    break;
                case 3:
                    displayFront(queue);
                    break;
                case 4:
                    queue.displayAll();
                    break;
                case 5:
                    checkQueueSize(queue);
                    break;
                case 0:
                    System.out.println("Thank you for using Academic Service by Exc!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
        } while (choice != 0);
        
        scanner.close();
    }

    public static void enqueueStudent(Scanner scanner, StudentQueue queue) {
        System.out.println("\n=== ENQUEUE STUDENT ===");
        
        if (queue.isFull()) {
            System.out.println("Queue is full! Cannot add more students.");
            return;
        }
        
        System.out.print("Enter NIM: ");
        String nim = scanner.nextLine();
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Study Program: ");
        String studyProgram = scanner.nextLine();
        
        System.out.print("Enter Class Name: ");
        String className = scanner.nextLine();
        
        Student11 newStudent = new Student11(nim, name, studyProgram, className);
        queue.enqueue(newStudent);
        
        System.out.println("Student successfully added to the queue!");
    }
    
    public static void dequeueStudent(StudentQueue queue) {
        System.out.println("\n=== DEQUEUE STUDENT ===");
        
        if (queue.isEmpty()) {
            System.out.println("The queue is empty!");
            return;
        }
        
        Student11 removedStudent = queue.dequeue();
        System.out.println("Student removed from the queue:");
        removedStudent.print();
    }
    
    public static void displayFront(StudentQueue queue) {
        System.out.println("\n=== FRONT OF QUEUE ===");
        
        if (queue.isEmpty()) {
            System.out.println("The queue is empty!");
            return;
        }
        
        System.out.println("The student at the front of the queue is:");
        queue.peek().print();
    }
    
    public static void checkQueueSize(StudentQueue queue) {
        System.out.println("\n=== QUEUE SIZE ===");
        System.out.println("Current queue size: " + queue.size() + " student(s)");
    }
}