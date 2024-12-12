package Leetcode;

public class StringToNumber {

    public int solve(String s,int i) {
      if(s.length()==0){
          return 0;
      }
      if(!Character.isDigit(s.charAt(i))){
          return 0;
      }
      if(i==0){
          return s.charAt(0) - '0';
      }
      int num = s.charAt(i) - '0';
      return 10*solve(s,i-1)+num;

    }

    public static void main(String[] args) {
        StringToNumber obj = new StringToNumber();
        int sign=1;
        String s="    -1235";
        //discard leading blank spaces
        while(s.charAt(0)==' '){
            s=s.substring(1);
           // System.out.println(s);
        }
        if(!s.isEmpty()) {
            sign = s.charAt(0) == '-' ? -1 : 1;
            s=s.substring(1);
        }
        int result = sign*obj.solve(s,s.length()-1);
        System.out.println(result);
    }
}
