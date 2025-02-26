package Jobsheet3;

public class RectangleMain {
    public static void main(String[] args) {
        Rectangle[] rectangleArray = new Rectangle[3];
        
        rectangleArray[0] = new Rectangle();
        rectangleArray[0].width = 10;
        rectangleArray[0].length = 50;

        rectangleArray[1] = new Rectangle();
        rectangleArray[1].width = 40;
        rectangleArray[1].length = 120;

        rectangleArray[2] = new Rectangle();
        rectangleArray[2].width = 80;
        rectangleArray[2].length = 100;

        System.out.println("Rectangle 1, width: " + rectangleArray[0].width + " , Length: " + rectangleArray[0].length);
        System.out.println("Rectangle 2, width: " + rectangleArray[1].width + " , Length: " + rectangleArray[1].length);
        System.out.println("Rectangle 3, width: " + rectangleArray[2].width + " , Length: " + rectangleArray[2].length);
    }
}
