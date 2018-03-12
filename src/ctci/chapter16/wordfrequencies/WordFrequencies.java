package ctci.chapter16.wordfrequencies;

import java.util.Arrays;
import java.util.HashMap;

public class WordFrequencies {

    public static int getFrequencies(String[] book, String word) {
        HashMap<String, Integer> countMap = new HashMap<>();
        Arrays.stream(book).forEach(s -> countMap.put(s, countMap.getOrDefault(s, 0) + 1));
        return countMap.getOrDefault(word, 0);
    }


    public static void main(String[] args) {
        String[] book = {"the", "Lara", "and", "outcropping", "career", "it"};
        System.out.printf("%s : %s \n", "the", WordFrequencies.getFrequencies(book,"the"));
    }
}
