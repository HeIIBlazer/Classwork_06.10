package Entity;

import java.io.Serializable;
import java.util.Arrays;

public class Book implements Serializable {
    private String NameBook;
    private int PublishedYear;
    private Author[] author;

    public String getNameBook() {
        return NameBook;
    }

    public void setNameBook(String NameBook) {
        this.NameBook = NameBook;
    }

    public int getPublishedYear() {
        return PublishedYear;
    }

    public void setPublishedYear(int PublishedYear) {
        this.PublishedYear = PublishedYear;
    }

    public Author[] getAuthor() {
        return author;
    }

    public void setAuthor(Author[] author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" + "NameBook=" + NameBook 
                + ", PublishedYear=" + PublishedYear 
                + ", author=" + Arrays.toString(author) + '}';
    }


    }
    

