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
                    System.out.println("-------------Видать книгу-------------"); 
                     for (int i = 0; i < historys.length; i++) {
                        if(historys[i]==null){
                        historys[i]=addHistories();
                        break;
                                    }
                    }
                    
                break;
                case 6:
                    System.out.println("-------------Список выданных книг-------------"); 
                    int n=0;
                    for (int i = 0; i < historys.length; i++) {
                        if(historys[i]!=null && historys[i].getReturndate()== null){
                            System.out.println(historys[i].toString());
                            System.out.println("Книгу "+historys[i].getBook().getNameBook()+" читает "+historys[i].getReader().getFirstName()+" "+historys[i].getReader().getLastName());
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
                    historys[numberHistory -1].setReturndate(c.getTime());
                    System.out.println("Книга "+historys[numberHistory-1].getBook().getNameBook()+" возвращена "+historys[numberHistory-1].getReader().getFirstName()+" "+historys[numberHistory-1].getReader().getLastName());
                    break;
                    
                default:
                    System.out.println("Введи номер из списка!!!");
            }
     }while("r".equals(repeat));   
        }
    private void printGivenBooks(){
        for (int i = 0; i < historys.length; i++) {
            if(historys[i]!=null && historys[i].getReturndate()== null){
                System.out.println(i+1+": Книгу "+historys[i].getBook().getNameBook()+" читает "+historys[i].getReader().getFirstName()+" "+historys[i].getReader().getLastName());
                        }
        }
    }
        
        
    
    private Book addBook(){
    Book book = new Book();
    System.out.print("Введите название книги: ");
    book.setNameBook(scanner.nextLine());
    System.out.print("Введите год издания книги: ");
    book.setPublishedYear(scanner.nextInt());
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
        for (int i = 0; i < books.length; i++) {
         if(books[i]!=null){
             System.out.println(books[i].toString());
         }
        }
        System.out.print("Введите номер книги: ");
        int numberBook =scanner.nextInt();scanner.nextLine();
        
        for (int i = 0; i < readers.length; i++) {
            if(readers[i]!=null){
               System.out.println(readers[i].toString());    
            }
                    }
        System.out.print("Введите номер читателя: ");
        int numberReader =scanner.nextInt();scanner.nextLine();
        history.setBook(books[numberBook-1]);
        history.setReader(readers[numberReader-1]);
        Calendar c= new GregorianCalendar();
        history.setGivendate(c.getTime());
        return history;
    }

    
    
}

    
    
    
