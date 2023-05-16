package kruskal;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Edge> graphEdges = new ArrayList<>();
        graphEdges.add(new Edge(3, 5, 2));
        graphEdges.add(new Edge(6, 7, 5));
        graphEdges.add(new Edge(3, 4, 6));
        graphEdges.add(new Edge(4, 8, 7));
        graphEdges.add(new Edge(1, 2, 9));
        graphEdges.add(new Edge(4, 5, 11));
        graphEdges.add(new Edge(1, 6, 14));
        graphEdges.add(new Edge(1, 7, 15));
        graphEdges.add(new Edge(5, 8, 16));
        graphEdges.add(new Edge(3, 6, 18));
        graphEdges.add(new Edge(3, 8, 19));
        graphEdges.add(new Edge(7, 5, 20));
        graphEdges.add(new Edge(2, 3, 24));
        graphEdges.add(new Edge(7, 8, 44));
        graphEdges.add(new Edge(6, 5, 30));

        int nodeCount = 8;

        Kruskal graph = new Kruskal();
        graph.kruskal(graphEdges, nodeCount);
    }
}
