package inheritance.class_problems;

public class Q4Test {

    public static String batchPrint(
            LibraryMember[] members) {

        StringBuilder report = new StringBuilder();

        for (LibraryMember member : members) {

            member.displayInfo();

            report.append(
                    "General | Books: "
            );

            if (member instanceof StudentMember) {

                StudentMember student =
                        (StudentMember) member;

                report.append(
                        "Student | Course: "
                                + student.course
                                + " | Books: "
                                + student.getBooksBorrowed()
                                + " [Course via downcast: "
                                + student.course
                                + "] | "
                );

            } else {

                report.append(
                        member.getBooksBorrowed()
                                + " | "
                );
            }
        }

        return report.toString();
    }

    public static void main(String[] args) {

        LibraryMember plain =
                new LibraryMember("LB05", 3);

        StudentMember student =
                new StudentMember(
                        "STU6",
                        3,
                        "ECE"
                );

        LibraryMember[] members = {
                plain,
                student
        };

        String report = batchPrint(members);

        System.out.println(report);
    }
}