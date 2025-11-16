package restaurant.observer.publisher;
import restaurant.model.Config;
import restaurant.observer.InterfaceObserv.Subscriber;
import java.util.ArrayList;
import java.util.List;

public class Kitchen {

    private List<Subscriber> subscribers = new ArrayList<>();
    private String orderState;

    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    public void notifySubscribers() {
        for (Subscriber s : subscribers) {
            s.update(this);
        }
    }

    public void updateOrderState(String newState) {
        System.out.println("\n" + String.format(Config.MESSAGE_KITCHEN_UPDATE, newState));
        this.orderState = newState;
        notifySubscribers();
    }

    public String getOrderState() {
        return orderState;
    }
}

