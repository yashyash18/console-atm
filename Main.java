

import java.util.Scanner;



public class Main{
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addUser(new User("Yash", 1001, 1234, 1000));
        bank.addUser(new User("uday", 1002, 5678, 2000));
        ATM atm = new ATM(bank);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Login");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    System.out.print("Enter PIN: ");
                    int pin = scanner.nextInt();
                    if (atm.login(accountNumber, pin)) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Login failed. Incorrect account number or PIN.");
                    }
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    System.out.print("Enter PIN: ");
                    pin = scanner.nextInt();
                    double balance = atm.checkBalance(accountNumber, pin);
                    if (balance != -1) {
                        System.out.println("Balance: $" + balance);
                    } else {
                        System.out.println("Error: User not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    System.out.print("Enter PIN: ");
                    pin = scanner.nextInt();
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    if (atm.deposit(accountNumber, pin, depositAmount)) {
                        System.out.println("Deposit successful!");
                    } else {
                        System.out.println("Error: User not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    System.out.print("Enter PIN: ");
                    pin = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    if (atm.withdraw(accountNumber, pin, withdrawAmount)) {
                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("Error: User not found or insufficient funds.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting ATM. Thank you for using our service!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}