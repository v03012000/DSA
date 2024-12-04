package QUESTIONS.RECURSION;

public class PrintNumbersIncreasing {

    public void printIncreasing(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        printIncreasing(n-1);
        System.out.println(n);
    }

    public void printDecreasing(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void main(String[] args) {
        System.out.println("Increasing");
        PrintNumbersIncreasing printNumbersIncreasing = new PrintNumbersIncreasing();
        printNumbersIncreasing.printIncreasing(7);
        System.out.println("Decreasing");
        printNumbersIncreasing.printDecreasing(7);
    }
}
