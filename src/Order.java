import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Order implements Observable {
    private List<Observer> listOfObservers;
    private final Passenger passenger;
    private final Taxi taxi;
    private Status status;

    Order(Passenger passenger, Taxi taxi) {
        this.listOfObservers = new ArrayList<>();
        this.passenger = passenger;
        this.taxi = taxi;
        this.status = Status.ACCEPTED;
        registerObserver(passenger);
    }

    void executeOrder() {

        taxi.setFree(false);
        notifyObservers();

        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            double time = getTimeToDone();
            System.out.printf("Order %d accepted by %s" +
                    "\nTime to done: %s" +
                    "\nCost is %s" +
                    "\nExecute order %d ...%n", hashCode(), taxi.getDriverName(), time, getCost(), hashCode());
            try {
                TimeUnit.SECONDS.sleep((long)(time * 0.5));
                this.status = Status.DONE;
                taxi.setFree(true);
                notifyObservers();
                System.out.printf("Order %d is %s%n", hashCode(), status);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
    }

    private double getTimeToDone() {

        return passenger.getLength() / 100 ;
    }

    double getCost() {

        return taxi.getTaxiClass().calculateCost(passenger.getLength());

    }

    @Override
    public String toString() {
        return  "routeLength - " + passenger.getLength() +
                "\ntaxiClass - " + taxi.getTaxiClass() +
                "\ntaxiDriver - " + taxi.getDriverName() +
                "\nstatus - " + status;
    }

    Taxi getTaxi() {
        return taxi;
    }

    @Override
    public void registerObserver(Observer observer) {
        listOfObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        listOfObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : listOfObservers) {
            observer.update(status);
        }
    }

    public enum Status {
        NEW,
        ACCEPTED,
        DONE
    }
}

