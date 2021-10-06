package jptv20library;

import MyClasses.Author;
import MyClasses.Book;
import MyClasses.History;
import MyClasses.Reader;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class App {
    public void run() {
        Reader reader1 = new Reader();
        reader1.setFirstName("Petr");
        reader1.setLastName("Petrov");
        reader1.setPhone("55556758");
        
        Reader reader2 = new Reader();
        reader2.setFirstName("Olga");
        reader2.setLastName("Jakovleva");
        reader2.setPhone("50984121");
        
        Book book1= new Book();
        book1.setNameBook("Voina i Mir");
        book1.setPublishedYear(2021);
        Author author1 =new Author();
        author1.setFirstName("Lev");
        author1.setLastName("Tolstoi");
        author1.setBirthYear(1828);
        Author [] authors= new Author[1];
        authors[0]=author1;
        book1.setAuthor(authors);
        
        Book book2 =new Book();
        book2.setNameBook("Otsi i deti");
        book2.setPublishedYear(1982);
        Author author2 = new Author();
        author2.setFirstName("Ivan");
        author2.setLastName("Turgenev");
        author2.setBirthYear(1818);
        Author [] authors2 = new Author[1];
        authors2[0]=author2;
        book2.setAuthor(authors2);
        
        Calendar c = new GregorianCalendar();
        
        History history1= new History();
        history1.setReader(reader1);
        history1.setBook(book1);
        history1.setGivendate(c.getTime());
        System.out.println("History1: " + history1.toString());
        
        History history2= new History();
        history2.setReader(reader2);
        history2.setBook(book2);
        c= new GregorianCalendar();
        history2.setGivendate(c.getTime());;
        System.out.println("History2: " + history2.toString());
        
        c= new GregorianCalendar();
        history1.setReturndate(c.getTime());
        System.out.println("-----------------------------");
        System.out.println("History1: " + history1.toString());
        
        c= new GregorianCalendar();
        history2.setReturndate(c.getTime());
        System.out.println("History2: " + history2.toString());
    }
    
    
}
