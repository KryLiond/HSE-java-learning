import java.util.Random;


//22 вариант.
//Задача 3
//Определить одномерный массив и заполнить его случайными значениями
//Дан массив с (n) . Переписать в массив х (n) все ненулевые элементы массива возведенные в квадрат. ( сжатие массива)


public class thirdTask {
    public static void main(String[] args) {
        int n = 10;
        int[] c = new int[n];

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            c[i] = random.nextInt(21) - 10;
        }

        printArray(c);

        int nonZeroCount = 0;
        for (int value : c) {
            if (value != 0) {
                nonZeroCount++;
            }
        }

        int[] x = new int[nonZeroCount];
        int index = 0;

        for (int value : c) {
            if (value != 0) {
                x[index++] = value * value;
            }
        }

        printArray(x);
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
