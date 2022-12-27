package org.example.exponentiation;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ExponentiationSolverImpl implements ExponentiationSolver {

    /**
     * алгоритм возведения в степень через домножение O(N/2+LogN) = O(N).
     *
     * @param number число, которое ы возводим в степень
     * @param degree степень числа
     */
    @Override
    public void exponentiate(double number, long degree) {
        var v = degree / 2;
        var x = v;
        var y = v;
        var powersNumberTwo = 0; //инициализируем степень, в которую необходимо возвести двойку, для получения части степени (2^511 = 2^256 + 2^255)
        for (int i = 0; i < degree; i++) {
            if (log2(x) % 1 == 0) {
                powersNumberTwo = (int) log2(x);
                break;
            }
            if (log2(y) % 1 == 0) {
                powersNumberTwo = (int) log2(y);
                break;
            }
            x += 1;
            y -= 1;
        }
        var secondPower = degree - x;//вторая степень числа
        BigDecimal rez = BigDecimal.valueOf(number);
        for (int i = 0; i < powersNumberTwo; i++) {
            rez = rez.multiply(rez);
        }
        System.out.println("algorithm complexity: O(N/2+LogN) = O(N)\n" +
                "result: " + new DecimalFormat("#0.00").format(rez.multiply(BigDecimal.valueOf(Math.pow(number, secondPower)))));

    }

    /**
     * алгоритм возведения в степень через двоичное разложение показателя степени O(2LogN) = O(LogN)
     *
     * @param number число, которое ы возводим в степень
     * @param degree степень числа
     */
    @Override
    public void exponentiateWithBinaryDecomposition(double number, long degree) {
        String binaryValue = Long.toBinaryString(degree);
        String[] mas = new String[binaryValue.length()];
        BigDecimal intermediateResult = BigDecimal.valueOf(number);
        BigDecimal result = BigDecimal.ONE;
        for (int i = mas.length; i > 0; i--) {
            if (binaryValue.charAt(i - 1) == '1') {
                result = result.multiply(intermediateResult);
            }
            intermediateResult = intermediateResult.multiply(intermediateResult);
        }
        System.out.println("algorithm complexity: O(2LogN) = O(LogN)\n" +
                "result: " + new DecimalFormat("#0.00").format(result));
    }


    /**
     * log b(a) = log10(a)/log10(b) -> log2x = log10(x)/log10(2)
     *
     * @param value число, чей двоичный логарифм нам необходимо получить
     */
    public double log2(long value) {
        return Math.log(value) / Math.log(2);
    }


}
