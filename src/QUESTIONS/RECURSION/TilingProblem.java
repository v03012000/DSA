package QUESTIONS.RECURSION;

//Find the number of possible different combinations to fill a 4 x N area (4 units height and N units width, N ≥ 1) with tiles of dimention 4 x 1 (4 units height and 1 unit width).
public class TilingProblem {

    public int solve(int n) {
       if(n<4){
           return 1;
       }
       if(n==4)return 2;
       return solve(n-1)+solve(n-4);
    }

    public int dpSolve(int n){
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4]=2;
        for(int i=5;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-4];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        TilingProblem tilingProblem = new TilingProblem();
        System.out.println(tilingProblem.solve(7)+"  : "+ tilingProblem.dpSolve(7));
    }
}
