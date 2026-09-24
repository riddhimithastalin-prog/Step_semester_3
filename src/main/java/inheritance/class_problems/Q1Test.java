package inheritance.class_problems;

public class Q1Test {

    public static void main(String[] args) {

        StudentMember s =
                new StudentMember("STU10", 3, "CSE");

        s.borrowBook();
        s.borrowBook();

        System.out.println(s.getBooksBorrowed());

        String result = LibraryMember.enrollBatch(
                new String[]{"STU1", "LB1", "STU2", " ", "STU3"},
                3
        );

        System.out.println(result);
    }
}