import java.util.Scanner;

public class StudentBankSystem {

    // Account details
    private static String studentName;
    private static String studentId;
    private static String accountNumber;
    private static double balance;

    private static final double ANNUAL_INTEREST_RATE = 5.0; // 5%
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        createAccount();

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    depositMoney();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    displayAccountDetails();
                    break;
                case 5:
                    calculateInterest();
                    break;
                case 6:
                    System.out.println("\nThank you for using Student Bank System!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please select an option between 1 and 6.");
            }
            System.out.println();
        }

        sc.close();
    }

    // ---------- Account Creation ----------
    private static void createAccount() {
        System.out.println("========== STUDENT BANK SYSTEM ==========\n");

        System.out.print("Enter Student Name: ");
        studentName = sc.nextLine().trim();

        System.out.print("Enter Student ID: ");
        studentId = sc.nextLine().trim();

        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextLine().trim();

        double initialDeposit;
        while (true) {
            System.out.print("Enter Initial Deposit: ");
            initialDeposit = readDoubleFromLine();
            if (initialDeposit > 0) {
                break;
            }
            System.out.println("Initial deposit must be greater than 0. Try again.");
        }

        balance = initialDeposit;
        System.out.println("\nAccount created successfully!\n");
    }

    // ---------- Main Menu ----------
    private static void printMenu() {
        System.out.println("========== STUDENT BANK SYSTEM ==========");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Check Balance");
        System.out.println("4. Display Account Details");
        System.out.println("5. Calculate Interest");
        System.out.println("6. Exit");
    }

    // ---------- 1. Deposit Money ----------
    private static void depositMoney() {
        System.out.print("Enter deposit amount: ");
        double amount = readDoubleFromLine();

        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
            return;
        }

        balance += amount;
        System.out.println("Rs." + formatAmount(amount) + " deposited successfully.");
        System.out.println("Current Balance: Rs." + formatAmount(balance));
    }

    // ---------- 2. Withdraw Money ----------
    private static void withdrawMoney() {
        System.out.print("Enter withdrawal amount: ");
        double amount = readDoubleFromLine();

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance! Withdrawal failed.");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawal successful.");
        System.out.println("Current Balance: Rs." + formatAmount(balance));
    }

    // ---------- 3. Check Balance ----------
    private static void checkBalance() {
        System.out.println("Current Balance: Rs." + formatAmount(balance));
    }

    // ---------- 4. Display Account Details ----------
    private static void displayAccountDetails() {
        System.out.println("Student Name : " + studentName);
        System.out.println("Student ID   : " + studentId);
        System.out.println("Account No   : " + accountNumber);
        System.out.println("Balance      : Rs." + formatAmount(balance));
    }

    // ---------- 5. Calculate Interest ----------
    private static void calculateInterest() {
        double years;
        while (true) {
            System.out.print("Enter number of years: ");
            years = readDoubleFromLine();
            if (years > 0) break;
            System.out.println("Number of years must be greater than 0. Try again.");
        }

        double interest = (balance * ANNUAL_INTEREST_RATE * years) / 100;
        double newBalance = balance + interest;

        System.out.println("Interest Earned: Rs." + formatAmount(interest));
        System.out.println("New Balance (Balance + Interest): Rs." + formatAmount(newBalance));
    }

    // ---------- Helper Methods ----------

    // Reads a whole line and parses it as an int. Re-prompts on invalid input.
    private static int readInt() {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 6.");
                System.out.print("Enter your choice: ");
            }
        }
    }

    // Reads a whole line and parses it as a double. Re-prompts on invalid input.
    private static double readDoubleFromLine() {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.print("Invalid amount! Please enter a numeric value: ");
            }
        }
    }

    private static String formatAmount(double amount) {
        if (amount == Math.floor(amount)) {
            return String.format("%,.0f", amount);
        }
        return String.format("%,.2f", amount);
    }
}