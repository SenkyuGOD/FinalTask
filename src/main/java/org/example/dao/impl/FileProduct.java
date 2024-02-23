package org.example.dao.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dao.DaoException;
import org.example.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileProduct {

    private static List<Product> products = new ArrayList<>();


    private static void loadProducts() {

        try {
            FileReader reader = new FileReader("ProductsDataBase.txt");
            Gson gson = new Gson();
            Product[] productsArray = gson.fromJson(reader, Product[].class);
            products.clear();
            for (Product product : productsArray) {
                products.add(product);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveProducts() throws DaoException {

        try(FileWriter writer = new FileWriter("ProductsDataBase.txt");) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String myJsonProducts = gson.toJson(products);
            writer.write(myJsonProducts);
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }

    public static List<Product> getProducts() {
        loadProducts();
        return products;
    }

    public static int sizeOfProduct() {
        loadProducts();
        return products.size();
    }
}
