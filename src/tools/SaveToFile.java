
package tools;

import Entity.Book;
import Entity.History;
import Entity.Reader;
import Interfaces.Keeping;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveToFile implements Keeping{

    @Override
    public void saveBooks(Book[] books) {
    FileOutputStream fos=null;
    ObjectOutputStream oos = null;
    try{
        fos = new FileOutputStream("books");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(books);
        oos.flush();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Нет файла books", ex);
    } catch (IOException ex) {
        Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
    }

    @Override
    public Book[] loadBooks() {
        Book[] books= new Book[10];
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("books");
            ois= new ObjectInputStream(fis);
            books = (Book[]) ois.readObject();
        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Файл books еще не создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "ошибка читавания файла books", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Класса Book не существует", ex);
        }
        return books;
    }

    @Override
    public void saveReaders(Reader[] readers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reader[] loadreaders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveHistories(History[] histories) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public History[] loadHistories() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
