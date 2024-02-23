package org.example.dao.impl;

import org.example.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private static  List<Product> bucket = new ArrayList<>();

    public static void add(Product product) {
        bucket.add(product);
    }

    public static void delete(Product product) {
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getName().equals(product.getName())) {
                bucket.remove(i);
            }
        }
    }

    public static void clear() {
        bucket.clear();
    }

    public static void delete(String product) {
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getName().equals(product)) {
                bucket.remove(i);
            }
        }
    }

    public static List<Product> getBucket() {
        return bucket;
    }
}
