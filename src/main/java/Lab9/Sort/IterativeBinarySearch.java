package Lab9.Sort;

public class IterativeBinarySearch {
    public static int binarySearchIterative(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int count = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            count++;

            if (arr[mid] == target) {
                return count;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;  // Target not found
    }

    public static void main(String[] args) {
        int[] array = new int[2000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        int target = 123456; // Sample target value
        int guessesIterative = binarySearchIterative(array, target);
        System.out.println("Binary search (Iterative) required " + guessesIterative + " guesses to find the value");
    }
}
