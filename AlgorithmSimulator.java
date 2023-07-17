
import java.util.*;

public class AlgorithmSimulator {

//                            ||-------------------------------------Main Method----------------------------------||
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Algorithm Simulator!");

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Sorting Algorithms");
            System.out.println("2. Array Operations");
            System.out.println("3. Stack Operations");
            System.out.println("4. Queue Operations");
            System.out.println("5. Exit");
            System.out.println("");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter the number of elements: ");
                    int n = scanner.nextInt();
                    int[] arr = new int[n];
                    System.out.print("Enter the elements: ");
                    for (int i = 0; i < n; i++) {
                        arr[i] = scanner.nextInt();
                    }

                    if (isSortedAsc(arr)) {
                        System.out.println("The Array is already sorted in Ascending Order");
                    }
                    if (isSortedDsc(arr)) {
                        System.out.println("The Array is already sorted in Descending Order");
                    }
                    sortingAlgorithmsMenu(scanner, n, arr);
                    break;

                case 2:
                    System.out.println("Enter the size and no of elements  in array");
                    System.out.print("Size  ");
                    int size = scanner.nextInt();
                    String arr2[] = new String[size];
                    System.out.print("enter no of  elements of array  ");
                    int k = scanner.nextInt();
                    for (int i = 0; i < k; i++) {
                        arr2[i] = scanner.next();
                    }

                    arrayOperationsMenu(scanner, arr2, k);
                    break;

                case 3:
                    System.out.print("Enter the size of stack :");
                    int Ssize = scanner.nextInt();
                    System.out.println("");
                    String stk[] = new String[Ssize];
                    Arrays.fill(stk, "__");
                    stackOperationsMenu(scanner, stk, Ssize);
                    break;

                case 4:
                    System.out.print("Enter the size of queue :");
                    int Qsize = scanner.nextInt();
                    System.out.println("");
                    String queue[] = new String[Qsize];
                    Arrays.fill(queue, "__");

                    while (true) {
                        System.out.println("\nPlease select an option:");
                        System.out.println("1. Queue");
                        System.out.println("2. Circular Queue");
                        System.out.println("3. Exit");
                        System.out.println("");

                        int choiceQ = scanner.nextInt();
                        if (choiceQ == 1)
                            queueOperationsMenu(scanner, queue, Qsize);
                        else if (choiceQ == 2)
                            CirculqueueOperationsMenu(scanner, queue, Qsize);
                        else if (choiceQ == 3)
                            break;
                    }

                    break;

