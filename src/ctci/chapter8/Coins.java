package ctci.chapter8;

public class Coins {

    public static int getCountOfWays(int amount, int[] coins, int coinsIndex){
        if(coinsIndex >= coins.length){
            return amount==0?1:0;
        }

        int count = 0;
        int value = coins[coinsIndex];
        while(amount >= 0){
            count += getCountOfWays(amount, coins, coinsIndex+1);
            amount -= value;
        }
        return count;
    }

    public static int getCountOfWays_dp(int amount, int[] coins, int coinsIndex, int[][] dp){
        if(dp[coinsIndex][amount] > 0){
            return dp[coinsIndex][amount];
        }
        if(coinsIndex >= coins.length){
            return amount==0?1:0;
        }

        int count = 0;
        int value = coins[coinsIndex];
        int remainAmount = amount;
        while(remainAmount >= 0){
            count += getCountOfWays(amount, coins, coinsIndex+1);
            remainAmount -= value;
        }
        dp[coinsIndex][amount] = count;
        return count;
    }

    public static int makeChange(int amount, int[] denoms, int index) {
        if (index >= denoms.length - 1) return 1; // one denom remaining -> one way to do it
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1); // go to next denom
        }
        return ways;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{25,10,5,3};
        int count = Coins.getCountOfWays(10, coins, 0);
        System.out.printf("toal ways : %d \n", count);

        int[][] dp = new int[coins.length+1][10+1];
        count = Coins.getCountOfWays_dp(10, coins, 0, dp);
        System.out.printf("toal ways : %d \n", count);

        count = Coins.makeChange(10, coins, 0);
        System.out.printf("toal ways : %d \n", count);
    }
}
