package QUESTIONS.RECURSION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static java.util.Collections.sort;

//PART 1:  https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=perfect-sum-problem
//PART2: PRINT UNIQUE SUBSETS WITH SUM K
public class SubsequenceWithSumK {

    private void printSubsets(ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> subset, ArrayList<Integer> nums, int index,int target,int sum){
        if(index==nums.size()){
            if(sum==target) {
                subsets.add(new ArrayList<>(subset));
                return;
            }
        return;
        }

        subset.add(nums.get(index));
        printSubsets(subsets,subset,nums,index+1,target,sum+nums.get(index));
        subset.remove(nums.get(index));
        printSubsets(subsets,subset,nums,index+1,target,sum);
    }

    private void printUniqueSubsets(ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> subset, ArrayList<Integer> nums, int index,int target,int sum, HashSet<ArrayList<Integer>> seen){
        if(index==nums.size()){
            if(sum==target) {
               /* if(!seen.contains(new ArrayList<>(subset))){
                    subsets.add(new ArrayList<>(subset));
                    seen.add(new ArrayList<>(subset));
                }*/
                subsets.add(new ArrayList<>(subset));
                return;
            }
            return;
        }
        if((index==0)|| index-1>=0 && !(nums.get(index)==nums.get(index-1))) {
            subset.add(nums.get(index));
            printUniqueSubsets(subsets, subset, nums, index + 1, target, sum + nums.get(index), seen);
            subset.remove(nums.get(index));
            printUniqueSubsets(subsets, subset, nums, index + 1, target, sum, seen);
        }
        else{
            printUniqueSubsets(subsets, subset, nums, index + 1, target, sum, seen);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(2,5,1,4,4,3));
        ArrayList<Integer> subset = new ArrayList<>();
        SubsequenceWithSumK SubsetsWithSumK = new SubsequenceWithSumK();
        SubsetsWithSumK.printSubsets(subsets, subset, nums, 0,10,0);
        for (int s = 0; s < subsets.size() ; s++) {
            ArrayList<Integer> sub = subsets.get(s);
            System.out.println("new subset: ");
            for (int t = 0; t < sub.size(); t++) {
                System.out.print(sub.get(t)+" ");
            }
            System.out.println(" ");
        }
        subsets = new ArrayList<>();
        System.out.println("Uniques: ");
        HashSet<ArrayList<Integer>> seen = new HashSet<ArrayList<Integer>>();
        sort(nums);
        SubsetsWithSumK.printUniqueSubsets(subsets, subset, nums, 0,10,0,seen);
        /*for (ArrayList<Integer> value : seen) {
            System.out.println("new subset: ");
            for (int t = 0; t < value.size(); t++) {
                System.out.print(value.get(t)+" ");
            }
        }*/
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
