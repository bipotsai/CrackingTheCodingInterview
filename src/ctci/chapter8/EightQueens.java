package ctci.chapter8;

import java.util.ArrayList;
import java.util.List;

public class EightQueens {

    public static List<int[]> result = new ArrayList<>();

    public static void placeQueen(int[] columns, int currentRow) {
        if (currentRow == columns.length) {
            result.add(columns.clone());
            return;
        }

        for (int col = 0; col < columns.length; col++) {
            if (isValid(columns, currentRow, col)) {
                columns[currentRow] = col;
                placeQueen(columns, currentRow + 1);
            }
        }

    }

    public static boolean isValid(int[] columns, int row, int col) {
        //check column collision
        for (int r = 0; r < row; r++) {
            if (columns[r] == col) {
                return false;
            }

            if (Math.abs(r - row) == Math.abs(columns[r] - col)) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        EightQueens.placeQueen(new int[8], 0);
        System.out.printf("%d solutions \n",EightQueens.result.size());
        for (int[] column : EightQueens.result) {
            for (int row = 0; row < column.length; row++) {
                System.out.printf("[%d,%d] ", row, column[row]);
            }
            System.out.printf("\n");
        }
    }


}
