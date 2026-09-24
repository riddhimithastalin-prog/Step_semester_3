package inheritance.week7;

public class AssignmentQ5Test {

    public static void logAll(
            DeliveryNote[] notes) {

        for (DeliveryNote note : notes) {
            System.out.println(
                    note.confirmDelivery()
            );
        }
    }

    public static void main(String[] args) {

        ParcelNote p =
                new ParcelNote("TRK-1");

        System.out.println(
                p.confirmDelivery()
        );

        System.out.println(
                p.confirmDelivery("J. Smith")
        );

        DeliveryNote ref = p;

        System.out.println();

        logAll(
                new DeliveryNote[]{
                        ref,
                        new LetterNote("TRK-2")
                }
        );
    }
}