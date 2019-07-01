public class Main {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        TaxiDriver td1 = new TaxiDriver("John", new TaxiDriver.TaxiCar("Lada", 30, TaxiClass.ECONOMY));
        TaxiDriver td2 = new TaxiDriver("Jim", new TaxiDriver.TaxiCar("Gaz", 35, TaxiClass.ECONOMY));
        TaxiDriver td3 = new TaxiDriver("Alex", new TaxiDriver.TaxiCar("Renault", 40, TaxiClass.COMFORT));
        TaxiDriver td4 = new TaxiDriver("Jane", new TaxiDriver.TaxiCar("Kia", 45, TaxiClass.COMFORT));
        TaxiDriver td5 = new TaxiDriver("Ben", new TaxiDriver.TaxiCar("Mercedes", 60, TaxiClass.BUSINESS));
        TaxiDriver td6 = new TaxiDriver("Karl", new TaxiDriver.TaxiCar("Audi", 60, TaxiClass.BUSINESS));
        dispatcher.listOfTaxiDrivers.add(td1);
        dispatcher.listOfTaxiDrivers.add(td2);
        dispatcher.listOfTaxiDrivers.add(td3);
        dispatcher.listOfTaxiDrivers.add(td4);
        dispatcher.listOfTaxiDrivers.add(td5);
        dispatcher.listOfTaxiDrivers.add(td6);

        for (int i = 0; i < 10; i++) {
            Passenger p = new Passenger();
            dispatcher.takeRequestFromPassenger(p);
        }
    }

}
