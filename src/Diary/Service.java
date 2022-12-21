package Diary;


import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Service implements Methods {

//    HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
//map.put("Something", new ArrayList<Integer>());
//for (int i=0;i<numarulDeCopii; i++) {
//        map.get("Something").add(coeficientUzura[i]);
//    }


    //The method collector
    public static void fillInTask(Scanner scanner) {
        Service service = new Service();
        String heading = "Хлеб";
        String description = "Хлеб";
        String type = "Хлеб";
        ConstantInfo repetition = ConstantInfo.SINGLE;
        LocalDate localDate = LocalDate.now();
        Task task = new Task(heading, description, type, repetition, localDate);
        List<Task> list = new ArrayList<>();
        list.add(task);
        Map<Integer, List<Task>> map = new HashMap<>();
        map.put(task.getId(), list);
        for (Map.Entry<Integer, List<Task>> entry : map.entrySet()) {
            for (Task task1 :entry.getValue()) {
                task1.setHeading(service.inputTask(scanner));
                task1.setDescription(service.inputDescription(scanner));
                task1.setType(service.chooseType(scanner));
                task1.setRepetition(service.setRepetition(scanner));
                task1.setLocalDate(service.obtainDate(scanner));
            }

        }
        System.out.println(map.keySet());



//        for (T tasks : taskArrayList) {
//            tasks.setHeading(service.inputTask(scanner));
//            tasks.setDescription(service.inputDescription(scanner));
//            tasks.setType(service.chooseType(scanner));
//            tasks.setRepetition(service.setRepetition(scanner));
//            if (tasks.getRepetition() == ConstantInfo.SINGLE) {
//                tasks.setLocalDate(Collections.singletonList(obtainDate(scanner)));
//            }
//            if (tasks.getRepetition() == ConstantInfo.DAILY) {
//                int counter = 1;
//                while (counter < 30) {
//                    counter++;
//                    tasks.setLocalDate(Collections.singletonList(LocalDate.now().plusDays(counter)));
//                }
//            }
//            if (tasks.getRepetition() == ConstantInfo.WEEKLY) {
//                int counter = 1;
//                while (counter < 5) {
//                    counter++;
//                    tasks.setLocalDate(Collections.singletonList(LocalDate.now().plusWeeks(1)));
//                }
//            }
//
//            if (tasks.getRepetition() == ConstantInfo.MONTHLY) {
//                int counter = 1;
//                while (counter < 12 && LocalDate.now().getMonthValue() != 12) {
//                    counter++;
//                    tasks.setLocalDate(Collections.singletonList(LocalDate.now().plusMonths(1)));
//                }
//            }
//            if (tasks.getRepetition() == ConstantInfo.ANNUALLY) {
//                int counter = 1;
//                while (counter <10 && LocalDate.now().getYear() < 10) {
//                    counter++;
//                    tasks.setLocalDate(Collections.singletonList(LocalDate.now().plusYears(1)));
//                }
//            }
//            taskArrayList.add(tasks);
//            map1.put(tasks.getId(), taskArrayList);
//        }
//        this.map = map1;
//
//        System.out.println(map1);

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
        String taskType = "Задача";
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
                setRepetition(scanner);
                break;
            case 3:
                break;
        }

        return taskType;
    }

    @Override
    public ConstantInfo setRepetition(Scanner scanner) {
        ConstantInfo constantValue = ConstantInfo.DAILY;

        System.out.println("Введите частоту повторения:\n SINGLE, \n DAILY, \n WEEKLY, \n MONTHLY, \n ANNUALLY");
        ConstantInfo constantInfo = ConstantInfo.valueOf(scanner.next());
        switch (constantInfo) {
            case SINGLE:
                constantValue = ConstantInfo.SINGLE;
                obtainDate(scanner);
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

    public LocalDate obtainDate(Scanner scanner) {
        System.out.println("Введите год события: ");
        int year = scanner.nextInt();
        System.out.println("Введите номер месяца события: ");
        int month = scanner.nextInt();
        System.out.println("Введите дату события: ");
        int day = scanner.nextInt();
        System.out.println();
        LocalDate localDate = LocalDate.of(year, month, day);
        System.out.println(localDate);
        return localDate;
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

    //Методы к 3 пункту меню



//    @Override
//    public void setRepetition(Scanner scanner, Integer interval) {
////        LocalDateTime localDateTime = LocalDateTime.now().plusHours(interval);
//        Task task = new Task();
//    }
}
