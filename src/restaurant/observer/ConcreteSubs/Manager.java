package restaurant.observer.ConcreteSubs;
import restaurant.model.Config;
import restaurant.observer.publisher.Kitchen;
import restaurant.observer.InterfaceObserv.Subscriber;

public class Manager implements Subscriber {
    @Override
    public void update(Kitchen kitchen) {
        System.out.println(String.format(Config.MESSAGE_MANAGER_UPDATE, kitchen.getOrderState()));
    }
}


