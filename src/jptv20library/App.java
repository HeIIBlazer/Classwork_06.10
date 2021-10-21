package jptv20library;

import Entity.Author;
import Entity.Book;
import Entity.History;
import Entity.Reader;
import Interfaces.Keeping;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import tools.SaveToFile;


public class App {
    private Scanner scanner = new Scanner(System.in);
    private Book[] books = new Book[10];
    private Reader[] readers= new Reader[10];
    private History[] histories= new History[10];
    private Keeping keeper= new SaveToFile();
public App() {
    books =keeper.loadBooks();
    readers=keeper.loadreaders();
    histories=keeper.loadHistories();


}
 public void run() {
     String repeat ="r";
        do{
            System.out.println("0: ����� �� ���������");
            System.out.println("1: ���� ���������� �� ����� � ������");
            System.out.println("2: ���������� � ������");
            System.out.println("3: ���� ���������� � ����� ��������");
            System.out.println("4: ���������� � ���������");
            System.out.println("5: ������ �����");
            System.out.println("6: ������ ������� �����");
            System.out.println("7: ������� �����");
            System.out.print("�������� ����� ������: ");
            int task = scanner.nextInt(); scanner.nextLine();
            
            
            switch (task) {
                case 0:
                    repeat="q";
                    System.out.println("����� �� ������!!!!!!");
                    break;
                case 1:
                    System.out.println("--------��������� �����----------");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i]==null){
                        books[i]= addBook();
                        keeper.saveBooks(books);
                        break;
                        }
                    }
                    break;
                    
                case 2:
                    System.out.println("-------------������ ����-------------");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i]!=null){
                            System.out.println(books[i].toString());
                                
                            }
                        
                    }
                break;
                case 3:
                    System.out.println("-------------�������� ��������----------------");
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i]==null){
                        readers[i]=addReader();
                        keeper.saveReaders(readers);
                        break;
                                    }
                    }
                break;
                case 4:
                    System.out.println("-------------C����� ���������-------------");
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i]!=null){
                            System.out.println(readers[i].toString());
                                
                            }
                        
                    }
               
                break;
                case 5:
                    System.out.println("-------------������ �����-------------"); 
                     for (int i = 0; i < histories.length; i++) {
                        if(histories[i]==null){
                        histories[i]=addHistories();
                        keeper.saveHistories(histories);
                        break;
                                    }
                    }
                    
                break;
                case 6:
                    System.out.println("-------------������ �������� ����-------------"); 
                    int n=0;
                    for (int i = 0; i < histories.length; i++) {
                        if(histories[i]!=null && histories[i].getReturndate()== null){
                            System.out.println(histories[i].toString());
                            System.out.println("����� "+histories[i].getBook().getNameBook()+" ������ "+histories[i].getReader().getFirstName()+" "+histories[i].getReader().getLastName());
                            n++;
                        }
                    }
                    
                if(n<1){
                    System.out.println("��� �������� ����");
                }
                break;
                    
                case 7:
                    System.out.println("---------------������� �����--------------");
                    System.out.println("������ �������� ����"); 
                    printGivenBooks();
                    System.out.println("����� ������������ �����");
                    int numberHistory =scanner.nextInt();scanner.nextLine();
                    Calendar c= new GregorianCalendar();
                    histories[numberHistory -1].setReturndate(c.getTime());
                    System.out.println("����� "+histories[numberHistory-1].getBook().getNameBook()+" ���������� "+histories[numberHistory-1].getReader().getFirstName()+" "+histories[numberHistory-1].getReader().getLastName());
                    break;
                    
                default:
                    System.out.println("����� ����� �� ������!!!");
            }
     }while("r".equals(repeat));   
        }
    private void printGivenBooks(){
        for (int i = 0; i < histories.length; i++) {
            if(histories[i]!=null && histories[i].getReturndate()== null){
                System.out.println(i+1+": ����� "+histories[i].getBook().getNameBook()+" ������ "+histories[i].getReader().getFirstName()+" "+histories[i].getReader().getLastName());
                        }
        }
    }
        
        
    
    private Book addBook(){
    Book book = new Book();
    System.out.print("������� �������� �����: ");
    book.setNameBook(scanner.nextLine());
    System.out.print("������� ��� ������� �����: ");
    book.setPublishedYear(scanner.nextInt());
    System.out.print("������� ���-�� ������� �����: ");
    int CountAuthors= scanner.nextInt(); scanner.nextLine();
    Author[] authors = new Author[CountAuthors];
    
    for (int i = 0; i < authors.length; i++) { 
        Author author =new Author();
        System.out.print("������� ��� ������: ");
        author.setFirstName(scanner.nextLine());
        System.out.print("������� ������� ������: ");
        author.setLastName(scanner.nextLine());
        System.out.print("������� ��� �������� ������: ");
        author.setBirthYear(scanner.nextInt());scanner.nextLine();
        authors[i]=author;
        }
    
    book.setAuthor(authors);
    
    return book;
    }
    
    
    
    private Reader addReader(){
    Reader reader = new Reader();
    System.out.print("������� ��� ��������: ");
    reader.setFirstName(scanner.nextLine());
    System.out.print("������� ������� ��������: ");
    reader.setLastName(scanner.nextLine());
    System.out.print("������� ���������� ����� ��������: ");
    reader.setPhone(scanner.nextLine());
    
    return reader;
    }
    private History addHistories(){
        History history = new History();
        System.out.println("������ ����");
        for (int i = 0; i < books.length; i++) {
         if(books[i]!=null){
             System.out.println(i+1+": "+books[i].toString());
         }
        }
        System.out.print("������� ����� �����: ");
        int numberBook =scanner.nextInt();scanner.nextLine();
        
        for (int i = 0; i < readers.length; i++) {
            if(readers[i]!=null){
               System.out.println(i+1+": "+readers[i].toString());    
            }
                    }
        System.out.print("������� ����� ��������: ");
        int numberReader =scanner.nextInt();scanner.nextLine();
        history.setBook(books[numberBook-1]);
        history.setReader(readers[numberReader-1]);
        Calendar c= new GregorianCalendar();
        history.setGivendate(c.getTime());
        return history;
    }

    
    
}

    
    
    
