package restaurant.observer.ConcreteSubs;
import  restaurant.model.Config;
import restaurant.observer.publisher.Kitchen;
import restaurant.observer.InterfaceObserv.Subscriber;

public class Waiter implements Subscriber {
    private String name;

    public Waiter(String name) {
        this.name = name;
    }

    @Override
    public void update(Kitchen kitchen) {
        System.out.println(String.format(Config.MESSAGE_WAITER_UPDATE, name, kitchen.getOrderState()));
    }
}

