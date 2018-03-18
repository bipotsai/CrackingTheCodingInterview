package ctci.chapter16._7_numbermax;

public class NumberMax {

    /**
     * if a and b have different signs
     * a > 0, then b < 0, and k = 1 --> keep a
     * a < 0, then b > 0, and k = 0 --> keep b
     * let k = sign(a)
     * else
     * let k = sign(a-b)
     * @param a
     * @param b
     * @return
     */
    public static int getMax_fixOverflow(int a, int b){
        int c = a - b;
        int sign_a = (a>>31)^1;
        int sign_b = (b>>31)^1;
        int sign_c = (c>>31)^1;

        int use_sign_a = sign_a ^ sign_b;//exclusive:1 same:0
        int inverse_of_use_sign_a = use_sign_a ^ 1;

        int k = use_sign_a * sign_a + inverse_of_use_sign_a * sign_c;
        int q = k ^ 1;
        return k * a + q * b;


    }

    public static int getMax(int a, int b){
        int c = a - b;
        int signOfC = (c>>31)^1;
        int inverseSign = signOfC^1;
        return a * signOfC + b * inverseSign;
    }

    public static void main(String[] args) {
        int a = 26;
        int b = -15;

        System.out.println("max_naive(" + a + ", " + b + ") = " + NumberMax.getMax(a, b));
        System.out.println("max(" + a + ", " + b + ") = " + getMax_fixOverflow(a, b));

        a = -15;
        b = 2147483647;
        System.out.println(b - a);
        System.out.println("max_naive(" + a + ", " + b + ") = " + NumberMax.getMax(a, b));
        System.out.println("max(" + a + ", " + b + ") = " + getMax_fixOverflow(a, b));
    }
}
