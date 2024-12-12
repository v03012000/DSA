package QUESTIONS.RECURSION;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=perfect-sum-problem
public class SubsetsWithSumK {

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

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(2,5,1,4,3));
        ArrayList<Integer> subset = new ArrayList<>();
        SubsetsWithSumK SubsetsWithSumK = new SubsetsWithSumK();
        SubsetsWithSumK.printSubsets(subsets, subset, nums, 0,10,0);
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
