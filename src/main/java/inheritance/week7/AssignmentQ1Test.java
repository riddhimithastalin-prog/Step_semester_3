package inheritance.week7;

public class AssignmentQ1Test {

    public static void main(String[] args) {

        ToyCar c = new ToyCar("Speedster");

        System.out.println(c.makeSound());
        System.out.println(c.getToyId());

        ToyRobot r = new ToyRobot("Bolt");

        System.out.println(r.makeSound());
        System.out.println(r.getToyId());
    }
}