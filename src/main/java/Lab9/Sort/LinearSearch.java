package Lab9.Sort;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            if (arr[i] == target) {
                return count;
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
        int iterations = linearSearch(array, target);
        System.out.println("Linear search required " + iterations + " loops to find the value");
    }
}

