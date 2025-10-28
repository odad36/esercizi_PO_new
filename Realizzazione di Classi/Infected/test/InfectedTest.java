import org.junit.Assert;
import org.junit.Test;

public class InfectedTest {
    @Test
    public void addInfectedTest() {
        Infected lukaku = new Infected("re di Milano", 1);
        lukaku.addInfected(10);
        Assert.assertEquals(11, lukaku.getNumberOfInfected(), 0);
    }

    @Test
    public void updateInfectedByRt() {
        Infected lukaku = new Infected("re di Milano", 0);
        lukaku.addInfected(10);
        lukaku.updateInfectedByRt(12);
        Assert.assertEquals(120, lukaku.getNumberOfInfected(), 0);
    }
}