package org.example.database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.entity.Product;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CreateDB {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Молоко", 2.49, 150));
        products.add(new Product("Хлеб", 1.29, 60));
        products.add(new Product("Масло", 3.19, 40));
        products.add(new Product("Форель", 12.29, 132));
        products.add(new Product("Яйца", 2.99, 56));
        products.add(new Product("Сахар", 1.79, 400));
        products.add(new Product("Картофель", 0.59, 367));
        products.add(new Product("Чай (чёрный)", 2.59, 152));
        products.add(new Product("Кофе", 5.99, 229));
        products.add(new Product("Вырезка говяжья", 8.49, 76));
        products.add(new Product("Томат", 3.69, 59));
        products.add(new Product("Шоколад", 1.89, 48));
        products.add(new Product("Макароны", 1.69, 124));
        products.add(new Product("Колбаса", 7.49, 87));
        products.add(new Product("Сыр", 7.99, 58));
        products.add(new Product("Яблоко", 1.89, 37));
        products.add(new Product("Вода питьевая", 1.39, 528));


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String myJsonProducts = gson.toJson(products);


        try (PrintWriter writer = new PrintWriter("ProductsDataBase.txt")){
            writer.println(myJsonProducts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
