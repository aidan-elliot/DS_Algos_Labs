package Lab12.BFS;

import java.util.LinkedList;
import java.util.Queue;

class Graph {
    private LinkedList<Integer>[] adjLists;
    private int numVertices;

    // Graph constructor
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjLists = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    // Add edge
    void insertEdge(int src, int dest) {
        adjLists[src].add(dest);
        // For undirected graph, add an edge from dest to src also
        adjLists[dest].add(src);
    }

    // BFS algorithm
    void BFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int adjVertex : adjLists[vertex]) {
                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
        }
    }
}

