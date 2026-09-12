package oop.class_problems;

public class LateFeeAccount {

    String regNo;
    double totalFee;

    LateFeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    final double calculateLateFee(int daysLate) {
        return totalFee * daysLate / 100;
    }

    final void printSummary(int daysLate) {
        if (daysLate <= 0) {
            System.out.println(regNo + " - On time, no late fee");
        } else {
            double lateFee = calculateLateFee(daysLate);
            System.out.println(regNo + " | Total Fee: Rs " +
                    totalFee + " | Late Fee: Rs " + lateFee);
        }
    }

    public static void main(String[] args) {

        LateFeeAccount[] accounts = {
                new LateFeeAccount("RA001", 200000),
                new LateFeeAccount("RA002", 150000),
                new LateFeeAccount("RA003", 180000),
                new LateFeeAccount("RA004", 220000)
        };

        int[] daysLate = {10, 0, -2, 5};

        for (int i = 0; i < accounts.length; i++) {
            accounts[i].printSummary(daysLate[i]);
        }
    }
}