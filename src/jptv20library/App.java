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
                    for (int i = 0; i < books.size(); i++) {
                        if(books.get(i)==null){
                        books.add(addBook());
                        keeper.saveBooks(books);
                        break;
                        }
                    }
                    break;
                    
                case 2:
                    System.out.println("-------------������ ����-------------");
                    for (int i = 0; i < books.size(); i++) {
                        if(books.get(i)!=null){
                            System.out.println(books.get(i).toString());
                                
                            }
                        
                    }
                break;
                case 3:
                    System.out.println("-------------�������� ��������----------------");
                    for (int i = 0; i < readers.size(); i++) {
                        if(readers.get(i)==null){
                        readers.add(addReader());
                        keeper.saveReaders(readers);
                        break;
                                    }
                    }
                break;
                case 4:
                    System.out.println("-------------C����� ���������-------------");
                    for (int i = 0; i < readers.size(); i++) {
                        if(readers.get(i)!=null){
                            System.out.println(readers.get(i).toString());
                                
                            }
                        
                    }
               
                break;
                case 5:
                    System.out.println("-------------������ �����-------------"); 
                     for (int i = 0; i < histories.size(); i++) {
                        if(histories.get(i)==null){
                        histories.add(addHistories());
                        keeper.saveHistories(histories);
                        break;
                                    }
                    }
                    
                break;
                case 6:
                    System.out.println("-------------������ �������� ����-------------"); 
                    int n=0;
                    for (int i = 0; i < histories.size(); i++) {
                        if(histories.get(i)!=null && histories.get(i).getReturndate()== null){
                            System.out.println(histories.get(i).toString());
                            System.out.println("����� "+histories.get(i).getBook().getNameBook()+" ������ "+histories.get(i).getReader().getFirstName()+" "+histories.get(i).getReader().getLastName());
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
                    histories.get(numberHistory -1).setReturndate(c.getTime());
                    System.out.println("����� "+histories.get(numberHistory-1).getBook().getNameBook()+" ���������� "+histories.get(numberHistory-1).getReader().getFirstName()+" "+histories.get(numberHistory-1).getReader().getLastName());
                    break;
                    
                default:
                    System.out.println("����� ����� �� ������!!!");
            }
     }while("r".equals(repeat));   
        }
    private void printGivenBooks(){
        for (int i = 0; i < histories.size(); i++) {
            if(histories.get(i)!=null && histories.get(i).getReturndate()== null){
                System.out.println(i+1+": ����� "+histories.get(i).getBook().getNameBook()+" ������ "+histories.get(i).getReader().getFirstName()+" "+histories.get(i).getReader().getLastName());
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
        for (int i = 0; i < books.size(); i++) {
         if(books.get(i)!=null){
             System.out.println(i+1+": "+books.get(i).toString());
         }
        }
        System.out.print("������� ����� �����: ");
        int numberBook =scanner.nextInt();scanner.nextLine();
        
        for (int i = 0; i < readers.size(); i++) {
            if(readers.get(i)!=null){
               System.out.println(i+1+": "+readers.get(i).toString());    
            }
                    }
        System.out.print("������� ����� ��������: ");
        int numberReader =scanner.nextInt();scanner.nextLine();
        history.setBook(books.get(numberBook-1));
        history.setReader(readers.get(numberReader-1));
        Calendar c= new GregorianCalendar();
        history.setGivendate(c.getTime());
        return history;
    }

    
    
    
}

    
    
    
