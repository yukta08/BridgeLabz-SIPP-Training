import java.util.*;

public class Sorting_Performance_Compare 
{
    // Bubble Sort: O(N^2)
    public static void bubbleSort(int[] arr) 
    {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) 
        {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) 
            {
                if (arr[j] > arr[j + 1]) 
                {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Merge Sort: O(N log N)
    public static void mergeSort(int[] arr, int l, int r) 
    {
        if (l < r) 
        {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) 
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) 
        {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort: O(N log N)
    public static void quickSort(int[] arr, int low, int high) 
    {
        if (low < high) 
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) 
    {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) 
        {
            if (arr[j] < pivot) 
            {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int t = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = t;
        return i + 1;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter dataset size: ");
        int n = sc.nextInt();

        int[] original = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++)
            original[i] = rand.nextInt(1_000_000);

        int[] a1 = Arrays.copyOf(original, n);
        int[] a2 = Arrays.copyOf(original, n);
        int[] a3 = Arrays.copyOf(original, n);

        long start, time;

        // Bubble Sort
        start = System.nanoTime();
        bubbleSort(a1);
        time = System.nanoTime() - start;
        System.out.println("Bubble Sort Time: " + time / 1_000_000.0 + " ms");

        // Merge Sort
        start = System.nanoTime();
        mergeSort(a2, 0, n - 1);
        time = System.nanoTime() - start;
        System.out.println("Merge Sort Time: " + time / 1_000_000.0 + " ms");

        // Quick Sort
        start = System.nanoTime();
        quickSort(a3, 0, n - 1);
        time = System.nanoTime() - start;
        System.out.println("Quick Sort Time: " + time / 1_000_000.0 + " ms");

        sc.close();
    }
}
