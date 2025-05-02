package iostreams.task03;

public class Removed_LenghtFilter implements Removed_LineFilter {
    private int minLenght;

    public Removed_LenghtFilter(int minLenght) {
        this.minLenght = minLenght;
    }

    @Override
    public boolean allow (String line) {
        return line.length() >= minLenght;
    }
}
