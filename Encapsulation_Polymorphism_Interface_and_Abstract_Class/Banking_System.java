import java.util.Scanner;

// Abstract base class representing a bank account
abstract class BankAccount {
    private long accountNumber;
    private String holderName;
    private double balance;

    // Constructor to initialize bank account
    public BankAccount(long accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters for account details
    public long getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    // Method to deposit money into account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw money from account
    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
        else System.out.println("Insufficient balance.");
    }

    // Protected setter used internally by subclasses if needed
    protected void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    // Abstract method for interest calculation (implemented differently in each account type)
    public abstract double calculateInterest();

    // Display account details and interest
    public void displayDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest: " + calculateInterest());
    }
}

// Interface defining loan-related behavior
interface Loanable {
    void applyForLoan(double amount);           // Method to apply for a loan
    boolean calculateLoanEligibility();         // Check if eligible for loan
}

// SavingsAccount inherits from BankAccount and implements Loanable
class SavingsAccount extends BankAccount implements Loanable {

    // Constructor to initialize SavingsAccount
    public SavingsAccount(long accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // Savings accounts offer 4% interest
    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    // Loan application logic for savings account
    public void applyForLoan(double amount) {
        System.out.println("Savings Loan Applied: " + amount);
    }

    // Eligibility rule: balance must be at least ₹5000
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000;
    }
}

// CurrentAccount inherits from BankAccount and implements Loanable
class CurrentAccount extends BankAccount implements Loanable {

    // Constructor to initialize CurrentAccount
    public CurrentAccount(long accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // Current accounts do not earn interest
    public double calculateInterest() {
        return 0;
    }

    // Loan application logic for current account
    public void applyForLoan(double amount) {
        System.out.println("Current Loan Applied: " + amount);
    }

    // Eligibility rule: balance must be at least ₹10000
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000;
    }
}

// Main class to test the banking system
public class Banking_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array to hold both types of accounts
        BankAccount[] accounts = new BankAccount[2];

        // Input details for savings account
        System.out.print("Enter Savings Account Number: ");
        long sAcc = sc.nextLong();
        sc.nextLine();  // Consume leftover newline
        System.out.print("Enter Holder Name: ");
        String sName = sc.nextLine();
        System.out.print("Enter Balance: ");
        double sBal = sc.nextDouble();
        accounts[0] = new SavingsAccount(sAcc, sName, sBal);

        // Input details for current account
        System.out.print("\nEnter Current Account Number: ");
        long cAcc = sc.nextLong();
        sc.nextLine();  // Consume newline
        System.out.print("Enter Holder Name: ");
        String cName = sc.nextLine();
        System.out.print("Enter Balance: ");
        double cBal = sc.nextDouble();
        accounts[1] = new CurrentAccount(cAcc, cName, cBal);

        // Loop through accounts and display their details
        for (BankAccount acc : accounts) {
            acc.displayDetails();  // Polymorphic method call

            // If account supports loan operations, apply and check eligibility
            if (acc instanceof Loanable) {
                ((Loanable) acc).applyForLoan(10000);
                boolean eligible = ((Loanable) acc).calculateLoanEligibility();
                System.out.println("Loan Eligible: " + eligible);
            }

            System.out.println(); // Separator for next account
        }
    }
}
