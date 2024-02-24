package org.example.dao.impl;

import org.example.dao.DaoException;
import org.example.dao.DaoProvider;
import org.example.dao.ProductDao;
import org.example.database.Bucket;
import org.example.database.DataBaseProvider;
import org.example.database.FileProduct;
import org.example.entity.Product;

import java.util.List;

public class FileProductDao implements ProductDao {

    private final DataBaseProvider provider = DataBaseProvider.getInstance();
    private final FileProduct db = provider.getFileProduct();

    private final Bucket bucket = provider.getBucket();

    @Override
    public void addProduct(Product product) throws DaoException {
        product.setId(db.sizeOfProduct() + 1);
        List<Product> products = db.getProducts();
        products.add(product);
        db.saveProducts();
    }


    @Override
    public boolean updateProductToPlus(Product updatedProduct) throws DaoException {
        List<Product> products = db.getProducts();

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
        List<Product> products = db.getProducts();

        for (Product product : products) {
            if (product.getName().equals(updatedProduct.getName())) {
                product.setCountInBase(product.getCountInBase() - updatedProduct.getCountInBase());
                db.saveProducts();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Product> getAllProducts() throws DaoException {
        return db.getProducts();
    }

    @Override
    public void deleteProduct(int id) throws DaoException {
        List<Product> products = db.getProducts();
        products.remove(id);
        db.saveProducts();
    }

    @Override
    public void addToBasket(Product product) throws DaoException {
        bucket.add(product);
    }

    @Override
    public void deleteProductFromBasket(Product product) throws DaoException {
        bucket.delete(product);
    }

    @Override
    public void deleteProductFromBasket(String product) throws DaoException {
        bucket.delete(product);
    }

    @Override
    public List<Product> getBasket() throws DaoException {
        return bucket.getBucket();
    }
}

