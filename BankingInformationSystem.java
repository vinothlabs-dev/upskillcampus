import java.util.Scanner;

class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    // Deposit money
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;

            System.out.println("Amount deposited successfully.");
            System.out.println("Current Balance: Rs. " + balance);

        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");

        } else if (amount > balance) {
            System.out.println("Insufficient balance.");

        } else {
            balance -= amount;

            System.out.println("Amount withdrawn successfully.");
            System.out.println("Current Balance: Rs. " + balance);
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current Balance: Rs. " + balance);
    }

    // Display account details
    public void displayAccountDetails() {

        System.out.println("\n========== ACCOUNT DETAILS ==========");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : Rs. " + balance);
        System.out.println("=====================================");
    }
}

public class BankingInformationSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("==========================================");
        System.out.println("       BANKING INFORMATION SYSTEM");
        System.out.println("==========================================");

        // Get account information
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accountHolder = scanner.nextLine();

        // Create bank account object
        BankAccount account =
                new BankAccount(accountNumber, accountHolder);

        int choice;

        // Banking menu
        do {

            System.out.println("\n============== MENU ==============");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.println("==================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter deposit amount: Rs. ");
                    double depositAmount = scanner.nextDouble();

                    account.deposit(depositAmount);

                    break;

                case 2:

                    System.out.print("Enter withdrawal amount: Rs. ");
                    double withdrawalAmount = scanner.nextDouble();

                    account.withdraw(withdrawalAmount);

                    break;

                case 3:

                    account.checkBalance();

                    break;

                case 4:

                    account.displayAccountDetails();

                    break;

                case 5:

                    System.out.println("\nThank you for using Banking Information System!");

                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}