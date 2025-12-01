package it.unisa.financialhistory;

import java.util.ArrayList;
import java.util.List;

public class FinancialHistory {
    final private Person person;
    private double balance;
    final private List<Movement> movements;

    public FinancialHistory(Person person, double balance) {
        if(balance < 0)
            throw new IllegalArgumentException("bilancio in rosso\n");
        this.person = person;
        this.balance = balance;
        movements = new ArrayList<>();
    }

    public void receiveFrom(int amount, String source) {
        Movement lukaku = new Movement(source, amount);
        movements.add(lukaku);
        balance += amount;
    }

    public void spendFor(int amount, String reason) {
        if (amount > 0) {
            throw new IllegalArgumentException("Il movimento deve essere negativo");
        }
        //Bisogna invertire il segno perché le somme delle spese sono sempre negativi
        if (amount * -1 > balance)
            throw new IllegalArgumentException("Non hai abbastanza denaro");
        this.movements.add(new Movement(reason, amount));
        this.balance += amount;
    }

    public double cashOnHand() {
        return balance;
    }

    public double totalReceivedFrom(String source) {
        double total = 0;
        for(Movement m : movements){
            if(m.getDescription().equals(source)) {
                if (m.getAmount() > 0)
                    total += m.getAmount();
            }
        }
        return total;
    }

    public double totalSpentFor(String reason) {
        double total = 0;
        for(Movement m : movements){
            if(m.getDescription().equals(reason)) {
                if (m.getAmount() < 0)
                    total += m.getAmount();
            }
        }
        return total;
    }

    public void printMovements() {
        System.out.println(movements);
    }

}
