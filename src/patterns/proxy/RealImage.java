package patterns.proxy;

public class RealImage implements Image{
    private String fileName;

    public RealImage (String fileName) {
    this.fileName = fileName;
    loadFromDisk (); //  дуже повільна операція
    }

    private void loadFromDisk() {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
