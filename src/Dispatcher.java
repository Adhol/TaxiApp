import java.util.ArrayList;
import java.util.List;

/**
 * Класс Dispatcher принимает заявку от клиента(Passenger), ищет свободного водителя и создает заказ
 */

public class Dispatcher implements Observer{

    static List<Taxi> listOfTaxi = new ArrayList<>();
    List<Order> listOfOrders = new ArrayList<>();

    void createOrder(Passenger passenger) throws ExecutionException, InterruptedException {
        //TODO странно ожидать завершения ордера здесь, в цикле распределения
        //TODO назначение заказа не должно ожидать его выполнение и блокировать основной поток
        while (passenger.getStatus() == Order.Status.NEW) {
            for (Taxi taxi : listOfTaxi) {
                if (passenger.getTaxiClass() == taxi.getTaxiClass() && taxi.isFree()) {
                    Order order = new Order(passenger, taxi);
                    order.registerObserver(this);
                    order.executeOrder();
                    listOfOrders.add(order);
                }
            }
        }


    }

    //TODO почему не реализовано? связано с синхронным выполнением ордеров?
    @Override
    synchronized public void update(Order.Status status) {
    }
}
