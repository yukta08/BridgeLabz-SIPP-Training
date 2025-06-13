import java.util.*;
class Problem3{
    public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         System.out.println("temperature in Celsius:");
         int celsius = sc.nextInt();
         int Fahrenheit = (celsius * 9/5) + 32;
         System.out.println("Temperature in fahrenheit:"+Fahrenheit);
}
}