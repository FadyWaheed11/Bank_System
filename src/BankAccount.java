
import java.util.ArrayList;

public class BankAccount {

    private static long accountNumber = 1000L;
    private String accountHolderName;
    private double balance;
    private final ArrayList<String> transactions;


    public BankAccount() {
        transactions = new ArrayList<>();
        accountNumber++;
    }

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        accountNumber++;
        transactions = new ArrayList<>();
        transactions.add("Account is created with initial balance of " + initialBalance);
    }


    public static long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addTransaction(String transaction) {
        if (!transaction.isEmpty())
            transactions.add(transaction);
        else
            System.out.println("Enter valid transaction");
    }

    public void deposit(double amount) {
        if (amount <= 0)
            System.out.println("PLZ enter amount more than zero");
        else {
            this.balance += amount;
            addTransaction("Deposit operation with amount of " + amount);
            System.out.println("Successful deposit with " + amount);
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0)
            System.out.println("You can't withdraw with" + amount);
        else if (amount > this.balance) {
            throw new InsufficientFundsException("Your Balance is not enough!");
        } else {
            this.balance -= amount;
            transactions.add("Withdrawing operation with amount of " + amount);
            System.out.println("Successful withdrawing with " + amount);
        }
    }

    public void showTransactionHistory() {
        System.out.println("Transaction history for account " + accountNumber);
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
