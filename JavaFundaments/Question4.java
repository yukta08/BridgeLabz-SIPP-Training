//Suppose you have to divide 14 pens among 3 students equally. Write a program to find how many pens each student will get if the pens must be divided equally. Also, find the remaining non-distributed pens
import java.util.*;
public class Question4 {
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int pen =14;
    int student = 3;
    int remainder = 14%3;
    int non_distributed = 14/3;
    System.out.print( "The Pen Per Student is" + " "+non_distributed +" "+"and the remaining pen not distributed is" + " "+ remainder);
 }
}
