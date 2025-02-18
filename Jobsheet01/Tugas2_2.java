package Jobsheet01;
import java.util.Scanner;

public class Tugas2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        String lastTwoDigits = nim.substring(nim.length() - 2);
        int n = Integer.parseInt(lastTwoDigits);
        
        if (n < 10) {
            n += 10;
        }
        
        System.out.println("n : " + n);
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i == 6 || i == 10) {
                continue;
            }
            if (i % 2 == 1) {
                output.append("* ");
            } else {
                output.append(i + " ");
            }
        }
        System.out.println(output.toString().trim());
        scanner.close();
    }
}