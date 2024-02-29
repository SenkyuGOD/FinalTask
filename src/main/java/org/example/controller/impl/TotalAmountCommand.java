package org.example.controller.impl;

import org.example.controller.Command;
import org.example.entity.Product;
import org.example.logic.LogicException;
import org.example.logic.LogicProvider;
import org.example.logic.ProductLogic;

import java.util.List;

public class TotalAmountCommand implements Command {
    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final ProductLogic logic = logicProvider.getProductLogic();


    @Override
    public String execute(String request) {
        String response = null;

        List<Product> products = null;
        try {
            products = logic.showAllProducts();

            response = "Стоимость товаров на складе: " + logic.totalAmount(products) + " руб.";
        } catch (LogicException e) {
            response = "Что-то пошло не так";
        }


        return response;
    }
}
