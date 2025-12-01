package it.unisa.student;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class StudentTest {
    @Test
    public void newStudentTest() {
        Student student = new Student("Dario", "Di Nucci");
        Assert.assertEquals("Dario", student.getFirstName());
        Assert.assertEquals("Di Nucci", student.getLastName());
        Assert.assertTrue(student.getExams().isEmpty());
    }

    @Test
    public void oneExamTest() {
        Student student = new Student("Dario", "Di Nucci");

        Exam exam = new Exam("Object Oriented Programming", new GregorianCalendar(2023, Calendar.JANUARY, 10), 30);
        student.registerExam(exam);

        Assert.assertEquals(1, student.getExams().size(), 0);
        Assert.assertEquals(30, student.computeAverageGrade(), 0);
    }

    @Test
    public void twoExamTest() {
        Student student = new Student("Dario", "Di Nucci");

        Exam exam1 = new Exam("Object Oriented Programming", new GregorianCalendar(2023, Calendar.JANUARY, 10), 30);
        student.registerExam(exam1);

        Exam exam2 = new Exam("Software Engineering", new GregorianCalendar(2024, Calendar.JANUARY, 20), 28);
        student.registerExam(exam2);

        Assert.assertEquals(2, student.getExams().size(), 0);
        Assert.assertEquals(29, student.computeAverageGrade(), 0);
    }

    @Test
    public void studentsOrderTest() {
        List<Student> lista = new ArrayList<>();
        Student student1 = new Student("Dario", "lukaku");
        Student student2 = new Student("Dario", "ze roberto");
        Student student3 = new Student("Dario", "zoff");
        Student student4 = new Student("Dario", "zaccardo");
        Student student5 = new Student("Dario", "zanimacchia");
        lista.add(student1);
        lista.add(student2);
        lista.add(student3);
        lista.add(student4);
        lista.add(student5);
        Collections.sort(lista);
        Assert.assertEquals("lukaku", lista.getFirst().getLastName());
        Assert.assertEquals("zoff", lista.getLast().getLastName());
    }
}