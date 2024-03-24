package Lab9.Sort;
import java.lang.*;
import java.util.Random;

public class Search {
    public static int linearSearch(int[] arr, int target) {
        long lsstartTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            if (arr[i] == target) {
                long lsestimatedTime = System.currentTimeMillis() - lsstartTime;
                System.out.println("Linear search took " + count + " loops to find the value. Time taken: " + lsestimatedTime + " nanoseconds");
                return count;
            }
        }
        return -1;  // Target not found
    }

    public static int binarySearchIterative(int[] arr, int target) {
        long bsistartTime = System.currentTimeMillis();
        int low = 0;
        int high = arr.length - 1;
        int count = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            count++;

            if (arr[mid] == target) {
                long bsiestimatedTime = System.currentTimeMillis() - bsistartTime;
                System.out.println("Iterative binary search took " + count + " guesses to find the value. Time taken: " + bsiestimatedTime + " nanoseconds");
                return count;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;  // Target not found
    }

    public static int binarySearchRecursive(int[] arr, int target, int low, int high, int count) {
        long bsrstartTime = System.currentTimeMillis();
        if (low <= high) {
            int mid = (low + high) / 2;
            count++;

            if (arr[mid] == target) {
                long bsrestimatedTime = System.currentTimeMillis() - bsrstartTime;
                System.out.println("Recursive binary search took " + count + " guesses to find the value. Time taken: " + bsrestimatedTime + " nanoseconds");
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
        int[] array = new int[200000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        Random rand = new Random();
        int upperbound = 200000000;
        int int_random = rand.nextInt(upperbound);

        int target = int_random; // Sample target value
        System.out.println("Target value is: " + target);
        int iterations = linearSearch(array, target);
        int guessesIterative = binarySearchIterative(array, target);
        int guessesRecursive = binarySearchRecursive(array, target, 0, array.length - 1, 0);

        if (iterations > guessesRecursive || iterations > guessesIterative) {
            System.out.println("Binary search was faster.");
        } else {
            System.out.println("Linear Search was faster.");
        }
    }
}


