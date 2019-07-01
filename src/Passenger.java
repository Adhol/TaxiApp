public class Passenger {
    private int length;
    private TaxiClass taxiClass;

    public Passenger() {
        this.length = 10 + (int) (Math.random() * 2000);
        this.taxiClass = TaxiClass.getRandom();
    }

    public int getLength() {
        return length;
    }

    public TaxiClass getTaxiClass() {
        return taxiClass;
    }


}
