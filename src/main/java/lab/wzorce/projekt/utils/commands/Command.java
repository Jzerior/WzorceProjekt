package lab.wzorce.projekt.utils.commands;

public interface Command {
    void execute();
    void undo();
}