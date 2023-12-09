import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        // Step 1: Read in the list of words
        String[] words = readWords();

        // Step 2: Perform Insertion Sort
        insertionSort(words);

        // Step 3: Print the sorted list
        System.out.println("Sorted List:");
        printArray(words);
    }

    private static String[] readWords() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the list of words (space-separated): ");
        String input = scanner.nextLine();

        // Split the input into an array of words
        return input.split("\\s+");
    }

    private static void insertionSort(String[] array) {
        int n = array.length;

        for (int i = 1; i < n; ++i) {
            String key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1] that are greater than key to one position ahead of their current position
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
    }

    private static void printArray(String[] array) {
        for (String word : array) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
}
