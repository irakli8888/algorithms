package org.example.prime_numbers;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeNumbersSolverImpl implements PrimeNumbersSolver {

    private final int firstPrimeNumber = 2;

    /**
     * метод для поиска простых чисел с помошью решета эратосфена O(N Log Log N).
     *
     * @param number диапозон поиска
     */
    @Override
    public void getPrimeNumbersUsingTheSieveOfEratosthenes(int number) {
        boolean sieve[] = new boolean[number];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;
        for (int i = firstPrimeNumber; i * i < sieve.length; i++) {
            if (sieve[i]) {
                //нам не нужно итерироваться по всему числу
                //мы ищем кратные числа, следовательно, достаточно дойти до середины
                for (int j = i * i; j * i < sieve.length; j += i) {
                    sieve[j] = false;
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 0; i < sieve.length; i++) {
            if(sieve[i]) {
                primes.add(i);
            }
        }
        System.out.println(primes.size() + " - number of primes");
    }

}
