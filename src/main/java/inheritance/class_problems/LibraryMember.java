package inheritance.class_problems;

import java.util.Arrays;

public class LibraryMember {

    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    private int[] fineHistory;
    private int fineCount;

    // Q5
    private static int memberCounter = 100;

    public final String memberNumber;

    protected String lastGenre;

    // Existing constructor from Q1-Q4
    public LibraryMember(String memberId, int borrowLimit) {

        if (memberId == null ||
                memberId.trim().isEmpty() ||
                memberId.length() < 4) {

            throw new IllegalArgumentException("Invalid member ID");
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;

        fineHistory = new int[10];
        fineCount = 0;

        memberCounter++;
        memberNumber = "LIB-" + memberCounter;
    }

    // Q5 constructor
    public LibraryMember(int borrowLimit) {

        this.memberId = "AUTO";
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;

        fineHistory = new int[10];
        fineCount = 0;

        memberCounter++;
        memberNumber = "LIB-" + memberCounter;
    }

    public void borrowBook() {

        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    // Q5 overloaded method
    public void borrowBook(String genre) {

        this.lastGenre = genre;

        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public void displayInfo() {
        System.out.println(
                "General | Books: " + booksBorrowed
        );
    }

    protected void chargeFine(int amount) {

        if (fineCount < fineHistory.length) {
            fineHistory[fineCount] = amount;
            fineCount++;
        }
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {

        int total = 0;

        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }

        return total;
    }

    public static String enrollBatch(
            String[] memberIds,
            int borrowLimit) {

        int enrolled = 0;
        int rejected = 0;

        for (String memberId : memberIds) {

            try {
                new LibraryMember(memberId, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled
                + " | Rejected: " + rejected;
    }

    // Q5 renewal-code validation
    public static boolean isValidRenewalCode(String code) {

        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'R'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    // Q5 member count
    public static int getMembersEnrolled() {
        return memberCounter - 100;
    }
}