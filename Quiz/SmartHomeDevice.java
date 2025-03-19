package Quiz;

public class SmartHomeDevice {
public static String Name;
public    static double KonsumsiPower;
public    static double standbyPower;
public    static double hasilEnergiAktual;
public    static double persentaseEnergi;

    public SmartHomeDevice(){

    }

    public SmartHomeDevice(String name, double KonsumsiPower, double standbyPower, double hasilEnergiAktual, double persentasiEnergi){
        Name = name;
        this.KonsumsiPower = KonsumsiPower;
        this.standbyPower = standbyPower;
        totalEnergiAktual(hasilEnergiAktual);
        rasioEfisiensi(persentasiEnergi);
        printData();
    }

   public static void printData(){
        System.out.println("Name: " + Name);
        System.out.println("Power Consumption: " + KonsumsiPower + " Watt");
        System.out.println("Standby Power: " + standbyPower + " Watt");
        System.out.println("Hasil Energi Aktual: " + hasilEnergiAktual);
        System.out.println("Rasio Efisiensi: " + persentaseEnergi);
        
    }

   public static void totalEnergiAktual(double resultEnergiAktual){
        hasilEnergiAktual = KonsumsiPower + standbyPower;

    }

   public static void rasioEfisiensi(double persenEnergi){
        persentaseEnergi = standbyPower * hasilEnergiAktual / 100;
    }

    public static void Average(double rataRata){
        if (KonsumsiPower>10) {
            double AverageKonsumsiPower = (double) hasilEnergiAktual / KonsumsiPower;
            System.out.println("Rata Rata: " + AverageKonsumsiPower);
        }
    }
}
