import java.util.Scanner;

// Class representing a bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal amount must be greater than zero.");
            return false;
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount. Deposit amount must be greater than zero.");
        }
    }
}

// Class representing the ATM
class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Current Balance: $" + bankAccount.getBalance());
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: $" + bankAccount.getBalance());
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
        System.out.println("New balance: $" + bankAccount.getBalance());
    }
}

// Main class to run the ATM simulation
public class ATMApplication {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Initialize with a starting balance
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}