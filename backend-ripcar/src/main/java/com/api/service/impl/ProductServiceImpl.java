package com.api.service.impl;

import com.api.model.Product;
import com.api.repository.ProductRepository;
import com.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> listProducts() {
        return repository.findAll();
    }

    @Override
    public Product searchById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public void deleteProductById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Product> searchByType(String type) {
        return repository.findByType(type);
    }

    @Override
    public List<String> searchBytypeJPQL() {
        return repository.findByName();
    }


}
