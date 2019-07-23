import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final int timeToAllDone;

        Dispatcher.listOfTaxi.add(new Taxi("Alex", Taxi.TaxiClass.ECONOMY));
        Dispatcher.listOfTaxi.add(new Taxi("Jim", Taxi.TaxiClass.ECONOMY));
        Dispatcher.listOfTaxi.add(new Taxi("John", Taxi.TaxiClass.COMFORT));
        Dispatcher.listOfTaxi.add(new Taxi("Jane", Taxi.TaxiClass.COMFORT));
        Dispatcher.listOfTaxi.add(new Taxi("Ben", Taxi.TaxiClass.BUSINESS));
        Dispatcher.listOfTaxi.add(new Taxi("Karl", Taxi.TaxiClass.BUSINESS));

        Manager manager = new Manager(new TaxiClassReport());
        Dispatcher dispatcher = new Dispatcher();
        List<Passenger> listOfPassengers = new ArrayList<>();

        int maxTime = 0;


        for (int i = 0; i < 20; i++) {
            Passenger p = new Passenger();
            dispatcher.createOrder(p);
            listOfPassengers.add(p);
        }

        timeToAllDone = maxTime;

        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep((long)(timeToAllDone));
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
        cf.get();

        //for (Passenger p : listOfPassengers) {
        //    System.out.println(p);
        //}

        for (Order order : dispatcher.listOfOrders) {
            manager.mapOfOrders.put(order, order.getTaxi());
        }

        System.out.println("-------------REPORT----------------");

        manager.createReport();
    }
}
