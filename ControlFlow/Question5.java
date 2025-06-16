//Write a program SpringSeason that takes two int values month and day from the command line and prints “Its a Spring Season” otherwise prints “Not a Spring Season”

import java.util.Scanner;

public class Question5 {
    public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int a = sc.nextInt();
	int b = sc.nextInt();
	if((a==3 && b<=20) || (a==4 && b<=30) || (a==5 && b<=31) ||(a==6 && b<=20)) {
		System.out.print("Its a Spring Season");
	}
	else {
		System.out.print("Not a spring season");

	}
    sc.close();
}
    
}
