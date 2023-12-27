package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    Product findByName(String name);
    void save(Product product);
    void update(int id, Product product);
    void delete(int id);
}
