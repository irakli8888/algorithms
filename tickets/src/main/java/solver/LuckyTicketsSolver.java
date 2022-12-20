package solver;

public interface LuckyTicketsSolver{

    long solve(int n);

    int resume(int n, int value);

    boolean checkForCompliance(int v);

    long getResult(int[] mas);
}
