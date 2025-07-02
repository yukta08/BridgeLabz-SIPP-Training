import java.util.*;

// Superclass representing a generic bank account
class BankAccount 
{
    String accountNumber;
    double balance;

    // Constructor to initialize account number and balance
    BankAccount(String accountNumber, double balance) 
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Display account basic details
    void displayInfo() 
    {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }

    // Method to be overridden by subclasses
    void displayAccountType() 
    {
        System.out.println("Generic Bank Account");
    }
}

// Subclass for Savings Account
class SavingsAccount extends BankAccount 
{
    double interestRate;

    // Constructor with interest rate
    SavingsAccount(String accountNumber, double balance, double interestRate) 
    {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    // Show specific type
    @Override
    void displayAccountType() 
    {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass for Checking Account
class CheckingAccount extends BankAccount 
{
    double withdrawalLimit;

    // Constructor with withdrawal limit
    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) 
    {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    // Show specific type
    @Override
    void displayAccountType() 
    {
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
    }
}

// Subclass for Fixed Deposit Account
class FixedDepositAccount extends BankAccount 
{
    int maturityPeriod; // in months

    // Constructor with maturity period
    FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) 
    {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    // Show specific type
    @Override
    void displayAccountType() 
    {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Maturity Period: " + maturityPeriod + " months");
    }
}

// Main class to test different account types
public class Bank_Account_Types 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select account type (1: Savings, 2: Checking, 3: Fixed Deposit): ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Balance: ");
        double bal = sc.nextDouble();

        BankAccount account;

        switch (choice) 
        {
            case 1:
                System.out.print("Enter Interest Rate (%): ");
                double rate = sc.nextDouble();
                account = new SavingsAccount(accNo, bal, rate);
                break;
            case 2:
                System.out.print("Enter Withdrawal Limit: ");
                double limit = sc.nextDouble();
                account = new CheckingAccount(accNo, bal, limit);
                break;
            case 3:
                System.out.print("Enter Maturity Period (in months): ");
                int months = sc.nextInt();
                account = new FixedDepositAccount(accNo, bal, months);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                return;
        }

        System.out.println("\n--- Account Details ---");
        account.displayInfo();
        account.displayAccountType();
    }
}
