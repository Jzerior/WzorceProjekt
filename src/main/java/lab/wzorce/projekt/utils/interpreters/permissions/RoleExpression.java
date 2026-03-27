package lab.wzorce.projekt.utils.interpreters.permissions;

import lab.wzorce.projekt.models.User;

// Tydzień 5, Wzorzec Interpreter 2
public class RoleExpression implements PermissionExpression {
    private final String requiredRole;

    public RoleExpression(String requiredRole) {
        this.requiredRole = requiredRole;
    }

    @Override
    public boolean interpret(User context) {
        return context.getPrivilege().equalsIgnoreCase(requiredRole);
    }
}