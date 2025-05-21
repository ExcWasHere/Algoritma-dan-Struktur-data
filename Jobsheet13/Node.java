class Student {
    String nim, name, className;
    double gpa;

    public Student() {
    }

    public Student(String nm, String nama, String kls, double ip) {
        nim = nm;
        name = nama;
        className = kls;
        gpa = ip;
    }

    void print() {
        System.out.println(nim + " - " + name + " - " + className + " - " + gpa);
    }
}

public class Node {
    Student data;
    Node prev;
    Node next;

    Node() {
    }

    Node(Student data) {
        this.data = data;
        prev = null;
        next = null;
    }

    Node(Node prev, Student data, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

class DoubleLinkedList {
    Node head;
    Node tail;

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(Student data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void addLast(Student data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void insertAfter(String key, Student data) {
        Node newNode = new Node(data);
        Node temp = head;
        while (temp != null) {
            if (temp.data.nim.equalsIgnoreCase(key)) {
                if (temp == tail) {
                    addLast(data);
                } else {
                    newNode.next = temp.next;
                    newNode.prev = temp;
                    temp.next.prev = newNode;
                    temp.next = newNode;
                }
            }
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Insertion failed. Data (" + key + ") notfound!!");
        }
    }

    void print() {
        if (!isEmpty()) {
            Node temp = head;
            while (temp != null) {
                temp.data.print();
                temp = temp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Double linked list is currentlyempty!!");
        }
    }

    public class DoubleLinkedListsMain {
        public static void main(String[] args) {
            DoubleLinkedList dll = new DoubleLinkedList();
            dll.print();
            dll.addFirst(new Student("111", "Anton", "TI-1I", 3.57));
            dll.print();
            dll.addLast(new Student("112", "Prabowo", "TI-1I", 3.7));
            dll.print();
            dll.addFirst(new Student("113", "Herco", "TI-1I", 3.89));
            dll.print();
            dll.insertAfter("111", new Student("114", "Rizki", "TI-1I",
                    3.8));
            dll.print();
            dll.insertAfter("112", new Student("115", "Hanzel", "TI-1I",
                    3.6));
            dll.print();
            dll.insertAfter("120", new Student("116", "Eiyu", "TI-1I",
                    3.4));
            dll.print();
        }
    }
}