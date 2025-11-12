package it.unisa.quiz;

    public class Quiz implements Comparable<Quiz> {

    private final double score;

    public Quiz(double score) {
        this.score = score;
    }

    public double getMeasure(){
        return this.score;
        }

    @Override
    public int compareTo(Quiz other) {
        if (this.score > other.score)
            return 1;
        else if(this.score < other.score)
            return -1;
        return 0;
    }
}
