package it.unisa.quiz;

public class DataSet {

    private double sum;
    private Measurable minimum;
    private Measurable maximum;
    private int count;

    public DataSet() {
        sum = 0;
        count = 0;
        minimum = null;
        maximum = null;
    }

    public double getAverage() {
        return (sum / count);
    }

    public Measurable getMaximum() {
        return maximum;
    }

    public Measurable getMinimum() {
        return minimum;
    }

    public void add(Measurable x) {
        double value = x.getMeasure();
        sum += value;
        count++;
        if((minimum == null) || (value < minimum.getMeasure()))
            minimum = x;
        if((maximum == null) || (value > maximum.getMeasure()))
            maximum = x;
    }
}