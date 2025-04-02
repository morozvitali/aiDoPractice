package regex.task17;

public class FileNameValidator {


        // букви, цифри, від 2-49 потім крапка і розширення (в середині ._-) а в кінці (txt|pdf|docx|jpg|png|zip|rar|exe)$

    public boolean isValidFilename(String filename) {
        return filename.matches("^[a-zA-Z0-9][a-zA-Z0-9._-]{2,49}\\.(txt|pdf|docx|jpg|png|zip|rar|exe)$");
    }

    public static void main(String[] args) {
        FileNameValidator fv = new FileNameValidator();
        System.out.println(fv.isValidFilename("document.txt") + "  document.txt");  // ✅ true
        System.out.println(fv.isValidFilename("photo.jpg") + "  photo.jpg");       // ✅ true
        System.out.println(fv.isValidFilename("my_resume.pdf") + "  my_resume.pdf");   // ✅ true
        System.out.println(fv.isValidFilename("backup-2024.zip") + "  backup-2024.zip"); // ✅ true
        System.out.println(fv.isValidFilename("file with space.txt") + "  file with space.txt"); // ❌ false (є пробіл)
        System.out.println(fv.isValidFilename("bad@name.exe") + "  bad@name.exe");    // ❌ false (є `@`)
        System.out.println(fv.isValidFilename("no_extension") + "  no_extension");    // ❌ false (немає розширення)
        System.out.println(fv.isValidFilename(".hiddenfile.txt") + "  .hiddenfile.txt"); // ❌ false (починається з `.`)
        System.out.println(fv.isValidFilename("superlongfilenameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee.pdf") + "  superlongfilenameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee.pdf");
    }
}
