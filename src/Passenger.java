public class Passenger implements Observer {
    private final int length;
    private final Taxi.TaxiClass taxiClass;
    private Order.Status status;

    Passenger() {
        this.length = 200 + (int) (Math.random() * 2000);
        this.taxiClass = Taxi.TaxiClass.getRandomTaxiClass();
        this.status = Order.Status.NEW;
    }

    int getLength() {
        return length;
    }

    Taxi.TaxiClass getTaxiClass() {
        return taxiClass;
    }

    synchronized Order.Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "length: " + length +
                ", taxiClass: " + taxiClass +
                ", status: " + status +
                '}';
    }

    @Override
    synchronized public void update(Order.Status status) {
        this.status = status;
    }
}
