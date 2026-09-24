package inheritance.class_problems;

public class StudentMember extends LibraryMember {

    protected String course;

    public StudentMember(
            String memberId,
            int borrowLimit,
            String course) {

        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Student | Course: "
                        + course
                        + " | Books: "
                        + booksBorrowed
        );
    }

    @Override
    protected void chargeFine(int amount) {

        super.chargeFine(amount / 2);
    }
}