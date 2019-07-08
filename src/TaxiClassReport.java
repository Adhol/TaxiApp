import java.util.List;

public class TaxiClassReport implements ReportStrategy {
    @Override
    public void createReport(List<Order> listOfOrders) {
        for(TaxiClass taxiClass : TaxiClass.values()){
            double sum = 0;
            int numberOfOrders = 0;
            for(Order order : listOfOrders) {
                if(taxiClass == order.getTaxiClass()) {
                    sum+=order.getCost();
                    numberOfOrders++;
                }
            }
            System.out.println(taxiClass + "\nNumber of orders: " + numberOfOrders + "\nTotal cost: " + sum);
            System.out.println();
        }

    }
}
