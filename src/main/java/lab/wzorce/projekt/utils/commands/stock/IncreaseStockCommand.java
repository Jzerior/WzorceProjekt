package lab.wzorce.projekt.utils.commands.stock;

import lab.wzorce.projekt.utils.commands.Command;

// Tydzień 5, Wzorzec Command 1
public class IncreaseStockCommand implements Command {
    private final StockReceiver receiver;
    private final int amount;

    public IncreaseStockCommand(StockReceiver receiver, int amount) {
        this.receiver = receiver;
        this.amount = amount;
    }

    @Override
    public void execute() {
        receiver.addStock(amount);
    }

    @Override
    public void undo() {
        receiver.removeStock(amount);
    }
}