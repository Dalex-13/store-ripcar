package com.api.controller;

import com.api.dto.ProductDTO;
import com.api.model.Product;
import com.api.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;


    @PostMapping("/post")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody @Valid ProductDTO productDTO){
        return new ResponseEntity<>(service.createProduct(productDTO), HttpStatus.CREATED) ;
    }

    @GetMapping("/listAll")
    public List<ProductDTO> listAllProduct(){
        return service.listProducts();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ProductDTO> searchById(@PathVariable(name = "id") long id){
        //ProductDTO responseProduct = service.searchById(id);

        return ResponseEntity.ok(service.searchById(id));
    }


    @PutMapping("/search/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody @Valid ProductDTO productDTO, @PathVariable(name = "id") Long id){
        ProductDTO responseProduct = service.updateProduct(productDTO, id);

        return new ResponseEntity<>(responseProduct, HttpStatus.OK);
    }

    @DeleteMapping("/search/{id}")
    public void deleteProduct(@PathVariable long id){
        service.deleteProductById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> searchByType(@RequestParam("type") String type){

        return new ResponseEntity<>(service.searchByType(type), HttpStatus.OK);
    }

    @GetMapping("/search/jpql")
    public List<String> searchByName(){
        return service.searchBytypeJPQL();
    }

}
