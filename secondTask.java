import java.util.Scanner;

//7 вариант.
//Задача 2
//Дано a, b. Найти наибольшее max(a,b) и наименьшее min(a,b) из чисел a и b. Найти d.

public class secondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();

        double max = Math.max(a, b);
        double min = Math.min(a, b);

        System.out.print("max(a,b): " + max + "\n");
        System.out.print("min(a,b): " + min + "\n");

        double numerator = 5 * max - 4 * min;
        double denominator = 8.3 + (max / min);
        double d = numerator / denominator;

        System.out.printf("d: %.4f\n", d);
    }

}
