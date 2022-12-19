package Diary;

import java.time.LocalDateTime;
import java.util.*;

public class Service implements Methods {


    //The method collector
    public void fillInMap() {
//        Map<Integer, List<Task>> map = new HashMap<>();
//        Task task = new Task();
//        List<Task> list = new ArrayList<>();
//        list.add(task);
//        map.put(task.getId(), list);
    }

    //Методы для первого пункта меню - Добавить задачу

    @Override
    public String inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        inputDescription(scanner);

        // todo
        return taskName;
    }


    @Override
    public String inputDescription(Scanner scanner) {
        System.out.println("Введите описание задачи: ");
        scanner.nextLine();
        String description = scanner.nextLine();
        chooseType(scanner);

        return description;
    }

    @Override
    public String chooseType(Scanner scanner) {
        String taskType = null;
        String personalTask = "Личная задача";
        String jobTask = "Рабочая задача";


        printTypeMenu();
        System.out.println("Выберите тип задачи, личная или рабочая: ");

        int menu = scanner.nextInt();

        switch (menu) {
            case 1:
                taskType = personalTask;
                setRepetition(scanner);
                break;
            case 2:
                taskType = jobTask;
                break;
            case 3:
                scanner.close();
                break;
        }

        return taskType;
    }

    @Override
    public void setRepetition(Scanner scanner) {
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("Введите частоту повторения:\n SINGLE, \n DAILY, \n WEEKLY, \n MONTHLY, \n ANNUALLY");
        ConstantInfo constantInfo = ConstantInfo.valueOf(scanner.next());
        switch (constantInfo) {
            case SINGLE:
                localDateTime = LocalDateTime.now().plusDays(constantInfo.getRepeatIndex());
                break;
            case DAILY:
                localDateTime = LocalDateTime.now().plusDays(constantInfo.getRepeatIndex());
                break;
        }

    }

    //Menus
    @Override
    public void printTypeMenu() {
        System.out.println(1 + ". Личная; " + "\n" + 2 + ". Рабочая;" +
                "\n" + 3 + ". Надоело кнопать");
    }

    @Override
    public void printMenu() {
        System.out.println(
                1 + ". Добавить задачу " + "\n" +
                        2 + ". Удалить задачу  " + "\n" +
                        3 + ". Получить задачу на указанный день " + "\n" +
                        0 + ". Выход"
        );
    }


//    @Override
//    public void setRepetition(Scanner scanner, Integer interval) {
////        LocalDateTime localDateTime = LocalDateTime.now().plusHours(interval);
//        Task task = new Task();
//    }
}
