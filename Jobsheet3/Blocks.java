package Jobsheet3;

public class Blocks {
    public int width, length, height;

    public Blocks(int p, int l, int t) {
        width = p;
        length = l;
        height = t;
    }

    public int getVolume() {
        return length * width * height;
    }
}
