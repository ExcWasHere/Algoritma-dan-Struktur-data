package Jobsheet01;
import java.util.ArrayList;
import java.util.Scanner;

public class Tugas3_3 {
   public static class MataKuliah {
        String nama;
        double nilaiAngka;
        int bobotSKS;
        String nilaiHuruf;
        double nilaiSetara;

        public MataKuliah(String nama, double nilaiAngka, int bobotSKS) {
            this.nama = nama;
            this.nilaiAngka = nilaiAngka;
            this.bobotSKS = bobotSKS;
            this.nilaiHuruf = hitungNilaiHuruf(nilaiAngka);
            this.nilaiSetara = hitungNilaiSetara(nilaiAngka);
        }
    }

    public static String hitungNilaiHuruf(double nilai) {
        if (nilai >= 80 && nilai <= 100) return "A";
        else if (nilai > 73 && nilai <= 80) return "B+";
        else if (nilai > 65 && nilai <= 73) return "B";
        else if (nilai > 60 && nilai <= 65) return "C+";
        else if (nilai > 50 && nilai <= 60) return "C";
        else if (nilai > 39 && nilai <= 50) return "D";
        else return "E";
    }

    public static double hitungNilaiSetara(double nilai) {
        if (nilai >= 80 && nilai <= 100) return 4.0;
        else if (nilai > 73 && nilai <= 80) return 3.5;
        else if (nilai > 65 && nilai <= 73) return 3.0;
        else if (nilai > 60 && nilai <= 65) return 2.5;
        else if (nilai > 50 && nilai <= 60) return 2.0;
        else if (nilai > 39 && nilai <= 50) return 1.0;
        else return 0.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<MataKuliah> mataKuliahs = new ArrayList<>();

        System.out.println("Program Menghitung IP Semester");
        System.out.println("=============================\n");

        while (true) {
            System.out.print("Masukkan nama mata kuliah (atau 'selesai' untuk mengakhiri): ");
            String nama = scanner.nextLine();
            
            if (nama.toLowerCase().equals("selesai")) break;

            System.out.print("Masukkan nilai Angka untuk MK " + nama + ": ");
            double nilaiAngka = Double.parseDouble(scanner.nextLine());

            System.out.print("Masukkan bobot SKS untuk MK " + nama + ": ");
            int bobotSKS = Integer.parseInt(scanner.nextLine());

            mataKuliahs.add(new MataKuliah(nama, nilaiAngka, bobotSKS));
        }
        System.out.println("\nHasil Konversi Nilai");
        System.out.println("===================");
        System.out.printf("%-35s %-12s %-12s %-12s%n", "MK", "Nilai Angka", "Nilai Huruf", "Bobot Nilai");
        double totalNilaiKali = 0;
        int totalSKS = 0;

        for (MataKuliah mk : mataKuliahs) {
            System.out.printf("%-35s %-12.2f %-12s %-12.2f%n", 
                mk.nama, mk.nilaiAngka, mk.nilaiHuruf, mk.nilaiSetara);
            
            totalNilaiKali += (mk.nilaiSetara * mk.bobotSKS);
            totalSKS += mk.bobotSKS;
        }

        double ipSemester = totalNilaiKali / totalSKS;
        System.out.println("===================");
        System.out.printf("IP : %.2f%n", ipSemester);

        scanner.close();
    }
}
