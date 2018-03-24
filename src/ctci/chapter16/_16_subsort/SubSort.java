package ctci.chapter16._16_subsort;

import java.util.Arrays;

public class SubSort {

    public static void findMinSection(int[] numbers) {
        int m = -1;
        int n = -1;
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                continue;
            }
            n = i;
            if (m == -1) {
                m = binarySearch(numbers, 0, i - 1, numbers[i]);
            } else {
                m = binarySearch(numbers, 0, m, numbers[i]);
            }
            m = m<0?(m+1)*-1:m;
            System.out.printf("n (%d,%d)\n", m, n);
        }
        System.out.printf("(%d,%d)\n", m, n);
    }

    private static int binarySearch(int[] numbers, int lo, int hi, int target) {

        while(lo <= hi){
            int mid = (lo+hi)>>>1;
            if(numbers[mid] < target){
                lo = mid + 1;
            }else if(numbers[mid] > target){
                hi = mid - 1;
            }else{
                return mid;
            }
        }
        return -(lo+1);

    }

    // Like public version, but without range checks.
    private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }


    public static void main(String[] args) {
        //int[] array = {1, 9, 4, 3, 5};
        //findMinSection(array);
        int[] array = new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        findMinSection(array);
    }

}
