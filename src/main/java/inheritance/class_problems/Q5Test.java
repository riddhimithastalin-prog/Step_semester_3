package inheritance.class_problems;

public class Q5Test {

    public static String processNightlyAudit(
            LibraryMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int faculty = 0;
        int regular = 0;

        for (LibraryMember member : members) {

            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof FacultyMember) {
                faculty++;
            } else {
                regular++;
            }
        }

        return processed
                + " processed | "
                + nullSkipped
                + " null skipped | "
                + faculty
                + " faculty | "
                + regular
                + " regular";
    }

    public static void main(String[] args) {

        // Member number
        LibraryMember m1 =
                new LibraryMember(3);

        System.out.println(
                m1.memberNumber
        );

        System.out.println(
                LibraryMember.getMembersEnrolled()
        );

        // Renewal code
        System.out.println(
                LibraryMember.isValidRenewalCode("R12A")
        );

        System.out.println(
                LibraryMember.isValidRenewalCode("R1A")
        );

        System.out.println(
                LibraryMember.isValidRenewalCode("X12A")
        );

        // Overloaded borrowBook()
        m1.borrowBook();
        m1.borrowBook("Fiction");

        System.out.println(
                m1.getBooksBorrowed()
        );

        // Nightly audit
        String result =
                processNightlyAudit(
                        new LibraryMember[]{
                                new FacultyMember(
                                        5,
                                        "Physics"
                                ),
                                null,
                                new LibraryMember(3)
                        }
                );

        System.out.println(result);
    }
}