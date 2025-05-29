package patterns.prototype4.realisation2;

import java.util.ArrayList;
import java.util.List;

public class Document implements Prototype {

    private String text;
    private List<String> tags = new ArrayList<>();
    public Document (String text) {
        this.text = text;
    }
    public void addTag (String tag) {
        tags.add(tag);
    }

    @Override
    public Document clone () {
        try {
            Document copy = (Document) super.clone();
            copy.tags = new ArrayList<>(tags);
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString () {
        return "Text: " + text + ", Tags: " + tags;
    }


    public static void main(String[] args) {
        Document original = new Document("Hello");
        original.addTag("welcome");
        original.addTag("text");

        Document copy = original.clone();
        copy.addTag("copy");
        System.out.println(original);
        System.out.println(copy);
    }
}
