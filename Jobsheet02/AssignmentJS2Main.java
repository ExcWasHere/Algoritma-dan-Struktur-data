package Jobsheet02;

public class AssignmentJS2Main {
    public static void main(String[] args) {
        AssignmentJS2 student10 = new AssignmentJS2(null, null, 0, 0);
        student10.Course = "Praktikkum Basis Data";
        student10.Name = "Jakik";
        student10.credit = 3;
        student10.hour = 6;
        student10.printData();
        student10.changeCredit(2);
        student10.reducedHour(2);
        student10.printData();

        AssignmentJS2 student11 = new AssignmentJS2("Design Interface", "Wahyu", 2, 4);
        student11.changeCredit(3);
        student11.addHour(2);
        student11.printData();
    }
}
