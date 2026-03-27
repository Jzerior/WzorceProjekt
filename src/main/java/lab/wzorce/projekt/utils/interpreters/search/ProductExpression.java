package lab.wzorce.projekt.utils.interpreters.search;

import lab.wzorce.projekt.models.Product;

// Tydzień 5, Wzorzec Interpreter 1
public interface ProductExpression {
    boolean interpret(Product context);
}
// Koniec, Tydzień 5, Wzorzec Interpreter 1