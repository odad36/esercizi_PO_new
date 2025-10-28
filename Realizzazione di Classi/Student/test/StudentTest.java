import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class StudentTest {
    @Test
    public void registerExamTest(){
        Student lukaku = new Student ("Romelu", "Lukaku");
        Exam matematica = new Exam ("matematica", new GregorianCalendar(2025, Calendar.OCTOBER, 9), 30);
        lukaku.registerExam(matematica);
        Assert.assertTrue(lukaku.getExams().contains(matematica));
    }
    @Test
    public void computerAverageGradeTest() {
        Student lukaku = new Student ("Romelu", "Lukaku");
        Exam matematica = new Exam ("matematica", new GregorianCalendar(2025, Calendar.OCTOBER, 9), 30);
        Exam storia = new Exam ("matematica", new GregorianCalendar(2025, Calendar.OCTOBER, 9), 25);
        Exam scienze = new Exam ("matematica", new GregorianCalendar(2025, Calendar.OCTOBER, 9), 18);
        lukaku.registerExam(matematica);
        lukaku.registerExam(storia);
        lukaku.registerExam(scienze);
        Assert.assertEquals(24.3, lukaku.computeAverageGrade(), 0.1);
    }
}