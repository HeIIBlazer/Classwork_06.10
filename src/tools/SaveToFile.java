
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
        Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "��� ����� books", ex);
    } catch (IOException ex) {
        Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "������ ����� ������", ex);
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
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "���� books ��� �� ������", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "������ ��������� ����� books", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "������ Book �� ����������", ex);
        }
        return books;
    }

    @Override
    public void saveReaders(Reader[] readers) {
        FileOutputStream fos=null;
        ObjectOutputStream oos = null;
        try{
            fos=new FileOutputStream("readers");
            oos=new ObjectOutputStream(fos);
            oos.writeObject(readers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "��� ����� readers", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "������ ����� ������", ex);
        }
    }

    @Override
    public Reader[] loadreaders() {
        Reader[] readers= new Reader[10];
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("readers");
            ois= new ObjectInputStream(fis);
            readers = (Reader[]) ois.readObject();
        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "���� readers ��� �� ������", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "������ ��������� ����� readers", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "������ Reader �� ����������", ex);
        }
        return readers;
    }

    @Override
    public void saveHistories(History[] histories) {
        FileOutputStream fos=null;
        ObjectOutputStream oos = null;
        try{
            fos=new FileOutputStream("histories");
            oos=new ObjectOutputStream(fos);
            oos.writeObject(histories);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "��� ����� histories", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "������ ����� ������", ex);
        }
    }

    @Override
    public History[] loadHistories() {
        History[] histories= new History[10];
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("histories");
            ois= new ObjectInputStream(fis);
            histories= (History[]) ois.readObject();
        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "���� histories ��� �� ������", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "������ ��������� ����� histories", ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveToFile.class.getName()).log(Level.INFO, "������ History �� �������", ex);
        }
        return histories;
    }
    
}
