package Diary;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Service {
    private final Map<Integer, Task> tasks;

    public Service() {
        tasks = new HashMap<>();
    }

    //The method collector
    public void fillInTask(Scanner scanner) {
        String taskName = inputTask(scanner);
        String description = inputDescription(scanner);
        String type = chooseType(scanner);
        ConstantInfo repetition = setRepetition(scanner);
        LocalDate localDate = LocalDate.now();
        if (repetition == ConstantInfo.SINGLE) {
            localDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyy"));
        } else {
            throw new DateTimeException("Введите дату в формате день.МЕСЯЦ.год");
        }
        Task task = new Task(taskName, description, type, repetition, localDate);
        tasks.put(task.getId(), task);
        System.out.println(task);
    }

    //Методы для первого пункта меню - Добавить задачу


    public static String inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        return taskName;
    }


    public static String inputDescription(Scanner scanner) {
        System.out.println("Введите описание задачи: ");
        scanner.nextLine();
        String description = scanner.nextLine();
        return description;
    }

    public static String chooseType(Scanner scanner) {
        String taskType = "Задача";
        String personalTask = "Личная задача";
        String jobTask = "Рабочая задача";


        printTypeMenu();
        System.out.println("Выберите тип задачи, личная или рабочая: ");

        int menu = scanner.nextInt();

        switch (menu) {
            case 1:
                taskType = personalTask;
                break;
            case 2:
                taskType = jobTask;
                break;
        }

        return taskType;
    }

    public static ConstantInfo setRepetition(Scanner scanner) {
        ConstantInfo constantValue = ConstantInfo.SINGLE;

        System.out.println("Введите частоту повторения:\n SINGLE, \n DAILY, \n WEEKLY, \n MONTHLY, \n ANNUALLY");
        ConstantInfo constantInfo = ConstantInfo.valueOf(scanner.next());
        switch (constantInfo) {
            case SINGLE:
                constantValue = ConstantInfo.SINGLE;
                break;
            case DAILY:
                constantValue = ConstantInfo.DAILY;
                break;
            case WEEKLY:
                constantValue = ConstantInfo.WEEKLY;
                break;
            case MONTHLY:
                constantValue = ConstantInfo.MONTHLY;
                break;
            case ANNUALLY:
                constantValue = ConstantInfo.ANNUALLY;
                break;
        }

        return constantValue;
    }

//    public static LocalDate obtainDate(Scanner scanner) {
//        System.out.println("Введите год события: ");
//        int year = scanner.nextInt();
//        System.out.println("Введите номер месяца события: ");
//        int month = scanner.nextInt();
//        System.out.println("Введите дату события: ");
//        int day = scanner.nextInt();
//        System.out.println();
//        LocalDate localDate = LocalDate.of(year, month, day);
//        return localDate;
//    }

    //Menus
    public static void printTypeMenu() {
        System.out.println(1 + ". Личная; " + "\n" + 2 + ". Рабочая;" +
                "\n" + 3 + ". Надоело кнопать");
    }

    public static void printMenu() {
        System.out.println(
                1 + ". Добавить задачу " + "\n" +
                        2 + ". Удалить задачу  " + "\n" +
                        3 + ". Получить задачу на указанный день " + "\n" +
                        0 + ". Выход"
        );
    }
}
