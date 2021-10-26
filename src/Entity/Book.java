package Entity;

import java.io.Serializable;
import java.util.Arrays;

public class Book implements Serializable {
    private String NameBook;
    private int PublishedYear;
    private Author[] author;
    private int Quantity;
    private int count;

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

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Book{" + "NameBook=" + NameBook + ", PublishedYear=" + PublishedYear + ", author=" + Arrays.toString(author) + ", Quantity=" + Quantity + ", count=" + count + '}';
    }

    }


    
    

