package inheritance.assignment_problems;

import java.util.Arrays;

public class GymMember {

    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    private int[] lateFeeHistory;
    private int lateFeeCount;

    // Q5
    private static int membershipCounter = 2000;

    public final String membershipNumber;

    private int feesPaid;
    private String paymentMode;

    // Q1-Q4 constructor
    public GymMember(
            String memberId,
            int monthlyFee) {

        if (memberId == null ||
                memberId.trim().isEmpty() ||
                memberId.length() < 4) {

            throw new IllegalArgumentException(
                    "Invalid member ID"
            );
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;

        lateFeeHistory = new int[10];
        lateFeeCount = 0;

        feesPaid = 0;
        paymentMode = null;

        membershipCounter++;

        membershipNumber =
                "GYM-" + membershipCounter;
    }

    // Q5 constructor
    public GymMember(int monthlyFee) {

        this.memberId = "AUTO";
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;

        lateFeeHistory = new int[10];
        lateFeeCount = 0;

        feesPaid = 0;
        paymentMode = null;

        membershipCounter++;

        membershipNumber =
                "GYM-" + membershipCounter;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public void displayInfo() {
        System.out.println(
                "Standard Member | Sessions: "
                        + sessionsAttended
        );
    }

    // Q3
    protected void chargeLateFee(int amount) {

        if (lateFeeCount < lateFeeHistory.length) {
            lateFeeHistory[lateFeeCount] = amount;
            lateFeeCount++;
        }
    }

    public int[] getLateFeeHistory() {

        return Arrays.copyOf(
                lateFeeHistory,
                lateFeeCount
        );
    }

    public int getTotalLateFees() {

        int total = 0;

        for (int i = 0; i < lateFeeCount; i++) {
            total += lateFeeHistory[i];
        }

        return total;
    }

    // Q1
    public static String signUpBatch(
            String[] memberIds,
            int monthlyFee) {

        int signedUp = 0;
        int rejected = 0;

        for (String memberId : memberIds) {

            try {
                new GymMember(
                        memberId,
                        monthlyFee
                );

                signedUp++;

            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: "
                + signedUp
                + " | Rejected: "
                + rejected;
    }

    // Q5
    public void payFee(int amount) {

        feesPaid += amount;
    }

    // Q5 overloaded method
    public void payFee(
            int amount,
            String mode) {

        paymentMode = mode;

        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    // Q5
    public static boolean isValidReferralCode(
            String code) {

        if (code == null ||
                code.length() != 4) {

            return false;
        }

        return code.charAt(0) == 'G'
                && Character.isDigit(
                code.charAt(1)
        )
                && Character.isDigit(
                code.charAt(2)
        )
                && Character.isUpperCase(
                code.charAt(3)
        );
    }

    // Q5
    public static int getMembersEnrolled() {

        return membershipCounter - 2000;
    }
}