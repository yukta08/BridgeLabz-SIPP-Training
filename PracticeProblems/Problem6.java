import java.util.*;
class Problem6{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
         System.out.println("enter your number:");
         int principal = sc.nextInt();
         int Rate=sc.nextInt();
         int Time=sc.nextInt();
         int SimpleInterest = (principal * Rate * Time) / 100;
         
         System.out.println(SimpleInterest); 
}
}