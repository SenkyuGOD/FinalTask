package org.example.dao.impl;

import org.example.dao.DaoException;
import org.example.dao.ProductDao;
import org.example.database.DataBaseProvider;
import org.example.database.FileProduct;
import org.example.entity.Product;

import java.io.IOException;
import java.util.List;

public class FileProductDao implements ProductDao {

    private final DataBaseProvider provider = DataBaseProvider.getInstance();
    private final FileProduct db = provider.getFileProduct();


    @Override
    public void addProduct(Product product) throws DaoException {
        try {
            product.setId(db.sizeOfProduct() + 1);
            List<Product> products = db.getProducts();
            products.add(product);
            db.saveProducts();
        } catch (IOException e) {
            throw new DaoException(e);
        }

    }


    @Override
    public boolean updateProductToPlus(Product updatedProduct) throws DaoException {
        try {
            List<Product> products = db.getProducts();

            for (Product product : products) {
                if (product.getName().equals(updatedProduct.getName())) {
                    product.setCountInBase(product.getCountInBase() + updatedProduct.getCountInBase());
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean updateProductToMinus(Product updatedProduct) throws DaoException {
        try {
            List<Product> products = db.getProducts();

            for (Product product : products) {
                if (product.getName().equals(updatedProduct.getName())) {
                    product.setCountInBase(product.getCountInBase() - updatedProduct.getCountInBase());
                    db.saveProducts();
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Product> getAllProducts() throws DaoException {
       try {
           return db.getProducts();
       } catch (IOException e) {
           throw new DaoException(e);
       }
    }

    @Override
    public void deleteProduct(int id) throws DaoException {
        try {
            List<Product> products = db.getProducts();
            products.remove(id);
            db.saveProducts();
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }

}

