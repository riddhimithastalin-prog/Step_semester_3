package inheritance.assignment_problems;

public class AssignmentQ1Test {

    public static void main(String[] args) {

        PremiumMember p =
                new PremiumMember(
                        "MEM01",
                        2000,
                        "Coach Riya"
                );

        p.attendSession();
        p.attendSession();

        System.out.println(
                p.getSessionsAttended()
        );

        String result =
                GymMember.signUpBatch(
                        new String[]{
                                "MEM1",
                                "GM1",
                                "MEM2",
                                " ",
                                "MEM3"
                        },
                        1000
                );

        System.out.println(result);
    }
}