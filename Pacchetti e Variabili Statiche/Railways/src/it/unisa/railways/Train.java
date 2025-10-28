package it.unisa.railways;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private final List <TrainStop> fermate;
    private int posti;
    private double kmPercorsi;
    private final int idTreno;
    private static int numeroTreni;

    public Train(List<TrainStop> fermate, int posti, int kmPercorsi) {
        this.fermate = fermate;
        this.posti = posti;
        this.kmPercorsi = kmPercorsi;
        this.idTreno = numeroTreni++;
    }

    public int getTotalNumberOfStops(){
        return(fermate.size());
    }

    public int getPosti(){
        return this.posti;
    }

    public double getKmPercorsi() {
        return this.kmPercorsi;
    }

    public int getIdTreno(){
        return this.idTreno;
    }

    public void setKmPercorsi(double kmPercorsi) {
        this.kmPercorsi = kmPercorsi;
    }

    public void setPosti(int posti) {
        this.posti = posti;
    }

    public TrainStop getFermata(int posizione){
        return fermate.get(posizione);
    }

    public void addFermata(TrainStop fermata, int posizione){
        this.fermate.add(posizione, fermata);
    }

    public double computeMaxRevenues(double ricavoPostoPerKm){
        return kmPercorsi * posti * ricavoPostoPerKm;
    }

    public boolean equals(Train treno) {
        return this.idTreno == treno.getIdTreno();
    }
}