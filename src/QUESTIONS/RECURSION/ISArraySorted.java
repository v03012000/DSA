package QUESTIONS.RECURSION;

public class ISArraySorted {


    public boolean checkSorted(int[] array, int index, int n){
        if(index>=array.length-1){
            return true;
        }
        boolean isSorted = checkSorted(array, index+1, n);
        if(isSorted && array[index]<=array[index+1]){
            return true;
        }
        else return false;
    }

    public static void main(String[] args){
        ISArraySorted isArraySorted = new ISArraySorted();
        int[] array= new int[]{1,2,3,7,5,6,7,8,9};
        System.out.println(isArraySorted.checkSorted(array, 0, array.length-1));
    }
}
