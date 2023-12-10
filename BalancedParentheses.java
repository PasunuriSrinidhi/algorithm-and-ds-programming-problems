import java.util.*;


class Stack<T> {
    
private Object[] arr;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    public Stack() {
        arr = new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    public void push(T data) {
        if (top == arr.length - 1) {
            // Resize the array if it's full
            resize();
        }
        arr[++top] = data;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) arr[top--];
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    private void resize() {
        int newCapacity = arr.length * 2;
        Object[] newArr = new Object[newCapacity];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

}

public class BalancedParentheses {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false; // Unmatched closing parenthesis
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an arithmetic expression: ");
        String arithmeticExpression = scanner.nextLine();

        boolean result = isBalanced(arithmeticExpression);
        System.out.println("Arithmetic Expression is balanced or not: " + result);

        scanner.close();
    }
}
