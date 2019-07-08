import java.util.List;

public class TaxiDriverReport implements ReportStrategy {
    @Override
    public void createReport(List<Order> listOfOrders) {

        for(TaxiDriver taxiDriver : Dispatcher.listOfTaxiDrivers) {
            double sum = 0;
            int numberOfOrders = 0;
            for(Order order : listOfOrders) {
                if(taxiDriver.equals(order.getTaxiDriver())) {
                    sum+=order.getCost();
                    numberOfOrders++;
                }
            }

            System.out.println(taxiDriver + "\nNumber of orders: " + numberOfOrders + "\nTotal cost: " + sum);
            System.out.println();
        }
    }
}
