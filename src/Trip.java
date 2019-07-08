import java.util.ArrayList;

public class Trip implements Runnable {

    private Thread t;
    private Order order;

    Trip(Order order) {
        this.order = order;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        order.setStatus(Status.ACCEPTED);
        System.out.println("Order accepted by " + order.getTaxiDriver());
        System.out.println("Time to done: " + order.getTimeToDone());
        System.out.println("Execute order...");
        try {
            Thread.sleep((long)(order.getTimeToDone() * 200));
            order.setStatus(Status.DONE);
            System.out.println("Order is " + order.getStatus());
            order.getTaxiDriver().setFree(true);
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted");
        }

    }
}
