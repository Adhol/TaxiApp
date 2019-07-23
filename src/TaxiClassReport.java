import java.util.Map;

/**
 * Вывод отчета, сгруппированного по по классу обслуживания.
 */
public class TaxiClassReport implements ReportStrategy {
    @Override
    public void createReport(Map<Order, Taxi> mapOfOrders) {
        final double[] EconomySum = {0};
        final double[] ComfortSum = {0};
        final double[] BusinessSum = {0};

        mapOfOrders.entrySet().stream().filter(x -> x.getKey().getTaxi().getTaxiClass() == Taxi.TaxiClass.ECONOMY)
                .forEach(x -> EconomySum[0] += x.getKey().getCost());

        mapOfOrders.entrySet().stream().filter(x -> x.getKey().getTaxi().getTaxiClass() == Taxi.TaxiClass.COMFORT)
                .forEach(x -> ComfortSum[0] += x.getKey().getCost());

        mapOfOrders.entrySet().stream().filter(x -> x.getKey().getTaxi().getTaxiClass() == Taxi.TaxiClass.BUSINESS)
                .forEach(x -> BusinessSum[0] += x.getKey().getCost());

        System.out.println("Economy class : " + EconomySum[0]);
        System.out.println("Comfort class : " + ComfortSum[0]);
        System.out.println("Business class : " + BusinessSum[0]);
    }
}