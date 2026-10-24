import java.util.Objects;

/** E01 - Classes and objects: blueprint vs instance, reference vs value equality, aliasing. */
public class E01_ClassesObjects {
    public static void main(String[] args) {
        Book b1 = new Book("Clean Code", "Robert Martin", 464);
        Book b2 = new Book("Clean Code", "Robert Martin", 464);
        System.out.println(b1);
        System.out.println("b1 == b2      : " + (b1 == b2));
        System.out.println("b1.equals(b2) : " + b1.equals(b2));
        check(b1 != b2, "two objects are two identities");
        check(b1.equals(b2), "equals compares state");

        Book alias = b1;          // same object, second reference
        alias.setPages(500);
        System.out.println("b1 pages after change through alias: " + b1.getPages());
        check(b1.getPages() == 500, "alias shares the object");
    }
    static void check(boolean c, String m) { if (!c) throw new AssertionError(m); }
}

class Book {
    private final String title;
    private final String author;
    private int pages;
    Book(String title, String author, int pages) { this.title = title; this.author = author; this.pages = pages; }
    int getPages() { return pages; }
    void setPages(int pages) { this.pages = pages; }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book b)) return false;
        return pages == b.pages && title.equals(b.title) && author.equals(b.author);
    }
    @Override public int hashCode() { return Objects.hash(title, author, pages); }
    @Override public String toString() { return "Book[" + title + ", " + author + ", " + pages + "p]"; }
}
