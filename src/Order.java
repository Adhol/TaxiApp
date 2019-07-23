import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Order implements Observable {
    private List<Observer> listOfObservers;
    private Passenger passenger;
    private Dispatcher dispatcher;
    private final int routeLength;
    private final Taxi taxi;
    private Status status;

    Order(Passenger passenger, Taxi taxi) {
        this.listOfObservers = new ArrayList<>();
        this.passenger = passenger;
        this.taxi = taxi;
        this.status = Status.ACCEPTED;
    }

    void executeOrder() throws ExecutionException, InterruptedException {
        registerObserver(passenger);
        taxi.setFree(false);
        notifyObservers();
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            registerObserver(passenger);
            registerObserver(dispatcher);
            taxi.setFree(false);
            notifyObservers();
            double time = getTimeToDone();
            System.out.println("Order accepted by " + taxi.getDriverName());
            System.out.println("Time to done: " + time);
            System.out.println("Cost is " + getCost());
            System.out.println("Execute order...");
            try {
                TimeUnit.SECONDS.sleep((long)(time * 0.1));
                this.status = Status.DONE;
                taxi.setFree(true);
                notifyObservers();
                System.out.println("Order is " + status);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });

        cf.get();
    }

    private double getTimeToDone() {

        return passenger.getLength() / 100 ;
    }

    private double getCost() {

        return taxi.getTaxiClass().calculateCost(routeLength);
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

