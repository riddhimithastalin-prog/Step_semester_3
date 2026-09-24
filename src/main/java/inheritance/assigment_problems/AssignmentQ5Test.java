package inheritance.assignment_problems;

public class AssignmentQ5Test {

    public static String processWeeklyCheckIn(
            GymMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMember member : members) {

            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof GroupClassMember) {
                group++;
            } else {
                individual++;
            }
        }

        return processed
                + " processed | "
                + nullSkipped
                + " null skipped | "
                + group
                + " group | "
                + individual
                + " individual";
    }

    public static void main(String[] args) {

        // Membership number
        GymMember m1 =
                new GymMember(1000);

        System.out.println(
                m1.membershipNumber
        );

        System.out.println(
                GymMember.getMembersEnrolled()
        );

        // Referral code validation
        System.out.println(
                GymMember.isValidReferralCode(
                        "G45B"
                )
        );

        System.out.println(
                GymMember.isValidReferralCode(
                        "G4B"
                )
        );

        System.out.println(
                GymMember.isValidReferralCode(
                        "X45B"
                )
        );

        // Overloaded payFee()
        m1.payFee(500);

        m1.payFee(
                500,
                "UPI"
        );

        System.out.println(
                m1.getFeesPaid()
        );

        // Weekly check-in
        String result =
                processWeeklyCheckIn(
                        new GymMember[]{
                                new GroupClassMember(
                                        1500,
                                        "Zumba"
                                ),
                                null,
                                new GymMember(1000)
                        }
                );

        System.out.println(result);
    }
}