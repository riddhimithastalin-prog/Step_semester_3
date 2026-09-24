package inheritance.assignment_problems;

public class GroupClassMember extends GymMember {

    private String className;

    // Q2 constructor
    public GroupClassMember(
            String memberId,
            int monthlyFee,
            String className) {

        super(memberId, monthlyFee);

        this.className = className;
    }

    // Q5 constructor
    public GroupClassMember(
            int monthlyFee,
            String className) {

        super(monthlyFee);

        this.className = className;
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Group Class Member | Class: "
                        + className
                        + " | Sessions: "
                        + sessionsAttended
        );
    }
}