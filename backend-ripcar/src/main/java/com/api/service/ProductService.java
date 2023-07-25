package com.api.service;

import com.api.model.Product;

import java.util.List;

public interface ProductService {

    public Product createProduct(Product product);

    public List<Product> listProducts();

    public Product searchById(long id);

    public Product updateProduct(Product product);

    public void deleteProductById(long id);

    public List<Product> searchByType(String type);

}
