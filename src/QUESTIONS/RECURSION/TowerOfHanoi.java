package QUESTIONS.RECURSION;

public class TowerOfHanoi {
    //n disks, 3 towers: a,b,c

    public int solve(int n, char a, char b, char c) {
        if(n==0) {
            return 0;
        }
        int ans=0;
ans = solve(n-1,a,c,b);
        System.out.println(n+" ->"+a+" "+b);
 ans+=solve(n-1,c,b,a)+1;
 return ans;
    }

    public static void main(String[] args) {
        TowerOfHanoi tower = new TowerOfHanoi();
        System.out.println(tower.solve(3,'A','B','C'));
    }
}
