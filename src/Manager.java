import java.util.ArrayList;
import java.util.List;

public class Manager {
    private ReportStrategy reportStrategy;
    public static int numberOfOrder = 1;
    public static List<Order> listOfOrders = new ArrayList<>();

    public void createReport(){
        reportStrategy.createReport(listOfOrders);
    }

    public void setReportStrategy(ReportStrategy reportStrategy) {
        this.reportStrategy = reportStrategy;
    }
}
