package org.example.controller.impl;

import org.example.controller.Command;
import org.example.logic.LogicException;
import org.example.logic.LogicProvider;
import org.example.logic.ProductLogic;

public class DeleteProductFromDBCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final ProductLogic logic = logicProvider.getProductLogic();

    @Override
    public String execute(String request) {
        String response = null;
        String[] params;

        params = request.split("\n");
        int ID = Integer.parseInt(params[1].split("=")[1]) - 1;

        try {
            logic.deleteProduct(ID);
            response = "Продукт удалён из базы данных";
        } catch (LogicException e) {
            response = "Что-то пошло не так";
        }

        return response;
    }
}
