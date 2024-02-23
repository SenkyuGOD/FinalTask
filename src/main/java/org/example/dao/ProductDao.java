package org.example.dao;

import org.example.entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductDao {
    void addProduct(Product product) throws DaoException;

    /*void saveProducts() throws DaoException, IOException;*/

    boolean updateProductToPlus(Product updatedProduct) throws DaoException;

    boolean updateProductToMinus(Product updatedProduct) throws DaoException;

    void deleteProduct(int id) throws DaoException;

    List<Product> getAllProducts() throws DaoException;

    void addToBasket(Product product) throws DaoException;

    void deleteProductFromBasket(Product product) throws DaoException;

    void deleteProductFromBasket(String product) throws DaoException;

    List<Product> getBasket() throws DaoException;

}
