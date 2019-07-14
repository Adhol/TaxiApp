import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Dispatcher.listOfTaxi.add(new Taxi("Alex", Taxi.TaxiClass.ECONOMY));
        Dispatcher.listOfTaxi.add(new Taxi("Jim", Taxi.TaxiClass.ECONOMY));
        Dispatcher.listOfTaxi.add(new Taxi("John", Taxi.TaxiClass.COMFORT));
        Dispatcher.listOfTaxi.add(new Taxi("Jane", Taxi.TaxiClass.COMFORT));
        Dispatcher.listOfTaxi.add(new Taxi("Ben", Taxi.TaxiClass.BUSINESS));
        Dispatcher.listOfTaxi.add(new Taxi("Karl", Taxi.TaxiClass.BUSINESS));

        Manager manager = new Manager(new TaxiClassReport());
        Dispatcher dispatcher = new Dispatcher();

        for (int i = 0; i < 10; i++) {
            Passenger p = new Passenger();
            dispatcher.createOrder(p);
        }

        for (Order order : dispatcher.listOfOrders) {
            manager.mapOfOrders.put(order, order.getTaxi());
        }

        //System.out.println("-------------REPORT----------------");

        //manager.createReport();
    }
}
