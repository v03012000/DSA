package Leetcode;
//https://leetcode.com/problems/add-strings/

public class AddStrings_415 {
    public String addStrings(String num1, String num2) {
        StringBuilder result1 = new StringBuilder(num1);
        num1 = result1.reverse().toString();
        StringBuilder result2 = new StringBuilder(num2);
        num2 = result2.reverse().toString();
        //System.out.println(num1+" "+num2);
        int carry=0;
        String ans = "";
        while(num1.length()>0 && num2.length()>0){
            int sum = Integer.parseInt(num1.substring(0,1))+
                    Integer.parseInt(num2.substring(0,1)) + carry;
            //System.out.println(sum);
            ans = ans + (sum%10);
            carry = sum/10;
            num1 = num1.substring(1);
            num2= num2.substring(1);
        }
        while(num1.length()>0 && !(num2.length()>0)){
            int sum = Integer.parseInt(num1.substring(0,1))+
                    + carry;
            //System.out.println(sum);
            ans = ans + (sum%10);
            carry = sum/10;
            num1 = num1.substring(1);
        }
        while(num2.length()>0 && !(num1.length()>0)){
            int sum = Integer.parseInt(num2.substring(0,1))+
                    + carry;
            System.out.println(sum);
            ans = ans + (sum%10);
            carry = sum/10;
            num2 = num2.substring(1);
        }

        if(num2.length()==0 && num1.length()==0 && carry>0){
            ans = ans +(carry%10);
        }
        StringBuilder result = new StringBuilder(ans);

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings_415 addStrings_415 = new AddStrings_415();
        System.out.println(addStrings_415.addStrings("123", "456"));
    }
}

