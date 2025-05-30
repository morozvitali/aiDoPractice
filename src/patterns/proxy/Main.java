package patterns.proxy;

public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("cat.jpg");
        // завантаження відклажене
        image.display(); // Loading cat_photo.jpg \n Displaying cat_photo.jpg
        image.display(); // Displaying cat_photo.jpg (без повторного завантаження)
    }
}
