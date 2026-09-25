package inheritance.week7_assignment;

public class AssignmentQ1Test {

    public static void ringAll(Ringable[] devices) {

        for (Ringable device : devices) {
            System.out.println(device.ring());
        }
    }

    public static void main(String[] args) {

        AlarmClock a =
                new AlarmClock("7:00 AM");

        Doorbell d =
                new Doorbell("Front Door");

        System.out.println(a.ring());
        System.out.println(d.ring());

        System.out.println();

        ringAll(new Ringable[]{a, d});
    }
}