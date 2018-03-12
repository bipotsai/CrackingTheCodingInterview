package ctci.chapter8;

import java.util.HashMap;
import java.util.Stack;

public class BooleanEvaluation {

    private static HashMap<String, Integer> dp = new HashMap<>();

    public static int countEval(String expression, boolean expected) {

        if(expression.length() == 1){
            return (expression.equals("1") == expected?1:0);
        }

        if(dp.containsKey(expression+String.valueOf(expected))){
            return dp.get(expression+String.valueOf(expected));
        }

        int ways = 0;
        for (int i = 1; i < expression.length(); i += 2) {

            char operand = expression.charAt(i);
            String left = expression.substring(0, i);
            String right = expression.substring(i + 1);

            int leftTrue = countEval(left, true);
            int leftFalse = countEval(left, false);

            int rightTrue = countEval(right, true);
            int rightFalse = countEval(right, false);
            switch (operand) {
                case '&':
                    if(expected == true){
                        ways += leftTrue * rightTrue;
                    }else {
                        ways += leftFalse * rightFalse;
                        ways += leftTrue * rightFalse;
                        ways += leftFalse * rightTrue;
                    }
                    break;
                case '|':
                    if(expected == true){
                        ways += leftTrue * rightTrue;
                        ways += leftTrue * rightFalse;
                        ways += leftFalse * rightTrue;
                    }else {
                        ways += leftFalse * rightFalse;
                    }
                    break;
                case '^':
                    if(expected == true){
                        ways += leftTrue * rightFalse;
                        ways += leftFalse * rightTrue;
                    }else {
                        ways += leftFalse * rightFalse;
                        ways += leftTrue * rightTrue;
                    }
                    break;
            }
        }
        dp.put(expression+String.valueOf(expected), ways);
        return ways;

    }


    public static int countEval_Bipo(String expression) {
        if (expression.length() == 3) {
            //System.out.printf("%s return %d \n", expression, eval(expression) ? 1 : 0);
            return eval(expression) ? 1 : 0;
        }

        int result = 0;
        for (int i = 0; i < expression.length() - 2; i += 2) {
            boolean bool = eval(expression.substring(i, i + 3));
            String operand = bool ? "1" : "0";
            result += countEval_Bipo(expression.substring(0, i) + operand + expression.substring(i + 3));

        }

        return result;
    }

    private static boolean eval(String expression) {
        boolean a = expression.substring(0, 1).equals("1") ? true : false;
        String operator = expression.substring(1, 2);
        boolean b = expression.substring(2).equals("1") ? true : false;
        switch (operator) {
            case "&":
                return a & b;
            case "|":
                return a | b;
            case "^":
                return a ^ b;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        String express = "1^0|0|1";
        //int result = BooleanEvaluation.countEval_Bipo(express);
        //System.out.printf("result %d \n", result);
        int result = BooleanEvaluation.countEval(express, false);
        System.out.printf("result %d \n", result);

        express = "0&0&0&1^1|0";
        result = BooleanEvaluation.countEval(express, true);
        System.out.printf("result %d \n", result);
    }

}
