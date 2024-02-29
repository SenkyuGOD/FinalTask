package org.example.database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FileProduct {

    private List<Product> products = new ArrayList<>();


   synchronized private void loadProducts() throws IOException{

        try (FileReader reader = new FileReader("ProductsDataBase.txt")) {

            Gson gson = new Gson();
            Product[] productsArray = gson.fromJson(reader, Product[].class);
            products.clear();
            Collections.addAll(products, productsArray);
        }

    }

    synchronized public void saveProducts() throws IOException{

        try (FileWriter writer = new FileWriter("ProductsDataBase.txt");) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String myJsonProducts = gson.toJson(products);
            writer.write(myJsonProducts);
        }
    }

    public List<Product> getProducts() throws IOException {
        loadProducts();
        return products;
    }

    public int sizeOfProduct() throws IOException {
        loadProducts();
        return products.size();
    }
}
