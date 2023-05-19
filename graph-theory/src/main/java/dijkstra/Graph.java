package dijkstra;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    private int relationMatrix[][]; // матрица связей вершин
    public List<Vertex> vertices;//вершины
    public List<Path> shortedPaths;
    private int startToCurrent = 0;

    public Graph(List<Vertex> vertices) {
        shortedPaths = new ArrayList<>();
        relationMatrix = new int[vertices.size()][vertices.size()];
        this.vertices = vertices;
        for (int[] row : relationMatrix) {
            Arrays.fill(row, 10000);
        }
    }


    public void addEdge(int start, int end, int weight) {
        relationMatrix[start][end] = weight; // задание ребер между вершинами, с весом между ними
        relationMatrix[end][start] = weight;
    }

    public void dijkstra() {
            find(0);
    }

    private void find(int i) {
        relationMatrix[i][i] = 0;
        for (int j = 0; j < vertices.size(); j++) {
            Path path = new Path();
            path.setDistance(relationMatrix[i][j]);
            path.getParentVertexes().add(i);
            shortedPaths.add(path);
        }
        vertices.get(i).setVisited(true);
        System.out.println(shortedPaths + " shortest");
        for (int j = 0; j < vertices.size(); j++) {
            System.out.println("iteration on vertex");
            int minimalPathForCurrentVertexIndex = findMinimalPathForCurrentVertexIndex();
            System.out.println((minimalPathForCurrentVertexIndex + 1) + " minimal path to neighbourhood vertex from vertex " + (j + 1));

            startToCurrent = shortedPaths.get(minimalPathForCurrentVertexIndex).getDistance();
            vertices.get(minimalPathForCurrentVertexIndex).setVisited(true);

            for (int x = 0; x < vertices.size(); x++) {
                if (relationMatrix[minimalPathForCurrentVertexIndex][x] + startToCurrent < shortedPaths.get(x).getDistance()
                        && !vertices.get(x).isVisited()) {

                    //toDo реализовать построение пути
                    shortedPaths.get(x).setDistance(relationMatrix[minimalPathForCurrentVertexIndex][x] + startToCurrent);
                    LinkedList<Integer> xc = shortedPaths.get(minimalPathForCurrentVertexIndex).getParentVertexes();
                    shortedPaths.get(x).setParentVertexes(xc);
                    shortedPaths.get(x).getParentVertexes().add(minimalPathForCurrentVertexIndex);
                }
                System.out.println(shortedPaths);
            }
        }
    }


    private int findMinimalPathForCurrentVertexIndex() {
        int minimalDistance = 10000;
        int minimalDistanceIndex = 0;
        for (int j = 0; j < vertices.size(); j++) {
            if (shortedPaths.get(j).getDistance() < minimalDistance && !vertices.get(j).isVisited()) {
                minimalDistance = shortedPaths.get(j).getDistance();
                minimalDistanceIndex = j;
            }
        }
        return minimalDistanceIndex;
    }
}

