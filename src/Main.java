
import Diary.Service;

import java.util.Scanner;



public class Main {



    public static void main(String[] args) {
        System.out.println("Hi");
        Service service = new Service();

        //Scanner

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                service.printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            service.fillInTask(scanner);
                            break;
                        case 2:
                            // todo: обрабатываем пункт меню 2
                            break;
                        case 3:
                            // todo: обрабатываем пункт меню 3
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }




}
