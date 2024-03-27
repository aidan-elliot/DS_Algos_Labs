package Lab10.Hash;

import java.util.Scanner;

/**
 * This class demonstrates the use of a dynamically allocated array to implement a simple hash table
 * with linear probing for collision resolution. It allows adding strings to the hash table and viewing its current state.
 */
public class MapString {
    private static final int SIZE = 100; // Size of the hash table
    private static String[] stringBuckets = new String[SIZE]; // The hash table

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a string to the hashtable");
            System.out.println("2. View the hashtable");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter a string: ");
                    String inputString = scanner.nextLine();
                    if (!addString(inputString)) {
                        System.err.println("Error: String cannot be added. Hashtable might be full or no empty slot found within the range.");
                    }
                    break;
                case 2:
                    printHashtable();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.err.println("Invalid option.");
            }
        }
    }

    /**
     * Adds a string to the hashtable using a hash function and linear probing for collision resolution.
     * @param str The string to add.
     * @return true if the string was added successfully, false otherwise.
     */
    private static boolean addString(String str) {
        int index = hashFunction(str);
        for (int i = 0; i < SIZE; i++) {
            int currentIndex = (index + i) % SIZE;
            if (stringBuckets[currentIndex] == null) {
                stringBuckets[currentIndex] = str;
                return true;
            }
        }
        return false; // No empty slot found
    }

    /**
     * Calculates the hash value for a given string.
     * @param str The string to hash.
     * @return The hash value.
     */
    private static int hashFunction(String str) {
        int sum = 0;
        for (char ch : str.toCharArray()) {
            sum += (int) ch;
        }
        return sum % SIZE;
    }

    /**
     * Prints the current state of the hashtable, showing which slots are filled and with what strings.
     */
    private static void printHashtable() {
        System.out.println("Current hashtable:");
        for (int i = 0; i < SIZE; i++) {
            if (stringBuckets[i] != null) {
                System.out.println(i + ": " + stringBuckets[i]);
            }
        }
    }
}
