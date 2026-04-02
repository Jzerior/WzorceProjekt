package lab.wzorce.projekt.utils.commands.order;

import lab.wzorce.projekt.utils.commands.Command;

// Tydzień 5, Wzorzec Command 2
public class PayOrderCommand implements Command {
    private final OrderReceiver receiver;
    private String previousStatus;

    public PayOrderCommand(OrderReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.previousStatus = receiver.getStatus();
        receiver.pay();
    }

    @Override
    public void undo() {
        receiver.setStatus(previousStatus);
        System.out.println("Cofnięto opłacenie. Status przywrócony do: " + previousStatus);
    }
}