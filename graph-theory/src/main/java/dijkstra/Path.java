package dijkstra;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Path {

    private LinkedList<Integer> parentVertexes;
    private int distance;

    public Path() {
        this.parentVertexes = new LinkedList<>();
        this.distance = 10000;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public LinkedList<Integer> getParentVertexes() {
        return parentVertexes;
    }

    public void setParentVertexes(LinkedList<Integer> parentVertexes) {
        this.parentVertexes = parentVertexes;
    }

    @Override
    public String toString() {
        return "Path{" +
                "parentVertexes=" + parentVertexes.stream().map(a->a +1).collect(Collectors.toList()) +
                ", distance=" + distance +
                '}';
    }
}
