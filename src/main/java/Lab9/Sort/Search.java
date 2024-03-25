package Lab9.Sort;

import java.util.Random;

public class Search {
    // Linear search method
    public static int linearSearch(int[] arr, int target) {
        long startTime = System.nanoTime(); // Measure start time in nanoseconds
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            if (arr[i] == target) {
                long estimatedTime = System.nanoTime() - startTime; // Calculate elapsed time in nanoseconds
                System.out.println("Linear search took " + count + " loops to find the value. Time taken: " + estimatedTime + " nanoseconds");
                return count;
            }
        }
        return -1;  // Target not found
    }

    // Iterative binary search method
    public static int binarySearchIterative(int[] arr, int target) {
        long startTime = System.nanoTime(); // Measure start time in nanoseconds
        int low = 0;
        int high = arr.length - 1;
        int count = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the middle index safely
            count++;

            if (arr[mid] == target) {
                long estimatedTime = System.nanoTime() - startTime; // Calculate elapsed time in nanoseconds
                System.out.println("Iterative binary search took " + count + " guesses to find the value. Time taken: " + estimatedTime + " nanoseconds");
                return count;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;  // Target not found
    }

    // Recursive binary search method
    public static int binarySearchRecursive(int[] arr, int target, int low, int high, int count, long startTime) {
        if (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the middle index safely
            count++;

            if (arr[mid] == target) {
                long estimatedTime = System.nanoTime() - startTime; // Calculate elapsed time in nanoseconds
                System.out.println("Recursive binary search took " + count + " guesses to find the value. Time taken: " + estimatedTime + " nanoseconds");
                return count;
            } else if (arr[mid] < target) {
                return binarySearchRecursive(arr, target, mid + 1, high, count, startTime);
            } else {
                return binarySearchRecursive(arr, target, low, mid - 1, count, startTime);
            }
        } else {
            System.out.println("Recursive binary search: Target not found.");
            return -1;  // Target not found
        }
    }

    // Main method
    public static void main(String[] args) {
        int[] array = new int[2000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        Random rand = new Random();
        int upperbound = 2000000;
        int int_random = rand.nextInt(upperbound);

        int target = int_random; // Sample target value
        System.out.println("Target value is: " + target);

        long startTime = System.nanoTime();
        int iterations = linearSearch(array, target);
        long linearTime = System.nanoTime() - startTime;

        int guessesIterative = binarySearchIterative(array, target);

        startTime = System.nanoTime();
        int guessesRecursive = binarySearchRecursive(array, target, 0, array.length - 1, 0, startTime);
        long recursiveTime = System.nanoTime() - startTime;

        if (recursiveTime < linearTime && guessesIterative < linearTime) {
            System.out.println("Binary search was faster.");
        } else {
            System.out.println("Linear Search was faster.");
        }
    }
}











