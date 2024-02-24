package org.example.database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dao.DaoException;
import org.example.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class FileProduct {

    private List<Product> products = new ArrayList<>();


   synchronized private void loadProducts() {

        try (FileReader reader = new FileReader("ProductsDataBase.txt")) {

            Gson gson = new Gson();
            Product[] productsArray = gson.fromJson(reader, Product[].class);
            products.clear();
            for (Product product : productsArray) {
                products.add(product);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    synchronized public void saveProducts() {

        try (FileWriter writer = new FileWriter("ProductsDataBase.txt");) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String myJsonProducts = gson.toJson(products);
            writer.write(myJsonProducts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getProducts() {
        loadProducts();
        return products;
    }

    public int sizeOfProduct() {
        loadProducts();
        return products.size();
    }
}
