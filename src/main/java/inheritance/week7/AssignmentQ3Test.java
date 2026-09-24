package inheritance.week7;

public class AssignmentQ3Test {

    public static void main(String[] args) {

        StringInstrument s =
                new StringInstrument();

        System.out.println(s.play());

        Violin v =
                new Violin();

        System.out.println(v.play());
    }
}