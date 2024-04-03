package Lab10.DFS;

public class ShowGraph {
    public static void main(String[] args)
    {
        Graph g = new Graph(12);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 7);
        g.addEdge(7, 8);
        g.addEdge(8, 9);
        g.addEdge(5, 10);
        g.addEdge(10, 11);


        System.out.println("Following is the Depth First Traversal");
        g.DFS(0);
        System.out.println("\nFollowing is the Depth First Traversal");
        g.DFS(7);
        System.out.println("\nFollowing is the Depth First Traversal");
        g.DFS(2);
    }
}

