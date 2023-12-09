import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking the command-line argument N
        System.out.print("Enter the value of N (2^n): ");
        int n = scanner.nextInt();
        int N = (int) Math.pow(2, n);

        // Guessing the number
        int low = 0;
        int high = N - 1;

        System.out.println("Think of a number between 0 and " + (N - 1));

        int steps = guessNumber(low, high);

        System.out.println("Number found in " + steps + " steps.");
        scanner.close();
    }

    private static int guessNumber(int low, int high) {
        Scanner scanner = new Scanner(System.in);

        int steps = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            System.out.println("Is the number between " + low + " and " + mid + "? (true/false)");
            boolean response = scanner.nextBoolean();

            steps++;

            if (response) {
                // Number is in the lower half
                high = mid - 1;
            } else {
                // Number is in the upper half
                low = mid + 1;
            }

            if (low == high) {
                System.out.println("Is your number " + low + "? (true/false)");
                boolean finalResponse = scanner.nextBoolean();
                if (finalResponse) {
                    break;
                } else {
                    System.out.println("You provided incorrect responses!");
                    steps = -1;
                    break;
                }
            }
        }

        scanner.close();
        return steps;
    }
}
