package org.example.logic;

import org.example.dao.impl.FileProduct;
import org.example.logic.impl.ProductLogicImpl;

public class LogicProvider {
    private final static LogicProvider instance = new LogicProvider();

    private ProductLogicImpl logic = new ProductLogicImpl();


    public ProductLogicImpl getProductLogic() {
        return logic;
    }

    public static LogicProvider getInstance() {
        return instance;
    }
}
