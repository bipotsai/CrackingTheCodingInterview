package ctci.chapter8;

public class TripStep {
    int[] dp;

    public TripStep(int n) {
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
    }

    public int iterativeSolution() {
        for (int i = 2; i < dp.length; i++) {
            if (i >= 3) {
                dp[i] += dp[i - 3];
            }
            if (i >= 2) {
                dp[i] += dp[i - 2];
            }
            if (i >= 1) {
                dp[i] += dp[i - 1];
            }
        }

        return dp[dp.length-1];
    }

    public int recursiveSolution() {
        return rec(dp.length-1);
    }

    private int rec(int n) {
        if(n <= 0){
            return 0;
        }else if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = rec(n - 1) + rec(n - 2) + rec(n - 3);
        return dp[n];
    }

    public static void main(String[] args) {
        TripStep tripStep = new TripStep(5);
        System.out.printf("iterative:%d recusive:%d \n", tripStep.iterativeSolution(), tripStep.recursiveSolution());
    }


}
