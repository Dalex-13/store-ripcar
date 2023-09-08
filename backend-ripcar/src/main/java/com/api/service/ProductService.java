package com.api.service;

import com.api.dto.ProductDTO;
import com.api.model.Product;

import java.util.List;

public interface ProductService {

    public ProductDTO createProduct(ProductDTO productDTO);

    public List<ProductDTO> listProducts();

    public ProductDTO searchById(long id);

    public ProductDTO updateProduct(ProductDTO productDTO, Long id);

    public void deleteProductById(long id);

    public List<ProductDTO> searchByType(String type);

    public List<String> searchBytypeJPQL();

}
