package ctci.chapter1.arraysandstrings;

public class RotateMatrix {


    /**
     * self implemented
     * wrong -> only shift one element
     * @param input
     */
    public void shift(int[][] input){
        int N = input.length;
        int i=0;
        int j=0;
        while(N>1){
            int diff = (input.length - N)/2;
            int last = input[i][j];
            //top
            while(j+1 < input.length - diff) {
                int temp = input[i][j + 1];
                input[i][j+1] = last;
                last = temp;
                j++;
            }
            //right
            while(i+1 < input.length - diff) {
                int temp = input[i+1][j];
                input[i+1][j] = last;
                last = temp;
                i++;
            }
            //bottom
            while(j-1 >= diff) {
                int temp = input[i][j-1];
                input[i][j-1] = last;
                last = temp;
                j--;
            }
            //left
            while(i-1 >= diff) {
                int temp = input[i-1][j];
                input[i-1][j] = last;
                last = temp;
                i--;
            }
            N-=2;
            i = diff+1;
            j = diff+1;
        }
    }

    /**
     * self implemented(correct solution)
     * @param input
     */
    public static void rotate90(int[][] input){
        int N = input.length;
        while(N>1){
            int first = (input.length-N)/2;
            int last = first + N - 1;
            for(int i=0;i<=last-first-1;i++){
                int temp = input[first][first+i];
                //left -> top
                input[first][first+i] = input[last-i][first];
                //bottom -> left
                input[last-i][first] = input[last][last-i];
                //right -> bottom
                input[last][last-i] = input[first+i][last];
                //top -> right
                input[first+i][last] = temp;
            }
            N -= 2;
        }
    }


    /**
     * solution from book
     * @param matrix
     */
    public static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        return true;
    }

    public static void print(int[][] input){
        for(int[] row : input){
            for(int n : row){
                System.out.printf("%d ", n);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};

//        RotateMatrix rm = new RotateMatrix();
        System.out.println("");
        RotateMatrix.print(input);
//        rm.shift(input);
//        System.out.println("");
//        rm.print(input);

        input = new int[][]{{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,24,21,8},{13,12,11,10,9}};
        RotateMatrix.rotate90(input);
        System.out.println("");
        RotateMatrix.print(input);

        input = new int[][]{{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,24,21,8},{13,12,11,10,9}};
        RotateMatrix.rotate(input);
        System.out.println("");
        RotateMatrix.print(input);
    }



}
