package org.example.output;

import org.example.entity.Product;


import java.util.List;

public class ProductOutput {
    public void print( List<Product> products) {
        System.out.println("Список всех товаров:");
        for (Product product : products) {
            System.out.println("|ID: " + product.getId());
            System.out.println("|Название: " + product.getName());
            System.out.println("|Цена: " + product.getCost() + "руб.");
            System.out.println("|Количество на складе: " + product.getCountInBase());
            System.out.println("|--------------------------------");
        }
    }

    public void printBucket(List<Product> products) {
        for (Product product : products) {
            System.out.println("|Название: " + product.getName());
            System.out.println("|Цена: " + product.getCost() + "руб.");
            System.out.println("|Количество в корзине: " + product.getCountInBase());
            System.out.println("|--------------------------------");
        }
    }
}
