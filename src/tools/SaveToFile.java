
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveToFile implements Keeping{

    @Override
    public void saveBooks(List<Book> books) {
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
    public List<Book> loadBooks() {
        List<Book> books= new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("books");
            ois= new ObjectInputStream(fis);
            books = (List<Book>) ois.readObject();
        
        
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
    public void saveReaders(List<Reader> readers) {
        FileOutputStream fos=null;
        ObjectOutputStream oos = null;
        try{
            fos=new FileOutputStream("readers");
            oos=new ObjectOutputStream(fos);
            oos.writeObject(readers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Нет файла readers", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
    }

    @Override
    public List<Reader> loadreaders() {
        List<Reader> readers= new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("readers");
            ois= new ObjectInputStream(fis);
            readers = (List<Reader>) ois.readObject();
        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Файл readers еще не создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "ошибка читавания файла readers", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Класса Reader не существует", ex);
        }
        return readers;
    }

    @Override
    public void saveHistories(List<History> histories) {
        FileOutputStream fos=null;
        ObjectOutputStream oos = null;
        try{
            fos=new FileOutputStream("histories");
            oos=new ObjectOutputStream(fos);
            oos.writeObject(histories);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Нет файла histories", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
    }

    @Override
    public List<History> loadHistories() {
        List<History> histories= new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("histories");
            ois= new ObjectInputStream(fis);
            histories= (List<History>) ois.readObject();
        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Файл histories еще не создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "ошибка читавания файла histories", ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "Класса History не найдено", ex);
        }
        return histories;
    }


    
}
