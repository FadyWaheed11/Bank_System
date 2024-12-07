import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SavingAccount account = new SavingAccount("Ahmed Mahmoud", 1000);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println();
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Show Balance");
                System.out.println("4. Transaction History");
                System.out.println("5. Generate transaction report");
                System.out.println("6. Exit");
                System.out.println();
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        try {
                            account.withdraw(withdrawAmount);
                        } catch (InsufficientFundsException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Current balance: " + account.getBalance());
                        break;
                    case 4:
                        account.showTransactionHistory();
                        break;
                    case 5:
                        try {
                            System.out.println("Report generated successfully.");
                            account.generateReport("src/report.txt");
                        } catch (IOException e) {
                            System.out.println("File path is not found");
                        }
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input enter correct service number! " + e);
                scanner.nextLine();
            }
        }

    }
}
