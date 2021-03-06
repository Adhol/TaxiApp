import java.util.ArrayList;
import java.util.List;

/**
 * Класс Dispatcher принимает заявку от клиента(Passenger), ищет свободного водителя и создает заказ
 */

public class Dispatcher implements Observer{

    //TODO а почему этот лист статический?
    //Сделал статическим, чтобы использовать этот список без создания объекта диспетчера,
    //например этот список используется в TaxiDriverReport, ну и плюс если добавятся еще диспетчеры,
    //то список авто будет у них общий.
    static List<Taxi> listOfTaxi = new ArrayList<>();
    List<Order> listOfOrders = new ArrayList<>();

    void createOrder(Passenger passenger) {
        while (passenger.getStatus() == Order.Status.NEW) {
            for (Taxi taxi : listOfTaxi) {
                if (passenger.getTaxiClass() == taxi.getTaxiClass() && taxi.isFree()) {
                    Order order = new Order(passenger, taxi);
                    order.registerObserver(this);
                    order.executeOrder();
                    listOfOrders.add(order);
                    break;
                }
            }
        }


    }

    //TODO почему не реализовано? связано с синхронным выполнением ордеров? !!!
    @Override
    synchronized public void update(Order.Status status) {
    }
}
