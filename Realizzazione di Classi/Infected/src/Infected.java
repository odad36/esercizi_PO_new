public class Infected {

    private final String disease;
    private double numberOfInfected;

    public Infected(String disease) {
        this.disease = disease;
        this.numberOfInfected = 0;
    }

    public Infected(String disease, int numberOfInfected)
    {
    this.disease = disease;
    this.numberOfInfected = numberOfInfected;
    }

    public double getNumberOfInfected() {
        return this.numberOfInfected;
    }

    public String getDisease() {
        return this.disease;
    }

    public void addInfected(int numberOfInfected) {
        this.numberOfInfected += numberOfInfected;
    }

    public void updateInfectedByRt(double Rt) {
        this.numberOfInfected = this.numberOfInfected * Rt;
    }
}