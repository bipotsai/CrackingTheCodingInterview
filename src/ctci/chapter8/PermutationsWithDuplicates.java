package ctci.chapter8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermutationsWithDuplicates {

    public List<String> result = new ArrayList<>();

    public void genPermutations(HashMap<Character, Integer> countMap, String current){
        boolean allUsed = true;
        for(char c : countMap.keySet()){
            int count = countMap.get(c);
            if(count > 0) {
                countMap.put(c, count - 1);
                genPermutations(countMap, current + c);
                countMap.put(c, count);
                allUsed = false;
            }
        }
        if(allUsed){
            result.add(current);
        }
    }


    public static void main(String[] args) {
        String input = "abbc";
        HashMap<Character, Integer> countMap = new HashMap<>();
        for(char c : input.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c,0)+1);
        }
        PermutationsWithDuplicates pwd = new PermutationsWithDuplicates();
        pwd.genPermutations(countMap, "");

        for(String s : pwd.result){
            System.out.printf("%s \n", s);
        }
    }
}
