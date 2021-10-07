package jptv20library;

import MyClasses.Author;
import MyClasses.Book;
import MyClasses.History;
import MyClasses.Reader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class App {
 private Scanner scanner = new Scanner(System.in);
 private Book[] books = new Book[10];
 private Reader[] readers= new Reader[10];
 private History[] historys= new History[10];
    public void run() {
     String repeat ="r";
        do{
            System.out.println("0: Выход из программы");
            System.out.println("1: Ввод Информация об книге и авторе");
            System.out.println("2: Информация о книгах");
            System.out.println("3: Ввод информации о новом читателе");
            System.out.println("4: Информация о читателях");
            System.out.println("5: информация о выданых книга");
            System.out.print("Выберети номер задачи: ");
            int task = scanner.nextInt(); scanner.nextLine();
            
            
            switch (task) {
                case 0:
                    repeat="q";
                    System.out.println("ДАВАЙ ДО ЗАВТРА!!!!!!");
                    break;
                case 1:
                    System.out.println("--------Добавляем книгу----------");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i]==null){
                        books[i]= addBook();
                        break;
                        }
                    }
                    break;
                    
                case 2:
                    System.out.println("-------------Список книг-------------");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i]!=null){
                            System.out.println(books[i].toString());
                                
                            }
                        
                    }
                break;
                case 3:
                    System.out.println("-------------Добавить читателя----------------");
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i]==null){
                        readers[i]=addReader();
                        break;
                                    }
                    }
                break;
                case 4:
                    System.out.println("-------------Cписок читателей-------------");
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i]!=null){
                            System.out.println(readers[i].toString());
                                
                            }
                        
                    }
                break;
                case 5:
                    System.out.println("-------------У какого читателя какая книга-------------");
                    for (int i = 0; i < historys.length; i++) {
                        if(historys[i]==null){
                            historys[i]= addHistory();
                            System.out.println(historys[i].toString());
                            break;
                                
                            }
                        
                    }
                break;
                default:
                    System.out.println("Введи номер из списка!!!");
            }
     }while("r".equals(repeat));   
        
        
        
    }
    private Book addBook(){
    Book book = new Book();
    System.out.print("Введите название книги: ");
    book.setNameBook(scanner.nextLine());
    System.out.print("Введите год издания книги: ");
    book.setPublishedYear(scanner.nextInt());
    System.out.print(" Введите кол-во авторов книги: ");
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
    private History addHistory(){
    History history = new History();
    for (int i = 0; i < readers.length; i++) {
        if(readers[i]==null){
            readers[i]


        history.setReader(readers[i]);
        }
    }
    
        for (int i = 0; i < books.length; i++) {
            if(books[i]==null){
                books[i]= addBook();
                
 
        history.setBook(books[i]);
            }
        }
        Calendar c = new GregorianCalendar();
        history.setGivendate(c.getTime());
            
        
    
    return history;
    
    
}
}
    
    
    
