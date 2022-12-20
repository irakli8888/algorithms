import solver.LuckyTicketsSolverBasicImpl;
import solver.LuckyTicketsSolverImpl;

public class Main {
    public static void main(String[] args) {
        LuckyTicketCounterRunner luckyTicketCounterRunner
                = new LuckyTicketCounterRunner(new LuckyTicketsSolverBasicImpl(), new LuckyTicketsSolverImpl());
        luckyTicketCounterRunner.run();
    }
}
