public class Car extends Vehicle{

    private static final double SUMMER_FUEL_CONSUMPTION_PER_KM = 0.9;

    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm);
    }


    @Override
    public String drive(double distance) {
        double fuel = distance * (this.getLitersPerKm() + SUMMER_FUEL_CONSUMPTION_PER_KM);

        if (this.getFuelQuantity() < fuel) {
            throw new IllegalArgumentException(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }

        this.setFuelQuantity(this.getFuelQuantity() - fuel);
        return String.format("%s travelled %.1f km", this.getClass().getSimpleName(), distance);
    }

    @Override
    public void refuel(double liters) {
        if (liters > 0) {
            this.setFuelQuantity(this.getFuelQuantity() + liters);
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.getFuelQuantity());
    }
}
