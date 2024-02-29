package org.example.logic;

import org.example.entity.Product;

import java.util.List;

public interface ProductLogic {
    void addProduct(Product product) throws LogicException;

    List<Product> findProduct(String product) throws LogicException;

    void deleteProduct(int id) throws LogicException;

    double totalAmount(List<Product> result) throws LogicException;

    void updateToMinus(Product product) throws LogicException;

    void updateToPlus(Product product) throws LogicException;

    List<Product> showAllProducts() throws LogicException;
}
