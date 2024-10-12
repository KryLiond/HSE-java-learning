public class firstTask {
    public static void main(String[] args) {
        System.out.println(superFunction(230, 100));
    }

    public static double superFunction(int a, int b) {
        return (a * b > 100) ? 3 * Math.tan(b) : a * 5;
    }
}