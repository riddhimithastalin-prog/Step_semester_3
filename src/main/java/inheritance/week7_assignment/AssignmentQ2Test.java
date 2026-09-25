package inheritance.week7_assignment;

public class AssignmentQ2Test {

    public static void main(String[] args) {

        Painting p =
                new Painting("Sunset Fields");

        Sculpture s =
                new Sculpture("The Thinker II");

        System.out.println(p.describe());
        System.out.println(p.getPieceId());

        System.out.println(s.describe());
        System.out.println(s.getPieceId());
    }
}