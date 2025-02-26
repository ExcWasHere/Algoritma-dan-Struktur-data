package Jobsheet3;
import java.util.Scanner;

public class RectangleMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle[] rectangleArray = new Rectangle[3];
        
        for (int i = 0; i < 3; i++) {
            rectangleArray[i] = new Rectangle();
            System.out.print("Rectangle " + i);

            System.out.print(" Input Length: ");
            rectangleArray[i].length = sc.nextInt();

            System.out.print(" Input width: ");
            rectangleArray[i].width = sc.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Rectangle " + i);
            System.out.println("Length: " + rectangleArray[0].length + " , Width: " + rectangleArray[0].width);
        }
    }
}
