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
        
        Class<?>[] types = { Integer.class, Double.class, Short.class, Long.class, Float.class, BigDecimal.class };
        for (Class<?> type : types) {
            sortedByType.put(type, new ArrayList<>());
        }

        //numbers.forEach(number -> sortedByType.get(number.getClass()).add(number));
        for (Number number: numbers){
            sortedByType.get(number.getClass()).add(number);
        }

        for (Map.Entry<Class<?>, List<Number>> entry : sortedByType.entrySet()) {
            System.out.println(entry.getKey().getSimpleName() + ": " + entry.getValue());
        }
        
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