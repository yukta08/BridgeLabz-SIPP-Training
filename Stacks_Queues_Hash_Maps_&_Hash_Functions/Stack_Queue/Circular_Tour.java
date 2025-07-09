import java.util.*;

public class Circular_Tour 
{

    // Find starting petrol pump index to complete the tour
    public int findStart(int[] petrol, int[] dist) 
    {
        int n = petrol.length;
        int start = 0, tank = 0, total = 0;

        for (int i = 0; i < n; i++) 
	{
            int gain = petrol[i] - dist[i];
            tank += gain;
            total += gain;

            if (tank < 0) 
	    {
                start = i + 1; // try next pump
                tank = 0;      // reset current tank
            }
        }

        return (total >= 0) ? start : -1;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Circular_Tour ct = new Circular_Tour();

        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();

        int[] petrol = new int[n];
        int[] dist = new int[n];

        System.out.println("Enter petrol and distance for each pump:");

        for (int i = 0; i < n; i++) 
	{
            System.out.print("Pump " + (i + 1) + " petrol: ");
            petrol[i] = sc.nextInt();
            System.out.print("Pump " + (i + 1) + " distance to next: ");
            dist[i] = sc.nextInt();
        }

        int start = ct.findStart(petrol, dist);

        if (start != -1) 
	{
            System.out.println("Start at pump index: " + start);
        } 
	else 
	{
            System.out.println("No possible tour. Return -1.");
        }

        sc.close();
    }
}
