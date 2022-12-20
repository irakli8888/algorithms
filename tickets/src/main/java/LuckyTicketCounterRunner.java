import solver.LuckyTicketsSolver;
import solver.LuckyTicketsSolverBasic;
import solver.LuckyTicketsSolverImpl;

import java.util.Scanner;

/**
 * @author IrklKvch
 */
public class LuckyTicketCounterRunner {

    private LuckyTicketsSolverBasic luckyTicketsSolverBasic;
    private LuckyTicketsSolver luckyTicketsSolver;

    public LuckyTicketCounterRunner(LuckyTicketsSolverBasic luckyTicketsSolverBasic, LuckyTicketsSolver luckyTicketsSolver) {
        this.luckyTicketsSolver = luckyTicketsSolver;
        this.luckyTicketsSolverBasic = luckyTicketsSolverBasic;
    }

    public void run(){
        System.out.println("введите разрядность билетика");
        Scanner s = new Scanner(System.in);
        Integer n = s.nextInt();
        System.out.println("оптимальный алгоритм: " + luckyTicketsSolver.solve(n/2) + " - счастливых комбинаций");
        luckyTicketsSolverBasic.solve(n/2, 0, 0);
        System.out.println("неоптимальный алгоритм" + luckyTicketsSolverBasic.getTicketsNum() + " - счастливых комбинаций");
        ;
    }


}
