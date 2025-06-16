import java.util.Scanner;
public interface Question6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbe: ");
        int n = sc.nextInt();
        int sum = 0;
        if(n>0){
            sum = n*(n+1)/2;
        }
        System.out.println(sum);
        sc.close();
    }
}
