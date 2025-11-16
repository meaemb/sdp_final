package restaurant.main;

import restaurant.model.*;
import restaurant.factory.Creator.Creator;
import restaurant.factory.ConcreteCreator.FrenchMealCreator;
import restaurant.factory.interfaceFac.MealFactory;

// DECORATOR
import restaurant.decorator.concrete.ConcreteComponent;
import restaurant.decorator.decorators.ExtraCheeseDecorator;
import restaurant.decorator.decorators.SauceDecorator;

// FACADE
import restaurant.facade.facade.Facade;
import restaurant.facade.additional.AdditionalFacade;

// BUILDER
import restaurant.builder.builder.ComplexOrderBuilder;
import restaurant.builder.builder.OrderBuilder;
import restaurant.builder.director.OrderDirector;
import restaurant.builder.products.ComplexOrder;

// OBSERVER
import restaurant.observer.publisher.Kitchen;
import restaurant.observer.ConcreteSubs.Waiter;
import restaurant.observer.ConcreteSubs.Manager;
import restaurant.observer.ConcreteSubs.DeliveryGuy;

// STRATEGY
import restaurant.strategy.context.PaymentContext;
import restaurant.strategy.context.PaymentProcessor;
import restaurant.strategy.strategy.PaymentStrategy;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nFACTORY ");
        Creator frenchFactory = new FrenchMealCreator();

        MealFactory croissant = frenchFactory.orderMeal("croissant");
        MealFactory ratatouille = frenchFactory.orderMeal("ratatouille");


        System.out.println("\nDECORATOR ");
        Meal tempMeal = new FrenchMeal(
                ratatouille.getName(),
                ratatouille.getPrice(),
                "Main Dish",
                "Decorated French meal"
        );

        ConcreteComponent base = new ConcreteComponent(tempMeal);
        ExtraCheeseDecorator cheeseAdded = new ExtraCheeseDecorator(base);
        SauceDecorator fullyDecorated = new SauceDecorator(cheeseAdded);

        System.out.println("Final meal with add-ons:");
        System.out.println(" → " + fullyDecorated.execute());


        System.out.println("\nFACADE ");
        Facade facade = new Facade();
        facade.subsystemOperation("Ratatouille", 3500, Config.DEFAULT_ADDRESS);

        AdditionalFacade extra = new AdditionalFacade();
        extra.anotherOperation();


        System.out.println("\nBUILDER ");
        OrderBuilder builder = new ComplexOrderBuilder();
        OrderDirector director = new OrderDirector(builder);

        ComplexOrder standardOrder = director.createStandardOrder("Aruzhan");
        System.out.println(standardOrder.summary());

        ComplexOrder dietOrder = director.createDietOrder("Dana");
        System.out.println(dietOrder.summary());


        System.out.println("\nOBSERVER ");
        Kitchen kitchen = new Kitchen();

        kitchen.subscribe(new Waiter("Zarina"));
        kitchen.subscribe(new DeliveryGuy("Bekzat"));
        kitchen.subscribe(new Manager());

        kitchen.updateOrderState("Order received");
        kitchen.updateOrderState("Cooking");
        kitchen.updateOrderState("Ready for delivery");


        System.out.println("\nSTRATEGY ");

        PaymentProcessor processor = new PaymentProcessor();
        PaymentContext payment = processor.createPaymentSession("ORD-777", 3500);

        PaymentStrategy wallet = processor.createOnlineWalletStrategy("Kaspi", "aruzhan@mail.com", "WLT12345");
        payment.setPaymentStrategy(wallet);

        payment.executePayment();


        System.out.println("\nALL PATTERNS EXECUTED SUCCESSFULLY\n");
    }
}
