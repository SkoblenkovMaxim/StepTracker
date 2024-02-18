import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    MonthData monthData = new MonthData();
    Converter converter = new Converter();
    Scanner scanner;
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        int monthNumber;
        int day;
        int steps;

        System.out.println("Введите номер месяца: от 1 до 12: ");
        monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Значение должно быть от 1 до 12!");
            return;
        }
        System.out.println("Введите номер дня: от 1 до 30: ");
        day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Значение должно быть от 1 до 30!");
            return;
        }
        System.out.println("Введите количество шагов: ");
        steps = scanner.nextInt();
        if (steps <= 0) {
            System.out.println("Значение должно быть больше ноля.");
            return;
        }
        MonthData monthData = monthToData[monthNumber - 1];
        monthData.days[day - 1] = steps;
    }

    void changeStepGoal() {
        System.out.println("Введите значение больше ноля");
        goalByStepsPerDay = scanner.nextInt();
        if (goalByStepsPerDay <= 0) {
            System.out.println("Значение должно быть больше  ноля.");
            return;
        }
        System.out.println("Установлена новая цель: " + goalByStepsPerDay + " шагов");
    }

    void printStatistic() {
        int monthNumber;

        System.out.println("Введите номер месяца от 1 до 12: ");
        monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Значение должно быть от 1 до 12 включительно.");
            return;
        }
        monthData = monthToData[monthNumber - 1];
        // Количество пройденных шагов по дням
        monthData.printDaysAndStepsFromMonth();
        // Общее количество шагов за месяц
        System.out.println("Пройдено всего " + monthData.sumStepsFromMonth() + " шагов.");
        // Максимальное пройденное количество шагов в месяце
        System.out.println("Максимальное количество " + monthData.maxSteps() + " шагов");
        // Среднее количество шагов в месяц
        int averageSteps = monthData.sumStepsFromMonth() / monthData.days.length;
        System.out.println("Среднее количество шагов: " + averageSteps);
        // Суммарное количество пройдено (км)
        System.out.println("Всего пройдено " + converter.convertToKm(monthData.sumStepsFromMonth())
           + " километров.");
        // Количество сожжённых килокалорий
        System.out.println("Всего сожжено " + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth())
           + " килокалорий.");
        // Лучшая серия
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay) + " дней подряд.");
    }
}
