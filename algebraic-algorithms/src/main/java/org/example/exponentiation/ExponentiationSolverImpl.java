package org.example.exponentiation;

public class ExponentiationSolverImpl implements ExponentiationSolver {

    @Override
    public void exponentiate(long number, long degree){

        long v = degree/2;
        long x = v;
        long y = v;
        long z = 0;
        for (int i = 0; i < degree; i++) {
            x+=1;
            System.out.println(x);
            y-=1;
            System.out.println(y);
            if(log2(x) % 1 == 0){
                System.out.println(x);
                System.out.println(log2(x));
                break;
            }
            if(log2(y) % 1 == 0){
                System.out.println(y);
                System.out.println(log2(y));
                break;
            }

        }
    }

    //logba = log10(a)/log10(b) -> log2x = log10(x)/log10(2)
    public double log2(long value){
        return Math.log(value) / Math.log(2);
    }


}
