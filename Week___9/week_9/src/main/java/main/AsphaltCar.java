package main;

public class AsphaltCar extends RallyCar {
    private double downforce;

    public AsphaltCar(String make, String model, int horsepower, double downforce) {
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    public double getDownforce() { return downforce; }

@Override
    public double calculatePerformance() {
        return (getHorsepower() * 0.8) + (getDownforce() * 0.3);
    }
}