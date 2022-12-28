package org.example.fibonacci.matrix;

public class MatrixMultiplicatorImpl implements MatrixMultiplicator {

    /**
     * метод, предназначенный для умножения двух одноразмерных матриц (2х2 * 2х2 и тд)
     *<br> далее представлен алгоритм умножения двух матриц
     *<br>resultMatrix[0][0] = matrix[0][0] * matrix[0][0] + matrix[0][1] * matrix[1][0];
     *<br>resultMatrix[0][1] = matrix[0][0] * matrix[1][0] + matrix[0][1] * matrix[1][1];
     *<br>resultMatrix[1][0] = matrix[1][0] * matrix[0][0] + matrix[1][1] * matrix[1][0];
     *<br>resultMatrix[1][1] = matrix[1][0] * matrix[0][1] + matrix[1][1] * matrix[1][1];
     *<br> исходя из этого можно заключить, что мы
     *поочередно суммируем произведения строк и столбцов
     * @param mas пермая матрица множитель
     * @param arr вторая матрица множитель
     */
    @Override
    public long[][] matrixMultiplication(long[][] mas, long[][] arr) {
        int matrixSize = mas.length;
        long[][] result = new long[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    result[i][j] += mas[i][k] * arr[k][j];
                }
            }
        }
        return result;
    }
}
