import org.junit.Assert;
import org.junit.Test;

public class PurseTest {

    @Test
    public void findTest() {
        Purse lukaku = new Purse();
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DIME);
        Assert.assertTrue(lukaku.find(Purse.DOLLAR));
        Assert.assertTrue(lukaku.find(Purse.DIME));
        Assert.assertFalse(lukaku.find(Purse.CENT));
    }

    @Test
    public void countTest() {
        Purse lukaku = new Purse();
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DIME);
        Assert.assertEquals(2, lukaku.count(Purse.DOLLAR), 0);
    }

    @Test
    public void minMaxTest() {
        Purse lukaku = new Purse();
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DIME);
        Assert.assertEquals(Purse.DIME, lukaku.getMinimum());
        Assert.assertEquals(Purse.DOLLAR, lukaku.getMaximum());
    }

    @Test
    public void getTotalTest() {
        Purse lukaku = new Purse();
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DOLLAR);
        Assert.assertEquals(3, lukaku.getTotal(), 0);
    }

    @Test
    public void addRemoveTest() {
        Purse lukaku = new Purse();
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DIME);

        Purse raspadori = new Purse();
        raspadori.add(Purse.DIME);

        lukaku.remove(Purse.DOLLAR);
        lukaku.remove(Purse.DOLLAR);
        Assert.assertEquals(lukaku, raspadori);
    }

    @Test
    public void hasCoinTest() {
        Purse lukaku = new Purse();
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DIME);
        Assert.assertTrue(lukaku.hasCoin(Purse.DOLLAR));
        Assert.assertTrue(lukaku.hasCoin(Purse.DIME));
        Assert.assertFalse(lukaku.hasCoin(Purse.CENT));
    }

    @Test
    public void toStringTest() {
        Purse lukaku = new Purse();
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DIME);
        Assert.assertEquals("Dollar = 2$\n"+
                "Quarter = 0q\n" +
                "Dime = 1d\n"+
                "Nickel = 0n\n"+
                "Cent = 0c\n", lukaku.toString());
    }

    @Test
    public void equalsTest() {
        Purse lukaku = new Purse();
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DOLLAR);
        lukaku.add(Purse.DIME);
        Purse raspadori = new Purse();
        raspadori.add(Purse.DIME);
        Assert.assertNotEquals(lukaku, raspadori);
        raspadori.add(Purse.DOLLAR);
        raspadori.add(Purse.DOLLAR);
        Assert.assertEquals(lukaku, raspadori);
    }
}