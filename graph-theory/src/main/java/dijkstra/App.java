package dijkstra;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Vertex> vertices;

        vertices = Arrays.asList(new Vertex("1"),
                new Vertex("2"),
                new Vertex("3"),
                new Vertex("4"),
                new Vertex("5"),
                new Vertex("6"));

        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1, 7);
        graph.addEdge(0,2, 9);
        graph.addEdge(0,5, 14);

        graph.addEdge(1,2, 10);
        graph.addEdge(1,3, 15);

        graph.addEdge(5,2, 2);

        graph.addEdge(2,3, 11);

        graph.addEdge(3,4, 6);

        graph.addEdge(4,5, 9);
        graph.dijkstra();
    }
}
