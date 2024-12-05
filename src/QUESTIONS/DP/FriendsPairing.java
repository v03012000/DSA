package QUESTIONS.DP;
//https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1
public class FriendsPairing {

    public long solve(int n){
        if(n<=2)return n;
        long [] dp = new long[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=(1*dp[i-1])+((i-1)*dp[i-2]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FriendsPairing fp = new FriendsPairing();
        System.out.println(fp.solve(7));
    }
}
