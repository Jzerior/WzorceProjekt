package lab.wzorce.projekt.utils.commands.order;

import lab.wzorce.projekt.utils.commands.Command;

// Tydzień 5, Wzorzec Command 2
public class ShipOrderCommand implements Command {
    private final OrderReceiver receiver;
    private String previousStatus;

    public ShipOrderCommand(OrderReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.previousStatus = receiver.getStatus();
        receiver.ship();
    }

    @Override
    public void undo() {
        receiver.setStatus(previousStatus);
        System.out.println("Cofnięto wysyłkę. Status przywrócony do: " + previousStatus);
    }
}