package lab.wzorce.projekt.utils.interpreters.permissions;

import lab.wzorce.projekt.models.User;

// Tydzień 5, Wzorzec Interpreter 2
public class OrPermissionExpression implements PermissionExpression {
    private final PermissionExpression expr1;
    private final PermissionExpression expr2;

    public OrPermissionExpression(PermissionExpression expr1, PermissionExpression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(User context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}