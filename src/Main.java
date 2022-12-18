import Diary.ConstantInfo;
import Diary.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static Diary.ConstantInfo.SINGLE;
import static Diary.ConstantInfo.WEEKLY;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hi");

        //Testing
        Task task = new Task("Купить хлеба", "Нужно выйти из дома и зайти в пятёрочку", "Личная задача", SINGLE);
        Task task1 = new Task("Купить воды", "Нужно выйти из дома и зайти в пятёрочку", "Личная задача", WEEKLY);
        System.out.println(task.getId());
        System.out.println(task1.getId());

        System.out.println(task.getRepetition());


        //Scanner

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
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

    private static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        // todo
    }

    private static void printMenu() {
        System.out.println(
                1 + "Добавить задачу " + 2 + "Удалить задачу  " + 3 + "Получить задачу на указанный день " +
                        0 + "Выход"
        );
    }
}
