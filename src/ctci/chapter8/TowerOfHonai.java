package ctci.chapter8;

import java.util.Stack;

public class TowerOfHonai {


    public void moveDisk(int topN, Stack<Integer> source, Stack<Integer> buffer, Stack<Integer> destination) {
        if (topN <= 0) {
            return;
        }
        moveDisk(topN - 1, source, destination, buffer);

        int i = tower1.pop();
        buffer.push(i);

        moveDisk(topN - 1, destination, buffer);

    }


    public static void main(String[] args) {
        Stack<Integer> tower1 = new Stack<>();
        Stack<Integer> tower2 = new Stack<>();
        Stack<Integer> tower3 = new Stack<>();
        int n = 5;
        while (n > 0) {
            tower1.push(n);
        }
    }

}
