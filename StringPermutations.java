import java.util.*;

public class StringPermutations {

    public static void main(String[] args) {
     
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String[] iterativePermutations = generatePermutationsIterative(input);
        String[] recursivePermutations = generatePermutationsRecursive(input);

        System.out.println("Iterative Permutations: " + Arrays.toString(iterativePermutations));
        System.out.println("Recursive Permutations: " + Arrays.toString(recursivePermutations));

        // Check if the arrays are equal
        boolean areEqual = Arrays.equals(iterativePermutations, recursivePermutations);
        System.out.println("Are the arrays equal? " + areEqual);
    }

    // Iterative method to generate permutations of a string
    public static String[] generatePermutationsIterative(String input) {
        int n = input.length();
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }

        String[] permutations = new String[factorial];
        permutations[0] = input;

        for (int i = 1; i < factorial; i++) {
            permutations[i] = nextPermutation(permutations[i - 1]);
        }

        return permutations;
    }

    // Recursive method to generate permutations of a string
    public static String[] generatePermutationsRecursive(String input) {
        int n = input.length();
        if (n == 0) {
            return new String[]{""};
        }

        char firstChar = input.charAt(0);
        String remaining = input.substring(1);

        String[] smallerPermutations = generatePermutationsRecursive(remaining);
        String[] permutations = new String[smallerPermutations.length * n];

        int index = 0;
        for (String smallerPermutation : smallerPermutations) {
            for (int i = 0; i <= smallerPermutation.length(); i++) {
                permutations[index++] = smallerPermutation.substring(0, i) + firstChar + smallerPermutation.substring(i);
            }
        }

        return permutations;
    }

    // Helper function to generate the next lexicographically greater permutation
    private static String nextPermutation(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int i = n - 2;

        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            while (chars[j] <= chars[i]) {
                j--;
            }
            swap(chars, i, j);
        }

        reverse(chars, i + 1, n - 1);

        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }
}
