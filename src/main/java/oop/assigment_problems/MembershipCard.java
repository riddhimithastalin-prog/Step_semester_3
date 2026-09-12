package oop.assigment_problems;

public class MembershipCard {

    static String libraryName;
    static String validUntil;

    String studentName;

    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";
        System.out.println("Library info loaded");
    }

    MembershipCard(String studentName) {
        this.studentName = studentName;
    }

    public static void main(String[] args) {

        String[] names = {
                "Ravi",
                "Meera",
                "Karthik",
                "Divya"
        };

        for (String name : names) {
            MembershipCard card = new MembershipCard(name);

            System.out.println(
                    "Card created for " + card.studentName
                            + " | " + libraryName
                            + " | Valid until: " + validUntil
            );
        }
    }
}