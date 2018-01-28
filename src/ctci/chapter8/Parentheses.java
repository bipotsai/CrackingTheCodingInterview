package ctci.chapter8;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {
    List<String> result = new ArrayList<>();
    public void genValidParentheses(int leftParens, int rightParens, String current){
        if(leftParens == 0 && rightParens == 0){
            result.add(current);
        }

        if(leftParens == rightParens){
            genValidParentheses(leftParens-1, rightParens, current+"(");
        }else {
            if (leftParens > 0) {
                genValidParentheses(leftParens - 1, rightParens, current + "(");
            }
            if (rightParens > 0) {
                genValidParentheses(leftParens, rightParens - 1, current + ")");
            }
        }
    }

    public static void main(String[] args) {
        Parentheses p = new Parentheses();
        int n = 3;
        p.genValidParentheses(n-1,n,"(");
        for(String s : p.result){
            System.out.printf("%s \n", s);
        }
    }
}
