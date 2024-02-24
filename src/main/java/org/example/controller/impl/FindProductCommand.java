package org.example.controller.impl;

import org.example.controller.Command;
import org.example.entity.Product;
import org.example.logic.LogicException;
import org.example.logic.LogicProvider;
import org.example.logic.ProductLogic;

import java.util.List;

public class FindProductCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final ProductLogic logic = logicProvider.getProductLogic();

    @Override
    public String execute(String request) {
        List<Product> products = null;
        String response = null;
        String[] params;

        // validate request
        params = request.split("\n");
        String str = params[1];

        try {
            boolean result = logic.findProduct(str);

            if (result) {
                response = "Продукт найден";
            } else {
                response = "Продукт не найден";
            }

        } catch (LogicException e) {
            response = "Что-то не так";
        }
        return response;
    }
}
