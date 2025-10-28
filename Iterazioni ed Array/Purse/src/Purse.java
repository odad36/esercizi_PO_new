import java.util.ArrayList;
import java.util.List;

public class Purse {

    final static Coin DOLLAR = new Coin("dollar", 1.00);
    final static Coin QUARTER = new Coin("quarter", 0.25);
    final static Coin DIME = new Coin("dime", 0.10);
    final static Coin NICKEL = new Coin("nickel", 0.05);
    final static Coin CENT = new Coin("cent", 0.01);

    private final List<Coin> coins;

    public Purse() {
        coins = new ArrayList<>();
    }

    public void add(Coin coin) {
        coins.add(coin);
    }

    public boolean find(Coin coin) {
        return coins.contains(coin);
    }

    public int count(Coin coin) {
        int counter = 0;
        for (Coin c : coins) {
            if (c.equals(coin))
                counter++;
        }
        return counter;
    }

    public Coin getMinimum() {
        if (coins.isEmpty()) return null;

        Coin min = coins.getFirst();
        for (Coin c : coins) {
            if (c.getValue() < min.getValue())
                min = c;
        }
        return min;
    }

    public Coin getMaximum() {
        if (coins.isEmpty()) return null;

        Coin max = coins.getFirst();
        for (Coin c : coins) {
            if (c.getValue() > max.getValue()) max = c;
        }
        return max;
    }

    public double getTotal() {
        double total = 0;
        for (Coin coin : coins) {
            total += coin.getValue();
        }
        return total;
    }

    public void remove(Coin coin) {
        coins.remove(coin);
    }

    public boolean hasCoin(Coin coin) {
        return coins.contains(coin);
    }

    @Override
    public String toString() {
        return ("Dollar = " +count(DOLLAR)+"$\n" +
                "Quarter = " +count(QUARTER)+"q\n" +
                "Dime = " +count(DIME)+"d\n" +
                "Nickel = " +count(NICKEL)+"n\n" +
                "Cent = " +count(CENT)+"c\n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Purse purse = (Purse) o;
        return purse.count(DOLLAR) == this.count(DOLLAR)
                && purse.count(QUARTER) == this.count(QUARTER)
                && purse.count(DIME) == this.count(DIME)
                && purse.count(NICKEL) == this.count(NICKEL)
                && purse.count(CENT) == this.count(CENT);
    }
}