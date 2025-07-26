import java.util.*;

// Withdrawal request record
class WithdrawalRequest 
{
    int accountNumber;
    double amount;

    WithdrawalRequest(int acc, double amt) 
    {
        this.accountNumber = acc;
        this.amount = amt;
    }
}

public class Banking_System 
{

    // HashMap: AccountNumber → Balance
    private Map<Integer, Double> accountMap = new HashMap<>();

    // Queue: Withdrawal requests
    private Queue<WithdrawalRequest> requestQueue = new LinkedList<>();

    // Add a customer account
    public void addAccount(int accNo, double initialBalance) 
    {
        accountMap.put(accNo, initialBalance);
    }

    // Make a withdrawal request
    public void requestWithdrawal(int accNo, double amount) 
    {
        requestQueue.add(new WithdrawalRequest(accNo, amount));
    }

    // Process all withdrawal requests
    public void processWithdrawals() 
    {
        System.out.println(" Processing Withdrawals:");
        while (!requestQueue.isEmpty()) 
        {
            WithdrawalRequest request = requestQueue.poll();

            if (!accountMap.containsKey(request.accountNumber)) 
            {
                System.out.println("❌ Account " + request.accountNumber + " not found.");
                continue;
            }

            double balance = accountMap.get(request.accountNumber);
            if (balance >= request.amount) 
            {
                accountMap.put(request.accountNumber, balance - request.amount);
                System.out.println("✅ Withdrawn ₹" + request.amount + " from Account " + request.accountNumber);
            } 
            else 
            {
                System.out.println("❌ Insufficient balance in Account " + request.accountNumber);
            }
        }
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() 
    {
        TreeMap<Double, List<Integer>> balanceMap = new TreeMap<>();

        for (Map.Entry<Integer, Double> entry : accountMap.entrySet()) 
        {
            int accNo = entry.getKey();
            double balance = entry.getValue();

            balanceMap.putIfAbsent(balance, new ArrayList<>());
            balanceMap.get(balance).add(accNo);
        }

        System.out.println("\n Accounts Sorted by Balance:");
        for (Map.Entry<Double, List<Integer>> entry : balanceMap.entrySet()) 
        {
            double balance = entry.getKey();
            for (int accNo : entry.getValue()) 
            {
                System.out.println("Account " + accNo + " → Balance: ₹" + balance);
            }
        }
    }

    public static void main(String[] args) 
    {
        Banking_System bank = new Banking_System();

        // Add sample accounts
        bank.addAccount(1001, 5000.0);
        bank.addAccount(1002, 3000.0);
        bank.addAccount(1003, 7000.0);
        bank.addAccount(1004, 5000.0);  // Duplicate balance for sorting test

        // Add withdrawal requests
        bank.requestWithdrawal(1002, 1000.0);
        bank.requestWithdrawal(1001, 6000.0); // Should fail
        bank.requestWithdrawal(1003, 2000.0);
        bank.requestWithdrawal(9999, 500.0);  // Non-existent

        bank.processWithdrawals();
        bank.displaySortedAccounts();
    }
}
