package it.unisa.school;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void toStringTest() {
        Student s = new Student("Roberto", "Bianchi", 2005, 3);
        s.decreaseAbsences();
        Assert.assertEquals("Nome='Roberto', Cognome='Bianchi', Anno di nascita=2005, Numero di assenze=2",
                s.toString());
    }
}