package QUESTIONS.Array;

//The contructor will be passed an integer n. generate is supposed to return a random number between 0 to n, but it is not supposed to return a number that it has already returned.
//If possiblities are exhauted, return -1.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    int maximum;
    int index;
    int noOfTimes;
    List<Integer> numbers = new ArrayList<>();
   public RandomGenerator(int maximum,int noOfTimes) {
       this.maximum = maximum;
       this.index=maximum;
       this.noOfTimes=noOfTimes;
       for(int i = 0; i <= maximum; i++){
           numbers.add(i);
            //System.out.println(i);
       }
   }
   private int generate(){
       int ans;
       if(index==-1)return -1;
       Random rand = new Random();
       if(maximum>0){
           ans = rand.nextInt(maximum+1)%maximum;
       }
       else{
           ans = 0;
       }
       maximum--;
       //System.out.println(index+" "+ans);
       Collections.swap(numbers,numbers.get(index), numbers.get(ans));
       ans=numbers.get(index);
       index--;
       return ans;
   }
   public void getRandom(){
       for(int i = 0; i <= noOfTimes; i++){
           System.out.println(generate());
       }
   }

   public static void main(String[] args){
       RandomGenerator randomGenerator = new RandomGenerator(10,11);
       randomGenerator.getRandom();
   }
}
