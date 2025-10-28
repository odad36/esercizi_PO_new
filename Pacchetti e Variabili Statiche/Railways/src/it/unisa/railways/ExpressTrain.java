package it.unisa.railways;

import java.util.ArrayList;
import java.util.List;

public class ExpressTrain {
    private final List<TrainStop> fermate;
    private int posti;
    private double kmPercorsi;
    private final int idTreno;
    private static int numeroTreni;
    private int postiRistorante;

    public ExpressTrain(List<TrainStop> fermate, int posti, int postiRistorante, int kmPercorsi) {
        this.fermate = fermate;
        this.posti = posti;
        this.postiRistorante = postiRistorante;
        this.kmPercorsi = kmPercorsi;
        this.idTreno = numeroTreni++;
    }

    public int getTotalNumberOfStops(){
        return(fermate.size());
    }

    public double computeMaxRevenues(double ricavoPostoPerKm, double ricavoPostoRistorantePerKm) {
        double restaurantRevenue = kmPercorsi * postiRistorante * ricavoPostoRistorantePerKm;
        double passengerRevenue = kmPercorsi * posti * ricavoPostoPerKm;
        return restaurantRevenue + passengerRevenue;
    }
}
