import java.util.*;
class Problem7{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
         System.out.println("enter your number:");
         int length = sc.nextInt();
         int width=sc.nextInt();
         int perimeter = 2*(length*width);
         System.out.println("perimeter of the rectangle:"+perimeter); 
}
}