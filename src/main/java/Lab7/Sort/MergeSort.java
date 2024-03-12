package Lab7.Sort;
public class MergeSort {
    public static int[] mergeSort(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    private static int[] mergeSort(int[] array, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(array, begin, mid);
            mergeSort(array, mid + 1, end);
            merge(array, begin, mid, end);
        }
        return array;
    }

    private static void merge(int[] array, int begin, int mid, int end) {
        int n1 = mid - begin + 1;
        int n2 = end - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; ++i) {
            left[i] = array[begin + i];
        }
        for (int j = 0; j < n2; ++j) {
            right[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = begin;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
}
