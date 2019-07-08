import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Dispatcher.listOfTaxiDrivers.add(new TaxiDriver("John", new TaxiDriver.TaxiCar("Lada", 30, TaxiClass.ECONOMY)));
        Dispatcher.listOfTaxiDrivers.add(new TaxiDriver("Jim", new TaxiDriver.TaxiCar("Gaz", 35, TaxiClass.ECONOMY)));
        Dispatcher.listOfTaxiDrivers.add(new TaxiDriver("Alex", new TaxiDriver.TaxiCar("Renault", 40, TaxiClass.COMFORT)));
        Dispatcher.listOfTaxiDrivers.add(new TaxiDriver("Jane", new TaxiDriver.TaxiCar("Kia", 45, TaxiClass.COMFORT)));
        Dispatcher.listOfTaxiDrivers.add(new TaxiDriver("Ben", new TaxiDriver.TaxiCar("Mercedes", 60, TaxiClass.BUSINESS)));
        Dispatcher.listOfTaxiDrivers.add(new TaxiDriver("Karl", new TaxiDriver.TaxiCar("Audi", 60, TaxiClass.BUSINESS)));

        Manager manager = new Manager();
        manager.setReportStrategy(new TaxiClassReport());
        Dispatcher dispatcher = new Dispatcher();
        List<Passenger> listOfPassenger = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listOfPassenger.add(new Passenger());
        }

        dispatcher.createOrder(listOfPassenger);
        manager.createReport();

        manager.setReportStrategy(new TaxiDriverReport());
        manager.createReport();



    }
}
