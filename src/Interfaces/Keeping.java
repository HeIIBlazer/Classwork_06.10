
package Interfaces;

import Entity.Book;
import Entity.History;
import Entity.Reader;


public interface Keeping {
    public  void saveBooks(Book[] books);
    public Book[] loadBooks();
    public  void saveReaders(Reader[] readers);
    public Reader[] loadreaders();
    public  void saveHistories(History[] histories);
    public History[] loadHistories();
}
