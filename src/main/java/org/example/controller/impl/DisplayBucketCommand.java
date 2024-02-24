package org.example.controller.impl;

import org.example.controller.Command;
import org.example.entity.Product;
import org.example.logic.LogicException;
import org.example.logic.LogicProvider;
import org.example.logic.ProductLogic;
import org.example.output.ProductOutput;

import java.util.List;

public class DisplayBucketCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final ProductLogic logic = logicProvider.getProductLogic();


    @Override
    public String execute(String request) {
        String response = null;

        List<Product> products = null;
        try {
            products = logic.showBasket();
        } catch (LogicException e) {
            throw new RuntimeException(e);
        }

        ProductOutput output = new ProductOutput();

        output.printBucket(products);

        response = "";

        if (products.isEmpty()) {
            response = "Корзина пуста";
        }

        return response;
    }
}
