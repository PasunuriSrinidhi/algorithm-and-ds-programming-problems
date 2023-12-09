import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSortString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take input from the user
        List<String> stringList = new ArrayList<>();
        System.out.println("Enter the size: ");
        int size = scanner.nextInt();
        for(int i=0;i<size;i++){
String str=scanner.next();
stringList.add(str);

}

       
        // Step 2: Perform Merge Sort
        mergeSort(stringList);

        // Step 3: Print the sorted list
        System.out.println("Sorted List: " + stringList);

        scanner.close();
    }

    public static void mergeSort(List<String> list) {
        if (list.size() > 1) {
            int mid = list.size() / 2;

            List<String> left = new ArrayList<>(list.subList(0, mid));
            List<String> right = new ArrayList<>(list.subList(mid, list.size()));

            mergeSort(left);
            mergeSort(right);

            merge(list, left, right);
        }
    }

    private static void merge(List<String> result, List<String> left, List<String> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) < 0) {
                result.set(k++, left.get(i++));
            } else {
                result.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            result.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            result.set(k++, right.get(j++));
        }
    }
}
