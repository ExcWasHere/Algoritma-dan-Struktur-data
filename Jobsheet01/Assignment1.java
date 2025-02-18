package Jobsheet01;

import java.util.Scanner;

public class Assignment1 {
    static char[] CODE = { 'A', 'B', 'D', 'E', 'F', 'G', 'H', 'L', 'N', 'T' };
    static char[][] CITY = {
        {'B', 'A', 'N', 'T', 'E', 'N', ' ', ' ', ' ', ' ', ' ',' '},
        {'J', 'A', 'K', 'A', 'R', 'T', 'A', ' ', ' ', ' ', ' ',' '},
        {'B', 'A', 'N', 'D', 'U', 'N', 'G', ' ', ' ', ' ', ' ',' '},
        {'C', 'I', 'R', 'E', 'B', 'O', 'N', ' ', ' ', ' ', ' ',' '},
        {'B', 'O', 'G', 'O', 'R', ' ', ' ', ' ', ' ', ' ', ' ',' '},
        {'P', 'E', 'K', 'A', 'L', 'O', 'N', 'G', 'A', 'N', ' ',' '},
        {'S', 'E', 'M', 'A', 'R', 'A', 'N', 'G', ' ', ' ', ' ',' '},
        {'S', 'U', 'R', 'A', 'B', 'A', 'Y', 'A', ' ', ' ', ' ',' '},
        {'M', 'A', 'L', 'A', 'N', 'G', ' ', ' ', ' ', ' ', ' ',' '},
        {'T', 'E', 'G', 'A', 'L', ' ', ' ', ' ', ' ', ' ', ' ',' '},
       
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Plate Number Code: ");
        char input = sc.next().toUpperCase().charAt(0);

        
        for (int i = 0; i < CODE.length; i++) {
            if (input == CODE[i]) {
                System.out.print("Car with Plate number Code " + CODE[i] + " is from ");
                for (int j = 0; j<CITY[i].length; j++) {
                    System.out.print(CITY[i][j]);
                }
                sc.close();
                return;
            }
            
        }
        System.out.println("Plate Number Code is not found");
        sc.close();
    }
}
