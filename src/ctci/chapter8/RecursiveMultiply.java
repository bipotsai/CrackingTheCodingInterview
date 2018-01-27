package ctci.chapter8;

public class RecursiveMultiply {

    public static int product(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        if (small == 1) return big;

        int remain = 0;
        while (small >= 2) {
            if (small % 2 == 1) {
                remain += big;
                small -= 1;
            }
            big = big << 1;
            small = small >> 1;
        }
        return big + remain;
    }

    public static void main(String[] args) {
        System.out.printf("%d \n", RecursiveMultiply.product(100, 101));
    }

}
