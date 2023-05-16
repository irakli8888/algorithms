package kruskal;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {

    public void kruskal(ArrayList<Edge> graphEdges, int nodeCount) {
        String outputMessage = "";

        Collections.sort(graphEdges);
        ArrayList<Edge> mstEdges = new ArrayList<Edge>();
        DisjointSet nodeSet = new DisjointSet(nodeCount + 1);

        for (int i = 0; i < graphEdges.size() && mstEdges.size() < (nodeCount - 1); i++) {
            Edge currentEdge = graphEdges.get(i);
            int root1 = nodeSet.find(currentEdge.getVertex1());
            int root2 = nodeSet.find(currentEdge.getVertex2());
            outputMessage += "find(" + currentEdge.getVertex1() + ") returns " + root1 + ", find(" + currentEdge.getVertex2() + ") returns " + root2;
            String unionMessage = ",\tNo union performed\n";
            if (root1 != root2) {
                mstEdges.add(currentEdge);
                nodeSet.union(root1, root2);
                unionMessage = ",\tUnion(" + root1 + ", " + root2 + ") done\n";
            }
            outputMessage += unionMessage;
        }

        outputMessage += "\nFinal Minimum Spanning Tree (" + mstEdges.size() + " edges)\n";
        int mstTotalEdgeWeight = 0;
        for (Edge edge : mstEdges) {
            outputMessage += edge + "\n";
            mstTotalEdgeWeight += edge.getWeight();
        }
        outputMessage += "\nTotal weight of all edges in MST = " + mstTotalEdgeWeight;

        System.out.println(outputMessage);
    }
}
