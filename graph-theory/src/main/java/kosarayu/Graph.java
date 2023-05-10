package kosarayu;


import java.util.Stack;

public class Graph {

    private Vertex vertexArray[]; //массив вершин
    private int adjMat[][]; // матрица смежности
    private int nVerts; // текущее количество вершин
    private Stack<Integer> stack;
    private Vertex sortVertex[];

    public Graph(Vertex [] vertexArray) {

        this.vertexArray = vertexArray;
        this.sortVertex = new Vertex[vertexArray.length];

        adjMat = new int[vertexArray.length][vertexArray.length];
        nVerts = 0;
        for (int j = 0; j < vertexArray.length; j++) {
            for (int k = 0; k < vertexArray.length; k++) {
                adjMat[j][k] = 0;
            }
        }
        stack = new Stack<>();
    }

    /**
     * обход в глубину
     */
    public void dfs() {
        int sortedVertexIndexCount = 0;
        vertexArray[0].setRed(true); // берётся первая вершина
        displayVertex(0);
        stack.push(0);

        while (!stack.empty()) {
            int v = getAdjUnvisitedVertex(stack.peek()); // вернуть индекс смежной вершины. Eсли нет: -1
            if (v == -1) { // если не пройденных смежных вершин нет
                int index = stack.pop();// элемент извлекается из стека
                vertexArray[index].setGreen(true);
                Vertex vertex = vertexArray[index];
                sortVertex[sortedVertexIndexCount] = vertex;
                sortedVertexIndexCount++;
            }
            else {
                vertexArray[v].setRed(true);
                displayVertex(v);
                stack.push(v); // элемент попадает на вершину стека
            }
        }
    }

    //рекурсия?
    private int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && vertexArray[j].isRed == false && vertexArray[j].isGreen == false) {
                return j;
            }
        }
        return -1;
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

}
