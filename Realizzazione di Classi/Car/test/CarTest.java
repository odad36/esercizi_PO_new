import org.junit.Assert;
import org.junit.Test;

public class CarTest {
    @Test
    public void DriveTest(){
        Car lukaku = new Car(100, 15);
        lukaku.addGas(50);
        lukaku.drive(5);
        Assert.assertEquals(75, lukaku.getGas(), 0);
    }
}