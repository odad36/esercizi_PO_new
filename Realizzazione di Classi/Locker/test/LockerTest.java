import org.junit.Assert;
import org.junit.Test;

public class LockerTest {
    @Test
    public void lockAndUnlockTest(){
        Locker lukaku = new Locker();
        lukaku.newComb("123");
        Assert.assertFalse(lukaku.isOpen());
        lukaku.unlock("123");
        Assert.assertTrue(lukaku.isOpen());
        lukaku.lock();
        Assert.assertFalse(lukaku.isOpen());
        lukaku.unlock("124");
        Assert.assertFalse(lukaku.isOpen());
        lukaku.unlock("123");
        lukaku.newComb("124");
        lukaku.unlock("124");
        Assert.assertTrue(lukaku.isOpen());
    }
}