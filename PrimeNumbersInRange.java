import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersInRange {

    public static void main(String[] args) {
        List<Integer> primeNumbers = findPrimesInRange(0, 1000);

        System.out.println("Prime numbers in the range 0 to 1000:");
        System.out.println(primeNumbers);
    }

    private static List<Integer> findPrimesInRange(int start, int end) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }

        return primeNumbers;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
