package Jobsheet12;

public class SingleLinkedList {
    public static class Student {
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
        Node next;

        public Node() {
        }

        public Node(Student data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node head;
    Node tail;

    boolean isEmpty() {
        return (head == null);
    }

    void print() {
        if (!isEmpty()) {
            Node tmp = head;
            System.out.println("LinkedList Data:");
            while (tmp != null) {
                tmp.data.print();
                tmp = tmp.next;
            }
        } else {
            System.out.println("LinkedList is empty!!");
        }
    }

    void addFirst(Student std) {
        Node newNode = new Node(std, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void addLast(Student std) {
        Node newNode = new Node(std, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    void insertAfter(Student std, String key) {
        Node newNode = new Node(std, null);
        Node temp = head;
        do {
            if (temp.data.name.equalsIgnoreCase(key)) {
                newNode.next = temp.next;
                temp.next = newNode;
                if (newNode.next == null) {
                    tail = newNode;
                }
                break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    public void insertAt(int index, Student std) {
        if (index < 0) {
            System.out.println("Wrong index!!");
        } else if (index == 0) {
            addFirst(std);
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = new Node(std, temp.next);
            if (temp.next.next == null) {
                tail = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        Student std1 = new Student("001", "Student 1", "TI-1I", 3.89);
        Student std2 = new Student("002", "Student 2", "TI-1I", 3.45);
        Student std3 = new Student("003", "Student 3", "TI-1I", 3.20);
        Student std4 = new Student("004", "Student 4", "TI-1I", 3.00);
        sll.print();
        sll.addFirst(std4);
        sll.print();
        sll.addLast(std1);
        sll.print();
        sll.insertAfter(std3, "Student 4");
        sll.insertAt(2, std2);
        sll.print();
    }
}
