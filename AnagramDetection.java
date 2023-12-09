import java.util.Arrays;
import java.util.Scanner;

public class AnagramDetection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take two strings as input
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        // Step 2: Check if the strings are anagrams
        if (areAnagrams(str1, str2)) {
            System.out.println("The two strings are Anagrams.");
        } else {
            System.out.println("The two strings are not Anagrams.");
        }

        scanner.close();
    }

    private static boolean areAnagrams(String str1, String str2) {
        // Step 3: Remove spaces and convert to lowercase for case-insensitive comparison
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // Step 4: Check if the lengths are the same
        if (str1.length() != str2.length()) {
            return false;
        }

        // Step 5: Sort the characters in both strings
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Step 6: Compare the sorted strings
        return Arrays.equals(charArray1, charArray2);
    }
}
