import java.util.ArrayList;
import java.util.List;

/*
Необходимо разработать консольное приложение, имитирующее работу такси. Должно эмулироваться поведение клиента, диспетчера, водителей и менеджера.

Заказ должен содержать следующую информацию:
номер заказа (уникальное значение)
расстояние (целое число)
класс обслуживания (эконом, комфорт, бизнес)
стоимость (рассчитывается исходя из расстояния и класса обслуживания)
информация о водителе
состояние (новый, принят к выполнению, выполнен)

"Клиент" заказывает поездку:
количество заказов задается на старте
расстояние выбирается случайно
класс обслуживания выбирается случайно

"Диспетчер" принимает и обрабатывает заказ:
сообщает клиенту информацию о новом заказе
сообщает водителям/менеджеру информацию
о новом заказе
о начале выполнения заказа
о завершении заказа
принимает от водителя подтверждение заказа (если заказ уже принят другим водителем, то выдает ошибку)
принимает от водителя "завершение заказа"
*/


public class Main {
    public static void main(String[] args) {

        Dispatcher.listOfTaxi.add(new Taxi("Alex", Taxi.TaxiClass.ECONOMY));
        Dispatcher.listOfTaxi.add(new Taxi("Jim", Taxi.TaxiClass.ECONOMY));
        Dispatcher.listOfTaxi.add(new Taxi("John", Taxi.TaxiClass.COMFORT));
        Dispatcher.listOfTaxi.add(new Taxi("Jane", Taxi.TaxiClass.COMFORT));
        Dispatcher.listOfTaxi.add(new Taxi("Ben", Taxi.TaxiClass.BUSINESS));
        Dispatcher.listOfTaxi.add(new Taxi("Karl", Taxi.TaxiClass.BUSINESS));

        Manager manager = new Manager(new TaxiClassReport());
        Dispatcher dispatcher = new Dispatcher();
        List<Passenger> listOfPassengers = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            Passenger p = new Passenger();
            dispatcher.createOrder(p);
            listOfPassengers.add(p);
        }

        //Ожидание выполнения всех заказов перед формированием отчета

        for (int i = 0; i < listOfPassengers.size(); i++) {
            if (listOfPassengers.get(i).getStatus() == Order.Status.DONE) {
                listOfPassengers.remove(i);
                i--;
            } else {
               i--;
            }
        }

        for (Order order : dispatcher.listOfOrders) {
            manager.mapOfOrders.put(order, order.getTaxi());
        }

        System.out.println("-------------REPORT----------------");

        manager.createReport();
    }
}
