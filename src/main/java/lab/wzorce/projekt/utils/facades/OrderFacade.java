package lab.wzorce.projekt.utils.facades;

import lab.wzorce.projekt.models.Order;
import lab.wzorce.projekt.utils.bridges.payments.PaymentProvider;
import lab.wzorce.projekt.utils.bridges.messages.MessageSender;
import lab.wzorce.projekt.utils.singletons.AuditLogger;

// Tydzień 4, Wzorzec Facade 1
//Wzorzec Facade pozwala na uproszczenie procesu składania zamówień, razem z procesem wysyłania powiadomień oraz zapisywaniem logów
public class OrderFacade {
    private final PaymentProvider paymentProvider;
    private final MessageSender messageSender;
    private final AuditLogger logger;

    public OrderFacade(PaymentProvider paymentProvider, MessageSender messageSender) {
        this.paymentProvider = paymentProvider;
        this.messageSender = messageSender;
        this.logger = AuditLogger.INSTANCE;
    }

    public void placeOrder(Order order, double amount) {
        logger.log("Rozpoczęto proces zamówienia dla ID: " + order.getId());

        paymentProvider.processPayment(amount);

        messageSender.sendMessage("Twoje zamówienie " + order.getId() + " zostało złożone.");

        logger.log("Zakończono proces zamówienia.");
    }
}
//Koniec Tydzień 4, Wzorzec Facade 1