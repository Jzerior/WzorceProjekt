package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.commands.Command;
import lab.wzorce.projekt.utils.commands.CommandInvoker;
import lab.wzorce.projekt.utils.commands.order.*;
import lab.wzorce.projekt.utils.commands.cart.*;
import lab.wzorce.projekt.utils.commands.stock.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/demo/command")
public class CommandDemoController {

    @GetMapping("/test")
    public Map<String, Object> testCommandPattern() {
        Map<String, Object> results = new LinkedHashMap<>();
        CommandInvoker invoker = new CommandInvoker();

        results.put("--- ZAMOWIENIA ---", "------------------------");
        OrderReceiver order = new OrderReceiver("ZAM-2026-102");
        results.put("01_Poczatkowy_Status", order.getStatus());

        Command payCmd = new PayOrderCommand(order);
        Command shipCmd = new ShipOrderCommand(order);
        Command cancelCmd = new CancelOrderCommand(order);

        invoker.executeCommand(payCmd);
        results.put("02_Po_Oplaceniu", order.getStatus());

        invoker.executeCommand(shipCmd);
        results.put("03_Po_Wysylce", order.getStatus());

        invoker.undoLastCommand();
        results.put("05_Po_Cofnieciu_Realizacji", order.getStatus());

        invoker.executeCommand(cancelCmd);
        results.put("07_Po_Anulowaniu", order.getStatus());


        results.put("--- KOSZYK ---", "------------------------");
        CartReceiver cart = new CartReceiver();
        Command addCartCmd1 = new AddToCartCommand(cart, "Wędka Karpiowa");
        Command addCartCmd2 = new AddToCartCommand(cart, "Kołowrotek");
        Command removeCartCmd = new RemoveFromCartCommand(cart, "Wędka Karpiowa");

        invoker.executeCommand(addCartCmd1);
        invoker.executeCommand(addCartCmd2);
        results.put("08_Koszyk_Po_Dodaniu", new ArrayList<>(cart.getItems()));

        invoker.executeCommand(removeCartCmd);
        results.put("09_Koszyk_Po_Usunieciu", new ArrayList<>(cart.getItems()));

        invoker.undoLastCommand();
        results.put("10_Koszyk_Po_Cofnieciu_Usuniecia", new ArrayList<>(cart.getItems()));


        results.put("--- MAGAZYN ---", "------------------------");
        StockReceiver stock = new StockReceiver("PROD-99", 50);
        results.put("11_Magazyn_Poczatkowy", stock.getQuantity());

        Command incStockCmd = new IncreaseStockCommand(stock, 20);
        Command decStockCmd = new DecreaseStockCommand(stock, 5);

        invoker.executeCommand(incStockCmd);
        results.put("12_Magazyn_Po_Zwiekszeniu", stock.getQuantity());

        invoker.executeCommand(decStockCmd);
        results.put("13_Magazyn_Po_Zmniejszeniu", stock.getQuantity());

        invoker.undoLastCommand();
        results.put("14_Magazyn_Po_Cofnieciu_Zmniejszenia", stock.getQuantity());


        results.put("--- PODSUMOWANIE ---", "------------------------");
        results.put("15_Laczna_ilosc_komend_w_historii_Invokera", invoker.getHistorySize());

        return results;
    }
}