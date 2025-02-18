package Jobsheet01;

public class Tugas4_4 {
    static int AGLONEMA_PRICE = 75000;
    static int KELADI_PRICE = 50000;
    static int ALOCASIA_PRICE = 60000;
    static int MAWAR_PRICE = 10000;
    static int[][] stockData = {
        // Aglonema, Keladi, Alocasia, Mawar
        {10, 5, 15, 7},
        {6, 11, 9, 12},
        {2, 10, 10, 5},
        {5, 7, 12, 9}
    };
    public static void calculateBranchIncome() {
        System.out.println("Income for each branch if all flowers are sold:");  
        for (int i = 0; i < stockData.length; i++) {
            int income = (stockData[i][0] * AGLONEMA_PRICE) +
                        (stockData[i][1] * KELADI_PRICE) +
                        (stockData[i][2] * ALOCASIA_PRICE) +
                        (stockData[i][3] * MAWAR_PRICE);
            System.out.println("RoyalGarden " + (i + 1) + ": Rp " + income);
        }
    }

    public static void calculateUpdatedStock() {
        System.out.println("\nUpdated stock for RoyalGarden 4 after reduction:");
        int[] reduction = {1, 2, 0, 5};
        System.out.println("Flower\t\tInitial Stock\tReduction\tFinal Stock");
        System.out.println("Aglonema\t" + stockData[3][0] + "\t\t" + reduction[0] + "\t\t" + (stockData[3][0] - reduction[0]));
        System.out.println("Keladi\t\t" + stockData[3][1] + "\t\t" + reduction[1] + "\t\t" + (stockData[3][1] - reduction[1]));
        System.out.println("Alocasia\t" + stockData[3][2] + "\t\t" + reduction[2] + "\t\t" + (stockData[3][2] - reduction[2]));
        System.out.println("Mawar\t\t" + stockData[3][3] + "\t\t" + reduction[3] + "\t\t" + (stockData[3][3] - reduction[3]));
    }

    public static void main(String[] args) {
        calculateBranchIncome();
        calculateUpdatedStock();
    }
}