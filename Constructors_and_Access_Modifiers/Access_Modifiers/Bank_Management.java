// Class representing a basic Bank Account
class BankAccount 
{
    public String accountNumber;     // Public: accessible from anywhere
    protected String accountHolder;  // Protected: accessible within subclass and same package
    private double balance;          // Private: accessible only within this class

    // Constructor to initialize BankAccount details
    BankAccount(String accountNumber, String accountHolder, double balance) 
    {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to deposit money into the account
    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
        }
    }

    // Public method to withdraw money from the account if sufficient balance exists
    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
        }
    }

    // Public method to retrieve the balance (read access to private variable)
    public double getBalance() 
    {
        return balance;
    }

    // Public method to display basic account details
    public void displayAccountInfo() 
    {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + getBalance());
    }
}

// Subclass representing a Savings Account
class SavingsAccount extends BankAccount 
{
    double interestRate;  // Additional attribute for savings account

    // Constructor for SavingsAccount using super to call parent constructor
    SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) 
    {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Method to display savings account details using inherited and subclass fields
    public void displaySavingsInfo() 
    {
        System.out.println("Savings Account Number: " + accountNumber);      // Accessing public member
        System.out.println("Account Holder Name: " + accountHolder);         // Accessing protected member
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Main class to test BankAccount and SavingsAccount
public class Bank_Management 
{
    public static void main(String[] args) 
    {
        // Create a basic bank account
        BankAccount acc1 = new BankAccount("SB1001", "Ravi Kumar", 15000.00);
        acc1.deposit(5000);
        acc1.withdraw(2000);
        System.out.println("--- Bank Account Info ---");
        acc1.displayAccountInfo();

        System.out.println();

        // Create a savings account
        SavingsAccount sa1 = new SavingsAccount("SB2002", "Aarti Mehra", 30000.00, 5.5);
        System.out.println("--- Savings Account Info ---");
        sa1.displaySavingsInfo();
        System.out.println("Current Balance: ₹" + sa1.getBalance());
    }
}
