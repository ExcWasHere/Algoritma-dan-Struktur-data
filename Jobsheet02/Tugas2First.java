package Jobsheet02;

public class Tugas2First {
    public static void main(String[] args) {
        Tugas2Zero student1 = new Tugas2Zero(null, null, null, 0);
        student1.NIM = "244107020227";
        student1.Name = "Excell";
        student1.className = "TI-1I";
        student1.IPK = 4.1;
        student1.printData();
        student1.changeClass("TI-2I");
        student1.updateIPK(4.0);
        student1.printData(); 

        Tugas2Zero student2 = new Tugas2Zero("244107020227", "Ridho", "TI-1I", 3.6);
        student2.updateIPK(3.3);
        student2.printData();
    }
}
