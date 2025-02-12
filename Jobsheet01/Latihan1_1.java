package Jobsheet01;
import java.util.Scanner;

public class Latihan1_1 {
    public static boolean HaudValidasi(double grade) {
        return grade >= 0 && grade <= 100;
    }

    public static String FinalCalculation(double tugas, double quiz, double midterm, double finalterm) {
        if (!HaudValidasi(tugas) || !HaudValidasi(quiz) || !HaudValidasi(midterm) || !HaudValidasi(finalterm)) {
            return "Invalid Grade";
        }
        double TotalGrade = tugas * 0.20 +
                quiz * 0.20 +
                midterm * 0.30 +
                finalterm * 0.40;

        return String.format("%.2f", TotalGrade);
    }

    public static String ConvertIPK(String IPK) {
        if (IPK.equals("Invalid Grade")) {
            return "Invalid Grade";
        }
        double grade = Double.parseDouble(IPK);
        if (grade > 80)
            return "A";
        if (grade > 73)
            return "B+";
        if (grade > 65)
            return "B";
        if (grade > 60)
            return "C+";
        if (grade > 50)
            return "C";
        if (grade > 39)
            return "D";
        return "E";
    }

    public static String ParameterPass(String letterGrade) {
        return switch (letterGrade) {
            case "A", "B+", "B", "C+", "C" -> "Lulus";
            default -> "Gagal";
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("--- Program Hitung IPK by Exc ---");

            System.out.print("Masukkan Nama Mahasiswa: ");
            String mahasiswa = sc.nextLine();

            System.out.print("Masukkan Nilai Tugas: ");
            double tugas = sc.nextDouble();

            System.out.print("Masukkan Nilai Quiz: ");
            double quiz = sc.nextDouble();

            System.out.print("Masukkan Nilai Midterm: ");
            double midterm = sc.nextDouble();

            System.out.print("Masukkan Nilai Finalterm: ");
            double finalterm = sc.nextDouble();

            String IPK = FinalCalculation(tugas, quiz, midterm, finalterm);

            if (IPK.equals("Invalid Grade")) {
                System.out.println("-- Invalid Grade, Masukkan semua nilai dengan benar! (0-100) --");
            } else {
                String Lettergrade = ConvertIPK(IPK);
                String Status = ParameterPass(Lettergrade);

                System.out.println("--- Result ---");
                System.out.println("Nilai Akhir: " + IPK);
                System.out.println("Setara Dengan: " + Lettergrade);
                System.out.println("Mahasiswa atas nama " + mahasiswa + " Dinyatakan: " + Status);
            }
        } catch (Exception e) {
            System.out.println("--- Invalid input: Please enter numeric values ---");
        }
        sc.close();
    }
}