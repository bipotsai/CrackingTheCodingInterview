package ctci.chapter16._5_.factorialzeros;

public class FactorialZeros {

    public int getTailingZeroBest2(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }


    public static int getTailingZeroBest(int n) {
        int five = 0;
        for (int i = 5; n / i > 0; i *= 5) {
            five += n / i;
        }
        return five;
    }

    public static int getTailingZeroBetter(int n) {
        int five = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = i;
            while (tmp % 5 == 0) {
                tmp = tmp / 5;
                five++;
            }
        }
        return five;
    }

    public static int getTailingZero(int n) {
        int result = 0;

        int five = 0;
        int two = 0;
        int ten = 0;

        for (int i = 1; i <= n; i++) {
            int tmp = i;
            while (tmp % 10 == 0) {
                tmp = tmp / 10;
                ten++;
            }
            while (tmp % 5 == 0) {
                tmp = tmp / 5;
                five++;
            }
            while (tmp % 2 == 0) {
                tmp = tmp / 2;
                two++;
            }

        }
        result = ten + Math.min(five, two);

        return result;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            System.out.printf("%d! has %d zeros ", i, FactorialZeros.getTailingZero(i));
            System.out.printf("--> %d! has %d zeros ", i, FactorialZeros.getTailingZeroBetter(i));
            System.out.printf("--> %d! has %d zeros \n", i, FactorialZeros.getTailingZeroBest(i));
        }
    }

}
