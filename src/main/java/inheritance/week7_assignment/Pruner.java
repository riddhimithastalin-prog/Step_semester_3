package inheritance.week7_assignment;

public class Pruner extends CuttingTool {

    public Pruner() {
        super();
    }

    @Override
    public String use() {

        String result = super.use();

        return result
                + ", then trimming branches precisely";
    }
}