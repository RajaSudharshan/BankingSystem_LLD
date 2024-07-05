package LLD;
import java.util.*;

public class Bank {
    private static int accountCounter = 1000; // Static counter for generating unique account numbers
    private int accountNo;
    private double balance;
    private String name;
    private long phNo;
    private static ArrayList<Bank> accounts = new ArrayList<>();

    public Bank(String name, long phNo, double amount) { // We can access the variable using this. keyword in the constructor only
        // Also we cannot use this while using static in constructor.
        this.accountNo = ++accountCounter; // Assign a unique account number.
        this.name = name;    
        this.phNo = phNo;   
        this.balance = amount;
    }
    // Creation of account
    public static void createAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Enter your Phone Number:");
        long phNo = sc.nextLong();
        System.out.println("Deposit for Initial Balance:");
        double amount = sc.nextDouble();

        Bank newAccount = new Bank(name, phNo, amount);
        accounts.add(newAccount);

        System.out.println("Account created successfully!");
        System.out.println("Your Account Number: " + newAccount.accountNo);
    }
    // Deposit function
    public static void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your account number:");
        int accNo = sc.nextInt();
        System.out.println("Enter the amount to deposit:");
        double amount = sc.nextDouble();

        Bank account = findAccount(accNo);
        if (account != null) {
            account.balance += amount;
            System.out.println("Deposit successful! Your new balance is: " + account.balance);
        } else {
            System.out.println("Account not found.");
        }
    }
    // Finding account
    public static Bank findAccount(int accNo) {
        for (Bank account : accounts) {
            if (account.accountNo == accNo) {
                return account;
            }
        }
        return null;
    }
    // Withdrawal function
    public static void withdrawal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your account number:");
        int accNo = sc.nextInt();
        System.out.println("Enter the amount to withdraw:");
        double amount = sc.nextDouble();

        Bank account = findAccount(accNo);
        if (account != null) {
            if (account.balance >= amount) {
                account.balance -= amount;
                System.out.println("Withdrawal successful! Your new balance is: " + account.balance);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }
    // Exit function
    public static void exit() {
        System.out.println("................");
        System.exit(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Select the option:\n 1. Create your Account\n 2. Withdrawal\n 3. Deposit\n 4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume the newline character left after nextInt
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    withdrawal();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    exit();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
