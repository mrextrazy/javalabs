import java.math.BigDecimal;
import java.util.*;

public class NumberOperations {

    public static void main(String[] args) {
        List<Number> numbers = List.of(
            0, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9,
            (short) 5, (long) 100L, 15.6f, new BigDecimal("123.678")
        );
        System.out.println("All numbers: " + numbers);
        Map<Class<?>, List<Number>> sortedByType = new HashMap<>();
        
        sortedByType.put(Integer.class, new ArrayList<>());
        sortedByType.put(Double.class, new ArrayList<>());
        sortedByType.put(Short.class, new ArrayList<>());
        sortedByType.put(Long.class, new ArrayList<>());
        sortedByType.put(Float.class, new ArrayList<>());
        sortedByType.put(BigDecimal.class, new ArrayList<>());

        numbers.forEach(number -> sortedByType.get(number.getClass()).add(number));

        System.out.println("Integers: " + sortedByType.get(Integer.class));
        System.out.println("Doubles: " + sortedByType.get(Double.class));
        System.out.println("Shorts: " + sortedByType.get(Short.class));
        System.out.println("Longs: " + sortedByType.get(Long.class));
        System.out.println("Floats: " + sortedByType.get(Float.class));
        System.out.println("BigDecimals: " + sortedByType.get(BigDecimal.class));

        double sumOfSquares = calculateSumOfSquares(numbers);
        System.out.println("Sum of squares: " + sumOfSquares);
    }

    public static double calculateSumOfSquares(List<Number> numbers) {
        double sumOfSquares = 0;
        for (Number number : numbers) {
            double value = number.doubleValue();
            sumOfSquares += Math.pow(value, 2);
        }
        return sumOfSquares;
    }
}