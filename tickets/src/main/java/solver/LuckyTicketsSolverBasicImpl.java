package solver;

public class LuckyTicketsSolverBasicImpl implements LuckyTicketsSolverBasic{

    private long ticketsNum = 0;

    @Override
    public void solve(Integer n, long sumA, long sumB) {
        if(n == 0){
            if (sumA == sumB){
                ticketsNum++;
            }
            return;
        }
        for(int i = 0; i <= 9; i++){
            for (int j = 0; j <= 9; j++) {
                solve(n - 1, sumA + i, sumB + j);
            }
        }
    }

    @Override
    public long getTicketsNum(){
        return ticketsNum;
    }

}
