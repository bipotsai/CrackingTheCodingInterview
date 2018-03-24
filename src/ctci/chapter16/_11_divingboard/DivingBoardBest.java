package ctci.chapter16._11_divingboard;

import java.util.HashSet;

public class DivingBoardBest {
    public static int getTotalPossibleLength(int k, int shortLength, int longLength) {
        HashSet<Integer> set = new HashSet<>();
        for (int shortCount = 0 ; shortCount <= k; shortCount++) {
            set.add(shortCount * shortLength + (k-shortCount)*longLength);
        }
        return set.size();
    }
    public static void main(String[] args) {
        int counter = getTotalPossibleLength(12, 1, 3);
        System.out.println(DivingBoard.possibleLengthSet);
        System.out.println(counter);
    }
}
