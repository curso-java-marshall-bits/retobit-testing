import java.util.List;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public int absoluteValue(int number) {
        return number < 0 ? -number : number;
    }

    public double average(List<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty or null");
        }

        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

    public double maximum(List<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty or null");
        }

        double max = numbers.get(0);
        for (double number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public double minimum(List<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty or null");
        }

        double min = numbers.get(0);
        for (double number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
}
