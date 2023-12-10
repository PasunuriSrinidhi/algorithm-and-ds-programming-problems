import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person<T> {
    String name;
    T transactionType;
    int amount;

    public Person(String name, T transactionType, int amount) {
        this.name = name;
        this.transactionType = transactionType;
        this.amount = amount;
    }
}

class CashCounter<T> {
    private Queue<Person<T>> queue;
    private int cashBalance;

    public CashCounter() {
        this.queue = new LinkedList<>();
        this.cashBalance = 100000; // Initial cash balance
    }

    public void enqueue(String name, T transactionType, int amount) {
        Person<T> person = new Person<>(name, transactionType, amount);
        queue.add(person);
    }

    public void dequeue() {
        if (!queue.isEmpty()) {
            Person<T> person = queue.poll();
            if (person.transactionType.equals("deposit")) {
                cashBalance += person.amount;
                System.out.println(person.name + " deposited $" + person.amount);
            } else if (person.transactionType.equals("withdraw")) {
                if (cashBalance >= person.amount) {
                    cashBalance -= person.amount;
                    System.out.println(person.name + " withdrew $" + person.amount);
                } else {
                    System.out.println(person.name + " does not have sufficient funds for withdrawal.");
                }
            }
            System.out.println("Current Cash Balance: $" + cashBalance);
        } else {
            System.out.println("Queue is empty.");
        }
    }

    public void displayQueue() {
        System.out.print("People in Queue: ");
        for (Person<T> person : queue) {
            System.out.print(person.name + " ");
        }
        System.out.println();
    }
}

public class CashCounterProgram {
    public static void main(String[] args) {
        CashCounter<String> cashCounter = new CashCounter<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Enqueue (Deposit/Withdraw)");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter transaction type (deposit/withdraw): ");
                    String transactionType = scanner.next();
                    System.out.print("Enter amount: $");
                    int amount = scanner.nextInt();
                    cashCounter.enqueue(name, transactionType, amount);
                    break;
                case 2:
                    cashCounter.dequeue();
                    break;
                case 3:
                    cashCounter.displayQueue();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
