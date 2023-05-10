package dfs;

import java.util.Stack;

public class Graph {

    private final int MAX_VERTS = 10;
    private Vertex vertexArray[]; //массив вершин
    private int adjMat[][]; // матрица смежности
    private int nVerts; // текущее количество вершин
    private Stack<Integer> stack;

    /**
     * инициализация внутренних полей
     */
    public Graph() {
        vertexArray = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        stack = new Stack<>();
    }

    public void addVertex(char lab) {
        vertexArray[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexArray[v].getLabel());
    }

    /**
     * обход в глубину
     */
    public void dfs() {
        vertexArray[0].setWasVisited(true); // берётся первая вершина
        displayVertex(0);
        stack.push(0);

        while (!stack.empty()) {
            int v = getAdjUnvisitedVertex(stack.peek()); // вернуть индекс смежной вершины. Eсли нет: -1
            if (v == -1) { // если не пройденных смежных вершин нет
                stack.pop(); // элемент извлекается из стека
            }
            else {
                vertexArray[v].setWasVisited(true);
                displayVertex(v);
                stack.push(v); // элемент попадает на вершину стека
            }
        }

        for (int j = 0; j < nVerts; j++) {  // сброс флагов
            vertexArray[j].wasVisited = false;
        }

    }

    private int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && vertexArray[j].wasVisited == false) {
                return j;
            }
        }
        return -1;
    }
}