import java.io.*;

public class SavingAccount extends BankAccount implements Reportable{

    private static final double minimumBalance = 1000.0;

    public SavingAccount(String accountHolderName , double initialBalance){
        openAccount(initialBalance);
        super.setAccountHolderName(accountHolderName);
        addTransaction("Account is created with initial balance of " + initialBalance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException{
        if((getBalance() - amount) < minimumBalance)
            throw new InsufficientFundsException("Cannot withdraw the minimum balance for Saving account to be maintained is " + minimumBalance);
        super.withdraw(amount);
    }

    public double calculateInterests(int numberOfMonths){
        return ((getBalance() * 0.2) + getBalance()) * numberOfMonths;
    }

    public void openAccount(double balance){
        if(balance < minimumBalance)
            System.out.println("The Minimum balance to open Saving account is 1000");
        else
            super.setBalance(balance);
    }

    @Override
    public void generateReport(String path) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
        for(String line : getTransactions()){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
