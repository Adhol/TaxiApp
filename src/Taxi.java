public class Taxi {
    private String driverName;
    private TaxiClass taxiClass;
    private boolean isFree;

    Taxi(String driverName, TaxiClass taxiClass) {
        this.driverName = driverName;
        this.taxiClass = taxiClass;
        this.isFree = true;
    }

    synchronized void setFree(boolean free) {
        isFree = free;
    }

    boolean isFree() {
        return isFree;
    }

    String getDriverName() {

        return driverName;

    }

    TaxiClass getTaxiClass() {

        return taxiClass;

    }

    @Override
    public String toString() {
        return "Driver: " + driverName +  ", Class: " + taxiClass + " " + isFree;
    }

    public enum TaxiClass{

        ECONOMY(1.0),
        COMFORT(2.0),
        BUSINESS(3.0);

        double cost;

        TaxiClass(Double cost) {
            this.cost = cost;

        }

        public double calculateCost(int length) {

            return this.cost * length;

        }

        public static TaxiClass getRandomTaxiClass() {

            return values()[(int) (Math.random() * values().length)];

        }

    }
}
