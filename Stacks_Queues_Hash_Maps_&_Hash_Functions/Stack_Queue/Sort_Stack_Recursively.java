import java.util.*;

public class Sort_Stack_Recursively 
{

    // Sort the stack using recursion
    public void sort(Stack<Integer> stk) 
    {
        if (!stk.isEmpty()) 
	{
            int top = stk.pop();
            sort(stk);
            insert(stk, top);
        }
    }

    // Insert element into sorted stack
    private void insert(Stack<Integer> stk, int val) 
    {
        if (stk.isEmpty() || val >= stk.peek()) 
	{
            stk.push(val);
        } 
	else 
	{
            int top = stk.pop();
            insert(stk, val);
            stk.push(top);
        }
    }

    // Print stack from top to bottom
    public void print(Stack<Integer> stk) 
    {
        for (int i = stk.size() - 1; i >= 0; i--) 
	{
            System.out.println(stk.get(i));
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stk = new Stack<>();
        Sort_Stack_Recursively srt = new Sort_Stack_Recursively();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) 
	{
            stk.push(sc.nextInt());
        }

        srt.sort(stk);

        System.out.println("Sorted Stack (Top to Bottom):");
        srt.print(stk);

        sc.close();
    }
}
