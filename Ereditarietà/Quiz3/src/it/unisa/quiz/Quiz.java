package it.unisa.quiz;

public class Quiz implements Measurable {

    private final double score;

    public Quiz(double score) {
        this.score = score;
    }

    @Override
    public double getMeasure(){
        return score;
    }

    public int compareTo(Measurable other){
        return Double.compare(score, other.getMeasure());
    }
}
