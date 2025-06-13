import java.util.*;
class Problem4{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
         System.out.println("enter your number:");
         int radius = sc.nextInt();
         int height=sc.nextInt();
         double Volume = 3.14 * radius*radius* height;
         System.out.println("Volume of the Cylinder:"+Volume); 
}
}