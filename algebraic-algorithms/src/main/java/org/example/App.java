package org.example;

import org.example.exponentiation.ExponentiationSolver;
import org.example.exponentiation.ExponentiationSolverImpl;

public class App 
{
    public static void main( String[] args )
    {
        ExponentiationSolver exponentiationSolver = new ExponentiationSolverImpl();
        exponentiationSolver.exponentiate(2, 511);
        exponentiationSolver.exponentiateWithBinaryDecomposition(2,511);
    }
}
