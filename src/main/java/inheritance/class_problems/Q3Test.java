package inheritance.class_problems;

import java.util.Arrays;

public class Q3Test {

    public static void main(String[] args) {

        StudentMember s =
                new StudentMember(
                        "STU5",
                        3,
                        "CSE"
                );

        s.chargeFine(100);

        System.out.println(
                "Total Fine: "
                        + s.getTotalFine()
        );

        int[] history = s.getFineHistory();

        history[0] = 999;

        System.out.println(
                "Fine History: "
                        + Arrays.toString(
                        s.getFineHistory()
                )
        );
    }
}