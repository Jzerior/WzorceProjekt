package lab.wzorce.projekt.utils.interpreters.permissions;

import lab.wzorce.projekt.models.User;

// Tydzień 5, Wzorzec Interpreter 2
public interface PermissionExpression {
    boolean interpret(User context);
}