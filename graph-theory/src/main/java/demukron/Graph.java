package demukron;

import java.util.Arrays;
import java.util.Stack;

/**
 * Топологическая сортировка (Topological sort) — один из основных алгоритмов на графах, который применяется для
 * решения множества более сложных задач.
 * Задача топологической сортировки графа состоит в следующем: указать такой линейный порядок на его вершинах,
 * чтобы любое ребро вело от вершины с меньшим номером к вершине с большим номером. Очевидно, что если в графе есть
 * циклы, то такого порядка не существует.
 * Ориентированной сетью (или просто сетью) называют бесконтурный ориентированный граф. В задачах подобного плана
 * рассматриваются только конечные сети.
 * <br/>
 * <br/>
 * Наглядно процесс определения уровней вершин можно представить следующим образом. Нулевой уровень образуют входы
 * сети - вершины с полустепенью захода, равной 0. Удалив из сети все вершины нулевого уровня и исходящие из них дуги,
 * вновь получим сеть, входами которой будут вершины первого уровня исходной сети. Указанный процесс "послойного"
 * удаления вершин следует продолжать до тех пор, пока все вершины исходной сети не будут распределены по уровням.
 * Алгоритм Демукрона использует матрицу смежности вершин В типа n x n в качестве средства представления сети и основан
 * непосредственно на определении уровня вершины и свойствах матрицы В. Можно увидеть, что сумма элементов k-го столбца
 * матрицы В равна полустепени захода вершины Vk. Поэтому, просуммировав элементы матрицы по всем столбцам и выбрав
 * вершины, соответствующие столбцам с нулевой суммой, получим множество вершин нулевого уровня - входы сети.
 */
public class Graph {

    private final int MAX_VERTS = 8;
    private Vertex vertexList[]; //массив вершин
    private int adjMat[][]; // матрица смежности
    private int nVerts; // текущее количество вершин
    private Stack<Integer> stack;
    private Vertex sortedVertexList[];

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        sortedVertexList = new Vertex[MAX_VERTS];
        nVerts = 0;
        for (int rec[] : adjMat) {
            Arrays.fill(rec, 0);
        }
        stack = new Stack<>();
    }

    /**
     * Реализация плгоритма Демукрона для топологической сортировки ориентированного графа
     */
    public void demukron() {

        int sum[] = new int[MAX_VERTS];
        //получаем сумму по каждому из столбцов
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {
                sum[j] += adjMat[i][j];
            }
        }
        //итерируемся по всем рядам
        for (int y = 0; y < MAX_VERTS; y++) {
            //поиск элемента, чья полустепень входа == 0 (то есть, он независим от других вершин графа)
            int zeroElementIndex = findZeroElementIndex(sum);

            addVertexToSortedVertexList(zeroElementIndex, y, sum);

            if (zeroElementIndex != -1) {
                int[] rowForZeroIndexElement = getRowForZeroElementIndex(zeroElementIndex);
                subtractingArrays(rowForZeroIndexElement, sum);
            } else throw new RuntimeException("This oriented graph cannot be " +
                    "topologically sorted due to the cyclic dependence of the vertices");
        }
        for (int i = 0; i < sortedVertexList.length; i++) {
            System.out.println(sortedVertexList[i].getLabel());
        }
    }

    /**
     * Добавление в массив топологической сортировки найденный элемент с нулевой полустепенню входа
     *
     * @param zeroElementIndex элемент с нулевой полустепенью входа
     * @param yIndex           индекс отсортированного массива
     * @param sum              сумма по каждому из столбцов матрицы
     */
    private void addVertexToSortedVertexList(int zeroElementIndex, int yIndex, int[] sum) {
        //вставляем в массив топологической сортировки найденный элемент
        sortedVertexList[yIndex] = vertexList[zeroElementIndex];
        //помечаем элемент с нулевой полустепенью входа, как обработанный
        sum[zeroElementIndex] = -1;
    }

    /**
     * Вычитание ряда элемента с нулевой полустепенью входа из массива суммы для каждого столба
     *
     * @param rowForZeroIndexElement ряд элемента, чья полустепень входа == 0
     * @param sum                    сумма по каждому из столбцов матрицы
     */
    private void subtractingArrays(int[] rowForZeroIndexElement, int[] sum) {
        for (int i = 0; i < sum.length; i++) {
            if (rowForZeroIndexElement[i] == -1) {
                continue;
            }
            sum[i] = sum[i] - rowForZeroIndexElement[i];
        }
    }

    /**
     * Поиск индекса элемента с нулевой полустепенью входа
     *
     * @param row наблюдаемый ряд
     * @return индекс элемента с нулевой полустепенью входа
     */
    public int findZeroElementIndex(int[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Добавление связи между вершинами
     *
     * @param start ось y
     * @param end   ocь x
     */
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
    }

    /**
     * Добавленеи новой вершины
     *
     * @param lab обозначение для вершины
     */
    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    /**
     * Получение ряда для элемента с нулевой полустепенью входа
     *
     * @param zeroElementIndex элемент с нулевой полустепенью входа
     * @return ряд элемента с нулевой полустепенью входа
     */
    public int[] getRowForZeroElementIndex(int zeroElementIndex) {
        int[] rowForZeroIndexElement = new int[MAX_VERTS];

        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {
                if (i == zeroElementIndex) {
                    rowForZeroIndexElement[j] = adjMat[i][j];
                }
            }
        }
        return rowForZeroIndexElement;

    }
}
