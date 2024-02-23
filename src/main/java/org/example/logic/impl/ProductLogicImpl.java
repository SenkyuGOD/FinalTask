package org.example.logic.impl;

import org.example.dao.DaoException;
import org.example.dao.DaoProvider;
import org.example.dao.impl.FileProductDao;
import org.example.entity.Product;
import org.example.logic.LogicException;
import org.example.logic.ProductLogic;

import java.util.List;

public class ProductLogicImpl implements ProductLogic {
    private final DaoProvider provider = DaoProvider.getInstance();
    private final FileProductDao dao = provider.getFileProductDao();

    @Override
    public void addProduct(Product product) throws LogicException {
        try {
            dao.addProduct(product);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }


    @Override
    public boolean findProduct(String product) throws LogicException {
        try {

            List<Product> products = dao.getAllProducts();

            Product task = new Product();

            task.setName(product);

            for (Product product1 : products) {
                if (product1.getName().equals(task.getName())) {
                    return true;
                }
            }

        } catch (DaoException e) {
            throw new LogicException(e);
        }
        return false;
    }

    @Override
    public void deleteProduct(int id) throws LogicException {
        try {
            dao.deleteProduct(id);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void updateToMinus(Product product) throws LogicException {
        try {
            dao.updateProductToMinus(product);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void updateToPlus(Product product) throws LogicException {
        try {
            dao.updateProductToPlus(product);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void addProductToBasket(Product product) throws LogicException {

        try {
            dao.addToBasket(product);

        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }


    @Override
    public void deleteProductFromBasket(Product product) throws LogicException {
        try {
            dao.deleteProductFromBasket(product);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public List<Product> showBasket() throws LogicException {
        try {
            List<Product> result = dao.getBasket();
            return result;
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void setCost(Product product) throws LogicException {
        try {
            List<Product> db = dao.getAllProducts();

            for (Product product1 : db) {
                if (product1.getName().equals(product.getName())) {
                    product.setCost(product1.getCost());
                }
            }

        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public double totalAmount(List<Product> result) throws LogicException {
        double totalAmount = 0;

        for (Product product : result) {
            totalAmount = totalAmount + product.getCost() * product.getCountInBase();
        }
        return totalAmount;

    }

    @Override
    public List<Product> showAllProducts() throws LogicException {
        try {
            List<Product> result = dao.getAllProducts();
            return result;
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }
}
