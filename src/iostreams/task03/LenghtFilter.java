package iostreams.task03;

public class LenghtFilter implements LineFilter {
    private int minLenght;

    public LenghtFilter (int minLenght) {
        this.minLenght = minLenght;
    }

    @Override
    public boolean allow (String line) {
        return line.length() >= minLenght;
    }
}
