import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(double initialBalance, String customerName) {
        BankAccount lukaku = new BankAccount(initialBalance, customerName);
        accounts.add(lukaku);
    }

    public BankAccount find(int accountNumber) {
        for (BankAccount ba : this.accounts) {
            if (ba.getAccountNumber() == accountNumber)
                return ba;
        }
        return null;
    }

    public void deposit(int accountNumber, double amount) {
        find(accountNumber).deposit(amount);
    }

    public void withdraw(int accountNumber, double amount) {
        find(accountNumber).withdraw(amount);
    }

    public double getBalance(int accountNumber) {
        return (find(accountNumber).getBalance());
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        find(fromAccountNumber).withdraw(amount);
        find(toAccountNumber).deposit(amount);
    }
}