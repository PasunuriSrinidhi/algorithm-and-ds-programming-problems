import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class WordSearch {

    public static void main(String[] args) {
        // Step 1: Read in the list of words from a file
        String[] wordList = readWordListFromFile("wordList.txt");

        // Step 2: Sort the word list using Arrays.sort()
        Arrays.sort(wordList);

        // Step 3: Prompt the user to enter a word to search
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to search: ");
        String searchWord = scanner.next();

        // Step 4: Perform binary search and print the result
        boolean isWordFound = binarySearch(wordList, searchWord);

        if (isWordFound) {
            System.out.println(searchWord + " is found in the word list.");
        } else {
            System.out.println(searchWord + " is not found in the word list.");
        }

        scanner.close();
    }

    private static String[] readWordListFromFile(String filePath) {
        // Assuming the words are comma-separated in the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            return line.split(",");
        } catch (IOException e) {
            System.err.println("Error reading the word list file: " + e.getMessage());
            return new String[0]; // Return an empty array in case of an error
        }
    }

    private static boolean binarySearch(String[] wordList, String searchWord) {
        int left = 0;
        int right = wordList.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparisonResult = searchWord.compareTo(wordList[mid]);

            if (comparisonResult == 0) {
                return true; // Word found
            } else if (comparisonResult < 0) {
                right = mid - 1; // Search in the left half
            } else {
                left = mid + 1; // Search in the right half
            }
        }

        return false; // Word not found
    }
}
