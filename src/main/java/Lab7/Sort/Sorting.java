package Lab7.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        // Generate fully random list
        List<Integer> numbersFullyRandom = generateFullyRandomList();

        // Generate partially sorted list (95% sorted)
        List<Integer> numbersPartiallySorted = generatePartiallySortedRandomList();

        // Print unsorted lists
        System.out.println("Unsorted List - Fully Random:");
        printList(numbersFullyRandom);
        System.out.println();

        System.out.println("Unsorted List - Partially Sorted (95%):");
        printList(numbersPartiallySorted);
        System.out.println();

        // Convert lists to arrays for sorting
        int[] arrayFullyRandom = convertListToArray(numbersFullyRandom);
        int[] arrayPartiallySorted = convertListToArray(numbersPartiallySorted);

        // Print message before sorting fully random list
        System.out.println("Sorting Fully Random List:");
        // Apply sorting algorithms and print sorted lists with times
        sortAndPrint("Insertion Sort", arrayFullyRandom.clone());
        sortAndPrint("Quick Sort", arrayFullyRandom.clone());
        sortAndPrint("Merge Sort", arrayFullyRandom.clone());

        System.out.println();

        // Print message before sorting partially sorted list
        System.out.println("Sorting Partially Sorted List (95%):");
        sortAndPrint("Insertion Sort", arrayPartiallySorted.clone());
        sortAndPrint("Quick Sort", arrayPartiallySorted.clone());
        sortAndPrint("Merge Sort", arrayPartiallySorted.clone());
    }


    private static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }

    private static void sortAndPrint(String algorithm, int[] array) {
        long startTime = System.nanoTime();
        switch (algorithm) {
            case "Insertion Sort":
                InsertionSort.insertionSort(array);
                break;
            case "Quick Sort":
                QuickSort.quickSort(array);
                break;
            case "Merge Sort":
                MergeSort.mergeSort(array);
                break;
            default:
                break;
        }
        long endTime = System.nanoTime();

        System.out.print("Sorted by " + algorithm + ": ");
        System.out.print("Time taken: " + (endTime - startTime) + " nanoseconds - ");
        for (int num : array) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }

    private static List<Integer> generateFullyRandomList() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    private static List<Integer> generatePartiallySortedRandomList() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            numbers.add(i);
        }

        // Shuffle only 5% of the numbers randomly
        int shuffleSize = (int) (0.05 * numbers.size());
        List<Integer> shuffleIndices = new ArrayList<>();
        for (int i = 0; i < shuffleSize; i++) {
            shuffleIndices.add(i);
        }
        Collections.shuffle(shuffleIndices);

        // Shuffle the corresponding elements in the list
        for (int index : shuffleIndices) {
            int randomIndex = (int) (Math.random() * numbers.size());
            Collections.swap(numbers, index, randomIndex);
        }

        return numbers;
    }


    private static int[] convertListToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}





