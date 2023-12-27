package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "safari", "water", 5000));
        products.put(2, new Product(2, "ycool", "issue", 10000));
        products.put(3, new Product(3, "karo", "cookie", 30000));
        products.put(4, new Product(4, "chinsu", "sauce", 20000));
        products.put(5, new Product(5, "macbook", "laptop", 30000000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public Product findByName(String name) {
        Product product = null;

        for (Product product1: products.values()) {
            if (product1.getName().equals(name)) {
                product = product1;
                break;
            }
        }
        return product;
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.replace(id, product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }
}
