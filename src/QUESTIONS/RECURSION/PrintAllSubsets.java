package QUESTIONS.RECURSION;

import java.util.ArrayList;
import java.util.Arrays;
//Subset: Same as subsequence except it has empty set
//https://leetcode.com/submissions/detail/1473739686/
public class PrintAllSubsets {

    private void printAllSubsets(ArrayList<ArrayList<Integer>> subsets,ArrayList<Integer> subset, ArrayList<Integer> nums,int index) {
         if(index==nums.size()){
             subsets.add(new ArrayList<>(subset));
             return;
         }
         subset.add(nums.get(index));
         printAllSubsets(subsets,subset,nums,index+1);
         subset.remove(nums.get(index));
         printAllSubsets(subsets,subset,nums,index+1);

    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> subset = new ArrayList<>();
        PrintAllSubsets printAllSubsets = new PrintAllSubsets();
        printAllSubsets.printAllSubsets(subsets, subset, nums, 0);
        System.out.println(subsets.size());
        for (int s = 0; s < subsets.size() ; s++) {
            ArrayList<Integer> sub = subsets.get(s);
            System.out.println("new subset: ");
           for (int t = 0; t < sub.size(); t++) {
               System.out.print(sub.get(t)+" ");
           }
            System.out.println(" ");
        }
    }
}
