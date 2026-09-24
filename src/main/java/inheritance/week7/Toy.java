package inheritance.week7;

public abstract class Toy {

    private static int toyCounter = 1000;

    private final String toyId;

    protected Toy() {
        toyCounter++;

        toyId = "TOY-" + toyCounter;
    }

    public abstract String makeSound();

    public String getToyId() {
        return toyId;
    }
}