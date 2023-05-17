package dijkstra;


import java.util.*;

public class Graph {

    private int relationMatrix[][]; // матрица связей вершин
    public List<Vertex> vertices;//вершины
    public List<Path> shortedPaths;

    public Graph(List<Vertex> vertices) {
        shortedPaths = new ArrayList<>();
        relationMatrix = new int[vertices.size()][vertices.size()];
        this.vertices = vertices;
        for (int [] row : relationMatrix) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
    }


    public void addEdge(int start, int end, int weight) {
        relationMatrix[start][end] = weight; // задание ребер между вершинами, с весом между ними
    }

    public void dijkstra(){
        vertices.get(0).setVisited(true);
        vertices.get(0).setDistance(0);

        for (int i = 0; i < vertices.size(); i++) {
                    System.out.println(relationMatrix[0][i]);
                    Path path = new Path();
                    path.setDistance(vertices.get(0).getDistance() + relationMatrix[0][i]);
                    path.getParentVertexes().add(0);
                    shortedPaths.add(path);
        }
        System.out.println(shortedPaths);
    }

    private int getMin(int index){
        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < vertices.size(); i++) {
            if(!vertices.get(index).isVisited() && shortedPaths.get(i).getDistance() < min){
                min = shortedPaths.get(i).getDistance(); // задаётся новый минимум
                minIndex = i; // обновление индекса вершины содержащую минимаьную дистанцию
            }
        }
        return minIndex;
    }
}

