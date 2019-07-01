import java.util.ArrayList;
import java.util.List;

public class Dispatcher {


    public List<TaxiDriver> listOfTaxiDrivers = new ArrayList<>();

    public void takeRequestFromPassenger(Passenger passenger) {
        for (TaxiDriver taxiDriver : listOfTaxiDrivers) {
            if(passenger.getTaxiClass() == (taxiDriver.getTaxiCar().getTaxiClass()) & taxiDriver.isFree()) {
                System.out.println("create order");
                Order order = new Order(passenger, taxiDriver);
                System.out.println(order);
                taxiDriver.completeOrder(order);
                System.out.println("status - " + order.getStatus());
                System.out.println();
                Manager.listOfOrders.add(order);
                return;
            }
        }
    }



}
