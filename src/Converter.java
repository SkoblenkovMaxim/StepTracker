public class Converter {
    int stepLength = 75;
    int caloriesNorm = 50;

    int convertToKm(int steps) {
        int distance;
        // Пересчет количества шагов в километры
        distance = steps * stepLength / 100000;
        return distance;
    }

    int convertStepsToKilocalories(int steps) {
        int calories;
        // Пересчет количества шагов в килокалории
        calories = steps * caloriesNorm / 1000;
        return calories;
    }
}
