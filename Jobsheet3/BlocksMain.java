package Jobsheet3;

public class BlocksMain {
    public static void main(String[] args) {
        Blocks[] blArray = new Blocks[3];

        blArray[0] = new Blocks(100, 40, 15);
        blArray[1] = new Blocks(200, 50, 10);
        blArray[2] = new Blocks(150, 60, 17);

        for (int i = 0; i < 3; i++) {
            System.out.println("Volume of block " + i + ": " + blArray[i].getVolume());
        }
    }
}
