import java.io.*;
import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class UnorderedList<T> {
    private Node<T> head;

    UnorderedList() {
        this.head = null;
    }

    void insert(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    void remove(T data) {
        Node<T> current = head;
        Node<T> prev = null;

        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            if (prev == null) {
                // If the node to be removed is the head
                head = current.next;
            } else {
                prev.next = current.next;
            }
        }
    }

    boolean search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true; // Found
            }
            current = current.next;
        }
        return false; // Not found
    }

    void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            Node<T> current = head;
            while (current != null) {
                writer.print(current.data + " ");
                current = current.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void saveListToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            Node<T> current = head;
            while (current != null) {
                writer.print(current.data + " ");
                current = current.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class WordListProgram {
    public static void main(String[] args) {
        UnorderedList<String> wordList = new UnorderedList<>();

        // Read from file
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNext()) {
                wordList.insert(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Take user input to search a word
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a word to search: ");
        String searchWord = userInput.next();

        // Search, add, or remove based on user input
        if (wordList.search(searchWord)) {
            System.out.println("Word found, removing...");
            wordList.remove(searchWord);
        } else {
            System.out.println("Word not found, adding...");
            wordList.insert(searchWord);
            // Also add the word to the file
            try (PrintWriter writer = new PrintWriter(new FileWriter("input.txt", true))) {
                writer.print(searchWord + " ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Display the updated list
        System.out.print("Updated List: ");
        wordList.display();

        // Save the updated list to a file
        wordList.saveListToFile("output.txt");

        userInput.close();
    }
}
