import java.util.HashMap;
import java.util.Map;

public class Manager{
    private ReportStrategy reportStrategy;
    Map<Order, Taxi> mapOfOrders;

    public Manager(ReportStrategy reportStrategy) {
        this.reportStrategy = reportStrategy;
        this.mapOfOrders = new HashMap<>();
    }

    public void createReport(){
        reportStrategy.createReport(mapOfOrders);
    }
}
