package inheritance.week7;

public class AssignmentQ4Test {

    public static void main(String[] args) {

        Blender b =
                new Blender();

        b.setSpeedLevel(3);

        System.out.println(
                b.getSpeedLevel()
        );

        try {
            b.setSpeedLevel(9);
        } catch (IllegalArgumentException e) {
            System.out.println("Speed level rejected");
        }

        System.out.println(
                b.getSpeedLevel()
        );

        System.out.println(
                b.prepare()
        );

        System.out.println(
                b.clean()
        );
    }
}