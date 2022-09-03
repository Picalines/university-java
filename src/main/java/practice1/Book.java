package practice1;

public class Book {
    public String _title;
    public String _author;
    public String[] _pages;

    public Book(String title, String author, int numberOfPages) {
        setTitle(title);
        setAuthor(author);

        _pages = new String[numberOfPages];
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String author) {
        _author = author;
    }

    public void setPage(int pageIndex, String pageContent) {
        _pages[pageIndex] = pageContent;
    }

    public String getPage(int pageIndex) {
        return _pages[pageIndex];
    }

    public int getPageCount() {
        return _pages.length;
    }

    public String toString() {
        return "Book { title: '" + _title + "', author: '" + _author + "', " + _pages.length + " pages }";
    }
}
