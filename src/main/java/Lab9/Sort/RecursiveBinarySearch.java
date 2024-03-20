package Lab9.Sort;

public class RecursiveBinarySearch {
    public static int binarySearchRecursive(int[] arr, int target, int low, int high, int count) {
        if (low <= high) {
            int mid = (low + high) / 2;
            count++;

            if (arr[mid] == target) {
                return count;
            } else if (arr[mid] < target) {
                return binarySearchRecursive(arr, target, mid + 1, high, count);
            } else {
                return binarySearchRecursive(arr, target, low, mid - 1, count);
            }
        } else {
            return -1;  // Target not found
        }
    }

    public static void main(String[] args) {
        int[] array = new int[2000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        int target = 123456; // Sample target value
        int guessesRecursive = binarySearchRecursive(array, target, 0, array.length - 1, 0);
        System.out.println("Binary search (Recursive) required " + guessesRecursive + " guesses to find the value");
    }
}
