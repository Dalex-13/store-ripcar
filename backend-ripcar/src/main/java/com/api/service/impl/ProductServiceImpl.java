package com.api.service.impl;

import com.api.dto.ProductDTO;
import com.api.model.Product;
import com.api.repository.ProductRepository;
import com.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        //convert from DTO to entity
        Product product = new Product();
        product.setType(productDTO.getType());
        product.setDescription(productDTO.getDescription());
        product.setAmount(productDTO.getAmount());
        product.setPrice(productDTO.getPrice());

        Product newProduct = repository.save(product);

        //convert entity to DTO
        ProductDTO productResponse = new ProductDTO();
        productResponse.setId(newProduct.getId());
        productResponse.setType(newProduct.getType());
        productResponse.setDescription(newProduct.getDescription());
        productResponse.setAmount(newProduct.getAmount());
        productResponse.setPrice(newProduct.getPrice());
        return productResponse;
    }

    @Override
    public List<ProductDTO> listProducts() {
        List<Product> products = repository.findAll();
        return products.stream().map(product ->
                mapDTO(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO searchById(long id) {
        Product products = repository.findById(id)
                .orElseThrow(() -> new ResolutionException());
        return mapDTO(products);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResolutionException("****************"));

        product.setType(productDTO.getType());
        product.setDescription(productDTO.getDescription());
        product.setAmount(productDTO.getAmount());
        product.setPrice(productDTO.getPrice());

        Product updatedProduct = repository.save(product);
        return mapDTO(updatedProduct);
    }

    @Override
    public void deleteProductById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ProductDTO> searchByType(String type) {
        List<Product> products = repository.findByType(type);
        return products.stream().map(product ->
                mapDTO(product)).collect(Collectors.toList());
    }

    @Override
    public List<String> searchBytypeJPQL() {
        return repository.findByName();
    }




    private ProductDTO mapDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setType(product.getType());
        productDTO.setDescription(product.getDescription());
        productDTO.setAmount(product.getAmount());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

    private Product mapEntity(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setType(productDTO.getType());
        product.setDescription(productDTO.getDescription());
        product.setAmount(productDTO.getAmount());
        product.setPrice(productDTO.getPrice());
        return product;
    }


}
