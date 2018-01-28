package ctci.chapter8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsWithoutDups {

    public List<String> result = new ArrayList<>();

    public void getAllpermutations(Set<String> strSet, String currentString){
        if(strSet.isEmpty()){
            result.add(currentString);
            return;
        }
        strSet.forEach((v) -> {
            Set<String> newStrSet = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            newStrSet.addAll(strSet);
            newStrSet.remove(v);
            sb.append(currentString).append(v);

            getAllpermutations(newStrSet, sb.toString());
        });
    }

    public static void main(String[] args) {
        String input = "bipo";
        Set<String>  strSet = new HashSet<>();
        for(char c : input.toCharArray()){
            strSet.add(String.valueOf(c));
        }
        PermutationsWithoutDups pwd = new PermutationsWithoutDups();
        pwd.getAllpermutations(strSet, "");
        System.out.printf("size %d \n", pwd.result.size());
        for(String s : pwd.result){
            System.out.printf("%s \n", s);
        }

    }
}
