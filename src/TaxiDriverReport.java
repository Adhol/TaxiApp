import java.util.Map;

/**
 * Вывод отчета, сгруппированного по водителям.
 */
public class TaxiDriverReport implements ReportStrategy {
    @Override
    public void createReport(Map<Order, Taxi> mapOfOrders) {
        for (Taxi taxi : Dispatcher.listOfTaxi) {
            double[] sum = {0};
            mapOfOrders.entrySet().stream()
                    .filter(x -> x.getKey().getTaxi().getDriverName().equals(taxi.getDriverName()))
                    .forEach(x -> sum[0] += x.getKey().getCost());

            System.out.println(taxi.getDriverName() + ": " + sum[0]);
        }
    }
}
