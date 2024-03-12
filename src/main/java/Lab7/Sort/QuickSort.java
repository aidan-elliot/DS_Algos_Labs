package Lab7.Sort;

public class QuickSort {
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (begin >= end) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[begin];
        int low = begin + 1;
        int high = end;
        while (low <= high) {
            while (low <= high && array[low] <= pivot) low++;
            while (low <= high && array[high] > pivot) high--;
            if (low < high) {
                swap(array, low, high);
            }
        }
        swap(array, begin, high);
        return high;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}


