package org.example.entity;

import org.example.util.GenerateId;

import java.util.Objects;
import java.util.Random;

public class Product {
    private int id;
    private String name;
    private double cost;
    private int countInBase;

    public Product() {
    }

    public Product(String name, int countInBase) {

        this.id = GenerateId.nextId();
        this.name = name;
        this.countInBase = countInBase;
    }

    public Product(String name, double cost, int countInBase) {

        this.id = GenerateId.nextId();
        this.name = name;
        this.cost = cost;
        this.countInBase = countInBase;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCountInBase() {
        return countInBase;
    }

    public void setCountInBase(int countInBase) {
        this.countInBase = countInBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(cost, product.cost) == 0 && countInBase == product.countInBase && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost, countInBase);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", countInBase=" + countInBase +
                '}';
    }
}
