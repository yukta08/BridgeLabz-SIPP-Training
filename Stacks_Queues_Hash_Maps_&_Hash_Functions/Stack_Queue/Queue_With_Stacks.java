import java.util.*;

public class Queue_With_Stacks 
{
    private final Stack<Integer> in = new Stack<>();
    private final Stack<Integer> out = new Stack<>();

    // Enqueue element
    public void enq(int val) 
    {
        in.push(val);
    }

    // Dequeue element
    public int deq() 
    {
        shift();
        if (out.isEmpty()) throw new RuntimeException("Queue is empty");
        return out.pop();
    }

    // Peek front element
    public int peek() 
    {
        shift();
        if (out.isEmpty()) throw new RuntimeException("Queue is empty");
        return out.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() 
    {
        return in.isEmpty() && out.isEmpty();
    }

    // Transfer from in to out only when out is empty
    private void shift() 
    {
        if (out.isEmpty()) 
	{
            while (!in.isEmpty()) out.push(in.pop());
        }
    }

    // Test the queue implementation
    public static void main(String[] args) 
    {
        QueueWithStacks q = new QueueWithStacks();

        q.enq(10);
        q.enq(20);
        q.enq(30);

        System.out.println(q.peek()); 
        System.out.println(q.deq());  
        System.out.println(q.peek()); 
        System.out.println(q.deq());  
        System.out.println(q.deq());  
        System.out.println(q.isEmpty()); 
    }
}
