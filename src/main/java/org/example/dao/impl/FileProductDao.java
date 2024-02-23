package org.example.dao.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dao.DaoException;
import org.example.dao.ProductDao;
import org.example.entity.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileProductDao implements ProductDao {

    @Override
    public void addProduct(Product product) throws DaoException {
        product.setId(FileProduct.sizeOfProduct() + 1);
        List<Product> products = FileProduct.getProducts();
        products.add(product);
        FileProduct.saveProducts();
    }



    @Override
    public boolean updateProductToPlus(Product updatedProduct) throws DaoException {
        List<Product> products = FileProduct.getProducts();

        for (Product product : products) {
            if (product.getName().equals(updatedProduct.getName())) {
                product.setCountInBase(product.getCountInBase() + updatedProduct.getCountInBase());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateProductToMinus(Product updatedProduct) throws DaoException {
        List<Product> products = FileProduct.getProducts();

        for (Product product : products) {
            if (product.getName().equals(updatedProduct.getName())) {
                product.setCountInBase(product.getCountInBase() - updatedProduct.getCountInBase());
                FileProduct.saveProducts();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Product> getAllProducts() throws DaoException {
        return FileProduct.getProducts();
    }

    @Override
    public void deleteProduct(int id) throws DaoException {
        List<Product> products = FileProduct.getProducts();
        products.remove(id);
        FileProduct.saveProducts();
    }

    @Override
    public void addToBasket(Product product) throws DaoException {
        Bucket.add(product);
    }

    @Override
    public void deleteProductFromBasket(Product product) throws DaoException {
        Bucket.delete(product);
    }

    @Override
    public void deleteProductFromBasket(String product) throws DaoException {
        Bucket.delete(product);
    }
    @Override
    public List<Product> getBasket() throws DaoException {
        return Bucket.getBucket();
    }
}

