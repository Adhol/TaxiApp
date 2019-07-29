import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingDouble;
import java.util.Map;

/**
 * Вывод отчета, сгруппированного по водителям.
 */
public class TaxiDriverReport implements ReportStrategy {
    @Override
    public void createReport(Map<Order, Taxi> mapOfOrders) {

        mapOfOrders.entrySet().stream()
                .collect(groupingBy(e -> e.getValue().getDriverName(), summarizingDouble(e -> e.getKey().getCost())))
                .forEach((key, value) -> System.out.println(key + " : " + value.getSum()));
    }
}
