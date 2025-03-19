package Jobsheet05;

import java.util.Scanner;

public class BruteForceDivideConquer {
    int factorialBF(int n) {
        int fakto = 1;
        for (int i = 1; i <= n; i++) {
            fakto = fakto * i;
        }
        return fakto;
    }

    int factorialDC(int n) {
        if (n == 1) {
            return 1;
        } else {
            int fakto = n * factorialDC(n - 1);
            return fakto;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Number: ");
        int num = sc.nextInt();

        System.out.println(
                "The factorial of " + num + " using Brute Force is: " + new BruteForceDivideConquer().factorialBF(num));
        System.out.println("The factorial of " + num + " using Divide and Conquer is: "
                + new BruteForceDivideConquer().factorialDC(num));
    }
}
