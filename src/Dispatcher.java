import java.util.ArrayList;
import java.util.List;

public class Dispatcher{

    static List<TaxiDriver> listOfTaxiDrivers = new ArrayList<>();

    public void createOrder(List<Passenger> listOfPassengers) {
        while(!listOfPassengers.isEmpty()) {
            for (TaxiDriver taxiDriver : listOfTaxiDrivers) {
                for (int i = 0; i < listOfPassengers.size(); i++) {
                    if (taxiDriver.isFree() & taxiDriver.getTaxiCar().getTaxiClass() == listOfPassengers.get(i).getTaxiClass()) {
                        Order order = new Order(listOfPassengers.get(i), taxiDriver);
                        Manager.listOfOrders.add(order);
                        Trip trip = new Trip(order);
                        listOfPassengers.remove(i);
                    }
                }
            }
        }
    }
}
