package jptv20library;

import java.util.Scanner;

public class App {
    public void run() {
     String repeat ="r";
        do{
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Выберети номер задачи: ");
            int task = scanner.nextInt();
            System.out.println("0: Выход из программы");
            
            switch (task) {
                case 0:
                    repeat="q";
                    System.out.println("ДАВАЙ ДО ЗАВТРА!!!!!!");
                    break;
                default:
                    System.out.println("Введи номер из списка!!!");
            }
     }while("r".equals(repeat));   
        
        
        
    }
    
    
}
