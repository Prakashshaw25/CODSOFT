import java.util.Scanner;

public class Atminterface {
    static class BankAccount {
        private double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        public void deposit(double amount) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". Current balance: $" + balance);
        }

        public void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn $" + amount + ". Current balance: $" + balance);
            } else {
                System.out.println("Insufficient funds. Current balance: $" + balance);
            }
        }

        public void checkBalance() {
            System.out.println("Current balance: $" + balance);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(1000); // Starting balance $1000

        while (true) {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            System.out.println(); // Print a blank line for readability
        }
    }
}