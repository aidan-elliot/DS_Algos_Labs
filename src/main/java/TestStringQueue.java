public class TestStringQueue {
    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>();

        queue.add("AB");
        queue.add("AC");
        queue.add("AD");
        queue.add("AE");
        queue.add("AF");

        queue.printQueue();

        queue.remove();
        queue.remove();

        queue.printQueue();

        queue.add("AG");

        queue.printQueue();
    }
}

