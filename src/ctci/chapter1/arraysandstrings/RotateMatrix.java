package ctci.chapter1.arraysandstrings;

public class RotateMatrix {

    public void rotate90(int[][] input){
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

    public void print(int[][] input){
        for(int[] row : input){
            for(int n : row){
                System.out.printf("%d ", n);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,24,21,8},{13,12,11,10,9}};

        RotateMatrix rm = new RotateMatrix();
        System.out.println("");
        rm.print(input);
        rm.rotate90(input);
        System.out.println("");
        rm.print(input);
    }



}
