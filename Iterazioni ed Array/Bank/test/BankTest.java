import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

    @Before
    public void setup() {
        BankAccount.totalNumberOfAccounts = 0;
    }

    @Test
    public void findAccountTest() {
        Bank b = new Bank();
        b.addAccount(1000, "Dario");
        BankAccount newAccount = b.find(1);
        Assert.assertEquals(1, newAccount.getAccountNumber());
        Assert.assertEquals(1000, newAccount.getBalance(), 0);
        Assert.assertEquals("Dario", newAccount.getCustomerName());
    }

    @Test
    public void depositTest() {
        Bank lukaku = new Bank();
        lukaku.addAccount(1000, "raspadori");
        lukaku.deposit(1, 500);
        Assert.assertEquals(1500, lukaku.getBalance(1), 0);
    }

    @Test
    public void withdrawTest() {
        Bank lukaku = new Bank();
        lukaku.addAccount(1000, "raspadori");
        lukaku.withdraw(1, 500);
        Assert.assertEquals(500, lukaku.getBalance(1), 0);
    }

    @Test
    public void transferTest() {
        Bank lukaku = new Bank();
        lukaku.addAccount(1000, "raspadori");
        lukaku.addAccount(1000, "nani");
        lukaku.transfer(1, 2, 500);
        Assert.assertEquals(500, lukaku.getBalance(1), 0);
        Assert.assertEquals(1500, lukaku.getBalance(2), 0);
    }
}