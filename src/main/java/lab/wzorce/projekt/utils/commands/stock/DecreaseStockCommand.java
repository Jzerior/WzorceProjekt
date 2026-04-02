package lab.wzorce.projekt.utils.commands.stock;

import lab.wzorce.projekt.utils.commands.Command;

// Tydzień 5, Wzorzec Command 1
public class DecreaseStockCommand implements Command {
    private final StockReceiver receiver;
    private final int amount;

    public DecreaseStockCommand(StockReceiver receiver, int amount) {
        this.receiver = receiver;
        this.amount = amount;
    }

    @Override
    public void execute() {
        receiver.removeStock(amount);
    }

    @Override
    public void undo() {
        receiver.addStock(amount);
    }
}