                case 5:
                    System.out.println("Exiting the Algorithm Simulator...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //                              ||-------------------------------------Sorting Methods---------------------------------||

    public static void sortingAlgorithmsMenu(Scanner scanner, int n, int arr[]) {
        System.out.println("\nSorting Algorithms:");

        while (true) {
            System.out.println("Select any option");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    String order;
                    do {
                        System.out.println("Please select an option");
                        System.out.println("a] Non-Optimized Bubble sort & Ascending Order");
                        System.out.println("b] Non-Optimized Bubble sort & Descending Order");
                        System.out.println("c] Optimized Bubble sort & Ascending Order");
                        System.out.println("d] Optimized Bubble sort & Descending Order");
                        System.out.println("e] Exit the bubble sorting");
                        order = scanner.next();

                        if (order.equals("a"))
                            performBubbleSortAsc(n, arr);
                        else if (order.equals("b"))
                            performBubbleSortDsc(n, arr);
                        else if (order.equals("c"))
                            performOptimizedBubbleSortAsc(n, arr);
                        else if (order.equals("d"))
                            performOptimizedBubbleSortDsc(n, arr);

                    } while (!(order.equals("e")));
                    break;

                case 2:
                    do {
                        System.out.println("Please select an option");
                        System.out.println("a]  Selection sort & Ascending Order");
                        System.out.println("b]  Selection sort & Descending Order");
                        System.out.println("c] Exit Selection sort");
                        order = scanner.next();

                        if (order.equals("a"))
                            performSelectionSortAsc(n, arr);
                        else if (order.equals("b"))
                            performSelectionSortDsc(n, arr);
                    } while (!(order.equals("c")));
                    break;

                case 3:
                    do {
                        System.out.println("Please select an option");
                        System.out.println("a]  Insertion sort & Ascending Order");
                        System.out.println("b]  Insertion sort & Descending Order");
                        System.out.println("c] Exit Insertion sort");
                        order = scanner.next();

                        if (order.equals("a")) {
                            System.out.println("Original array " + Arrays.toString(arr));
                            performInsertionSortAsc(n, arr);
                        } else if (order.equals("b")) {
                            performInsertionSortDsc(n, arr);
                        }
                    } while (!(order.equals("c")));
                    break;

                case 4:
                    do {
                        System.out.println("Please select an option");
                        System.out.println("a]  Merge sort & Ascending Order");
                        System.out.println("b]  Merge sort & Descending Order");
                        System.out.println("c] Exit Merge sort");
                        order = scanner.next();

                        if (order.equals("a")) {
                            System.out.println("Original array " + Arrays.toString(arr));
                            System.out.println("");
                            int array[] = new int[arr.length];
                            System.arraycopy(arr, 0, array, 0, arr.length);
                            mergeSortAsc(array);
                            System.out.println(
                                    "***************************************************************************");
                        } else if (order.equals("b")) {
                            System.out.println("");
                            System.out.println("Original array " + Arrays.toString(arr));
                            int array[] = new int[arr.length];
                            System.arraycopy(arr, 0, array, 0, arr.length);
                            mergeSortDsc(array);
                            System.out.println(
                                    "***************************************************************************");
                        }
                    } while (!(order.equals("c")));
                    break;

                case 5:
                    System.out.println("Returning to the main menu...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //                                                              ||---Already sorted or not---||

    public static boolean isSortedAsc(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSortedDsc(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    //                                                                          ||---Bubble Sort---||

    // ||---Type: 1---||

    public static void performBubbleSortAsc(int n, int arr[]) {

        int arr1[] = new int[n];
        System.arraycopy(arr, 0, arr1, 0, n);

        System.out.println("\nBubble Sort");
        int isSwap = 0;

        System.out.println("**************************************");
        System.out.println("Original Array:   " + Arrays.toString(arr));
        System.out.println("");

        for (int i = 0; i < n - 1; i++) {
            System.out.println("------ PASS :" + (i + 1) + " ------");
            System.out.println("");
            for (int j = 0; j < n - 1; j++) {
                isSwap = 0;
                if (arr1[j] > arr1[j + 1]) {
                    isSwap = 1;
                    int temp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp;
                    System.out.println("Step " + (j + 1) + " swapped " + arr1[j + 1] + " with " + arr1[j]);
                }

                // Visualization: Print the array at each step
                if (isSwap == 0)
                    System.out.println("Step " + (j + 1) + " No swap is done as " + arr1[j] + " < " + arr1[j + 1]);
                System.out.println("Step " + (j + 1) + " :    " + Arrays.toString(arr1));
            }
            System.out.println("");
        }

        System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.out.println("**************************************");
    }

    // ||---Type: 2---||

    public static void performBubbleSortDsc(int n, int arr[]) {
        int arr1[] = new int[n];
        System.arraycopy(arr, 0, arr1, 0, n);

        System.out.println("\nBubble Sort");
        int isSwap = 0;

        System.out.println("**************************************");
        System.out.println("Original Array:   " + Arrays.toString(arr));
        System.out.println("");

        for (int i = 0; i < n - 1; i++) {
            System.out.println("------ PASS :" + (i + 1) + " ------");
            System.out.println("");
            for (int j = 0; j < n - 1; j++) {
                isSwap = 0;
                if (arr1[j] < arr1[j + 1]) {
                    isSwap = 1;
                    int temp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp;
                    System.out.println("Step " + (j + 1) + " swapped " + arr1[j + 1] + " with " + arr1[j]);
                }

                
                if (isSwap == 0)
                    System.out.println("Step " + (j + 1) + " No swap is done as " + arr1[j] + " > " + arr1[j + 1]);
                System.out.println("Step " + (j + 1) + " :    " + Arrays.toString(arr1));
            }
            System.out.println("");
        }

        System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.out.println("**************************************");
    }

    // ||---Type: 3---||

    public static void performOptimizedBubbleSortAsc(int n, int arr[]) {
        int arr1[] = new int[n];
        System.arraycopy(arr, 0, arr1, 0, n);
        System.out.println("\n Optimized Bubble Sort");
        int isSwap = 0;

        System.out.println("**************************************");
        System.out.println("Original Array:   " + Arrays.toString(arr));
        System.out.println("");

        for (int i = 0; i < n - 1; i++) {
            System.out.println("------ PASS :" + (i + 1) + " ------");
            System.out.println("");
            boolean swap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                isSwap = 0;
                if (arr1[j] > arr1[j + 1]) {
                    isSwap = 1;
                    swap = true;
                    int temp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp;
                    System.out.println("Step " + (j + 1) + " swapped " + arr1[j + 1] + " with " + arr1[j]);
                }

                // Visualization: Print the array at each step
                if (isSwap == 0)
                    System.out.println("Step " + (j + 1) + " No swap is done as " + arr1[j] + " < " + arr1[j + 1]);
                System.out.println("Step " + (j + 1) + " :    " + Arrays.toString(arr1));

            }
            System.out.println("");
            if (!swap)
                break;
        }

        System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.out.println("**************************************");
    }

    // ||---Type: 4---||

    public static void performOptimizedBubbleSortDsc(int n, int arr[]) {
        int arr1[] = new int[n];
        System.arraycopy(arr, 0, arr1, 0, n);

        System.out.println("\n Optimized Bubble Sort");
        int isSwap = 0;

        System.out.println("**************************************");
        System.out.println("Original Array:   " + Arrays.toString(arr));
        System.out.println("");

        for (int i = 0; i < n - 1; i++) {
            System.out.println("------ PASS :" + (i + 1) + " ------");
            System.out.println("");
            boolean swap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                isSwap = 0;
                if (arr1[j] < arr1[j + 1]) {
                    isSwap = 1;
                    swap = true;
                    int temp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp;
                    System.out.println("Step " + (j + 1) + " swapped " + arr1[j + 1] + " with " + arr1[j]);
                }

                if (isSwap == 0)
                    System.out.println("Step " + (j + 1) + " No swap is done as " + arr1[j] + " > " + arr1[j + 1]);
                System.out.println("Step " + (j + 1) + " :    " + Arrays.toString(arr1));

            }
            System.out.println("");
            if (!swap)
                break;
        }

        System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.out.println("**************************************");

    }

    //                                                                     ||---Selection Sort---||

    // ||---Type: 1---||

    public static void performSelectionSortAsc(int n, int arr[]) {
        System.out.println("\nSelection Sort");
        int arr1[] = Arrays.copyOf(arr, n);

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println();

        for (int i = 0; i < n - 1; i++) {
            System.out.println("Pass: " + (i + 1));

            int minIndex = i;
            int step = 0; // Count the number of comparisons

            for (int j = i + 1; j < n; j++) {
                step++;
                if (arr1[j] < arr1[minIndex]) {
                    System.out.println(
                            "Step" + step + " : As " + arr1[j] + " < " + arr1[minIndex] + " so  minimum: " + arr1[j]);
                    minIndex = j;

                } else
                    System.out.println("Step" + step + " : As " + arr1[j] + " > " + arr1[minIndex] + " so  minimum: "
                            + arr1[minIndex]);
            }

            System.out.println("Minimum element: " + arr1[minIndex]);
            System.out.print("Swapping " + arr1[i] + " with " + arr1[minIndex] + "  --->");

            int temp = arr1[minIndex];
            arr1[minIndex] = arr1[i];
            arr1[i] = temp;

            System.out.println(Arrays.toString(arr1));
            System.out.println("");
        }

        System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.out.println("*********************************************");
        System.out.println("");
    }

    // ||---Type: 2---||

    public static void performSelectionSortDsc(int n, int arr[]) {
        System.out.println("\nSelection Sort");
        int arr1[] = Arrays.copyOf(arr, n);

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println();

        for (int i = 0; i < n - 1; i++) {
            System.out.println("Pass: " + (i + 1));

            int maxIndex = i;
            int step = 0; 

            for (int j = i + 1; j < n; j++) {
                step++;
                if (arr1[j] > arr1[maxIndex]) {
                    System.out.println(
                            "Step" + step + " : As " + arr1[j] + " > " + arr1[maxIndex] + " so  maximum: " + arr1[j]);
                    maxIndex = j;

                } else
                    System.out.println("Step" + step + " : As " + arr1[j] + " < " + arr1[maxIndex] + " so  maximum: "
                            + arr1[maxIndex]);
            }

            System.out.println("Minimum element: " + arr1[maxIndex]);
            System.out.print("Swapping " + arr1[i] + " with " + arr1[maxIndex] + "  --->");

            int temp = arr1[maxIndex];
            arr1[maxIndex] = arr1[i];
            arr1[i] = temp;

            System.out.println(Arrays.toString(arr1));
            System.out.println("");
        }

        System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.out.println("*********************************************");
        System.out.println("");
    }

    //                                                                      ||---Insertion Sort---||

    // ||---Type: 1---||

    public static void performInsertionSortAsc(int n, int arr[]) {
        System.out.println("\nInsertion Sort");
        int arr1[] = new int[n];
        System.arraycopy(arr, 0, arr1, 0, n);

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Elements to left of key are sorted");
        System.out.println("");

        for (int i = 1; i < n; i++) {
            int key = arr1[i];
            int j = i - 1;

            System.out.println("Pass " + i + ": ");
            System.out.println("Current key: " + key);

            while (j >= 0 && arr1[j] > key) {
                arr1[j + 1] = arr1[j];
                j--;

                System.out.println("Shifting " + arr1[j + 1] + " to the right");
            }
            arr1[j + 1] = key;
            System.out.print("Inserting key " + key + " at index " + (j + 1) + " --->");
            System.out.println(Arrays.toString(arr1));
            System.out.println("");
        }

        System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.out.println("****************************************");
    }

    // ||--Type: 2--||

    public static void performInsertionSortDsc(int n, int arr[]) {
        System.out.println("\nInsertion Sort");
        int arr1[] = new int[n];
        System.arraycopy(arr, 0, arr1, 0, n);

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Elements to left of key are sorted");
        System.out.println("");

        for (int i = 1; i < n; i++) {
            int key = arr1[i];
            int j = i - 1;

            System.out.println("Pass " + i + ": ");
            System.out.println("Current key: " + key);

            while (j >= 0 && arr1[j] < key) {
                arr1[j + 1] = arr1[j];
                j--;

                System.out.println("Shifting " + arr1[j + 1] + " to the right");
            }
            arr1[j + 1] = key;
            System.out.print("Inserting key " + key + " at index " + (j + 1) + " --->");
            System.out.println(Arrays.toString(arr1));
            System.out.println("");
        }

        System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.out.println("****************************************");
    }

    //                                                                   ||---Merge Sort---||

    // ||---Type: 1--||

    public static void mergeSortAsc(int[] array) {

        if (array.length <= 1) {
            return;
        }
        System.out.println("");
        System.out.println("Call -->");
        int mid = array.length / 2;
        System.out.println("Mid Element " + array[mid - 1]);
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, left.length);
        System.out.println("Left Sub Array  " + Arrays.toString(left));
        System.arraycopy(array, mid, right, 0, right.length);
        System.out.println("Right Sub Array " + Arrays.toString(right));
        System.out.println("");

        mergeSortAsc(left);
        mergeSortAsc(right);

        merge(left, right, array);

        System.out.println("");
    }

    private static void merge(int[] left, int[] right, int[] result) {
        int i = 0; // Index for left array
        int j = 0; // Index for right array
        int k = 0; // Index for merged array

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        System.out.println("* Merging  Left sub Array ->" + Arrays.toString(left) + "  with   Right sub Array ->"
                + Arrays.toString(right) + " after sorting");
        System.out.print("Merge: " + Arrays.toString(result));
    }

    // ||---Type: 2---||

    public static void mergeSortDsc(int[] array) {

        if (array.length <= 1) {
            return;
        }
        System.out.println("");
        System.out.println("Call -->");
        int mid = array.length / 2;
        System.out.println("Mid Element " + array[mid - 1]);
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, left.length);
        System.out.println("Left Sub Array  " + Arrays.toString(left));
        System.arraycopy(array, mid, right, 0, right.length);
        System.out.println("Right Sub Array " + Arrays.toString(right));
        System.out.println("");

        mergeSortDsc(left);
        mergeSortDsc(right);

        mergeDsc(left, right, array);

        System.out.println("");
    }

    private static void mergeDsc(int[] left, int[] right, int[] result) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] >= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        System.out.println("* Merging  Left sub Array ->" + Arrays.toString(left) + "  with   Right sub Array ->"
                + Arrays.toString(right) + " after sorting");
        System.out.print("Merge: " + Arrays.toString(result));

    }

