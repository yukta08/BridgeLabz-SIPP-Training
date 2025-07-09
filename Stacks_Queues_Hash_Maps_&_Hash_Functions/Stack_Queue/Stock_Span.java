import java.util.*;

public class Stock_Span 
{

    // Compute span of stock prices
    public int[] getSpan(int[] prices) 
    {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) 
	{
            while (!stk.isEmpty() && prices[i] >= prices[stk.peek()]) 
	    {
                stk.pop();
            }

            span[i] = stk.isEmpty() ? i + 1 : i - stk.peek();

            stk.push(i);
        }

        return span;
    }

    // Print array
    public void print(int[] arr) 
    {
        for (int val : arr) 
	{
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Stock_Span s = new Stock_Span();

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter stock prices:");

        for (int i = 0; i < n; i++) 
	{
            prices[i] = sc.nextInt();
        }

        int[] result = s.getSpan(prices);

        System.out.println("Stock Prices: ");
        s.print(prices);

        System.out.println("Span for each day: ");
        s.print(result);

        sc.close();
    }
}
