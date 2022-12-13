package org.example;

import org.example.exponentiation.ExponentiationSolverImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ExponentiationSolverImpl exponentiationSolver = new ExponentiationSolverImpl();
        exponentiationSolver.exponentiate(2, 511);
        exponentiationSolver.exponentiateWithBinaryDecomposition(2,511);
    }
}
