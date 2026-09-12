package oop.class_problems;

public class FeeAccount {

    String accountType;

    FeeAccount(String accountType) {
        this.accountType = accountType;
    }

    void processPayment(FeeAccount account, double amount) {

        if (account instanceof HostelFeeAccount) {
            System.out.println("Paid in two installments (hostel account)");
        } else {
            System.out.println("Paid in one go (day-scholar account)");
        }
    }

    public static void main(String[] args) {

        FeeAccount[] accounts = {
                new HostelFeeAccount(),
                new HostelFeeAccount(),
                new FeeAccount("Day Scholar"),
                new FeeAccount("Day Scholar")
        };

        int hostelCount = 0;
        int dayScholarCount = 0;

        FeeAccount processor = new FeeAccount("Processor");

        for (FeeAccount account : accounts) {
            processor.processPayment(account, 60000);

            if (account instanceof HostelFeeAccount) {
                hostelCount++;
            } else {
                dayScholarCount++;
            }
        }

        System.out.println("Hostel accounts processed: " + hostelCount +
                " | Day-scholar accounts processed: " + dayScholarCount);
    }
}

class HostelFeeAccount extends FeeAccount {

    HostelFeeAccount() {
        super("Hostel");
    }
}