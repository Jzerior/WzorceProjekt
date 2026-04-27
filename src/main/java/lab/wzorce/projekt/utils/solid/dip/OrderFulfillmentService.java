package lab.wzorce.projekt.utils.solid.dip;

import lab.wzorce.projekt.utils.solid.dip.inventory.InventoryManager;
import lab.wzorce.projekt.utils.solid.dip.notification.NotificationSender;
import lab.wzorce.projekt.utils.solid.dip.payment.PaymentProcessor;
import org.springframework.stereotype.Service;

// Tydzień 8, Zasada DIP
//Serwis wysoko-poziomowy zależny wyłącznie od abstrakcji,
//Zostało to osiągnięte za pomocą wstrzykiwania zależności
@Service
public class OrderFulfillmentService {
    private final PaymentProcessor paymentProcessor;
    private final NotificationSender notificationSender;
    private final InventoryManager inventoryManager;

    public OrderFulfillmentService(PaymentProcessor paymentProcessor,
                                   NotificationSender notificationSender,
                                   InventoryManager inventoryManager) {
        this.paymentProcessor = paymentProcessor;
        this.notificationSender = notificationSender;
        this.inventoryManager = inventoryManager;
    }

    public void fulfillOrder(String productId, double amount) {
        if (inventoryManager.checkStock(productId)) {
            if (paymentProcessor.processPayment(amount)) {
                notificationSender.sendNotification("Zamówienie na produkt " + productId + " zostało zrealizowane pomyślnie.");
            } else {
                notificationSender.sendNotification("Płatność za zamówienie " + productId + " została odrzucona.");
            }
        } else {
            notificationSender.sendNotification("Produkt " + productId + " jest obecnie niedostępny.");
        }
    }
}
// Koniec, Tydzień 8, Zasada DIP