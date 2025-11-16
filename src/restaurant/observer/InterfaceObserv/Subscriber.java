package restaurant.observer.InterfaceObserv;

import restaurant.observer.publisher.Kitchen;

public interface Subscriber {
    void update(Kitchen context);
}
