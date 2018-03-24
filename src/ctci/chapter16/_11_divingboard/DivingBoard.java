package ctci.chapter16._11_divingboard;

import java.util.HashSet;

public class DivingBoard {
    static HashSet<Integer> possibleLengthSet = new HashSet<>();
    static HashSet<String> visited = new HashSet<>();
    public static int getTotalPossibleLength(int k, int shortLength, int longLength){
        recursion(k, shortLength, longLength, 0, 0);
        return possibleLengthSet.size();
    }

    public static void recursion(int k, int shortLength, int longLength, int shortCount, int longCount){
        if(k == 0){
            possibleLengthSet.add(shortLength*shortCount + longLength*longCount);
            return;
        }
        String key = shortCount+":"+longCount;
        if(visited.contains(key)){
            return;
        }
        recursion(k-1, shortLength, longLength, shortCount+1, longCount);
        recursion(k-1, shortLength, longLength, shortCount, longCount+1);
    }

    public static void main(String[] args) {
        int counter = getTotalPossibleLength(12, 1, 3);
        System.out.println(DivingBoard.possibleLengthSet);
        System.out.println(counter);
    }
}
