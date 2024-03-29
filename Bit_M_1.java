class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            if( i%2 == 0 )      //When even for eg: 2->(10), 4->(100) a zero is added at the end so same number of ones
                dp[i] = dp[i/2];  
            else       //When odd for eg: 2->(10), 3->(011) an extra one is added for 3
                dp[i] = dp[i-1] + 1;
        }
        return dp;
    }
}
