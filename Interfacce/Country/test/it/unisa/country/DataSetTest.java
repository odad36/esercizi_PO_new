package it.unisa.country;

import org.junit.Assert;
import org.junit.Test;

public class DataSetTest {
    @Test
    public void testMinimum() {
        Country c1 = new Country("lukaku", 0);
        Country c2 = new Country("raspadori", 7);
        Country c3 = new Country("nani", 7.5);
        DataSet dataset = new DataSet();
        dataset.add(c1);
        dataset.add(c2);
        dataset.add(c3);
        Assert.assertEquals("lukaku", dataset.getMinimum().getName());
    }

    @Test
    public void testMaximum() {
        Country c1 = new Country("lukaku", 1000000);
        Country c2 = new Country("raspadori", 7);
        Country c3 = new Country("nani", 7.5);
        DataSet dataset = new DataSet();
        dataset.add(c1);
        dataset.add(c2);
        dataset.add(c3);
        Assert.assertEquals("lukaku", dataset.getMaximum().getName());
    }
}
