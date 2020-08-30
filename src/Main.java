import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Dispatcher.listOfTaxi.add(new Taxi("Alex", Taxi.TaxiClass.ECONOMY));
        Dispatcher.listOfTaxi.add(new Taxi("Jim", Taxi.TaxiClass.ECONOMY));
        Dispatcher.listOfTaxi.add(new Taxi("John", Taxi.TaxiClass.COMFORT));
        Dispatcher.listOfTaxi.add(new Taxi("Jane", Taxi.TaxiClass.COMFORT));
        Dispatcher.listOfTaxi.add(new Taxi("Ben", Taxi.TaxiClass.BUSINESS));
        Dispatcher.listOfTaxi.add(new Taxi("Karl", Taxi.TaxiClass.BUSINESS));

        Manager manager = new Manager(new TaxiClassReport());
        Dispatcher dispatcher = new Dispatcher();
        List<Passenger> listOfPassengers = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            Passenger p = new Passenger();
            dispatcher.createOrder(p);
            listOfPassengers.add(p);
        }

        //Ожидание выполнения всех заказов перед формированием отчета

        for (int i = 0; i < listOfPassengers.size(); i++) {
            if (listOfPassengers.get(i).getStatus() == Order.Status.DONE) {
                listOfPassengers.remove(i);
                i--;
            } else {
               i--;
            }
        }

        for (Order order : dispatcher.listOfOrders) {
            manager.mapOfOrders.put(order, order.getTaxi());
        }

        System.out.println("-------------REPORT----------------");

        manager.createReport();
    }
}
