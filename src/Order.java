public class Order {
    private int number = Manager.numberOfOrder;
    private int length;
    private TaxiClass taxiClass;
    private double cost;
    private TaxiDriver taxiDriver;
    private Status status;

    public Order(Passenger passenger, TaxiDriver taxiDriver) {
        this.length = passenger.getLength();
        this.taxiClass = passenger.getTaxiClass();
        switch (taxiClass) {
            case ECONOMY:
                this.cost = length;
                break;
            case COMFORT:
                this.cost = length * 2;
                break;
            case BUSINESS:
                this.cost = length * 3;
                break;
        }
        this.taxiDriver = taxiDriver;
        this.status = Status.NEW;
        Manager.numberOfOrder++;
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

