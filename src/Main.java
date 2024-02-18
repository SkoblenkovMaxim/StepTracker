import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать!");

        StepTracker stepTracker = new StepTracker(scanner);

        while(true) {
            printMenu();

            try { // Обработка исключения на случай, когда пользователь введет не число
                int command = scanner.nextInt();

                if (command == 1) {
                    System.out.println("Выполняется команда 1");
                    stepTracker.addNewNumberStepsPerDay();
                } else if (command == 2) {
                    System.out.println("Выполняется команда 2");
                    stepTracker.changeStepGoal();
                } else if (command == 3) {
                    System.out.println("Выполняется команда 3");
                    stepTracker.printStatistic();
                } else if (command == 4) {
                    System.out.println("До скорых встреч!");
                    break;
                } else {
                    System.out.println("Неизвестная команда");
                }
            } catch (Exception e) {
                System.out.println("Должно быть введено целое число.");
                break;
            }
        }
    }

    static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Установить цель по количеству шагов в день");
        System.out.println("3 - Напечатать статистику за месяц");
        System.out.println("4 - Выйти из приложения");
    }
}
