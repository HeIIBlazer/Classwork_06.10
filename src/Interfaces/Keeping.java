
package Interfaces;

import Entity.Book;
import Entity.History;
import Entity.Reader;
import java.util.List;


public interface Keeping {
    public  void saveBooks(List<Book> books);
    public List<Book> loadBooks();
    public  void saveReaders(List<Reader> readers);
    public List<Reader> loadreaders();
    public  void saveHistories(List<History> histories);
    public List<History> loadHistories();
}
