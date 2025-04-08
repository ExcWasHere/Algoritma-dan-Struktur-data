package Quiz;

public class SmartHomeMain {
    public static void main(String[] args) {
         SmartHomeDevice[] SmartDevice = new SmartHomeDevice[3];
         SmartDevice[0] = new SmartHomeDevice("Lamp", 15, 30, 0, 0);
         SmartDevice[1] = new SmartHomeDevice("Kulkas", 30, 40, 0, 0);
         SmartDevice[2] = new SmartHomeDevice("Tv", 25, 50, 0, 0);
         SmartHomeDevice.Average(0);
    }

}
