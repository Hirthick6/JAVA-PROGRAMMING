import java.util.Scanner;

class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void displayBalance() {
        System.out.println("Account Balance: $" + balance);
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        balance += balance * interestRate;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array of Account objects
        Account[] accounts = new Account[3];
        accounts[0] = new SavingsAccount("S12345", 0.05);
        accounts[1] = new Account("C67890");
        accounts[2] = new SavingsAccount("S13579", 0.03);

        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Add Interest (Savings Account)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber1 = scanner.next();
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    for (Account account : accounts) {
                        if (account != null && account.accountNumber.equals(accountNumber1)) {
                            account.deposit(depositAmount);
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String accountNumber2 = scanner.next();
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    for (Account account : accounts) {
                        if (account != null && account.accountNumber.equals(accountNumber2)) {
                            account.withdraw(withdrawAmount);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    String accountNumber3 = scanner.next();
                    for (Account account : accounts) {
                        if (account != null && account.accountNumber.equals(accountNumber3)) {
                            account.displayBalance();
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    String accountNumber4 = scanner.next();
                    for (Account account : accounts) {
                        if (account != null && account.accountNumber.equals(accountNumber4) && account instanceof SavingsAccount) {
                            ((SavingsAccount) account).addInterest();
                            System.out.println("Interest added to the account.");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting the banking system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
