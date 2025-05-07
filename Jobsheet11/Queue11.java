package Jobsheet11;

public class Queue11 {
    public int[] data;
    public int front;
    public int rear;
    public int size;
    public int max;
    
    public Queue11(int max) {
        this.max = max;
        data = new int[max];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public boolean isFull() {
        return size == max;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void enqueue(int dt) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        
        rear = (rear + 1) % max;
        data[rear] = dt;
        size++;
        System.out.println(dt + " is successfully added at index " + rear);
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        
        int dt = data[front];
        front = (front + 1) % max;
        size--;
        return dt;
    }
    
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        
        System.out.println("Front data: " + data[front]);
    }
    
    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        
        System.out.println("Queue elements:");
        int count = 0;
        int i = front;
        
        while (count < size) {
            System.out.println((count + 1) + ". " + data[i]);
            i = (i + 1) % max;
            count++;
        }
        
        System.out.println("Number of elements: " + size);
    }
    
    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Queue has been cleared!");
    }
    
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.print("Input maximum number of data: ");
        int max = scanner.nextInt();
        
        Queue11 queue = new Queue11(max);
        
        int choice = 0;
        
        do {
            displayMenu();
            System.out.print("Input choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Input new data: ");
                    int data = scanner.nextInt();
                    queue.enqueue(data);
                    break;
                    
                case 2:
                    int dequeued = queue.dequeue();
                    if (dequeued != -1) {
                        System.out.println(dequeued);
                    }
                    break;
                    
                case 3:
                    queue.print();
                    break;
                    
                case 4:
                    queue.peek();
                    break;
                    
                case 5:
                    queue.clear();
                    break;
                    
                case 0:
                    System.out.println("Thankyouu and Keep Spiritt!");
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
            
            System.out.println("-------------------------------------");
            
        } while (choice != 0);
        scanner.close();
    }
    
    public static void displayMenu() {
        System.out.println("Available menu:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Clear");
        System.out.println("0. Exit");
        System.out.println("-------------------------------------");
    }
}