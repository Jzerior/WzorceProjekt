package lab.wzorce.projekt.utils.commands.order;

// Tydzień 5, Wzorzec Command 2
import lab.wzorce.projekt.utils.commands.Command;

public class CancelOrderCommand implements Command {
    private final OrderReceiver receiver;
    private String previousStatus;

    public CancelOrderCommand(OrderReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.previousStatus = receiver.getStatus();
        receiver.cancel();
    }

    @Override
    public void undo() {
        receiver.setStatus(previousStatus);
        System.out.println("Cofnięto anulowanie. Status przywrócony do: " + previousStatus);
    }
}