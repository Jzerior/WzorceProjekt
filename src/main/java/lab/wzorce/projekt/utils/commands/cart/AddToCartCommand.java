package lab.wzorce.projekt.utils.commands.cart;

import lab.wzorce.projekt.utils.commands.Command;

// Tydzień 5, Wzorzec Command 3
public class AddToCartCommand implements Command {
    private final CartReceiver receiver;
    private final String item;

    public AddToCartCommand(CartReceiver receiver, String item) {
        this.receiver = receiver;
        this.item = item;
    }

    @Override
    public void execute() {
        receiver.addItem(item);
    }

    @Override
    public void undo() {
        receiver.removeItem(item);
    }
}