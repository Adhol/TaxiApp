public class Order {
    private int number = Manager.numberOfOrder;
    private int length;
    private TaxiClass taxiClass;
    private double cost;
    private TaxiDriver taxiDriver;
    private Status status;
    private double timeToDone;



    public Order(Passenger passenger, TaxiDriver taxiDriver) {
        this.length = passenger.getLength();
        this.taxiClass = passenger.getTaxiClass();
        this.taxiDriver = taxiDriver;
        this.status = Status.NEW;
        this.cost = calculateCost(taxiClass);
        this.timeToDone = length / (taxiDriver.getTaxiCar().getSpeed());
        taxiDriver.setFree(false);
        Manager.numberOfOrder++;
    }

    private double calculateCost(TaxiClass taxiClass) {
        cost = 0;
        if(taxiClass == TaxiClass.ECONOMY) {
            cost = length;
        } else if(taxiClass == TaxiClass.COMFORT) {
            cost = length * 2;
        } else {
            cost = length * 3;
        }
        return cost;
    }

    @Override
    public String toString() {
        return "Order number - " + number +
                "\nlength - " + length +
                "\ntaxiClass - " + taxiClass +
                "\ncost - " + cost +
                "\ntaxiDriver - " + taxiDriver +
                "\nstatus - " + status;
    }

    public double getTimeToDone() {
        return timeToDone;
    }

    public int getNumber() {
        return number;
    }

    public int getLength() {
        return length;
    }

    public TaxiClass getTaxiClass() {
        return taxiClass;
    }

    public double getCost() {
        return cost;
    }

    public TaxiDriver getTaxiDriver() {
        return taxiDriver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

