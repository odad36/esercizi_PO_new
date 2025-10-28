public class Car {
    private double gas;
    private final double consumptionRate;

    public Car(double gas, double consumptionRate){
        this.gas = gas;
        this.consumptionRate = consumptionRate;
    }

    public double getGas() {
        return gas;
    }

    public void addGas(double gas) {
        this.gas += gas;
    }

    public void drive(double km) {
        gas -= km*consumptionRate;
    }
}