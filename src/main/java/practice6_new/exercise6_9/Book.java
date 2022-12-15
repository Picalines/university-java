package practice6_new.exercise6_9;

import practice6_new.exercise3.Nameable;
import practice6_new.exercise4.Priceable;

public class Book implements Priceable, Nameable, Printable {
    private final String title;
    private final String author;
    private final double price;
    private final String[] pages;

    public Book(String title, String author, double price, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.price = price;

        pages = new String[numberOfPages];
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getName() {
        return getTitle();
    }

    public String getAuthor() {
        return author;
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

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println('"' + title + '"' + " by " + author);
        System.out.println();

        for (int i = 0; i < pages.length; i++) {
            var page = pages[i];
            System.out.println("[page " + (i + 1) + '/' + pages.length + ']');
            System.out.println(page);
            System.out.println();
        }
    }
}
