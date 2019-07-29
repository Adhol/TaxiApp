import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingDouble;
import java.util.Map;

/**
 * Вывод отчета, сгруппированного по по классу обслуживания.
 */
public class TaxiClassReport implements ReportStrategy {
    @Override
    public void createReport(Map<Order, Taxi> mapOfOrders) {

        mapOfOrders.entrySet().stream()
                .collect(groupingBy(e -> e.getValue().getTaxiClass(), summarizingDouble(e -> e.getKey().getCost())))
                .forEach((key, value) -> System.out.println(key + " : " + value.getSum()));
    }
}