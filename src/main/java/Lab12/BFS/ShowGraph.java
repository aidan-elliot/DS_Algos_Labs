package Lab12.BFS;

public class ShowGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(12);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(3, 4);
        graph.insertEdge(3, 5);
        graph.insertEdge(4, 6);
        graph.insertEdge(5, 7);
        graph.insertEdge(7, 8);
        graph.insertEdge(8, 9);
        graph.insertEdge(5, 10);
        graph.insertEdge(10, 11);

        System.out.println("Breadth First Traversal for the graph is:\n");
        graph.BFS(0);
        System.out.println("\nBreadth First Traversal for the graph is:\n");
        graph.BFS(7);
        System.out.println("\nBreadth First Traversal for the graph is:\n");
        graph.BFS(2);
    }
}
