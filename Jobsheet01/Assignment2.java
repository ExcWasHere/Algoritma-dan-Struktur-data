package Jobsheet01;

import java.util.Scanner;

public class Assignment2 {
    public static int calcCubeVolume(Scanner sc) {
        int cubeVolume = 0;
        System.out.print("Enter the length of it's side: ");
        int side = sc.nextInt();
        if (side <= 0) {
            System.out.println("Cannot calculate negative length");
            return 0;
        }
        cubeVolume = side * side * side;
        System.out.println("The volume of a cube with a side length of " + side + " is: " + cubeVolume);
        return cubeVolume;
    }

    public static int calcCubeSurfaceArea(Scanner sc) {
        int cubeSurfaceArea = 0;
        System.out.print("Enter the length of it's side: ");
        int side = sc.nextInt();
        if (side <= 0) {
            System.out.println("Cannot calculate negative length");
            return 0;
        }
        cubeSurfaceArea = (side * side) * 6;
        System.out.println("The surface area of a cube with a side length of " + side + " is: " + cubeSurfaceArea);
        return cubeSurfaceArea;
    }

    public static int calcCubePerimeter(Scanner sc) {
        int cubePerimeter = 0;
        System.out.print("Enter the length of it's side: ");
        int side = sc.nextInt();
        if (side <= 0) {
            System.out.println("Cannot calculate negative length");
            return 0;
        }
        cubePerimeter = side * 12;
        System.out.println(
                "The perimeter (edge length) of a cube with a side length of " + side + " is: " + cubePerimeter);
        return cubePerimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------- MENU ---------------");
        System.out.println("Welcome to Exc Cube Calci!");
        System.out.println("1. Calculate Volume");
        System.out.println("2. Calculate Surface Area");
        System.out.println("3. Calculate Perimeter (Edge Length)");
        System.out.print("Choose an available calculating option: ");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                calcCubeVolume(sc);
                break;
            case 2:
                calcCubeSurfaceArea(sc);
                break;
            case 3:
                calcCubePerimeter(sc);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
}
