package org.example;

import org.example.exponentiation.ExponentiationSolver;
import org.example.exponentiation.ExponentiationSolverImpl;
import org.example.fibonacci.FibonacciSolverImpl;
import org.example.prime_numbers.PrimeNumbersSolver;
import org.example.prime_numbers.PrimeNumbersSolverImpl;

public class App {
    public static void main(String[] args) {
        ExponentiationSolver exponentiationSolver = new ExponentiationSolverImpl();
        FibonacciSolverImpl fibonacciSolver = new FibonacciSolverImpl();
        PrimeNumbersSolver primeNumbersSolver = new PrimeNumbersSolverImpl();
        //возведения в степень
        exponentiationSolver.exponentiate(2, 100);
        exponentiationSolver.exponentiateWithBinaryDecomposition(2, 100);
        //поиск простых чисел решетом эратосфена
        primeNumbersSolver.getPrimeNumbersUsingTheSieveOfEratosthenes(10000000);
        //числа фибоначчи через умножение матриц и бинарное разложение степени
        System.out.println(String
                .format("the result of the algorithm for finding Fibonacci " +
                                "numbers O(LogN) through raising matrices " +
                                "to a power using the algorithm for binary " +
                                "expansion of the exponent for a number %d = %d",
                        50,
                        fibonacciSolver.getFibonacciValue(50)));

    }
}
