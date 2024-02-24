package org.example.database;

import org.example.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private  List<Product> bucket = new ArrayList<>();

    public  void add(Product product) {
        bucket.add(product);
    }

    public  void delete(Product product) {
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getName().equals(product.getName())) {
                bucket.remove(i);
            }
        }
    }

    public  void clear() {
        bucket.clear();
    }

    public  void delete(String product) {
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getName().equals(product)) {
                bucket.remove(i);
            }
        }
    }

    public  List<Product> getBucket() {
        return bucket;
    }
}
