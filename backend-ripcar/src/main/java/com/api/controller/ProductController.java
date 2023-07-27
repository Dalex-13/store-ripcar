package com.api.controller;

import com.api.model.Product;
import com.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return service.createProduct(product);
    }

    @GetMapping
    public List<Product> listAllProduct(){
        return service.listProducts();
    }

    @GetMapping("/search/{id}")
    public Product searchById(@PathVariable long id){
        return service.searchById(id);
    }

    @PutMapping("/search/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable long id){

        Product updateProduct = service.searchById(id);
        updateProduct.setType(product.getType());
        updateProduct.setDescription(product.getDescription());
        updateProduct.setAmount(product.getAmount());
        updateProduct.setPrice(product.getPrice());

        service.updateProduct(updateProduct);

        return updateProduct;
    }

    @DeleteMapping("/search/{id}")
    public void deleteProduct(@PathVariable long id){
        service.deleteProductById(id);
    }

    @GetMapping("/search")
    public List<Product> searchByType(@RequestParam("type") String type){
        return service.searchByType(type);
    }

    @GetMapping("/search/jpql")
    public List<String> searchByName(){
        return service.searchBytypeJPQL();
    }

}
