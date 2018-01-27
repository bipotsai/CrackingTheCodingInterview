package ctci.chapter8;

import java.util.ArrayList;

public class MagicIndex {

    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void findNotDistinctMagicIndex(int[] ary, int lo, int hi) {
        if (lo > hi) {
            return;
        }

        int mid = (lo + hi) >>> 1;
        if (ary[mid] == mid) {
            answer.add(mid);
        } else if (ary[mid] > mid) {

            findNotDistinctMagicIndex(ary, lo, mid - 1);
            findNotDistinctMagicIndex(ary, ary[mid], hi);
        } else {
            findNotDistinctMagicIndex(ary, mid + 1, hi);
            findNotDistinctMagicIndex(ary, lo, ary[mid]);
        }
    }


    public static void main(String[] args) {
        int[] input = new int[]{-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        MagicIndex.findNotDistinctMagicIndex(input, 0, input.length - 1);
        for (int n : MagicIndex.answer) {
            System.out.printf("%d ",n);
        }
    }

}
