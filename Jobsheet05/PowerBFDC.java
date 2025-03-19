package Jobsheet05;

import java.util.Scanner;

public class PowerBFDC {
    
    int powerBF(int n, int e) {
        int result = 1;
        for (int i = 0; i < e; i++) {
            result = result * n;
        }
        return result;
    }

    int powerDC(int n, int e) {
        if (e == 1) {
            return n;
        }else{
            if (e % 2 == 0) {
                return (powerDC(n, e / 2) * powerDC(n, e / 2)*n);
            }else{
                return (powerDC(n, e / 2) * powerDC(n, e / 2));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Element: ");
        int elemen = sc.nextInt();
    }

    
}
