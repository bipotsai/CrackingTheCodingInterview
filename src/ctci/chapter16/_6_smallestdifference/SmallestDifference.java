package ctci.chapter16._6_smallestdifference;

import java.util.Arrays;

public class SmallestDifference {
    public static int getSmallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        int smallestDiff = Integer.MAX_VALUE;
        while (i < a.length && j < b.length) {
            smallestDiff = Math.min(smallestDiff, Math.abs(a[i] - b[j]));
            if (a[i] < b[j]) {
                while (i < a.length && a[i] < b[j]) {
                    i++;
                }
            } else {
                while (j < b.length && b[j] < a[i]) {
                    j++;
                }
            }
        }
        return smallestDiff;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 15, 11, 2};
        int[] array2 = {23, 127, 234, 19, 8};
        int difference = SmallestDifference.getSmallestDifference(array1, array2);
        System.out.println(difference);
    }
}
