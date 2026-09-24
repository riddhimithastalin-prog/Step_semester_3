package inheritance.week7;

public class AssignmentQ2Test {

    public static void printAll(Printable[] items) {

        for (Printable item : items) {
            System.out.println(item.printLabel());
        }
    }

    public static void main(String[] args) {

        PackageBox p =
                new PackageBox("TRK-88");

        Invoice i =
                new Invoice("INV-42");

        System.out.println(p.printLabel());
        System.out.println(i.printLabel());

        System.out.println();

        printAll(new Printable[]{p, i});
    }
}