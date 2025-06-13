//Write a program that takes the distance in kilometres as input from the user and converts it into miles using the formula:

import java.util.Scanner;
class Problem10{
public static void main (String []args){
Scanner sc = new Scanner(System.in);
Double k = sc.nextDouble();
Double m = k*0.621371;
System.out.println("Kilometers to Miles :" +m );
}}