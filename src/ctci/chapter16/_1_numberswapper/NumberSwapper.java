package ctci.chapter16._1_numberswapper;

public class NumberSwapper {

    public static void swap(int x, int y) {
        System.out.printf("%d %d ----> ", x, y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.printf("%d %d \n", x, y);
    }

    public static void swap2(int x, int y) {
        System.out.printf("%d %d ----> ", x, y);
        x = x - y;
        y = x + y;
        x = y - x;
        System.out.printf("%d %d \n", x, y);
    }

    public static void main(String[] args) {

        int x = 10;
        int y = 20;
        NumberSwapper.swap(x, y);
        NumberSwapper.swap2(x, y);


        int a = 99999999;
        int b = 77777777;
        NumberSwapper.swap(a, b);
        NumberSwapper.swap2(a, b);

    }


}
