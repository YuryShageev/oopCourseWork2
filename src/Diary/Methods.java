package Diary;

import java.time.LocalDateTime;
import java.util.Scanner;

public interface Methods{

    void setRepetition(Scanner scanner);

    String inputTask(Scanner scanner);

    String inputDescription(Scanner scanner);

    String chooseType(Scanner scanner);

    void printTypeMenu();
    void printMenu();
}