    //                              ||-------------------------------------Array Methods---------------------------------||

    public static void arrayOperationsMenu(Scanner scanner, String arr[], int m) {

        do {
            System.out.println("\nArray Operations:");
            System.out.println("1. Insert in  Array");
            System.out.println("2. Delete from Array");
            System.out.println("3. Reverse Array");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Original array " + Arrays.toString(arr));
                    System.out.println("");
                    System.out.print("Enert the no. want to insert : ");
                    String elem = scanner.next();
                    System.out.print("Enter the position of insertion : ");
                    int pos = scanner.nextInt();
                    m = insert(arr, elem, pos - 1, m);
                    break;
                case 2:
                    System.out.println("Original array " + Arrays.toString(arr));
                    System.out.println("");
                    System.out.print("Enter the position of which want to delete : ");
                    int posd = scanner.nextInt();
                    m = delet(arr, posd - 1, m);
                    break;
                case 3:
                    reverseArray(arr, m);
                    break;
                case 4:
                    System.out.println("Returning to the main menu...");
                    return;
                default:
                    System.out.println("Please select the valid option");
            }
        } while (true);

    }

    //  ||---Insertion---||

    public static int insert(String arr[], String x, int k, int m) {
        if (m == arr.length) {
            System.out.println("Overflow");
            return -1;
        }
        if (m < 0)
            System.out.println("Invalid insertion");

        for (int i = m; i > k; i--) {
            arr[i] = arr[i - 1];
            System.out.println("");
            System.out.println(
                    "Shifting index(" + (i - 1) + ") element -> " + arr[i - 1] + ", to " + " index(" + i + ")");
            arr[i - 1] = "__";
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("");
        System.out.println("inserting " + x + " at " + k + "th index");
        arr[k] = x;
        m = m + 1;
        System.out.println("After insertion --> " + Arrays.toString(arr));
        return m;
    }

    // ||---Deletion---||

    public static int delet(String arr[], int k, int m) {
        if (k < 0 || k > m) {
            System.out.println("Underflow");
            return -1;
        }

        for (int i = k; i < m - 1; i++) {
            arr[i] = arr[i + 1];
            System.out.println("");
            System.out.println(
                    "Shifting index(" + (i + 1) + ") element -> " + arr[i + 1] + ", to " + " index(" + i + ")");
            arr[i + 1] = "__";
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("");
        m = m - 1;
        System.out.println("After deletion --> " + Arrays.toString(arr));
        return m;
    }

    // ||---Reverse Array---||

    public static void reverseArray(String arr[], int n) {
        System.out.println("\nReverse Array");
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("");

        int start = 0;
        int end = n - 1;
        int step = 0;

        while (start < end) {
            System.out.println("Step : " + (++step));
            System.out.println("Start : index(" + start + ") is " + arr[start]);
            System.out.println("End : index(" + end + ") is " + arr[end]);
            System.out.println("Swapping " + arr[start] + " with " + arr[end]);
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            System.out.println("Swapped: " + Arrays.toString(arr));
            System.out.println("");

            start++;
            end--;
        }

        System.out.println("Reversed Array: " + Arrays.toString(arr));
        System.out.print("**************************************************************");
        System.out.println("");
    }

    //                                      ||-------------------------------------Stack Operation---------------------------------||

    public static void stackOperationsMenu(Scanner scanner, String arr[], int size) {
        int top = -1;
        while (true) {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. peek");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Original Stack " + Arrays.toString(arr));
                    System.out.println("top : (" + top + ")");
                    if (top == size - 1) {
                        System.out.println("Overflow : Stack is full");
                    } else {
                        System.out.print("Enter the element to push: ");
                        String element = scanner.next();
                        System.out.println("");
                        arr[++top] = element;
                        System.out.println("Element " + element + " pushed to the stack.");
                        System.out.println("Stack After push :" + Arrays.toString(arr));
                        System.out.println("Now Top : (" + top + ")");
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Original Stack " + Arrays.toString(arr));
                    System.out.println("top : (" + top + ")");
                    if (top == -1) {
                        System.out.println("Underflow : stack is empty");
                    } else {
                        System.out.println("Top : index(" + top + ") --> " + arr[top] + " is removed ");
                        arr[top--] = "__";
                        System.out.println("Stack After pop: " + Arrays.toString(arr));
                        System.out.println("Now Top : index(" + top + ")");
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Element at top of stack : " + arr[top]);
                    break;
                case 4:
                    System.out.println("Returning to the main menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //                               ||-------------------------------------Queue Operation---------------------------------||

    private static void queueOperationsMenu(Scanner scanner, String queue[], int size) {
        int front = -1;
        int rear = -1;
        while (true) {
            System.out.println("\nQueue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. peek");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    String element = scanner.next();

                    if (rear != -1)
                        System.out.println("Rear is : (" + rear + ") -->" + queue[rear]);
                    if (rear == -1)
                        System.out.println("Rear is : (" + rear + ")");

                    System.out.println("Queue :" + Arrays.toString(queue));
                    System.out.println("");

                    if (rear == size - 1) {
                        System.out.println("Queue is full");
                    } else {
                        queue[++rear] = element;
                        if (front == -1)
                            front++;
                        System.out.println("Element " + element + " enqueued to the queue.");
                        System.out.println("Rear after enqueue index(" + rear + ") -->" + queue[rear]);
                        System.out.println("Queue after enqueue :" + Arrays.toString(queue));
                    }
                    break;
                case 2:
                    if (front != -1)
                        System.out.println("Front is : index (" + front + ") --> " + queue[front]);
                    if (front == -1)
                        System.out.println("Front is : index (" + front + ")");
                    System.out.println("Queue :" + Arrays.toString(queue));
                    System.out.println("");
                    if (front == -1) {
                        System.out.println("Queue is empty");
                    }
                    if (front == rear) {
                        queue[front] = "__";
                        front = -1;
                        rear = -1;
                        System.out.println("Front after dequeue " + front);
                        System.out.println("Queue after dequeue :" + Arrays.toString(queue));
                    } else {
                        queue[front] = "__";
                        front++;
                        System.out.println("Front after dequeue " + front);
                        System.out.println("Queue after dequeue :" + Arrays.toString(queue));

                    }
                    break;
                case 3:
                    if (front != -1)
                        System.out.println("Peek element of Queue: " + queue[front]);
                    break;
                case 4:
                    System.out.println("Returning to  Menu : Queue Selection...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //                          ||-------------------------------------Circular Queue---------------------------------||

    private static void CirculqueueOperationsMenu(Scanner scanner, String[] queue, int size) {
        int front = -1;
        int rear = -1;
        Arrays.fill(queue, "__");
        while (true) {
            System.out.println("\nQueue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    String element = scanner.next();
                    System.out.println("");

                    if (rear != -1)
                        System.out.println("Rear is : (" + rear + ") -->" + queue[rear]);
                    if (rear == -1)
                        System.out.println("Rear is : (" + rear + ")");

                    if ((front == 0 && rear == size - 1) || (rear == front - 1)) {
                        System.out.println("Queue is full. Cannot enqueue an element.");
                    } else {
                        if (front == -1) {
                            front = 0;
                        }
                        rear = (rear + 1) % size;
                        queue[rear] = element;
                        System.out.println("Element " + element + " enqueued to the queue.");
                        System.out.println("Rear after enqueue index (" + rear + ") --> " + queue[rear]);
                        System.out.println("Queue after enqueue: " + Arrays.toString(queue));
                    }
                    break;
                case 2:
                    if (front == -1) {
                        System.out.println("Front is : index (" + front + ")");
                        System.out.println("Queue is empty. Cannot dequeue an element.");
                    } else {
                        System.out.println("Front is : index (" + front + ") --> " + queue[front]);
                        System.out.println("Queue: " + Arrays.toString(queue));
                        if (front == rear) {
                            front = -1;
                            rear = -1;
                        } else {
                            queue[front] = "__";
                            front = (front + 1) % size;
                        }
                        System.out.println("Front after dequeue:  index(" + front + ")");
                        System.out.println("Queue after dequeue: " + Arrays.toString(queue));
                    }
                    break;
                case 3:
                    if (front == -1) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Peek element of Queue: " + queue[front]);
                    }
                    break;
                case 4:
                    System.out.println("Returning to  Menu : Queue Selection...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
