package org.example.controller.impl;

import org.example.controller.Command;
import org.example.entity.Product;
import org.example.logic.LogicException;
import org.example.logic.LogicProvider;
import org.example.logic.ProductLogic;

public class DeleteProductFromBucketCommand implements Command {
    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final ProductLogic logic = logicProvider.getProductLogic();


    @Override
    public String execute(String request) {
        String response = null;
        String[] params;
        Product newProduct;


        params = request.split("\n");
        newProduct = new Product();
        newProduct.setName(params[1].split("=")[1]);
        String name = params[1].split("=")[1];
        newProduct.setCountInBase(Integer.parseInt(params[2].split("=")[1]));


        try {
                logic.deleteProductFromBasket(newProduct);

                logic.updateToPlus(newProduct);
                response = "Продукт удален из корзины";
        } catch (LogicException e) {
            response = "Что-то пошло не так";
        }

        return response;
    }
}
