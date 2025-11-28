package it.unisa.school;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Hashtable;

public class Student extends Person {

    private String matricola;
    private int numberOfAbsences;
    Hashtable<String, Integer> map;

    public Student(String name, String surname, int birthYear, String userId, String password, String matricola, int numberOfAbsences) {
        super(name, surname, birthYear, userId, password);
        if(matricola == null || matricola.isEmpty())
            throw new IllegalArgumentException("Matricola dello studente con formato errato");
        this.matricola = matricola;
        this.numberOfAbsences = numberOfAbsences;
        map = new Hashtable<>();
    }

    public String getMatricola(){
        return matricola;
    }

    public void addAbsence() {
        this.numberOfAbsences++;
    }

    public void removeAbsence() {
        this.numberOfAbsences--;
    }

    public int getNumberOfAbsences() {
        return numberOfAbsences;
    }

    public void addExam(String examName, int grade) {
        if(grade < 18 || grade >31)
            throw new IllegalArgumentException("voto non valido");
        map.put(examName, grade);
    }

    public int getNumberOfPassedExams() {
        return map.size();
    }

    public Hashtable<String, Integer> getMap(){
        return map;
    }

    public double getAverageGrade() {
        double total = 0;
        for(Integer value: map.values()){
            if (value == 31)
                value--;
            total += value;
        }
       if (total == 0)
           return 0;
       return total / map.size();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Numero di assenze=" + numberOfAbsences;
    }
}
