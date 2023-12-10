import java.util.LinkedList;
import java.util.Deque;
import java.util.Scanner;

class PalindromeChecker<T> {
    private Deque<T> deque;

    public PalindromeChecker() {
        this.deque = new LinkedList<>();
    }

    public void addToRear(T data) {
        deque.addLast(data);
    }

    public boolean isPalindrome() {
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false; // If characters from both ends are not equal, it's not a palindrome
            }
        }
        return true; // All characters matched, it's a palindrome
    }
}

public class PalindromeCheckerProgram {
    public static void main(String[] args) {
        PalindromeChecker<Character> palindromeChecker = new PalindromeChecker<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        for (char ch : inputString.toCharArray()) {
            palindromeChecker.addToRear(ch);
        }

        boolean result = palindromeChecker.isPalindrome();
        System.out.println("Is the string a palindrome? " + result);

        scanner.close();
    }
}
