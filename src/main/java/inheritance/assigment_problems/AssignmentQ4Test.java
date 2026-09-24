package inheritance.assignment_problems;

public class AssignmentQ4Test {

    public static String batchPrint(
            GymMember[] members) {

        StringBuilder announcement =
                new StringBuilder();

        for (GymMember member : members) {

            member.displayInfo();

            if (member instanceof PremiumMember) {

                PremiumMember premium =
                        (PremiumMember) member;

                announcement.append(
                        "Premium | Trainer: "
                );

                announcement.append(
                        premium.trainerName
                );

                announcement.append(
                        " | Sessions: "
                );

                announcement.append(
                        premium.getSessionsAttended()
                );

                announcement.append(
                        " [Trainer via downcast: "
                );

                announcement.append(
                        premium.trainerName
                );

                announcement.append(
                        "] | "
                );

            } else {

                announcement.append(
                        "Standard | Sessions: "
                );

                announcement.append(
                        member.getSessionsAttended()
                );

                announcement.append(
                        " | "
                );
            }
        }

        return announcement.toString();
    }

    public static void main(String[] args) {

        GymMember standard =
                new GymMember(
                        "MEM6",
                        1000
                );

        PremiumMember premium =
                new PremiumMember(
                        "MEM7",
                        2000,
                        "Coach Riya"
                );

        GymMember[] members = {
                standard,
                premium
        };

        System.out.println(
                batchPrint(members)
        );
    }
}