import java.util.Random;

//22 вариант.
//Задача 4
//Определить матрицу (двумерный массив) и ее заполнить случайными значениями.
//Построить вектор В, которой возвращает максимальный элемент в каждой строке матрицы. Затем к каждому элементу каждой строки прибавить максимальный элемент строки.


public class fourthTask  {

    public static void main(String[] args) {
        int rows = 5;
        int cols = 5;

        int[][] matrix = new int[rows][cols];
        int[] vectorB = new int[rows];

        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }

        System.out.println("Матрица: ");
        printMatrix(matrix);

        for (int i = 0; i < rows; i++) {
            int max = matrix[i][0];
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            vectorB[i] = max;

        }
        System.out.println();


        System.out.println("Вектор B: ");
        for (int i = 0; i < rows; i++) {
            System.out.print(vectorB[i] + " ");
        }

        System.out.println("\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] += vectorB[i];
            }
        }

        System.out.println("Измененная матрица:");
        printMatrix(matrix);

    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

}
