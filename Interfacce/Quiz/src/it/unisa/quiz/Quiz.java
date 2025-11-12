package it.unisa.quiz;

public class Quiz implements Measurable {

    private double voto;

    public Quiz(double voto) {
        this.voto = voto;
    }

    public double getMeasure(){
        return voto;
    }

    public double getVoto(){
        return voto;
    }

    public void setVoto(double voto){
        this.voto = voto;
    }
}
