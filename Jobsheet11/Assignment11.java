package Jobsheet11;
import java.util.Scanner;

public class Assignment11 {
    static class Student {
        public String nim;
        public String name;
        public String major;
        public String phoneNumber;
        public boolean isApproved;

        public Student(String nim, String name, String major, String phoneNumber) {
            this.nim = nim;
            this.name = name;
            this.major = major;
            this.phoneNumber = phoneNumber;
            this.isApproved = false;
        }

        public String getNim() {
            return nim;
        }

        public String getName() {
            return name;
        }

        public String getMajor() {
            return major;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public boolean isApproved() {
            return isApproved;
        }

        public void setApproved(boolean approved) {
            isApproved = approved;
        }
        public String toString() {
            return "NIM: " + nim + ", Nama: " + name + ", Jurusan: " + major + ", No. HP: " + phoneNumber;
        }
    }

    static class StudentQueue {
        public final int MAX_SIZE = 10;
        public Student[] queue;
        public int front, rear, size;
        public int approvedCount;

        public StudentQueue() {
            queue = new Student[MAX_SIZE];
            front = 0;
            rear = -1;
            size = 0;
            approvedCount = 0;
        }
        public boolean isEmpty() {
            return size == 0;
        }
        public boolean isFull() {
            return size == MAX_SIZE;
        }
        public void enqueue(Student student) {
            if (isFull()) {
                System.out.println("Antrian penuh! Tidak dapat menambahkan mahasiswa baru.");
                return;
            }
            rear = (rear + 1) % MAX_SIZE;
            queue[rear] = student;
            size++;
            System.out.println("Mahasiswa berhasil ditambahkan ke antrian.");
        }
        public void dequeue() {
            if (isEmpty()) {
                System.out.println("Antrian kosong! Tidak ada mahasiswa untuk diproses.");
                return;
            }
            int processCount = Math.min(2, size);
            System.out.println("\nMemproses " + processCount + " mahasiswa:");

            for (int i = 0; i < processCount; i++) {
                Student student = queue[front];
                student.setApproved(true);
                System.out.println((i + 1) + ". " + student.getName() + " (NIM: " + student.getNim() + ") - KRS disetujui!");
                front = (front + 1) % MAX_SIZE;
                size--;
                approvedCount++;
            }
        }
        public void displayAllStudents() {
            if (isEmpty()) {
                System.out.println("Antrian kosong!");
                return;
            }

            System.out.println("\nDaftar Semua Mahasiswa dalam Antrian (" + size + " mahasiswa):");
            int index = front;
            for (int i = 0; i < size; i++) {
                System.out.println((i + 1) + ". " + queue[index].toString());
                index = (index + 1) % MAX_SIZE;
            }
        }
        public void displayFirstTwoStudents() {
            if (isEmpty()) {
                System.out.println("Antrian kosong!");
                return;
            }

            System.out.println("\nDua Mahasiswa Pertama dalam Antrian:");
            int count = Math.min(2, size);
            int index = front;
            
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + queue[index].toString());
                index = (index + 1) % MAX_SIZE;
            }
        }
        public void displayLastStudent() {
            if (isEmpty()) {
                System.out.println("Antrian kosong!");
                return;
            }

            System.out.println("\nMahasiswa Terakhir dalam Antrian:");
            System.out.println(queue[rear].toString());
        }
        public void displayTotalStudents() {
            System.out.println("\nJumlah mahasiswa dalam antrian: " + size);
        }
        public void displayApprovedStudents() {
            System.out.println("Jumlah mahasiswa yang telah menyelesaikan proses persetujuan KRS: " + approvedCount);
        }
        public void displayPendingStudents() {
            int totalCapacity = 30;
            int pendingStudents = totalCapacity - approvedCount;
            if (pendingStudents < 0) pendingStudents = 0;
            System.out.println("Jumlah mahasiswa yang belum menyelesaikan proses persetujuan KRS: " + pendingStudents);
        }
        public void clear() {
            front = 0;
            rear = -1;
            size = 0;
            System.out.println("Antrian berhasil dikosongkan.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentQueue queue = new StudentQueue();
        int choice;

        System.out.println("================================");
        System.out.println("    SIMULASI ANTRIAN KRS");
        System.out.println("  POLITEKNIK NEGERI MALANG");
        System.out.println("================================");

        do {
            System.out.println("\n======== MENU UTAMA ========");
            System.out.println("1. Tambah Mahasiswa ke Antrian");
            System.out.println("2. Proses Persetujuan KRS (2 Mahasiswa)");
            System.out.println("3. Cek Status Antrian");
            System.out.println("4. Tampilkan Semua Mahasiswa");
            System.out.println("5. Tampilkan Dua Mahasiswa Pertama");
            System.out.println("6. Tampilkan Mahasiswa Terakhir");
            System.out.println("7. Informasi Jumlah Mahasiswa");
            System.out.println("8. Kosongkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (queue.isFull()) {
                        System.out.println("Antrian sudah penuh! Maksimum 10 mahasiswa.");
                    } else {
                        System.out.println("\n== Registrasi Mahasiswa ==");
                        System.out.print("NIM: ");
                        String nim = scanner.nextLine();
                        System.out.print("Nama: ");
                        String name = scanner.nextLine();
                        System.out.print("Jurusan: ");
                        String major = scanner.nextLine();
                        System.out.print("Nomor HP: ");
                        String phoneNumber = scanner.nextLine();

                        Student student = new Student(nim, name, major, phoneNumber);
                        queue.enqueue(student);
                    }
                    break;
                
                case 2:
                    queue.dequeue();
                    break;
                
                case 3:
                    System.out.println("\n== Status Antrian ==");
                    if (queue.isEmpty()) {
                        System.out.println("Status: Antrian KOSONG");
                    } else if (queue.isFull()) {
                        System.out.println("Status: Antrian PENUH");
                    } else {
                        System.out.println("Status: Antrian BERISI (tidak kosong dan tidak penuh)");
                    }
                    break;
                
                case 4:
                    queue.displayAllStudents();
                    break;
                
                case 5:
                    queue.displayFirstTwoStudents();
                    break;
                
                case 6:
                    queue.displayLastStudent();
                    break;
                
                case 7:
                    System.out.println("\n== Informasi Jumlah Mahasiswa ==");
                    queue.displayTotalStudents();
                    queue.displayApprovedStudents();
                    queue.displayPendingStudents();
                    break;
                
                case 8:
                    queue.clear();
                    break;
                
                case 0:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;
                
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
            
        } while (choice != 0);
        
        scanner.close();
    }
}