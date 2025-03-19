package Jobsheet03;

public class LecturerData11 {
    public void showAllLecturerData(Lecturer11[] lecturerArray) {
        System.out.println("\nALL LECTURER DATA:");
        System.out.println("========================");

        boolean dataFound = false;
        for (Lecturer11 lecturer : lecturerArray) {
            if (lecturer != null) {
                lecturer.displayInfo();
                dataFound = true;
            }
        }

        if (!dataFound) {
            System.out.println("No lecturer data available.");
        }
    }

    public void countLecturerByGender(Lecturer11[] lecturerArray) {
        int maleCount = 0;
        int femaleCount = 0;

        for (Lecturer11 lecturer : lecturerArray) {
            if (lecturer != null) {
                if (lecturer.isMale) {
                    maleCount++;
                } else {
                    femaleCount++;
                }
            }
        }

        System.out.println("\nLECTURER COUNT BY GENDER:");
        System.out.println("========================");
        System.out.println("Male: " + maleCount + " lecturer(s)");
        System.out.println("Female: " + femaleCount + " lecturer(s)");
        System.out.println("Total: " + (maleCount + femaleCount) + " lecturer(s)");
    }

    public void averageLecturerAgeByGender(Lecturer11[] lecturerArray) {
        int maleCount = 0;
        int femaleCount = 0;
        int totalMaleAge = 0;
        int totalFemaleAge = 0;

        for (Lecturer11 lecturer : lecturerArray) {
            if (lecturer != null) {
                if (lecturer.isMale) {
                    maleCount++;
                    totalMaleAge += lecturer.age;
                } else {
                    femaleCount++;
                    totalFemaleAge += lecturer.age;
                }
            }
        }

        System.out.println("\nAVERAGE LECTURER AGE BY GENDER:");
        System.out.println("========================");

        if (maleCount > 0) {
            double maleAvgAge = (double) totalMaleAge / maleCount;
            System.out.printf("Male: %.2f years\n", maleAvgAge);
        } else {
            System.out.println("Male: No data available");
        }

        if (femaleCount > 0) {
            double femaleAvgAge = (double) totalFemaleAge / femaleCount;
            System.out.printf("Female: %.2f years\n", femaleAvgAge);
        } else {
            System.out.println("Female: No data available");
        }
    }

    public void showOldestLecturerInfo(Lecturer11[] lecturerArray) {
        Lecturer11 oldest = null;

        for (Lecturer11 lecturer : lecturerArray) {
            if (lecturer != null) {
                if (oldest == null || lecturer.age > oldest.age) {
                    oldest = lecturer;
                }
            }
        }

        System.out.println("\nOLDEST LECTURER INFORMATION:");
        System.out.println("========================");

        if (oldest != null) {
            oldest.displayInfo();
        } else {
            System.out.println("No lecturer data available.");
        }
    }

    public void showYoungestLecturerInfo(Lecturer11[] lecturerArray) {
        Lecturer11 youngest = null;

        for (Lecturer11 lecturer : lecturerArray) {
            if (lecturer != null) {
                if (youngest == null || lecturer.age < youngest.age) {
                    youngest = lecturer;
                }
            }
        }

        System.out.println("\nYOUNGEST LECTURER INFORMATION:");
        System.out.println("========================");

        if (youngest != null) {
            youngest.displayInfo();
        } else {
            System.out.println("No lecturer data available.");
        }
    }
}