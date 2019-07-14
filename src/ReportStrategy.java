import java.util.Map;

public interface ReportStrategy {
    void createReport(Map<Order, Taxi> MapOfOrders);
}


