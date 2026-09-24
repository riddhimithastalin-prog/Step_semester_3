package inheritance.week7;

public class Violin extends StringInstrument {

    public Violin() {
        super();
    }

    @Override
    public String play() {

        String result = super.play();

        return result +
                ", with a bow drawn across four strings";
    }
}