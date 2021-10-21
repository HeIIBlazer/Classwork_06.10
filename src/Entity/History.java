    package Entity;

import java.io.Serializable;
import java.util.Date;

    public class History implements Serializable{
    private Reader reader;
    private Book book;
    private Date givendate;
    private Date returndate;

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getGivendate() {
        return givendate;
    }

    public void setGivendate(Date givendate) {
        this.givendate = givendate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    @Override
    public String toString() {
        return "History{" + "reader=" + reader + ", book=" + book + ", givendate=" + givendate + ", returndate=" + returndate + '}';
    }
    
}
