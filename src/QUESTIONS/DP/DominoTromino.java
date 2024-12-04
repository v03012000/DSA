package QUESTIONS.DP;
//https://leetcode.com/problems/domino-and-tromino-tiling/description/
public class DominoTromino {
        public int numTilings(int n) {
            long [] full = new long[n+1];
            long [] topMissing = new long[n+1];
            long [] bottomMissing = new long[n+1];
            if(n<=2) return n;
            full[0]=1;
            full[1]=1;
            full[2]=2;
            bottomMissing[0]=0;
            bottomMissing[1]=0;
            bottomMissing[2]=1;
            topMissing[0]=0;
            topMissing[1]=0;
            topMissing[2]=1;
            int MOD=1000000007;
            for(int i=3;i<=n;i++){
                full[i]=(full[i-1]+full[i-2]+topMissing[i-1]+bottomMissing[i-1])%MOD;
                topMissing[i]= (bottomMissing[i-1]+full[i-2])%MOD;
                bottomMissing[i]=(topMissing[i-1]+full[i-2])%MOD;
            }
            return (int)full[n];
        }

        public static void main(String[] args) {
            DominoTromino dominoTromino = new DominoTromino();
            System.out.println(dominoTromino.numTilings(30));
        }

}
