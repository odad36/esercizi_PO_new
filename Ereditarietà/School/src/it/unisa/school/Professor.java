package it.unisa.school;

public class Professor extends Person {

    private final String topic;

    private final double wage;

    public Professor (String name, String surname, int birthYear, String topic, double wage){
        super(name, surname, birthYear);
        this.topic = topic;
        this.wage = wage;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Argomento='" + topic + '\'' +
                ", Stipendio=" + wage;
    }
}
