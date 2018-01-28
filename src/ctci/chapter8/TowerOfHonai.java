package ctci.chapter8;

import java.util.Stack;

public class TowerOfHonai {


    public void moveDisk(int topN, Stack<Integer> source, Stack<Integer> buffer, Stack<Integer> destination) {
        if (topN <= 0) {
            return;
        }
        moveDisk(topN - 1, source, destination, buffer);

        int i = source.pop();
        destination.push(i);

        moveDisk(topN - 1, buffer, source, destination);

        System.out.printf("topN : %d \n", topN);

        System.out.printf("%d - %d - %d \n", source.empty()?0:source.peek(), buffer.empty()?0:buffer.peek(), destination.empty()?0:destination.peek());

    }

    public void print(Stack<Integer> source, Stack<Integer> buffer, Stack<Integer> destination){
        while (!source.empty()) {
            System.out.printf("%d ", source.pop());
        }
        System.out.printf("\n");
        while (!buffer.empty()) {
            System.out.printf("%d ", buffer.pop());
        }
        System.out.printf("\n");
        while (!destination.empty()) {
            System.out.printf("%d ", destination.pop());
        }
        System.out.printf("\n");
    }


    public static void main(String[] args) {
        Stack<Integer> tower1 = new Stack<>();
        Stack<Integer> tower2 = new Stack<>();
        Stack<Integer> tower3 = new Stack<>();
        int n = 5;
        while (n > 0) {
            tower1.push(n);
            n--;
        }
        new TowerOfHonai().moveDisk(5, tower1, tower2, tower3);

        while (!tower1.empty()) {
            System.out.printf("%d ", tower1.pop());
        }
        System.out.printf("\n");
        while (!tower2.empty()) {
            System.out.printf("%d ", tower2.pop());
        }
        System.out.printf("\n");
        while (!tower3.empty()) {
            System.out.printf("%d ", tower3.pop());
        }

    }

}
