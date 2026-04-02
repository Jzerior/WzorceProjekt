package lab.wzorce.projekt.utils.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
    private final List<Command> history = new ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        history.add(command);
    }

    public void undoLastCommand() {
        if (!history.isEmpty()) {
            Command lastCommand = history.remove(history.size() - 1);
            lastCommand.undo();
        }
    }

    public int getHistorySize() {
        return history.size();
    }
}