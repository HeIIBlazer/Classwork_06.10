package jptv20library;

import Entity.Author;
import Entity.Book;
import Entity.History;
import Entity.Reader;
import Interfaces.Keeping;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import tools.SaveToFile;


public class App {
    private Scanner scanner = new Scanner(System.in);
    private List<Book> books = new ArrayList<>();
    private List<Reader> readers= new ArrayList<>();
    private List<History> histories= new ArrayList<>();
    private Keeping keeper= new SaveToFile();
public App() {
    books =keeper.loadBooks();
    readers=keeper.loadreaders();
    histories=keeper.loadHistories();


}
 public void run() {
     String repeat ="r";
        do{
            System.out.println(" ");
            System.out.println("0: Выход из программы");
            System.out.println("1: Ввод Информация об книге и авторе");
            System.out.println("2: Информация о книгах");
            System.out.println("3: Ввод информации о новом читателе");
            System.out.println("4: Информация о читателях");
            System.out.println("5: Выдать книгу");
            System.out.println("6: Список выданых книгу");
            System.out.println("7: Возврат книги");
            System.out.print("Выберети номер задачи: ");
            int task = scanner.nextInt(); scanner.nextLine();
            
            
            switch (task) {
                case 0:
                    repeat="q";
                    System.out.println("ДАВАЙ ДО ЗАВТРА!!!!!!");
                    break;
                case 1:
                    System.out.println("--------Добавляем книгу----------");

                        books.add(addBook());
                        keeper.saveBooks(books);
                        break;
                    
                case 2:
                    System.out.println("-------------Список книг-------------");
                    printBooks();
                    break;
                case 3:
                    System.out.println("-------------Добавить читателя----------------");
                        readers.add(addReader());
                        keeper.saveReaders(readers);
                        break;
                case 4:
                    System.out.println("-------------Cписок читателей-------------");
                    for (int i = 0; i < readers.size(); i++) {
                        if(readers.get(i)!=null){
                            System.out.println(readers.get(i).toString());
                                
                            }
                        
                    }
               
                break;
                case 5:
                    System.out.println("-------------Видать книгу-------------"); 
                    histories.add(addHistories());
                    keeper.saveHistories(histories);
                    break;
                case 6:
                    System.out.println("-------------Список выданных книг-------------"); 
                    int n=0;
                    for (int i = 0; i < histories.size(); i++) {
                        if(histories.get(i)!=null && histories.get(i).getReturndate()== null){
                            //System.out.println(histories.get(i).toString());
                            System.out.println("Книгу "+histories.get(i).getBook().getNameBook()+" читает "+histories.get(i).getReader().getFirstName()+" "+histories.get(i).getReader().getLastName());
                            n++;
                        }
                    }
                    
                if(n<1){
                    System.out.println("Нет выданных книг");
                }
                break;
                    
                case 7:
                    System.out.println("---------------Возврат книги--------------");
                    System.out.println("Список выданных книг"); 
                    printGivenBooks();
                    System.out.println("Номер возвращаемой книги");
                    int numberHistory =scanner.nextInt();scanner.nextLine();
                    Calendar c= new GregorianCalendar();
                    if(histories.get(numberHistory - 1).getBook().getCount()
                            < histories.get(numberHistory - 1).getBook().getQuantity()){
                        histories.get(numberHistory - 1).setReturndate(c.getTime());
                        histories.get(numberHistory - 1).getBook().setCount(histories.get(numberHistory - 1).getBook().getCount()+1);
                    }else{
                        System.out.println("Все экземпляры книги в библиотеке");
                    }
                    
                    keeper.saveHistories(histories);
                    keeper.saveBooks(books);
                    System.out.printf("Книга \"%s\" возвращена%n", histories.get(numberHistory-1).getBook().getNameBook());
                    break;
                    
                default:
                    System.out.println("Введи номер из списка!!!");
            }
     }while("r".equals(repeat));   
        }
    private boolean printBooks(){
    int booksInStock = 0;
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i) != null && books.get(i).getCount() > 0){
                System.out.println(i+1+". "+books.get(i).toString());
                booksInStock++;
            }else{
                System.out.println(i+1+". "+"Книги: \""+books.get(i).getNameBook()+ "\" нет в наличии");
            }
        }
        if(booksInStock < 1){
            System.out.println("Нет книг для чтения.");
            return false;
        }
        return true;
    }
        
    private Book addBook(){
    Book book = new Book();
    System.out.print("Введите название книги: ");
    book.setNameBook(scanner.nextLine());
    System.out.print("Введите год издания книги: ");
    book.setPublishedYear(scanner.nextInt());
    System.out.println("Ввидете кол-во экземпляров книги");
    book.setQuantity(scanner.nextInt()); scanner.nextLine();
    book.setCount(book.getQuantity());
    System.out.print("Введите кол-во авторов книги: ");
    int CountAuthors= scanner.nextInt(); scanner.nextLine();
    Author[] authors = new Author[CountAuthors];
    
    for (int i = 0; i < authors.length; i++) { 
        Author author =new Author();
        System.out.print("Введите имя автора: ");
        author.setFirstName(scanner.nextLine());
        System.out.print("Введите Фамилию автора: ");
        author.setLastName(scanner.nextLine());
        System.out.print("Введите год рождения автора: ");
        author.setBirthYear(scanner.nextInt());scanner.nextLine();
        authors[i]=author;
        }
    
    book.setAuthor(authors);
    
    return book;
    }
    
    
    
    private Reader addReader(){
    Reader reader = new Reader();
    System.out.print("Введите имя читателя: ");
    reader.setFirstName(scanner.nextLine());
    System.out.print("Введите фамилию читателя: ");
    reader.setLastName(scanner.nextLine());
    System.out.print("Введите телефонный номер читателя: ");
    reader.setPhone(scanner.nextLine());
    
    return reader;
    }
    private History addHistories(){
        History history = new History();
        System.out.println("Список книг");
        for (int i = 0; i < books.size(); i++) {
         if(books.get(i)!=null){
             System.out.println(i+1+": "+books.get(i).toString());
         }
        }
        System.out.print("Введите номер книги: ");
        int numberBook =scanner.nextInt();scanner.nextLine();
        
        for (int i = 0; i < readers.size(); i++) {
            if(readers.get(i)!=null){
               System.out.println(i+1+": "+readers.get(i).toString());    
            }
                    }
        System.out.print("Введите номер читателя: ");
        int numberReader =scanner.nextInt();scanner.nextLine();
        history.setBook(books.get(numberBook-1));
        history.setReader(readers.get(numberReader-1));
        Calendar c= new GregorianCalendar();
        history.setGivendate(c.getTime());
        return history;
    }
   private boolean printGivenBooks(){
        int n = 0;
        for (int i = 0; i < histories.size(); i++) {
            if(histories.get(i) != null 
                    && histories.get(i).getReturndate()== null 
                    && histories.get(i).getBook().getCount() < histories.get(i).getBook().getQuantity()
                    ){
                System.out.printf("%d. Книгу %s читает %s %s. Выдана книга: %s%n",
                        i+1,
                        histories.get(i).getBook().getNameBook(),
                        histories.get(i).getReader().getFirstName(),
                        histories.get(i).getReader().getLastName(),
                        histories.get(i).getGivendate().toString()
                );
                n++;
            if(n < 1){
                System.out.println("Нет выданных книг");
                return false;
        }
    }
}
        return true;
   }
}