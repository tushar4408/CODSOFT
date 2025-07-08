import java.util.Scanner;

public class ATMApp {
    public static void main(String[] args) {
        Account myAccount = new Account(5000); // Starting balance: ₹5000
        ATM atm = new ATM(myAccount);
        atm.start();
    }
}

// -----------------------------
// Account class
// -----------------------------
class Account {
    private double balance;

    public Account(double openingBalance) {
        balance = openingBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println(" Deposit must be a positive amount.");
            return;
        }
        balance += amount;
        System.out.println("✅ ₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal must be a positive amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("✅ ₹" + amount + " withdrawn successfully.");
        }
    }
}

// -----------------------------
// ATM class
// -----------------------------
class ATM {
    private Account account;
    private Scanner sc;

    public ATM(Account acc) {
        this.account = acc;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        System.out.println("🏧 Welcome to CODSOFT ATM!\n");

        int choice;
        do {
            showMenu();
            choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> handleDeposit();
                case 2 -> handleWithdraw();
                case 3 -> showBalance();
                case 4 -> System.out.println("👋 Thank you for banking with us!");
                default -> System.out.println("⚠️ Invalid choice. Please try again.\n");
            }
        } while (choice != 4);
    }

    private void showMenu() {
        System.out.println("""
                ====== MENU ======
                1. Deposit
                2. Withdraw
                3. Check Balance
                4. Exit
                """);
    }

    private void handleDeposit() {
        double amt = getDoubleInput("Enter amount to deposit: ₹");
        account.deposit(amt);
    }

    private void handleWithdraw() {
        double amt = getDoubleInput("Enter amount to withdraw: ₹");
        account.withdraw(amt);
    }

    private void showBalance() {
        System.out.println("Current balance: ₹" + account.getBalance() + "\n");
    }

    // Input helpers
    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. " + prompt);
            sc.next();
        }
        return sc.nextInt();
    }

    private double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input. " + prompt);
            sc.next();
        }
        return sc.nextDouble();
    }
}
