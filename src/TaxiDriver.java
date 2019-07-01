public class TaxiDriver {
    private String name;
    private TaxiCar taxiCar;
    private boolean isFree;

    public TaxiDriver(String name, TaxiCar taxiCar) {
        this.name = name;
        this.taxiCar = taxiCar;
        this.isFree = true;
    }

    public void completeOrder(Order order) {
        if(isFree) {
            isFree = false;
            order.setStatus(Status.ACCEPTED);
            int timeToDone = order.getLength() / taxiCar.getSpeed();
            System.out.println("Order starts, time to done " + timeToDone);
            System.out.println("status - " + order.getStatus());
            System.out.println("Order is done");
            order.setStatus(Status.DONE);
            isFree = true;
        } else {
            System.out.println("I'm busy");
        }
    }

    public boolean isFree() {
        return isFree;
    }

    public String getName() {
        return name;
    }

    public TaxiCar getTaxiCar() {
        return taxiCar;
    }

    @Override
    public String toString() {
        return name + ", Car: " + taxiCar.getName();
    }

    static class TaxiCar {
        private String name;
        private int speed;
        private TaxiClass taxiClass;

        public TaxiCar(String name, int speed, TaxiClass taxiClass) {
            this.name = name;
            this.speed = speed;
            this.taxiClass = taxiClass;
        }

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }

        public TaxiClass getTaxiClass() {
            return taxiClass;
        }
    }
}
