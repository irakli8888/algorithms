package org.example.fibonacci;

import org.example.fibonacci.matrix.MatrixMultiplicator;
import org.example.fibonacci.matrix.MatrixMultiplicatorImpl;

public class FibonacciSolverImpl implements FibonacciSolver {
    private final int matrixSize = 2;
    private final MatrixMultiplicator matrixMultiplicator;

    /**
     * F3 F2
     * <br> F2 F1
     */
    private long matrix[][] = new long[matrixSize][matrixSize];
    private long matrixBasic[][] = new long[matrixSize][matrixSize];

    /**
     * собираем первичную матрицу и внедряем зависимости
     */
    public FibonacciSolverImpl() {
        matrixMultiplicator = new MatrixMultiplicatorImpl();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 1;
                matrixBasic[i][j] = 1;
                if (i == 1 && j == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * метод для рассчета значения порядкового номера числа фибоначчи
     * ( 5 = 3 - пятый порядковый номер числа фибоначчи- это 3).
     * Для возведения в степень задействован алгоритм
     * возведения в степень через двоичное разложение показателя степени
     *
     * @param number порядковый номер числа
     * @return значение порядового номера
     */
    public long getFibonacciValue(long number) {
        //промежуточная переменная, необходимая для фиксирования результата умножения
        long intermediateResultMatrix[][] = matrix;
        //результирующая переменная
        long resultMatrix[][] = matrix;
        //переводим порядковый номер в бинарный вид (number - 1 тк по формуле возводим именно в такую степень)
        String binaryValue = Long.toBinaryString(number - 1);
        //итерируемся по полученному бинарному представлению номера,
        //попутно возводя промежуточную переменную в квадрат, путем умножения саму на себя
        //при нахождении '1' умножаем результирующую переменную на промежуточную
        for (int i = binaryValue.length(); i > 0; i--) {
            if (binaryValue.charAt(i - 1) == '1') {
                resultMatrix = matrixMultiplicator
                        .matrixMultiplication(resultMatrix, intermediateResultMatrix);
            }
            intermediateResultMatrix = matrixMultiplicator
                    .matrixMultiplication(intermediateResultMatrix, intermediateResultMatrix);
        }
        //значение порядкогого номера содержит элемент 11 матрицы
        return resultMatrix[1][1];
    }
}
