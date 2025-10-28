import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTest {
    @Test
    public void addAndTakeCansTest()
    {
        VendingMachine lukaku = new VendingMachine(2);
        lukaku.addCans(10);
        lukaku.takeCan();
        lukaku.takeCan();
        Assert.assertEquals(10, lukaku.getNumberOfCans(), 0);
        Assert.assertEquals(2, lukaku.getNumberOfTokens(), 0);
    }
    @Test
    public void takeTokensTest()
    {
        VendingMachine lukaku = new VendingMachine(2);
        lukaku.takeCan();
        lukaku.takeTokens();
        Assert.assertEquals(0, lukaku.getNumberOfTokens(), 0);
    }
}