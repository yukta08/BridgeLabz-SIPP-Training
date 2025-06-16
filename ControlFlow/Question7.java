//- Write a program to find the sum of n natural numbers using for loop, compare the result with the formulae n*(n+1)/2 and show the result from both computations was correct.
import java.util.Scanner;
public record Question7() {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0,sum2=0;
        int n =  sc.nextInt();
        for(int i = n ;i>0;i--){
            sum = sum +i;
        }
        sum2 = n*(n+1)/2;
        if(sum == sum2){
            System.out.println("Correct");
        }else{
            System.out.println("Incorrect");
        }
        sc.close();
    }
}
