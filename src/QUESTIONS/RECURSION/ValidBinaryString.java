package QUESTIONS.RECURSION;
//count the no of binary strings with no consecutive ones that can be formed using a binary string of length n

public class ValidBinaryString {


        int countStrings(int n) {
            // code here
            int[] ending0 = new int[n+1];
            int[] ending1 = new int[n+1];
            ending0[0]=0;
            ending1[0]=0;
            ending0[1]=1;
            ending1[1]=1;
            for(int i=2;i<=n;i++){
                ending0[i]=ending0[i-1]+ending1[i-1];
                ending1[i]=ending0[i-1];
            }
            return ending0[n]+ending1[n];
        }
        public static void main(String[] args) {
            ValidBinaryString v = new ValidBinaryString();
            System.out.println(v.countStrings(5));
        }
}
