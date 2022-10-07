package practice1;

public class Book {
    private String title;
    private String author;
    private final String[] pages;

    public Book(String title, String author, int numberOfPages) {
        setTitle(title);
        setAuthor(author);

        pages = new String[numberOfPages];
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPage(int pageIndex, String pageContent) {
        pages[pageIndex] = pageContent;
    }

    public String getPage(int pageIndex) {
        return pages[pageIndex];
    }

    public int getPageCount() {
        return pages.length;
    }

    public String toString() {
        return "Book { title: '" + title + "', author: '" + author + "', " + pages.length + " pages }";
    }
}
