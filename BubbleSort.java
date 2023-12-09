import java.util.*;

class BubbleSort { 
    void bubbleSort(List<Integer> list) { 
        int n = list.size(); 
        for (int i = 0; i < n - 1; i++) 
            for (int j = 0; j < n - i - 1; j++) 
                if (list.get(j) > list.get(j + 1)) { 
                    // Swap elements using the set method
                    int temp = list.get(j); 
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                } 
    } 

    // Prints the list 
    void printList(List<Integer> list) { 
        int n = list.size(); 
        for (int i = 0; i < n; ++i) 
            System.out.print(list.get(i) + " "); 
        System.out.println(); 
    } 

    // Driver method to test above 
    public static void main(String args[]) { 
        Scanner s = new Scanner(System.in);
        BubbleSort ob = new BubbleSort(); 
        List<Integer> list = new ArrayList<>();
        
        int size = s.nextInt();
        for (int i = 0; i < size; i++) {
            int ele = s.nextInt();
            list.add(ele);
        }

        s.close(); // Closing the Scanner

        ob.bubbleSort(list); 
        System.out.println("Sorted list"); 
        ob.printList(list); 
    } 
}
