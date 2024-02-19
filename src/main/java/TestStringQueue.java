// Task 1
public class TestStringQueue {
    public static void main(String[] args) {
        /* Task 1
        //new arrayqueue instance
        ArrayQueue<String> queue = new ArrayQueue<>();

        //adds each element to queue
        queue.add("AB");
        queue.add("AC");
        queue.add("AD");
        queue.add("AE");
        queue.add("AF");

        queue.printQueue();

        //removes two elements from the front of queue
        queue.remove();
        queue.remove();

        queue.printQueue();

        //add new element to back of queue
        queue.add("AG");

        queue.printQueue();

 */
        //Task 3
        //new linked list instance
        LinkedQueue<String> queue = new LinkedQueue<>();


        System.out.println("Adds elements to queue");
        //adds each element to queue
        queue.add("AB");
        queue.add("AC");
        queue.add("AD");
        queue.add("AE");
        queue.add("AF");

        printQueue(queue);

        //removes two elements from the front of queue
        System.out.println("\nRemove two elements from queue");
        queue.remove();
        queue.remove();

        printQueue(queue);

        //add new element to back of queue
        System.out.println("\nAdd new element to queue");
        queue.add("AG");

        printQueue(queue);
    }

    private static void printQueue(LinkedQueue<String> queue) {

        LinkedQueue<String> tempQueue = new LinkedQueue<>();
        System.out.println("Current queue:");


        while (!queue.isEmpty()) {
            String element = queue.remove();
            System.out.println(element);
            tempQueue.add(element);
        }

        while (!tempQueue.isEmpty()) {
            String element = tempQueue.remove();
            queue.add(element);
        }
    }
}

