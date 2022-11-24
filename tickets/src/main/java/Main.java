import java.util.Scanner;

/**
 * @author IrklKvch
 */
public class Main {
    private static long ticketsNum = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer n = s.nextInt();
        check(n, 0 , 0);
        System.out.println(ticketsNum);
    }

    private static void check(Integer n, long sumA, long sumB) {
        if(n == 0){
            if (sumA == sumB){
                ticketsNum++;
            }
            return;
        }
        for(int i = 0; i <= 9; i++){
            for (int j = 0; j <= 9; j++) {
                check(n - 1, sumA + i, sumB + j);
            }
        }
    }
}
