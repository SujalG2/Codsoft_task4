package Practice;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayOptions() {
        System.out.println("ATM Options:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = scanner.nextDouble();
                if (userAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: $" + userAccount.getBalance());
                } else {
                    System.out.println("Insufficient funds or invalid amount for withdrawal.");
                }
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
                break;
            case 3:
                System.out.println("Current balance: $" + userAccount.getBalance());
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        // Initialize user's bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        // Create an ATM connected to the user's bank account
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayOptions();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose an option (1-4): ");
            int option = scanner.nextInt();

            atm.processOption(option);
        }
    }
}
