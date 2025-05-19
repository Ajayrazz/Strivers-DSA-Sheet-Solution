public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n][w + 1];
        for(int i = weight[0]; i <= w; i++){
            dp[0][i] = ((int) i / weight[0]) * profit[0];
        }

        for(int idx = 1; idx < n; idx++){
            for(int cap = 0; cap <= w; cap++){
                int notTaken = 0 + dp[idx - 1][cap];
                int taken = Integer.MIN_VALUE;
                if(weight[idx] <= cap){
                    taken =  profit[idx] + dp[idx][cap - weight[idx]];
                }

                dp[idx][cap] = Math.max(taken, notTaken);
            }
        }

        return dp[n - 1][w];
    }
}
