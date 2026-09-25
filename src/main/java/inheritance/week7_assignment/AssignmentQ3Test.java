package inheritance.week7_assignment;

public class AssignmentQ3Test {

    public static void main(String[] args) {

        CuttingTool c =
                new CuttingTool();

        System.out.println(c.use());

        Pruner p =
                new Pruner();

        System.out.println(p.use());
    }
}