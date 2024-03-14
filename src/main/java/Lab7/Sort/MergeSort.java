package Lab7.Sort;
import java.util.LinkedList;
import java.util.Queue;

public class MergeSort {

    // Method to create single-item queues from a queue of items
    public static <T extends Comparable<T>> Queue<Queue<T>> makeSingleItemQueues(Queue<T> items) {
        Queue<Queue<T>> singleItemQueues = new LinkedList<>();
        for (T item : items) {
            Queue<T> singleItemQueue = new LinkedList<>();
            singleItemQueue.add(item);
            singleItemQueues.add(singleItemQueue);
        }
        return singleItemQueues;
    }

    // Method to merge two sorted queues into a single sorted queue
    public static <T extends Comparable<T>> Queue<T> mergeSortedQueues(Queue<T> q1, Queue<T> q2) {
        Queue<T> mergedQueue = new LinkedList<>();
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q1.isEmpty()) {
                mergedQueue.add(q2.remove());
            } else if (q2.isEmpty()) {
                mergedQueue.add(q1.remove());
            } else {
                // Compare ignoring case if T is String
                if (q1.peek() instanceof String && q2.peek() instanceof String) {
                    String s1 = ((String) q1.peek()).toLowerCase();
                    String s2 = ((String) q2.peek()).toLowerCase();
                    if (s1.compareTo(s2) <= 0) {
                        mergedQueue.add(q1.remove());
                    } else {
                        mergedQueue.add(q2.remove());
                    }
                } else {
                    if (q1.peek().compareTo(q2.peek()) <= 0) {
                        mergedQueue.add(q1.remove());
                    } else {
                        mergedQueue.add(q2.remove());
                    }
                }
            }
        }
        return mergedQueue;
    }


    // Method to perform merge sort on a queue of items
    public static <T extends Comparable<T>> Queue<T> mergeSort(Queue<T> items) {
        if (items.size() <= 1) {
            return items;
        }

        // Split the items into two halves
        Queue<Queue<T>> singleItemQueues = makeSingleItemQueues(items);
        Queue<T> leftHalf = new LinkedList<>();
        Queue<T> rightHalf = new LinkedList<>();
        int size = singleItemQueues.size();

        for (int i = 0; i < size / 2; i++) {
            leftHalf.add(singleItemQueues.remove().remove());
        }
        while (!singleItemQueues.isEmpty()) {
            rightHalf.add(singleItemQueues.remove().remove());
        }

        // Recursively sort the left and right halves
        Queue<T> sortedLeft = mergeSort(leftHalf);
        Queue<T> sortedRight = mergeSort(rightHalf);

        // Merge the sorted left and right halves
        return mergeSortedQueues(sortedLeft, sortedRight);
    }

    // Main method to test the merge sort implementation
    public static void main(String[] args) {
        // Creating a queue of students' names
        Queue<String> students = new LinkedList<>();
        students.add("Jay");
        students.add("ali");
        students.add("Deepa");

        // Sorting the students' names using merge sort
        Queue<String> sortedStudents = mergeSort(students);

        // Creating a queue of numbers
        Queue<Integer> numbers = new LinkedList<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(5);

        // Sorting the numbers using merge sort
        Queue<Integer> sortedNumbers = mergeSort(numbers);

        // Printing the sorted students' names and numbers
        System.out.println("Sorted students: " + sortedStudents);
        System.out.println("Sorted numbers: " + sortedNumbers);
    }
}


